package couchePrésentation;

import classesMétiers.LigneCommande;
import classesMétiers.Order;
import classesMétiers.Vin;
import coucheAccesBd.ExceptionAccesBd;
import coucheMétier.Metier;
import javafx.collections.FXCollections;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class OrderDetailsListBox {
	
	private static final int LARGEUR = 1044;
	private static final int HAUTEUR = 494;

	Metier laCoucheMétier = new Metier();
	// objet de la fenêtre
	private Stage stage = new Stage();
	private Scene thisScene;
	private AnchorPane anchor = new AnchorPane();
	
	
	
	public OrderDetailsListBox(Stage fenParent,Order LaCommande,AnchorPane anchorZone ) throws ExceptionAccesBd{
		thisScene = new Scene(anchor,LARGEUR, HAUTEUR);
		stage.setScene(thisScene);
		thisScene.getStylesheets().add("couchePrésentation/tabPane.css");
		thisScene.setFill(Color.TRANSPARENT);
		
		stage.setTitle("StockVal");
	    stage.initOwner(fenParent);
	    stage.initModality(Modality.APPLICATION_MODAL); 
	    stage.initStyle(StageStyle.TRANSPARENT);
	    
	    remplirAnchor(stage,LaCommande,anchorZone);
	    stage.showAndWait();
	}

	private void remplirAnchor(Stage stage, Order laCommande, AnchorPane anchorZone) {
		
		TableView<LigneCommande> OrderDetailList = new TableView<LigneCommande>();
		Button btQuit = new Button("_X");
		btQuit.getStyleClass().add("btImage");
		Label laCom = new Label("Commande N°: "+ laCommande.getIdOrder());
		
		// TODO Auto-generated method stub
		anchor.getStyleClass().add("anchor");
		// Position AnchorPane
				
				btQuit.setOnAction(e -> { stage.close(); });
				anchor.setTopAnchor(laCom,10.0);
				anchor.setLeftAnchor(laCom, 10.0);
				anchor.setTopAnchor(btQuit, 10.0);
				anchor.setRightAnchor(btQuit, 10.0);
				anchor.setTopAnchor(OrderDetailList,70.0);
				anchor.setLeftAnchor(OrderDetailList, 20.0);
				
				OrderDetailList.getStyleClass().add("TableOrder");
				OrderDetailList.setColumnResizePolicy(OrderDetailList.CONSTRAINED_RESIZE_POLICY);

				//Ajout des donner depuis db
				try
				{
					OrderDetailList.itemsProperty().setValue(FXCollections.observableArrayList(laCoucheMétier.ListerOrderDetails(laCommande.getIdOrder())));
				}
				catch(Exception ex)
				{			
					new MessageBox(stage, AlertType.ERROR,"Accès à la BD impossible (" + ex.getMessage() + ")");
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
				//anchorZone.getChildren().addAll(OrderDetailList);
				anchor.getChildren().addAll(OrderDetailList,btQuit,laCom);
		
	}
	
	
}
