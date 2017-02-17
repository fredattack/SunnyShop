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

public class ZoneCommande {

	
	private TableView<Order> OrderList = new TableView<Order>();
	private TableView<LigneCommande> OrderDetailList = new TableView<LigneCommande>();
	
	
	public ZoneCommande(){
		
		
		
	}
	
	public void CreateZoneCommande(AnchorPane anchorZone){
		
		createHboxSearch(anchorZone);
		createOrderList(anchorZone);
		createOrderDetailList(anchorZone);
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
		HBox hboxShipped = new HBox();
		Button btShipped = new Button("Expédier");
		
		hboxShipped.getChildren().add(btShipped);
		// Position AnchorPane
		anchorZone.setTopAnchor(OrderList, 90.0);
		anchorZone.setLeftAnchor(OrderList, 50.0);
		anchorZone.setBottomAnchor(hboxShipped, 20.0);
		anchorZone.setRightAnchor(hboxShipped, 25.0);
		OrderList.getStyleClass().add("TableOrder");

		
		//création tableau Order
		TableColumn<Order, String> idCol = new TableColumn<Order, String>("IDdd");
		TableColumn<Order, String> descriptionCol = new TableColumn<Order, String>("Description");
		descriptionCol.prefWidthProperty().bind(OrderList.widthProperty().multiply(0.4045));
		TableColumn<Order, String> typeOrderCol = new TableColumn<Order, String>("Type de Order");
	    TableColumn<Order, String> origineCol = new TableColumn<Order, String>("Origine");
	    TableColumn<Order, String> milleCol = new TableColumn<Order, String>("Millésime");
	    TableColumn<Order, Float> prixCol = new TableColumn<Order, Float>("Prix Unitaire");
	    TableColumn<Order, Float> StickCol = new TableColumn<Order, Float>("Stock");
	    OrderList.getColumns().addAll(idCol,descriptionCol,typeOrderCol, origineCol, milleCol,prixCol,StickCol);
	    anchorZone.getChildren().addAll(hboxShipped,OrderList);
	}
	

	private void createOrderDetailList(AnchorPane anchorZone) {
		
		// Position AnchorPane
		HBox hboxTotal = new HBox();
		TextField tfTotal = new TextField("Total");
		tfTotal.getStyleClass().add("tfTotal");
		hboxTotal.getChildren().add(tfTotal);
		
		anchorZone.setTopAnchor(OrderDetailList,420.0);
		anchorZone.setLeftAnchor(OrderDetailList, 50.0);
		anchorZone.setRightAnchor(hboxTotal, 25.0);
		anchorZone.setBottomAnchor(hboxTotal, 70.0);
		OrderDetailList.getStyleClass().add("TableOrder");

		//création tableau Order
		TableColumn<LigneCommande, String> idCol2 = new TableColumn<LigneCommande, String>("IDdd");
		TableColumn<LigneCommande, String> descriptionCol2 = new TableColumn<LigneCommande, String>("Description");
		descriptionCol2.prefWidthProperty().bind(OrderDetailList.widthProperty().multiply(0.4045));
		TableColumn<LigneCommande, String> typeOrderCol2 = new TableColumn<LigneCommande, String>("Type de Order");
	    TableColumn<LigneCommande, String> origineCol2 = new TableColumn<LigneCommande, String>("Origine");
	    OrderDetailList.getColumns().addAll(idCol2,descriptionCol2,typeOrderCol2,origineCol2);
	    anchorZone.getChildren().addAll(OrderDetailList,hboxTotal);
		
	}
	
}
