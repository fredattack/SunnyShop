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
import classesMétiers.Chemise;
import classesMétiers.Vin;
import coucheAccesBd.ExceptionAccesBd;
import coucheMétier.*;




@SuppressWarnings("unused")
public class MainStage extends Application {
	
	private static Metier CoucheMetier;
	
	// déclaratiens des conteneurs
	private Scene scene;
	
    //private BorderPane mainPane = new BorderPane();
	private static final AnchorPane anchorPrincipal = new AnchorPane();
	private static final AnchorPane anchorZone =  new AnchorPane();
	private static VBox vboxSectionLeft = new VBox(10);	
	
	private static TableView<Vin> vinTable = new TableView<Vin>();	
	private static TableView<Alcool> alcoolTable = new TableView<Alcool>();
	private static TableView<Chemise> chemiseTable = new TableView<Chemise>();
	private static HBox hboxTopSearch = new HBox(27);
	private static HBox hboxMid = new HBox(10);
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
	
    
	scene = new Scene(anchorPrincipal,LARGEUR, HAUTEUR);
	scene.getStylesheets().add("couchePrésentation/tabPane.css");
	anchorPrincipal.getStyleClass().add("anchor");
	anchorZone.getStyleClass().add("Zone");
    
    
     // MainStage Designer
 
    MainStage.initStyle(StageStyle.TRANSPARENT);
    scene.setFill(Color.TRANSPARENT);
    MainStage.setScene(scene);
    MainStage.show();
    
    //anchorContent @start
    anchorPrincipal.getChildren().addAll(vboxSectionLeft,anchorZone);
   
    
    vinTable.setVisible(false);
    alcoolTable.setVisible(false);
    chemiseTable.setVisible(false);
    anchorPrincipal.setTopAnchor(anchorZone, 0.0);
    anchorPrincipal.setLeftAnchor(anchorZone, 225.0);
    anchorPrincipal.setBottomAnchor(anchorZone, 0.0);
    anchorPrincipal.setRightAnchor(anchorZone, 0.0);
    
