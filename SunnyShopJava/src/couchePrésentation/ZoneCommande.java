package couchePrésentation;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.HPos;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.util.ArrayList;

import classesMétiers.*;
import coucheAccesBd.ExceptionAccesBd;
import coucheMétier.ExceptionMetier;
import coucheMétier.Metier;

public class ZoneCommande {
	Metier laCoucheMétier = new Metier();
	
	private Order laCommande = new Order();
	private LigneCommande laLigne;
	private TableView<Order> OrderList;
	private ObservableList<Order> laListe = null;
	private Float totalAchatClient;
	GridPane gridClientDetail = new GridPane();
	private TableView<LigneCommande> OrderDetailList;
	Button btShipped = new Button("Expédier");
	
	
	public ZoneCommande() throws ExceptionAccesBd{
		
	}
	
	public void CreateZoneCommande(AnchorPane anchorZone,Stage MainStage) throws ExceptionAccesBd{
		
		createOrderList(anchorZone,MainStage);
		
	}
	

	public void createOrderList(AnchorPane anchorZone, Stage MainStage) throws ExceptionAccesBd {
		
		OrderList = new TableView<Order>();
		OrderList.getStyleClass().add("OrderList");
		OrderList.setColumnResizePolicy(OrderList.CONSTRAINED_RESIZE_POLICY);
		
		
		//HBox hboxOrder = new HBox(15);
		
		
		//btShipped.getChildren().addAll(btShipped);
		btShipped.setVisible(false);
		// Position AnchorPane
		anchorZone.setTopAnchor(OrderList, 90.0);
		anchorZone.setLeftAnchor(OrderList, 50.0);
		anchorZone.setBottomAnchor(btShipped, 20.0);
		anchorZone.setRightAnchor(btShipped, 25.0);
		/*anchorZone.setRightAnchor(hboxTotal, 200.0);
		anchorZone.setBottomAnchor(hboxTotal, 20.0);*/
		OrderList.getStyleClass().add("TableOrder");

		//Ajout des donner depuis db
			try
			{
			laListe=FXCollections.observableArrayList(laCoucheMétier.ListerOrder());
			OrderList.itemsProperty().setValue(FXCollections.observableArrayList(laCoucheMétier.ListerOrder()));
			}catch(Exception ex)
			{			
			new MessageBox(MainStage, AlertType.ERROR,"Accès à la BD impossible (" + ex.getMessage() + ")");
			}
		
		//création tableau Order
		TableColumn<Order, Integer> idCol = new TableColumn<Order, Integer>("ID");
		idCol.setCellValueFactory(new PropertyValueFactory<>("idOrder"));
		TableColumn<Order, String> dateCol = new TableColumn<Order, String>("Date");
		dateCol.setCellValueFactory(new PropertyValueFactory<>("dateOrder"));
		TableColumn<Order, String> timeCol = new TableColumn<Order, String>("Heure");
		timeCol.setCellValueFactory(new PropertyValueFactory<>("timeOrder"));
		TableColumn<Order, Float> totalCol = new TableColumn<Order, Float>("Total");
	    totalCol.setCellValueFactory(new PropertyValueFactory<>("TotalPrice"));
		TableColumn<Order, Integer> buyerCol = new TableColumn<Order,Integer>("Client");
	    buyerCol.setCellValueFactory(new PropertyValueFactory<>("idUserOrder"));	    
	    TableColumn<Order, String> deliveredCol = new TableColumn<Order, String>("Expédié");
	    deliveredCol.setCellValueFactory(new PropertyValueFactory<>("deliveredOrder"));
	    
	    OrderList.getColumns().addAll(idCol,dateCol,timeCol,buyerCol,totalCol,deliveredCol);
	    anchorZone.getChildren().addAll(btShipped,OrderList);
	    
	  //quand un enregistrement est sélectionné
	   OrderList.getSelectionModel().selectedItemProperty().addListener((obs, ancOrder, nouvOrder) ->
	  		{
	  			btShipped.setVisible(false);
	  			OrderDetailList = new TableView<LigneCommande>();
	  			anchorZone.getChildren().remove(OrderDetailList);
	  			gridClientDetail.getChildren().clear();
	  			anchorZone.getChildren().remove(gridClientDetail);
	  			laCommande = nouvOrder;
	  			
	  			try {
					anchorZone.getChildren().remove(gridClientDetail);
	  				createClientDetail(anchorZone,MainStage,laCommande.getIdUserOrder());
				} catch (ExceptionAccesBd | ExceptionMetier e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	  			createOrderDetailList(anchorZone, MainStage);
	  			
	  			//btShipped.setVisible(true);
	  			if(laCommande.getDeliveredOrder().compareTo("non")== 0 ){
	  				btShipped.setVisible(true);
	  			}
	  			
	  		});	
	   btShipped.setOnAction(e -> { 
		   laCommande.setDeliveredOrder("oui");
		   try {
			laCoucheMétier.SetDelivered(laCommande);
			Refresh(anchorZone, MainStage);
		} catch (ExceptionAccesBd e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (ExceptionMetier e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	   		});
	}
	
	private void createClientDetail(AnchorPane anchorZone,Stage mainStage,Integer idUser) throws ExceptionAccesBd, ExceptionMetier
	{
		
		User user = new User();
		user = laCoucheMétier.LireUserSpecifique(idUser);
		
		anchorZone.getChildren().add(gridClientDetail);
		gridClientDetail.setHgap(20);
		gridClientDetail.setVgap(15);
		gridClientDetail.setAlignment(Pos.CENTER);
		gridClientDetail.setGridLinesVisible(false);
		gridClientDetail.getStyleClass().add("gridClientDetail");
	
		anchorZone.setTopAnchor(gridClientDetail,120.0);
		anchorZone.setRightAnchor(gridClientDetail, 80.0);
		
		Label lbTitre = new Label("Détails du clients :");
		gridClientDetail.add(lbTitre, 0, 0,3,1);
		GridPane.setHalignment(lbTitre, HPos.CENTER);
		lbTitre.getStyleClass().add("lbTitre");
		
		Label lbIdClient = new Label("Id: "+String.valueOf(user.getIdUser()));
		gridClientDetail.add(lbIdClient, 0, 1, 1, 1);
		GridPane.setHalignment(lbIdClient, HPos.CENTER);
		
		Label lbPrénomClient = new Label(user.getFirstName());
		gridClientDetail.add(lbPrénomClient, 1, 1, 1, 1);
		GridPane.setHalignment(lbPrénomClient, HPos.CENTER);
		
		Label lbNomClient = new Label(user.getLastName());
		gridClientDetail.add(lbNomClient, 2, 1, 1, 1);
		GridPane.setHalignment(lbNomClient, HPos.LEFT);
		
		Label lbAdresClient = new Label(user.getAdresUser());
		gridClientDetail.add(lbAdresClient, 0, 2,3,1);
		GridPane.setHalignment(lbAdresClient, HPos.CENTER);
		
		Label lbBirthDate = new Label("Date de Naissance: "+user.getBirthDate());
		gridClientDetail.add(lbBirthDate, 0, 3, 5, 1);
		GridPane.setHalignment(lbBirthDate, HPos.LEFT);
		
		Label lbTotal = new Label("Total des achats: "+String.valueOf(countClientTotal(user.getIdUser()))+" €");
		gridClientDetail.add(lbTotal, 0, 4, 5, 1);
		GridPane.setHalignment(lbTotal, HPos.LEFT);
		
		
	}
	
	private Float countClientTotal(int idUser){
		Float totalAchatClient = new Float(0);
		for(Order O : laListe)
		{
			if(O.getIdUserOrder()== idUser){
				totalAchatClient+=O.getTotalPrice();
			}
		}
		
		
		return totalAchatClient;
	}

	private void createOrderDetailList(AnchorPane anchorZone,Stage MainStage) {
		
		// Position AnchorPane
		anchorZone.setTopAnchor(OrderDetailList,420.0);
		anchorZone.setLeftAnchor(OrderDetailList, 50.0);
		
		OrderDetailList.getStyleClass().add("TableOrder");
		OrderDetailList.setColumnResizePolicy(OrderDetailList.CONSTRAINED_RESIZE_POLICY);

		//Ajout des donner depuis db
		try
		{
			OrderDetailList.itemsProperty().setValue(FXCollections.observableArrayList(laCoucheMétier.ListerOrderDetails(laCommande.getIdOrder())));
		}
		catch(Exception ex)
		{			
			new MessageBox(MainStage, AlertType.ERROR,"Accès à la BD impossible (" + ex.getMessage() + ")");
		}
		
		//création tableau Order
		TableColumn<LigneCommande, String> idProduitCol = new TableColumn<LigneCommande, String>("IdProduit");
		idProduitCol.setCellValueFactory(new PropertyValueFactory<>("idProduit"));
		
		TableColumn<LigneCommande, String> descriptionCol = new TableColumn<LigneCommande, String>("Description");
		descriptionCol.prefWidthProperty().bind(OrderDetailList.widthProperty().multiply(0.4045));
		descriptionCol.setCellValueFactory(new PropertyValueFactory<>("nom"));
		
		TableColumn<LigneCommande, Float> prixProdCol = new TableColumn<LigneCommande, Float>("Prix unitaire");
		prixProdCol.setCellValueFactory(new PropertyValueFactory<>("PrixUnitaire"));
		
		TableColumn<LigneCommande, Integer> quantitéCol = new TableColumn<LigneCommande, Integer>("Quantité");
		quantitéCol.setCellValueFactory(new PropertyValueFactory<>("quantité"));
		
		TableColumn<LigneCommande, Float> sousTotalCol = new TableColumn<LigneCommande, Float>("SousTotal");
		sousTotalCol.setCellValueFactory(new PropertyValueFactory<>("sousTotal"));
		OrderDetailList.getColumns().addAll(idProduitCol,descriptionCol,prixProdCol,quantitéCol,sousTotalCol);
		anchorZone.getChildren().addAll(OrderDetailList);
		
	}
	
	public void Refresh(AnchorPane anchorZone,Stage MainStage) throws ExceptionAccesBd{
		anchorZone.getChildren().removeAll(OrderList,gridClientDetail,OrderDetailList,btShipped);
		createOrderList(anchorZone, MainStage);
	}
		
}
