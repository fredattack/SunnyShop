package couchePrésentation;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class GestionStockAlcool {

	private static final int LARGEUR = 544;
	private static final int HAUTEUR = 394;

	// objet de la fenêtre 
	private Stage stage = new Stage();
	private Scene thisScene;
	private String StockVal = "25";
	private String quantitéCaisse = "6";
	
	private AnchorPane anchor = new AnchorPane();
	HBox hboxBottom = new HBox(30);
	VBox vboxCheck = new VBox(30);
	
	public GestionStockAlcool(Stage fenParent ) 
	{

		 
		thisScene = new Scene(anchor,LARGEUR, HAUTEUR);
		stage.setScene(thisScene);
		anchor.getChildren().addAll(hboxBottom,vboxCheck);
		thisScene.getStylesheets().add("couchePrésentation/tabPane.css");
		thisScene.setFill(Color.TRANSPARENT);
		stage.setTitle("StockVal");
	    stage.initOwner(fenParent);
	    stage.initModality(Modality.APPLICATION_MODAL); 
	    stage.initStyle(StageStyle.TRANSPARENT);
	    

	    remplirAnchor(stage);
	    stage.showAndWait();
    
	}
	
    private void remplirAnchor(Stage stage) 
    {
    	anchor.getStyleClass().add("anchor");
		
		// hboxBottom settings
		AnchorPane.setBottomAnchor(hboxBottom,40.0);
		AnchorPane.setRightAnchor(hboxBottom, 57.0);
		
		Button btValider=new Button("Valider");
		btValider.setOnAction(e -> { stage.close(); }); 
        
		Button btAnnuler=new Button("Annuler");
        btAnnuler.setOnAction(e -> { stage.close(); }); 
        hboxBottom.getChildren().addAll(btAnnuler,btValider); 
        
        //hboxTop settings        
        AnchorPane.setTopAnchor(vboxCheck, 50.0);
        AnchorPane.setRightAnchor(vboxCheck, 170.0);
        
        Label LaStock = new Label("Stock Actuel : "+ StockVal);
        vboxCheck.getChildren().add(LaStock);
        LaStock.getStyleClass().add("LaStock");
		
        CheckBox cbParCaisse = new CheckBox("Ajouter par caisse ("+quantitéCaisse+")");
        CheckBox cbParBout = new CheckBox("Ajouter par bouteille");
        
        TextField tfNouveauStock = new TextField();
        tfNouveauStock.getStyleClass().add("tfNouveaustock");
        vboxCheck.getChildren().addAll(cbParBout,cbParCaisse,tfNouveauStock);  
        vboxCheck.setAlignment(Pos.CENTER);
	}
	
	
	
}