    // startContent
    createStartContent(MainStage);
	}
	
	//create strat content
	public void createStartContent(Stage MainStage) {
		
	
	
	// Css Conteneur
	vboxSectionLeft.getStyleClass().add("vboxSectionLeft");
			
	// Position AnchorPane
	anchorPrincipal.setTopAnchor(vboxSectionLeft,5.0);
	anchorPrincipal.setLeftAnchor(vboxSectionLeft, 25.0);
	
	Button btProduit = new Button("Produits");
	btProduit.setOnAction(e->
        { 
        	clearAnchorProduct();
        	vboxRightButton.getChildren().clear();
        	//vboxSectionLeft.getChildren().clear();
        	anchorZone.getChildren().clear();
        	createStartContent(MainStage);
        	createCommonContainer(MainStage);
        	//closeWindowButton(MainStage);
        });
	Button btCommandes = new Button("Commandes");
	btCommandes.setOnAction(e->
    { 
    	clearAnchorProduct();
    	vboxRightButton.getChildren().clear();
    	vboxSectionLeft.getChildren().clear();
    	createStartContent(MainStage);
    	//anchorZone.getChildren().clear();
    	
    	ZoneCommande zone = new ZoneCommande();
    	zone.CreateZoneCommande(anchorZone);
    	
    	
    });
	Button btClients = new Button("Clients");
	btClients.setOnAction(e->
    { 
    	clearAnchorProduct();
    	vboxRightButton.getChildren().clear();
    	vboxSectionLeft.getChildren().clear();
    	createStartContent(MainStage);
    	anchorZone.getChildren().clear();
    	
    	ZoneClients zone = new ZoneClients();
    	zone.createZoneClients(anchorZone);
    	
    });
	
	Button btQuit = new Button("Quitter");
	btQuit.setOnAction(e->
    { 
    	MainStage.close(); 
    });
	vboxSectionLeft.getChildren().addAll(btProduit,btCommandes,btClients,btQuit);
	
	
	 //création hboxFooter---> Quitter
        
	}
	
	/*
	 * 
	 *Zone Produit ---->start
	 * 
	 */
	
	//createCommonPane Container (Multiple Pane usable)
		@SuppressWarnings({ "static-access"})
	public void createCommonContainer(Stage MainStage) {
			
		
			// Css Conteneur
			vboxRightButton.getStyleClass().add("vboxRightButton");
			
			// Position AnchorPane
			anchorZone.setTopAnchor(vboxRightButton,150.0);
			anchorZone.setRightAnchor(vboxRightButton, 25.0);
			
	        /*
	         * 
	         * création vboxRight     --->TYPE PRODUIT
	         *    
	         */
	        Button btVin=new Button("Vin");
	        btVin.setOnAction(e->
	        { 
	        	vboxRightButton.getChildren().clear();
	        	anchorZone.getChildren().clear();
	        	createCommonContainer(MainStage);
	        	createZoneVin(MainStage);
	        	
	        });
	        
	        Button btAlcool=new Button("Alcool");
	        btAlcool.setOnAction(e->
	        {         	
	        	vboxRightButton.getChildren().clear();
	        	anchorZone.getChildren().clear();
	        	createCommonContainer(MainStage);
	        	createZoneAlcool(MainStage);
	        });
	        
	        Button btChemise=new Button("Chemise");
	        btChemise.setOnAction(e->
	        {         	
	        	vboxRightButton.getChildren().clear();
	        	anchorZone.getChildren().clear();
	        	createCommonContainer(MainStage);
	        	createZoneChemise(MainStage);
	        });
	        vboxRightButton.getChildren().addAll(btVin,btAlcool,btChemise);
	        vboxRightButton.getStyleClass().add("vboxRight");
	        anchorZone.getChildren().addAll(vboxRightButton);
	       
	        
	        
		}
		
	//createVinzone
	private void createZoneVin(Stage mainStage) {
		clearAnchorProduct();
		vinTable.setVisible(true);
		createHboxSearch();
		createTableVin();
		createHboxMidManageProduct(mainStage);
		createGridePaneChangeVin(gridChange, vboxRightImage);
		
	}
	
	//create Zone Alcool
	private void createZoneAlcool(Stage mainStage){
		clearAnchorProduct();
		createTableAlcool();
		alcoolTable.setVisible(true);
		createHboxSearch();
		createHboxMidManageProduct(mainStage);
		createGridePaneChangeAlcool(gridChange, vboxRightImage);
		
	}
	
	//create zone chemise
	
	private void createZoneChemise(Stage mainStage)
	{
		clearAnchorProduct();
		createTableChemise();
		chemiseTable.setVisible(true);
		createHboxSearch();
		createHboxMidManageProduct(mainStage);
		createGridePaneChangeChemise(gridChange, vboxRightImage);
	}
	
	//clear AnchorProduct
	public void clearAnchorProduct() {
		hboxTopSearch.getChildren().clear();
		hboxMid.getChildren().clear();		
		vinTable.getColumns().clear();
		alcoolTable.getColumns().clear();
		chemiseTable.getColumns().clear();
		vboxRightImage.getChildren().clear();
		gridChange.getChildren().clear();
		vinTable.setVisible(false);
		alcoolTable.setVisible(false);
		chemiseTable.setVisible(false);
	}
	
	//createHboxSearch (Multiple Pane usable)
	public void createHboxSearch() {
		anchorZone.setTopAnchor(hboxTopSearch, 25.0);
		anchorZone.setRightAnchor(hboxTopSearch, 25.0);
		
		hboxTopSearch.getStyleClass().add("hboxTopSearch");
		
		TextField tfCol1 = new TextField();
        TextField tfCol2 = new TextField();
        TextField tfCol3 = new TextField();
        Button btChercher = new Button("Chercher");
        hboxTopSearch.getChildren().addAll(tfCol1,tfCol2,tfCol3,btChercher);
        btChercher.getStyleClass().add("btChercher");
        anchorZone.getChildren().addAll(hboxTopSearch);
	}

	//createTableVin 
	public void createTableVin() {
		
	// Position AnchorPane
	anchorZone.setTopAnchor(vinTable, 90.0);
	anchorZone.setLeftAnchor(vinTable, 50.0);
	
	vinTable.getStyleClass().add("Table");

	
	//création tableau vin
	TableColumn<Vin, String> idCol = new TableColumn<Vin, String>("ID Produit");
	TableColumn<Vin, String> descriptionCol = new TableColumn<Vin, String>("Description");
	descriptionCol.prefWidthProperty().bind(vinTable.widthProperty().multiply(0.4045));
	TableColumn<Vin, String> typeVinCol = new TableColumn<Vin, String>("Type de vin");
    TableColumn<Vin, String> origineCol = new TableColumn<Vin, String>("Origine");
    TableColumn<Vin, String> milleCol = new TableColumn<Vin, String>("Millésime");
    TableColumn<Vin, Float> prixCol = new TableColumn<Vin, Float>("Prix Unitaire");
    TableColumn<Vin, Float> StickCol = new TableColumn<Vin, Float>("Stock");
    vinTable.getColumns().addAll(idCol,descriptionCol,typeVinCol, origineCol, milleCol,prixCol,StickCol);
    anchorZone.getChildren().addAll(vinTable);
	}
	
	//create alcoolTable
	private void createTableAlcool() {
		
	anchorZone.setTopAnchor(alcoolTable, 90.0);
	anchorZone.setLeftAnchor(alcoolTable, 50.0);
		
	alcoolTable.getStyleClass().add("Table");
		
	//création tableau alcool
	TableColumn<Alcool, String> idCol = new TableColumn<Alcool, String>("ID Produit");
	TableColumn<Alcool, String> descriptionCol = new TableColumn<Alcool, String>("Description");
	descriptionCol.prefWidthProperty().bind(alcoolTable.widthProperty().multiply(0.445));
	TableColumn<Alcool, String> familleCol = new TableColumn<Alcool, String>("Famille");
	TableColumn<Alcool, String> origineCol = new TableColumn<Alcool, String>("Origine");
	TableColumn<Alcool, Float> prixCol = new TableColumn<Alcool, Float>("Prix Unitaire");
	TableColumn<Alcool, Float> StockCol = new TableColumn<Alcool, Float>("Stock");
	
	alcoolTable.getColumns().addAll(idCol,descriptionCol,familleCol, origineCol,
	    		prixCol,StockCol);
	alcoolTable.setVisible(false);
	anchorZone.getChildren().addAll(alcoolTable);
	
	}
	
	//create chemiseTable
	private void createTableChemise(){
	anchorZone.setTopAnchor(chemiseTable, 90.0);
	anchorZone.setLeftAnchor(chemiseTable, 50.0);
		
	chemiseTable.getStyleClass().add("Table");
		
	//création tableau alcool
	TableColumn<Chemise, String> idCol = new TableColumn<Chemise, String>("ID Produit");
	TableColumn<Chemise, String> descriptionCol = new TableColumn<Chemise, String>("Description");
	descriptionCol.prefWidthProperty().bind(chemiseTable.widthProperty().multiply(0.4045));
	TableColumn<Chemise, String> tailleCol = new TableColumn<Chemise, String>("Taille");
	TableColumn<Chemise, Float> prixCol = new TableColumn<Chemise, Float>("Prix Unitaire");
	TableColumn<Chemise, Float> StockCol = new TableColumn<Chemise, Float>("Stock");
	
	chemiseTable.getColumns().addAll(idCol,descriptionCol,tailleCol,
	    		prixCol,StockCol);
	chemiseTable.setVisible(false);
	anchorZone.getChildren().addAll(chemiseTable);
	}
	
	//createHboxMidManageProduct
	public void createHboxMidManageProduct(Stage MainStage) {
			anchorZone.setBottomAnchor(hboxMid,275.0);
			anchorZone.setRightAnchor(hboxMid, 260.0);		
			  
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
	        if(vinTable.isVisible()){
	        btStock.setOnAction(e -> { 
	        	new GestionStockVin(MainStage);});
	        }
	        else if(alcoolTable.isVisible()){
		        btStock.setOnAction(e -> { new GestionStockAlcool(MainStage); });
	        }
	        else if (chemiseTable.isVisible()){
	        	btStock.setOnAction(e -> { new GestionStockChemise(MainStage); });
	        }
	        
	        hboxMid.getChildren().addAll(btStock,btModifier,btAjouter);
	        anchorZone.getChildren().addAll(hboxMid);
		}
	
	//create GridPane Change VIN
	public void createGridePaneChangeVin(GridPane gridChange, VBox vboxRightImage) {
			gridChange.setHgap(10);
	        gridChange.setVgap(5);
	        gridChange.setAlignment(Pos.CENTER);
	        gridChange.setVisible(false);
	        
	        gridChange.getStyleClass().add("gridChange");
	        
	        anchorZone.setBottomAnchor(gridChange, 20.0);
			anchorZone.setLeftAnchor(gridChange, 50.0);
			anchorZone.setBottomAnchor(vboxRightImage,20.0);
			anchorZone.setRightAnchor(vboxRightImage, 25.0);
			
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
			
			 anchorZone.getChildren().addAll(vboxRightImage,gridChange);
		}

	//create GridPane Change ALCOOl
	public void createGridePaneChangeAlcool(GridPane gridChange, VBox vboxRightImage) {
		gridChange.setHgap(10);
        gridChange.setVgap(5);
        gridChange.setAlignment(Pos.CENTER);
        gridChange.setVisible(false);
        
        gridChange.getStyleClass().add("gridChange");
        
        anchorZone.setBottomAnchor(gridChange, GridPosition);
		anchorZone.setLeftAnchor(gridChange, 50.0);
		anchorZone.setBottomAnchor(vboxRightImage,20.0);
		anchorZone.setRightAnchor(vboxRightImage, 25.0);
		
        TextField tfNomSearch = new TextField("Nom");
        gridChange.add(tfNomSearch,0,0,2,1);
        tfNomSearch.getStyleClass().add("tfNomSearch");
        
        
        Label laQuantiteCaisse = new Label("Quantité par Caisse");
        gridChange.add(laQuantiteCaisse, 0, 2,1,1);
        
        TextField tfQuantiteCaisse = new TextField();
        gridChange.add(tfQuantiteCaisse,1, 2, 1, 1);
        tfQuantiteCaisse.getStyleClass().add("tfQuantiteCaisse");

        TextField tfGout = new TextField("Gout"); 
        gridChange.add(tfGout,3,1,1,1 ); 
        tfGout.getStyleClass().add("tfGout");
        
        Label laStock = new Label("Quantité en stock");
        gridChange.add(laStock, 0, 3,1,1);
        
        TextField tfStockAlcool = new TextField();
        gridChange.add(tfStockAlcool,1,3,1,1);
        tfStockAlcool.getStyleClass().add("tfStockAlcool");
       
        ComboBox<String> cbFamille = new ComboBox<>(); 
        cbFamille.setValue("Famille");
        gridChange.add(cbFamille, 3, 0, 1, 1);
        cbFamille.getStyleClass().add("cbFamille");
        
        ComboBox<String> cbProvenance = new ComboBox<>();
        cbProvenance.setValue("Provenance");
        gridChange.add(cbProvenance, 4, 0,1,1);
        cbProvenance.getStyleClass().add("cbProvenance");
        
        TextField tfDegreAlcool = new TextField("Degré");
        gridChange.add(tfDegreAlcool,4,1,1,1);
        tfDegreAlcool.getStyleClass().add("tfDegre");
        
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
		
		 anchorZone.getChildren().addAll(vboxRightImage,gridChange);
	}

	//create GridPane Change VIN
	public void createGridePaneChangeChemise(GridPane gridChange, VBox vboxRightImage) {
			gridChange.setHgap(10);
	        gridChange.setVgap(5);
	        gridChange.setAlignment(Pos.CENTER);
	        gridChange.setVisible(false);
	        
	        gridChange.getStyleClass().add("gridChange");
	        
	        anchorZone.setBottomAnchor(gridChange, 20.0);
			anchorZone.setLeftAnchor(gridChange, 50.0);
			anchorZone.setBottomAnchor(vboxRightImage,20.0);
			anchorZone.setRightAnchor(vboxRightImage, 25.0);
			
	        TextField tfNomSearch = new TextField("Nom");
	        gridChange.add(tfNomSearch,0,0,2,1);
	        tfNomSearch.getStyleClass().add("tfNomSearch");
	        
	        ComboBox<String> cbMat = new ComboBox<>(); 
	        cbMat.setValue("Matière");
	        gridChange.add(cbMat, 0, 1, 1, 1);
	        cbMat.getStyleClass().add("cbMat");
	        
	        ComboBox<String> cbSaveur = new ComboBox<>(); 
	        cbSaveur.setValue("Saveur");
	        gridChange.add(cbSaveur,3,1,1,1 ); 
	        cbSaveur.getStyleClass().add("cbSaveur");
	        
	        Label laStock = new Label("Quantité en stock");
	        gridChange.add(laStock, 0, 3,1,1);
	        
	        TextField tfStockVin = new TextField();
	        gridChange.add(tfStockVin,1,3,1,1);
	        tfStockVin.getStyleClass().add("tfStockVin");
	       
	        ComboBox<String> cbTaille = new ComboBox<>(); 
	        cbTaille.setValue("Taille");
	        gridChange.add(cbTaille, 3, 0, 1, 1);
	        cbTaille.getStyleClass().add("cbTaille");
	        
	        TextField tfCouleur = new TextField("Couleur");
	        gridChange.add(tfCouleur,4,0,1,1);
	        
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
			
			 anchorZone.getChildren().addAll(vboxRightImage,gridChange);
		}

	/*
	 * 
	 * End TabProduit ---> Tab1
	 *  
	 */
	
	
}
