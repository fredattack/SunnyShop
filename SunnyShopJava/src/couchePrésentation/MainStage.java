package couchePrésentation;



import javafx.animation.Interpolator;
import javafx.animation.TranslateTransition;

/*
 * Les Imports
 */

import javafx.application.Application;
import javafx.beans.value.WritableDoubleValue;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.TabPane.TabClosingPolicy;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.Window;
import javafx.scene.text.Font;
import javafx.geometry.Pos;
import javafx.geometry.Side;
import javafx.scene.text.Font;

import java.awt.Checkbox;
import java.nio.channels.NetworkChannel;
import java.time.Duration;

import classesMétiers.Alcool;
import classesMétiers.Vin;
import coucheAccesBd.ExceptionAccesBd;
import coucheMétier.*;




@SuppressWarnings("unused")
public class MainStage extends Application {
	
	private static Metier CoucheMetier;
	
	// déclaratiens des conteneurs
	private Scene scene;
	
    private BorderPane mainPane = new BorderPane();
	private static final AnchorPane anchor = new AnchorPane();
	private static VBox vboxSectionLeft = new VBox(10);	
	
	private static TableView<Vin> vinTable = new TableView<Vin>();	
	private static TableView<Alcool> alcoolTable;
	private static HBox hboxTopSearch = new HBox(27);
	private static HBox hboxMid = new HBox(10);
	private static HBox hboxFooterRight = new HBox(10);
	private static HBox hboxFooterLeft = new HBox(10);
	private static VBox vboxRightButton = new VBox(10);
	private static VBox vboxRightImage = new VBox(10);
	private static GridPane gridChange = new GridPane();
			
	private static final int LARGEUR = 1300;
	private static final int HAUTEUR = 840;
	private Double GridPosition = 20.0;
	
	// Main
	public static void main(String[] args)
	{
		//Connect To DB
		
		try
		{
		CoucheMetier = new Metier();
		}
		catch (ExceptionAccesBd e)
		{
		System.out.println("\nAccès à la BD impossible (" + e.getMessage() + ")");
		System.exit(0);
		}
		
		// Launch App
		MainStage.launch();
	}

	//Start	
	@Override
	public void start(Stage MainStage)
	{
	//css
	
    
	scene = new Scene(anchor,LARGEUR, HAUTEUR);
	scene.getStylesheets().add("couchePrésentation/tabPane.css");
	anchor.getStyleClass().add("anchor");
    
	mainPane.prefHeightProperty().bind(scene.heightProperty());
    mainPane.prefWidthProperty().bind(scene.widthProperty());
    
	
    
     // MainStage Designer
 
    MainStage.initStyle(StageStyle.TRANSPARENT);
    scene.setFill(Color.TRANSPARENT);
    MainStage.setScene(scene);
    MainStage.show();
    
    //anchorContent
    anchor.getChildren().addAll(vboxSectionLeft,hboxFooterRight,vboxRightButton,hboxTopSearch,vinTable,hboxMid,
    		vboxRightImage,gridChange);
    vinTable.setVisible(false);
    
    // startContent
    
    createStartContent(MainStage);
	}
	
	public void createStartContent(Stage MainStage) {
		
		closeWindowButton(MainStage);
		
		// Css Conteneur
		vboxSectionLeft.getStyleClass().add("vboxSectionLeft");
				
		// Position AnchorPane
		anchor.setTopAnchor(vboxSectionLeft,25.0);
		anchor.setLeftAnchor(vboxSectionLeft, 25.0);
		
		Button btProduit = new Button("Produits");
		btProduit.setOnAction(e->
	        { 
	        	vboxRightButton.getChildren().clear();
	        	vboxSectionLeft.getChildren().clear();
	        	hboxFooterRight.getChildren().clear();
	        	createStartContent(MainStage);
	        	createCommonContainer(MainStage);
	        	
	        	//closeWindowButton(MainStage);
	        });
		Button btCommandes = new Button("Commandes");
		btCommandes.setOnAction(e->
        { 
        	vboxRightButton.getChildren().clear();
        	vboxSectionLeft.getChildren().clear();
        	hboxFooterRight.getChildren().clear();
        	createStartContent(MainStage);
        	
        });
		Button btClients = new Button("Produits");
		btClients.setOnAction(e->
        { 
        	vboxRightButton.getChildren().clear();
        	vboxSectionLeft.getChildren().clear();
        	hboxFooterRight.getChildren().clear();
        	createStartContent(MainStage);
        	
        });
		
		vboxSectionLeft.getChildren().addAll(btProduit,btCommandes,btClients);
		
		
		 //création hboxFooter---> Quitter
        
	}
	
