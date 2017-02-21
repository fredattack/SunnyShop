package couchePrésentation;

import javafx.stage.Stage;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.Modality;


public class MessageBox {
	private final int Largeur = 350;
	private final int Hauteur = 100;
	// objets de la fenêtre
	private Stage Fenetre = new Stage();
	private HBox HBMsg = new HBox(20);
	private AnchorPane APZonesFenetre = new AnchorPane();
	private Scene SceneObj;
	private Button BFermer = new Button("Fermer");
	private ImageView IVImage;
	/**
	* Constructeur : ajouter tous les objets à la fenêtre
	* @param fenParent : l'objet Stage représentant la fenêtre principale
	* @param type : la nature du message à afficher
	* @param msg : le message à afficher
	* */
		public MessageBox(Stage fenParent, AlertType type, String msg)
		{
		// déterminer l'image à Afficher en fonction de la nature du message
		if(type == AlertType.INFORMATION)
		{
		IVImage = new ImageView(new Image("file:imgs/imgsmsgbox/information.jpg"));
		Fenetre.setTitle("Information");
		}else if(type == AlertType.WARNING)
		{
		IVImage = new ImageView(new Image("file:imgs/imgsmsgbox/attention.jpg"));
		Fenetre.setTitle("Attention");
		}else if(type == AlertType.ERROR)
		{
		IVImage = new ImageView(new Image("file:imgs/imgsmsgbox/erreur.jpg"));
		Fenetre.setTitle("Erreur");
		}
		// paramétrer le bouton BFermer
		BFermer.setPrefSize(80, 20);
		BFermer.setOnAction(e -> { Fenetre.close(); });
		// IVImage et Label -> HBMsg
		HBMsg.getChildren().addAll(IVImage, new Label(msg));
		HBMsg.setAlignment(Pos.CENTER);
		// HBMsg et TVProfs -> APZonesFenetre
		APZonesFenetre.getChildren().addAll(HBMsg, BFermer);
		AnchorPane.setTopAnchor(HBMsg, 15.0);
		AnchorPane.setLeftAnchor(HBMsg, 15.0);
		AnchorPane.setBottomAnchor(BFermer, 15.0);
		AnchorPane.setRightAnchor(BFermer, 15.0);
		// APZonesFenetre -> Scene; Scene -> Stage
		SceneObj = new Scene(APZonesFenetre, Largeur, Hauteur);
		Fenetre.setScene(SceneObj);
		// faire qu'il ne se passe rien quand clic sur la croix dans le coin de la fenêtre
		Fenetre.setOnCloseRequest(e -> { e.consume(); });
		// centrer la fenêtre p/r à la fenêtre parent, la mettre en avant plan et l'afficher
		Fenetre.setResizable(false);
		//Fenetre.setX(fenParent.getX() + (fenParent.getWidth() - Largeur) / 2);
		//Fenetre.setY(fenParent.getY() + (fenParent.getHeight() - Hauteur) / 2);
		Fenetre.initOwner(fenParent);
		Fenetre.initModality(Modality.APPLICATION_MODAL);
		Fenetre.showAndWait();
		}

}
