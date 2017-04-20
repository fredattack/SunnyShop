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
import coucheAccesBd.*;
import coucheMétier.*;




@SuppressWarnings("unused")
public class MainStage extends Application {
	
	static Metier laCoucheMétier ;
	
	// déclaratiens des conteneurs
	private Scene scene;
	private AnchorPane anchorPrincipal = new AnchorPane();
	private VBox vboxSectionLeft = new VBox(10);	
	
	private AnchorPane anchorZone =  new AnchorPane();
	
	private int LARGEUR = 1300;
	private int HAUTEUR = 840;
	
	// Main
		public static void main(String[] args)
		{
			//Connect To DB
			
			try
			{
				laCoucheMétier = new Metier();
			
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
	scene = new Scene(anchorPrincipal,LARGEUR, HAUTEUR);
	
	//css
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
	
	Button btProduit = new Button("_Produits");
	btProduit.setOnAction(e->
        { 
        	anchorZone.getChildren().clear();
        	ZoneProduit zone = null;
			try {
				zone = new ZoneProduit();
			} catch (ExceptionAccesBd e1) {
				
				e1.printStackTrace();
			}
        	zone.createZoneProduit(anchorZone, MainStage);
        });
	Button btCommandes = new Button("_Commandes");
	btCommandes.setOnAction(e->
    { 
    	anchorZone.getChildren().clear();
    	ZoneCommande zone = null;
		try {
			zone = new ZoneCommande();
		} catch (ExceptionAccesBd e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
    	try {
			zone.CreateZoneCommande(anchorZone,MainStage);
		} catch (ExceptionAccesBd e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
    });
	Button btClients = new Button("C_lients");
	btClients.setOnAction(e->
    { 
    	anchorZone.getChildren().clear();
    	ZoneClients zone = null;
		try {
			zone = new ZoneClients();
		} catch (ExceptionAccesBd e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
    	zone.createZoneClients(anchorZone,MainStage);
    	
    });
	Button btQuit = new Button("_Quitter");
	btQuit.setOnAction(e->
    { 
    	MainStage.close();
    	
    });

	vboxSectionLeft.getChildren().addAll(btProduit,btCommandes,btClients,btQuit);
	}


	

}