	//createCommonPane Container (Multiple Pane usable)
		@SuppressWarnings({ "static-access"})
		public void createCommonContainer(Stage MainStage) {
			
			
			// Css Conteneur
			vboxRightButton.getStyleClass().add("vboxRightButton");
			
			// Position AnchorPane
			anchor.setTopAnchor(vboxRightButton,150.0);
			anchor.setRightAnchor(vboxRightButton, 25.0);
			
	        /*
	         * 
	         * création vboxRight     --->TYPE PRODUIT
	         *    
	         */
	        Button btVin=new Button("Vin");
	        btVin.setOnAction(e->
	        { 
	        	createZoneVin(MainStage);
	        	
	        });
	        
	        Button btAlcool=new Button("Alcool");
	        btAlcool.setOnAction(e->
	        {         	
	        	
	        });
	        
	        Button btChemise=new Button("Chemise");
	        vboxRightButton.getChildren().addAll(btVin,btAlcool,btChemise);
	        vboxRightButton.getStyleClass().add("vboxRight");
	        
	       
	        
	        
		}
		
		

		//Close window button
		public void closeWindowButton(Stage MainStage) {
			hboxFooterRight.getStyleClass().add("hboxFooterRight");
			
			// Position AnchorPane
			anchor.setBottomAnchor(hboxFooterRight, 20.0);
			anchor.setRightAnchor(hboxFooterRight, 25.0);
			
			Button btQuitter=new Button("Quitter");
	        btQuitter.setOnAction(e -> { MainStage.close(); });        
	        hboxFooterRight.getChildren().add(btQuitter);
	       
		}
		
		//createVinzone
		private void createZoneVin(Stage mainStage) {
			hboxTopSearch.getChildren().clear();
			hboxMid.getChildren().clear();		
			vinTable.getColumns().clear();
			vboxRightImage.getChildren().clear();
			gridChange.getChildren().clear();
			vinTable.setVisible(true);
			createHboxSearch();
			createTableVin();
			createHboxMidManageProduct(mainStage);
			createGridePaneChangeVin(gridChange, vboxRightImage);
			
		}
		
	
	
	
	
	//createHboxSearch (Multiple Pane usable)
	public void createHboxSearch() {
		anchor.setTopAnchor(hboxTopSearch, 25.0);
		anchor.setRightAnchor(hboxTopSearch, 25.0);
		
		hboxTopSearch.getStyleClass().add("hboxTopSearch");
		
		TextField tfCol1 = new TextField();
        TextField tfCol2 = new TextField();
        TextField tfCol3 = new TextField();
        Button btChercher = new Button("Chercher");
        hboxTopSearch.getChildren().addAll(tfCol1,tfCol2,tfCol3,btChercher);
        btChercher.getStyleClass().add("btChercher");
	}

	//createTableVin 
	public void createTableVin() {
		
	// Position AnchorPane
	anchor.setTopAnchor(vinTable, 90.0);
	anchor.setLeftAnchor(vinTable, 275.0);
	
	vinTable.getStyleClass().add("vinTable");

	
	//création tableau vin
	TableColumn<Vin, String> idCol = new TableColumn<Vin, String>("ID Produit");
	TableColumn<Vin, String> descriptionCol = new TableColumn<Vin, String>("Description");
	descriptionCol.prefWidthProperty().bind(vinTable.widthProperty().multiply(0.2));
	TableColumn<Vin, String> typeVinCol = new TableColumn<Vin, String>("Type de vin");
    TableColumn<Vin, String> origineCol = new TableColumn<Vin, String>("Origine");
    TableColumn<Vin, String> milleCol = new TableColumn<Vin, String>("Millésime");
    TableColumn<Vin, Float> prixCol = new TableColumn<Vin, Float>("Prix Unitaire");
    TableColumn<Vin, Float> StickCol = new TableColumn<Vin, Float>("Stock");
    vinTable.getColumns().addAll(idCol,descriptionCol,typeVinCol, origineCol, milleCol,prixCol,StickCol);
	}
	
