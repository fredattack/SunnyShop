package couchePr�sentation;
import javafx.collections.FXCollections;
import javafx.geometry.Orientation;
import javafx.scene.control.Button;
import javafx.scene.control.Separator;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import classesM�tiers.*;
import coucheAccesBd.ExceptionAccesBd;
import coucheM�tier.Metier;

public class ZoneClients {

		TableView<User> userList = new TableView<User>() ;
		TableView<Order> userOrderList ;
		User leClient =  new User();
		Metier laCoucheM�tier = new Metier();
		Order laCommande = new Order();
	
	public ZoneClients()  throws ExceptionAccesBd{
		
	}
	
	public void createZoneClients(AnchorPane anchorZone,Stage MainStage){
		
		createUserList(anchorZone,MainStage);
	}		

			
	public void createUserList(AnchorPane anchorZone,Stage MainStage) {
			// Position AnchorPane
			anchorZone.setTopAnchor(userList , 90.0);
			anchorZone.setLeftAnchor(userList , 50.0);
			
			userList.getStyleClass().add("TableUser");
			userList.setColumnResizePolicy(userList.CONSTRAINED_RESIZE_POLICY);

			//Ajout des donner depuis db
			try
			{
			userList.itemsProperty().setValue(FXCollections.observableArrayList(laCoucheM�tier.ListerClients()));
			}catch(Exception ex)
			{			
			new MessageBox(MainStage, AlertType.ERROR,"Acc�s � la BD impossible (" + ex.getMessage() + ")");
			}
		
			
			//cr�ation tableau Order
			TableColumn<User, String> idCol = new TableColumn<User, String>("Id");
			idCol.setCellValueFactory(new PropertyValueFactory<>("idUser"));
			TableColumn<User, String> firstNameCol = new TableColumn<User, String>("Pr�nom");
			firstNameCol.prefWidthProperty().bind(userList.widthProperty().multiply(0.15));
			firstNameCol.setCellValueFactory(new PropertyValueFactory<>("firstName"));
			TableColumn<User, String> lastNameCol = new TableColumn<User, String>("Nom");
			lastNameCol.prefWidthProperty().bind(userList.widthProperty().multiply(0.15));
			lastNameCol.setCellValueFactory(new PropertyValueFactory<>("lastName"));
		    TableColumn<User, String> adressCol = new TableColumn<User, String>("Adresse");
		    adressCol.prefWidthProperty().bind(userList.widthProperty().multiply(0.3));
		    adressCol.setCellValueFactory(new PropertyValueFactory<>("adresUser"));
		    TableColumn<User, String> birthCol = new TableColumn<User, String>("date de naissance");
		    birthCol.prefWidthProperty().bind(userList.widthProperty().multiply(0.15));
		    birthCol.setCellValueFactory(new PropertyValueFactory<>("birthDate"));
		    TableColumn<User, Float> totalCol = new TableColumn<User, Float>("Total des achats");
		    totalCol.prefWidthProperty().bind(userList.widthProperty().multiply(0.15));
		    totalCol.setCellValueFactory(new PropertyValueFactory<>("totalAchat"));
		    userList.getColumns().addAll(idCol,firstNameCol,lastNameCol, adressCol, birthCol,totalCol);
		    
		  //quand un enregistrement est s�lectionn�
		    userList.getSelectionModel().selectedItemProperty().addListener((obs, ancUser, nouvUser) ->
			  		{
			  			userOrderList= new TableView<Order>();
			  			anchorZone.getChildren().remove(userOrderList);
			  			leClient = nouvUser;
			  			createUserOrderDetailList(anchorZone, MainStage);
			  		});	
		    
		    anchorZone.getChildren().add(userList);
		}

	private void createUserOrderDetailList(AnchorPane anchorZone, Stage mainStage) {
		anchorZone.setTopAnchor(userOrderList , 420.0);
		anchorZone.setLeftAnchor(userOrderList , 50.0);
		
		userOrderList.getStyleClass().add("TableOrder");
		userOrderList.setColumnResizePolicy(userList.CONSTRAINED_RESIZE_POLICY);

		//Ajout des donner depuis db
		try
		{
		userOrderList.itemsProperty().setValue(FXCollections.observableArrayList(laCoucheM�tier.ListerOrderClients(leClient.getIdUser())));
		}catch(Exception ex)
		{			
		new MessageBox(mainStage, AlertType.ERROR,"Acc�s � la BD impossible (" + ex.getMessage() + ")");
		}
		
		//cr�ation tableau Order
		TableColumn<Order, Integer> idCol = new TableColumn<Order, Integer>("ID");
		idCol.setCellValueFactory(new PropertyValueFactory<>("idOrder"));
		TableColumn<Order, String> dateCol = new TableColumn<Order, String>("Date");
		dateCol.setCellValueFactory(new PropertyValueFactory<>("dateOrder"));
		TableColumn<Order, String> timeCol = new TableColumn<Order, String>("Heure");
		timeCol.setCellValueFactory(new PropertyValueFactory<>("timeOrder"));
		TableColumn<Order, Float> totalCol = new TableColumn<Order, Float>("Total");
	    totalCol.setCellValueFactory(new PropertyValueFactory<>("TotalPrice"));
	    TableColumn<Order, String> deliveredCol = new TableColumn<Order, String>("Exp�di�");
	    deliveredCol.setCellValueFactory(new PropertyValueFactory<>("deliveredOrder"));
	    userOrderList.getColumns().addAll(idCol,dateCol,timeCol, totalCol, deliveredCol);
	    anchorZone.getChildren().add(userOrderList);
	    
	  //quand un enregistrement est s�lectionn�
	    userOrderList.getSelectionModel().selectedItemProperty().addListener((obs, ancOrder, newOrder) ->
		  		{
		  			try 
					{
		  				laCommande = newOrder;
						new OrderDetailsListBox(mainStage,laCommande,anchorZone);
						
					} 
					catch (ExceptionAccesBd e1) {
						e1.printStackTrace();
					}
		  		});	
		
	}
}