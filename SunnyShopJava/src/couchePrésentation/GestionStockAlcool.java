package couchePrésentation;

import classesMétiers.Alcool;
import coucheAccesBd.ExceptionAccesBd;
import coucheMétier.ExceptionMetier;
import coucheMétier.*;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
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
	private Integer nvStock = 0 ;
	private Stage stage = new Stage();
	private Scene thisScene;
	private String StockVal = "25";
	private String quantitéCaisse = "6";
	
	private AnchorPane anchor = new AnchorPane();
	HBox hboxBottom = new HBox(30);
	VBox vboxCheck = new VBox(30);
	
	Metier laCoucheMétier = new Metier();
	
	public GestionStockAlcool(Stage fenParent ,Alcool lAlcool,AnchorPane anchorZone) throws ExceptionAccesBd
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

	    remplirAnchor(stage, lAlcool, anchorZone);
	    stage.showAndWait();
    
	}
	
    private void remplirAnchor(Stage stage,Alcool lAlcool,AnchorPane anchorZone) 
    {
    	anchor.getStyleClass().add("anchor");
		
		// hboxBottom settings
		AnchorPane.setBottomAnchor(hboxBottom,40.0);
		AnchorPane.setRightAnchor(hboxBottom, 57.0);
        
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
        
      //event handler
        cbParCaisse.selectedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                cbParBout.setSelected(!newValue);
                tfNouveauStock.setVisible(true);
            }
        });

        cbParBout.selectedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                cbParCaisse.setSelected(!newValue);
                tfNouveauStock.setVisible(true);
                
            }
        });
        
        EventHandler<ActionEvent> eh = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (event.getSource() instanceof CheckBox) {
                    CheckBox chk = (CheckBox) event.getSource();
                    System.out.println("Action performed on checkbox " + chk.getText());
                    if ("chk 1".equals(chk.getText())) {
                        cbParBout.setSelected(!cbParCaisse.isSelected());
                    } else if ("chk 2".equals(chk.getText())) {
                        cbParCaisse.setSelected(!cbParBout.isSelected());
                    }
                }
            }
        };

        cbParCaisse.setOnAction(eh);
        cbParBout.setOnAction(eh);
        

        Button btValider=new Button("_Valider");
		btValider.setOnAction(e -> { 
			if (tfNouveauStock.getText()!= null)
	        {	
				if(cbParBout.isSelected()) nvStock = Integer.valueOf(tfNouveauStock.getText()) + lAlcool.getStockAlcool(); 
		        else if(cbParCaisse.isSelected()) nvStock =(Integer.valueOf(tfNouveauStock.getText())* lAlcool.getQuantitéCaisse()) + lAlcool.getStockAlcool(); 
	        	lAlcool.setStockAlcool(nvStock);
	        	try {
					
					laCoucheMétier.ModifierAlcool(lAlcool);
					new MessageBox(stage, AlertType.WARNING, "Le Nouveau stock est de "+ String.valueOf(nvStock) +" .");
					
					anchorZone.getChildren().clear();
					ZoneProduit laZone = new ZoneProduit();
					laZone.clearAnchorProduct();
					laZone.createZoneProduit(anchorZone, stage);
					laZone.createZoneAlcool(anchorZone, stage);
					
	        	}
				
				 catch (ExceptionAccesBd | ExceptionMetier e1) {
					// TODO Auto-generated catch block
					 new MessageBox(stage, AlertType.WARNING, "L'ajout de n' a pas eu lieu!");}
				}
	        
			else {
				new MessageBox(stage, AlertType.WARNING, "Veuillez indiquer les nombre de bouteilles à ajouter.");
				
			}
			
			
			stage.close(); }); 
        
		Button btAnnuler=new Button("_Annuler");
        btAnnuler.setOnAction(e -> { stage.close(); }); 
        hboxBottom.getChildren().addAll(btAnnuler,btValider);
	}
	
	
	
}
