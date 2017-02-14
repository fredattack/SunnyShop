package couchePr�sentation;



import classesM�tiers.Chemise;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class GestionStockChemise {
	
	private static final int LARGEUR = 544;
	private static final int HAUTEUR = 394;
	
	private Stage Fenetre = new Stage();
	private Scene SceneObj;
	private AnchorPane APZonesFenetre = new AnchorPane();
	/**
	* Constructeur: ajouter tous les objets � la fen�tre
	* @param fenParent : l'objet Stage repr�sentant la fen�tre principale
	*/
	@SuppressWarnings("unchecked")
	public GestionStockChemise(Stage fenParent){
	
	
		// APZonesFenetre -> Scene; Scene -> Stage
		SceneObj = new Scene(APZonesFenetre, LARGEUR, HAUTEUR);
		Fenetre.setScene(SceneObj);
		
		// charger les styles CSS
		SceneObj.getStylesheets().add("couchePresentation/tabPane.css");
		
		// centrer la fen�tre p/r � la fen�tre parent, la mettre en avant plan et l'afficher
		Fenetre.setTitle("Stock chemise");
		Fenetre.setResizable(false);
		
		Fenetre.setX(fenParent.getX() + (fenParent.getWidth() - LARGEUR) / 2);
		Fenetre.setY(fenParent.getY() + (fenParent.getHeight() - LARGEUR) / 2);
		
		Fenetre.initOwner(fenParent);
		Fenetre.initModality(Modality.APPLICATION_MODAL);
		Fenetre.showAndWait();
		
		HBox hbtest = new HBox();
		
		AnchorPane.setBottomAnchor(hbtest,40.0);
		AnchorPane.setRightAnchor(hbtest, 57.0);
		Label latest = new Label("test");
		hbtest.getChildren().add(latest);
		APZonesFenetre.getChildren().add(hbtest);
		
	}
}
