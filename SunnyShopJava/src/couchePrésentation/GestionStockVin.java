package couchePrésentation;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

//@SuppressWarnings("unused")
public class GestionStockVin {
	
	private static final int LARGEUR = 544;
	private static final int HAUTEUR = 394;

	// objet de la fenêtre 
	private Stage stage = new Stage();
	private Scene thisScene;
	private String StockVal = "25";
	private String quantitéCaisse = "6";
	private AnchorPane anchor = new AnchorPane();
	HBox hboxTop = new HBox();
	HBox hboxBottom = new HBox(30);
	VBox vboxCheck = new VBox(10);
	
	 public GestionStockVin(Stage fenParent ) {
		
	thisScene = new Scene(anchor,LARGEUR, HAUTEUR);
	stage.setScene(thisScene);
	
	thisScene.getStylesheets().add("couchePrésentation/tabPane.css");
	thisScene.setFill(Color.TRANSPARENT);
	stage.setTitle("StockVal");
    stage.initOwner(fenParent);
    stage.initModality(Modality.APPLICATION_MODAL); 
  //  stage.initStyle(StageStyle.DECORATED);
    stage.showAndWait();
    //stage.setX(fenParent.getX() +(fenParent.getMaxWidth()-LARGEUR)/2);
    //stage.setY(fenParent.getY() +(fenParent.getMaxHeight()-HAUTEUR)/2);
   
    remplirAnchor(stage);
	}

	
	//@SuppressWarnings("static-access")
	private void remplirAnchor(Stage stage) {
		
		
		//thisScene.getStylesheets().add("couchePrésentation/tabPane.css");
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
        AnchorPane.setTopAnchor(hboxTop, 10.0);
        AnchorPane.setRightAnchor(hboxTop, 175.0);
        
        Label LaStock = new Label("Stock Actuel : "+ StockVal);
        hboxTop.getChildren().add(LaStock);
        
        //vboxCheck settings
        AnchorPane.setTopAnchor(vboxCheck, 70.0);
        AnchorPane.setRightAnchor(vboxCheck, 125.0);
        
		CheckBox cbParCaisse = new CheckBox("Ajouter par caisse ("+quantitéCaisse+")");
        CheckBox cbParBout = new CheckBox("Ajouter par bouteille");
        vboxCheck.getChildren().addAll(cbParBout,cbParCaisse);     
        
        anchor.getChildren().addAll(hboxTop,hboxBottom,vboxCheck);
	}

	
}