	//createHboxMidManageProduct
	public void createHboxMidManageProduct(Stage MainStage) {
			anchor.setBottomAnchor(hboxMid,275.0);
			anchor.setRightAnchor(hboxMid, 260.0);		
			
			
			  
			 // création hboxMid ---> STOCK,MODIFIER,AJOUTER
			   
			 
	        Button btModifier = new Button("Modifier article");
	        btModifier.setOnAction(e -> 
	        { 
	        	gridChange.setVisible(true); 
	        	vboxRightImage.setVisible(true);
	        });   //afficher gridChange 
	        
	        Button btAjouter = new Button("Ajouter");
	        btAjouter.setOnAction(e -> 
	        { 
	        	gridChange.setVisible(true); 
	        	vboxRightImage.setVisible(true);
	        });   //afficher gridChange 
	        
	        Button btStock = new Button("Gestion stock");     
	        btStock.setOnAction(e -> { new GestionStockVin(MainStage); });
	        hboxMid.getChildren().addAll(btStock,btModifier,btAjouter);
		}
	
	//createGridPaneVin
		public void createGridePaneChangeVin(GridPane gridChange, VBox vboxRightImage) {
			gridChange.setHgap(10);
	        gridChange.setVgap(5);
	        gridChange.setAlignment(Pos.CENTER);
	        gridChange.setVisible(false);
	        
	        gridChange.getStyleClass().add("gridChange");
	        
	        anchor.setBottomAnchor(gridChange, 20.0);
			anchor.setLeftAnchor(gridChange, 275.0);
			anchor.setBottomAnchor(vboxRightImage,90.0);
			anchor.setRightAnchor(vboxRightImage, 25.0);
			
	        TextField tfNomSearch = new TextField("Nom");
	        gridChange.add(tfNomSearch,0,0,2,1);
	        tfNomSearch.getStyleClass().add("tfNomSearch");
	        
	        ComboBox<String> cbMat = new ComboBox<>(); 
	        cbMat.setValue("Maturité");
	        gridChange.add(cbMat, 0, 1, 1, 1);
	        cbMat.getStyleClass().add("cbMat");
	        
	        Label laQuantiteCaisse = new Label("Quantité par Caisse");
	        gridChange.add(laQuantiteCaisse, 0, 2,1,1);
	        
	        TextField tfQuantiteCaisse = new TextField();
	        gridChange.add(tfQuantiteCaisse,1, 2, 1, 1);
	        tfQuantiteCaisse.getStyleClass().add("tfQuantiteCaisse");
	        ComboBox<String> cbSaveur = new ComboBox<>(); 
	        
	        cbSaveur.setValue("Saveur");
	        gridChange.add(cbSaveur,3,1,1,1 ); 
	        cbSaveur.getStyleClass().add("cbSaveur");
	        
	        Label laStock = new Label("Quantité en stock");
	        gridChange.add(laStock, 0, 3,1,1);
	        
	        TextField tfStockVin = new TextField();
	        gridChange.add(tfStockVin,1,3,1,1);
	        tfStockVin.getStyleClass().add("tfStockVin");
	       
	        ComboBox<String> cbType = new ComboBox<>(); 
	        cbType.setValue("Type de vin");
	        gridChange.add(cbType, 3, 0, 1, 1);
	        cbType.getStyleClass().add("cbType");
	        
	        ComboBox<String> cbProvenance = new ComboBox<>();
	        cbProvenance.setValue("Provenance");
	        gridChange.add(cbProvenance, 4, 0,1,1);
	        cbProvenance.getStyleClass().add("cbProvenance");
	        
	        TextField tfMillesime = new TextField("Millésime");
	        gridChange.add(tfMillesime,4,1,1,1);
	        
	        TextField tfImageName = new TextField("Image");
	        gridChange.add(tfImageName,3,2,1,1);
	        
	        Button btImage = new Button("Img");
	        gridChange.add(btImage,4,2,1,1);
	        btImage.getStyleClass().add("btImage");
	        
	        Button btValider = new Button("Valider");
	        gridChange.add(btValider,4,3,1,1);
	        btValider.setOnAction(e -> 
	        { 
	        	gridChange.setVisible(false); 
	        	vboxRightImage.setVisible(false);
	        });  
	        btValider.getStyleClass().add("btValider");
	        
	        //afficher gridChange 
	        ToggleButton  rbAfficher = new RadioButton("Afficher le produit");
	        gridChange.add(rbAfficher, 3, 3,1,1);
	        rbAfficher.getStyleClass().add("rbAfficher");
	        
	        //image
	        vboxRightImage.getStyleClass().add("vboxRightImage");
			vboxRightImage.setVisible(false);
			
			
		}
/*
	private void createTableAlcool() {
		
	anchor.setTopAnchor(alcoolTable, 90.0);
	anchor.setLeftAnchor(alcoolTable, 25.0);
		
	vinTable.getStyleClass().add("vinTable");
		
	//création tableau vin
	TableColumn<Alcool, String> idCol = new TableColumn<Alcool, String>("ID Produit");
	TableColumn<Alcool, String> descriptionCol = new TableColumn<Alcool, String>("Description");
	descriptionCol.prefWidthProperty().bind(alcoolTable.widthProperty().multiply(0.4045));
	TableColumn<Alcool, String> familleCol = new TableColumn<Alcool, String>("Famille");
	TableColumn<Alcool, String> origineCol = new TableColumn<Alcool, String>("Origine");
	TableColumn<Alcool, Float> prixCol = new TableColumn<Alcool, Float>("Prix Unitaire");
	TableColumn<Alcool, Float> StockCol = new TableColumn<Alcool, Float>("Stock");
	
	alcoolTable.getColumns().addAll(idCol,descriptionCol,familleCol, origineCol,
	    		prixCol,StockCol);
	alcoolTable.setVisible(false);
	anchor.getChildren().add(alcoolTable);
	
	}
	
	
	

	

	//createGridPaneVin
	public void createGridePaneChangeVin(GridPane gridChange, VBox vboxRightImage) {
		gridChange.setHgap(10);
        gridChange.setVgap(5);
        gridChange.setAlignment(Pos.CENTER);
        gridChange.setVisible(false);
        
        gridChange.getStyleClass().add("gridChange");
        
        anchor.setBottomAnchor(gridChange, GridPosition);
		anchor.setLeftAnchor(gridChange, 20.0);
		anchor.setBottomAnchor(vboxRightImage,90.0);
		anchor.setRightAnchor(vboxRightImage, 25.0);
		
        TextField tfNomSearch = new TextField("Nom");
        gridChange.add(tfNomSearch,0,0,2,1);
        tfNomSearch.getStyleClass().add("tfNomSearch");
        
        ComboBox<String> cbMat = new ComboBox<>(); 
        cbMat.setValue("Maturité");
        gridChange.add(cbMat, 0, 1, 1, 1);
        cbMat.getStyleClass().add("cbMat");
        
        Label laQuantiteCaisse = new Label("Quantité par Caisse");
        gridChange.add(laQuantiteCaisse, 0, 2,1,1);
        
        TextField tfQuantiteCaisse = new TextField();
        gridChange.add(tfQuantiteCaisse,1, 2, 1, 1);
        tfQuantiteCaisse.getStyleClass().add("tfQuantiteCaisse");
        ComboBox<String> cbSaveur = new ComboBox<>(); 
        
        cbSaveur.setValue("Saveur");
        gridChange.add(cbSaveur,3,1,1,1 ); 
        cbSaveur.getStyleClass().add("cbSaveur");
        
        Label laStock = new Label("Quantité en stock");
        gridChange.add(laStock, 0, 3,1,1);
        
        TextField tfStockVin = new TextField();
        gridChange.add(tfStockVin,1,3,1,1);
        tfStockVin.getStyleClass().add("tfStockVin");
       
        ComboBox<String> cbType = new ComboBox<>(); 
        cbType.setValue("Type de vin");
        gridChange.add(cbType, 3, 0, 1, 1);
        cbType.getStyleClass().add("cbType");
        
        ComboBox<String> cbProvenance = new ComboBox<>();
        cbProvenance.setValue("Provenance");
        gridChange.add(cbProvenance, 4, 0,1,1);
        cbProvenance.getStyleClass().add("cbProvenance");
        
        TextField tfMillesime = new TextField("Millésime");
        gridChange.add(tfMillesime,4,1,1,1);
        
        TextField tfImageName = new TextField("Image");
        gridChange.add(tfImageName,3,2,1,1);
        
        Button btImage = new Button("Img");
        gridChange.add(btImage,4,2,1,1);
        btImage.getStyleClass().add("btImage");
        
        Button btValider = new Button("Valider");
        gridChange.add(btValider,4,3,1,1);
        btValider.setOnAction(e -> 
        { 
        	gridChange.setVisible(false); 
        	vboxRightImage.setVisible(false);
        });  
        btValider.getStyleClass().add("btValider");
        
        //afficher gridChange 
        ToggleButton  rbAfficher = new RadioButton("Afficher le produit");
        gridChange.add(rbAfficher, 3, 3,1,1);
        rbAfficher.getStyleClass().add("rbAfficher");
        
        //image
        vboxRightImage.getStyleClass().add("vboxRightImage");
		vboxRightImage.setVisible(false);
		
		anchor.getChildren().addAll(vboxRightImage,gridChange);
	}

	/*
	 * 
	 * End TabProduit ---> Tab1
	 *  
	 */
	
	
}
