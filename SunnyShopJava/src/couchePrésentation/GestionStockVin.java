package couchePrésentation;

import classesMétiers.Vin;
import coucheAccesBd.ExceptionAccesBd;
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
	private Integer nvStock = 0 ;
	private Stage stage = new Stage();
	//private Stage fenPrincipal = new Stage();
	private Scene thisScene;
	private AnchorPane anchor = new AnchorPane();
	HBox hboxBottom = new HBox(30);
	VBox vboxCheck = new VBox(30);
	
	Metier laCoucheMétier = new Metier();
	
	public GestionStockVin(Stage fenParent,Vin leVin,AnchorPane anchorZone ) throws ExceptionAccesBd{
	
	//fenPrincipal=fenParent;	 
	thisScene = new Scene(anchor,LARGEUR, HAUTEUR);
	stage.setScene(thisScene);
	anchor.getChildren().addAll(hboxBottom,vboxCheck);
	thisScene.getStylesheets().add("couchePrésentation/tabPane.css");
	thisScene.setFill(Color.TRANSPARENT);
	stage.setTitle("StockVal");
    stage.initOwner(fenParent);
    stage.initModality(Modality.APPLICATION_MODAL); 
    stage.initStyle(StageStyle.TRANSPARENT);
    
    remplirAnchor(stage,leVin,anchorZone);
    stage.showAndWait();
    
	}

	
	//@SuppressWarnings("static-access")
	private void remplirAnchor(Stage stage,Vin leVin,AnchorPane anchorZone) {
		
		anchor.getStyleClass().add("anchor");
		
		// hboxBottom settings
		AnchorPane.setBottomAnchor(hboxBottom,40.0);
		AnchorPane.setRightAnchor(hboxBottom, 57.0);
		
        //hboxTop settings        
        AnchorPane.setTopAnchor(vboxCheck, 50.0);
        AnchorPane.setRightAnchor(vboxCheck, 170.0);
        
        Label LaStock = new Label("Stock Actuel : "+ String.valueOf(leVin.getStockVin()));
        vboxCheck.getChildren().add(LaStock);
        LaStock.getStyleClass().add("LaStock");
		
        CheckBox cbParCaisse = new CheckBox("Ajouter par caisse ("+String.valueOf(leVin.getQuantitéCaisse())+")");
        CheckBox cbParBout = new CheckBox("Ajouter par bouteille");
        
        TextField tfNouveauStock = new TextField();
        tfNouveauStock.getStyleClass().add("tfNouveaustock");
        vboxCheck.getChildren().addAll(cbParBout,cbParCaisse,tfNouveauStock);
        tfNouveauStock.setVisible(false);
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
				if(cbParBout.isSelected()) nvStock = Integer.valueOf(tfNouveauStock.getText()) + leVin.getStockVin(); 
		        else if(cbParCaisse.isSelected()) nvStock =(Integer.valueOf(tfNouveauStock.getText())* leVin.getQuantitéCaisse()) + leVin.getStockVin(); 
	        	leVin.setStockVin(nvStock);
	        	try {
					laCoucheMétier.ModifierVin(leVin);
					new MessageBox(stage, AlertType.WARNING, "Le Nouveaustock est de "+ String.valueOf(nvStock) +" .");
					
					anchorZone.getChildren().clear();
					ZoneProduit laZone = new ZoneProduit();
					laZone.clearAnchorProduct();
					laZone.createZoneProduit(anchorZone, stage);
					laZone.createZoneVin(anchorZone, stage, hboxBottom);
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
