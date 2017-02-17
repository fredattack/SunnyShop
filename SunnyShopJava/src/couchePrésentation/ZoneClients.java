package couchePrésentation;
import javafx.geometry.Orientation;
import javafx.scene.control.Button;
import javafx.scene.control.Separator;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import classesMétiers.*;

public class ZoneClients {

		TableView<User> userList = new TableView<User>() ;
	
	public ZoneClients(){
		
	}
	
	public void createZoneClients(AnchorPane anchorZone){
		
		createHboxSearch(anchorZone);
		createOrderList(anchorZone);
	}		

		public void createHboxSearch(AnchorPane anchorZone) {
			HBox hboxTopSearch = new HBox(27);
			anchorZone.setTopAnchor(hboxTopSearch, 25.0);
			anchorZone.setRightAnchor(hboxTopSearch, 25.0);
			
			hboxTopSearch.getStyleClass().add("hboxTopSearch");
			
			TextField tfCol1 = new TextField("N° commande");
	        TextField tfCol2 = new TextField("N° Client");
	        TextField tfCol3 = new TextField("Date");
	        Button btChercher = new Button("Chercher");
	        hboxTopSearch.getChildren().addAll(tfCol1,tfCol2,tfCol3,btChercher);
	        btChercher.getStyleClass().add("btChercher");
	        anchorZone.getChildren().addAll(hboxTopSearch);
		}
			
		public void createOrderList(AnchorPane anchorZone) {
			// Position AnchorPane
			anchorZone.setTopAnchor(userList , 90.0);
			anchorZone.setLeftAnchor(userList , 50.0);
			
			userList.getStyleClass().add("TableOrder");

			//création tableau Order
			TableColumn<User, String> idCol = new TableColumn<User, String>("IDdd");
			TableColumn<User, String> descriptionCol = new TableColumn<User, String>("Description");
			descriptionCol.prefWidthProperty().bind(userList.widthProperty().multiply(0.4045));
			TableColumn<User, String> typeOrderCol = new TableColumn<User, String>("Type de Order");
		    TableColumn<User, String> origineCol = new TableColumn<User, String>("Origine");
		    TableColumn<User, String> milleCol = new TableColumn<User, String>("Millésime");
		    TableColumn<User, Float> prixCol = new TableColumn<User, Float>("Prix Unitaire");
		    TableColumn<User, Float> StickCol = new TableColumn<User, Float>("Stock");
		    userList.getColumns().addAll(idCol,descriptionCol,typeOrderCol, origineCol, milleCol,prixCol,StickCol);
		    anchorZone.getChildren().add(userList);
		}
}