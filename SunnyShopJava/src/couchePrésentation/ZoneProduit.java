package couchePrésentation;

import coucheMétier.*;
import coucheAccesBd.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import com.sun.javafx.geom.transform.GeneralTransform3D;

import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;
import classesMétiers.*;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.geometry.Pos;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class ZoneProduit {
	ObservableList<String> laListeMaturation = null;
	ObservableList<String> laListeProvenanceVin = null;
	ObservableList<String> laListeProvenanceAlcool = null;
	ObservableList<String> laListeFamilleAlcool = null;
	ObservableList<String> laListeType = null;
	ObservableList<String> laListeSaveur = null;
	ObservableList<String> laListeMatiere = null;
	ObservableList<Vin> laListeDeVin = null;
	Metier laCoucheMétier = new Metier();
	private Vin leVin; 
	private int leMaxNumVin;

	private Alcool lAlcool = new Alcool();
	private int leMaxNumAlcool;
	
	private Chemise laChemise = new Chemise();
	private List<Chemise> laListeChemise;
	
	private Button btModifier = new Button("_Modifier article");
	private Button btAjouter = new Button("A_jouter");
	private Button btStock = new Button("Au_gmenter stock");
	private static TableView<Vin> vinTable = new TableView<Vin>();
	private static TableView<Alcool> alcoolTable = new TableView<Alcool>();
	private static TableView<Chemise> chemiseTable = new TableView<Chemise>();
	private static HBox hboxTopSearch = new HBox(27);
	private static HBox hboxMid = new HBox(10);
	private static VBox vboxRightButton = new VBox(10);
	private static GridPane gridChange = new GridPane();
	private ImageView imgView = new ImageView();

	
	
	//Constructeur
	public ZoneProduit() throws ExceptionAccesBd {
		//les listes Vins
		laListeProvenanceVin = FXCollections.observableArrayList(laCoucheMétier.ListerProvenanceVin());
		laListeType = FXCollections.observableArrayList(laCoucheMétier.ListerTypeVin());
		laListeMaturation = FXCollections.observableArrayList(laCoucheMétier.ListerMaturationVin());
		laListeSaveur = FXCollections.observableArrayList(laCoucheMétier.ListerSaveurVin());
		leMaxNumVin = laCoucheMétier.GetMaxNumVin()+2;
		//les listes Alcool
		laListeProvenanceAlcool = FXCollections.observableArrayList(laCoucheMétier.ListerProvenanceAlcool());
		laListeFamilleAlcool = FXCollections.observableArrayList(laCoucheMétier.ListerFamilleAlcool());
		leMaxNumAlcool=laCoucheMétier.GetMaxNumAlcool();
		//les listes Chemise
		laListeMatiere = FXCollections.observableArrayList(laCoucheMétier.ListerMatièreChemise());
		
	}

	/*
	 * 
	 * Zone produit commune
	 * 
	 */
	public void createZoneProduit(AnchorPane anchorZone, Stage MainStage) {
		createCommonContainer(anchorZone, MainStage);
		
	}

	// createCommon Container (Multiple Pane usable)
	@SuppressWarnings({ "static-access" })
	public void createCommonContainer(AnchorPane anchorZone, Stage MainStage) {

		vboxRightButton.getChildren().clear();
		
		// Position AnchorPane et css
		anchorZone.setTopAnchor(vboxRightButton, 150.0);
		anchorZone.setRightAnchor(vboxRightButton, 25.0);
		vboxRightButton.getStyleClass().add("vboxRightButton");
		vboxRightButton.getStyleClass().add("vboxRight");

		// image
		HBox HbImage = new HBox();
		anchorZone.setBottomAnchor(HbImage, 20.0);
		anchorZone.setRightAnchor(HbImage, 25.0);
		HbImage.getStyleClass().add("vboxRightImage");
	    HbImage.getChildren().add(imgView);
			    
			    
		//Création des Boutons 
		Button btVin = new Button("_Vin");
		btVin.setOnAction(e -> {
			anchorZone.getChildren().clear();
			createCommonContainer(anchorZone, MainStage);
			createZoneVin(anchorZone, MainStage, HbImage);
		});

		Button btAlcool = new Button("_Alcool");
		btAlcool.setOnAction(e -> {
			anchorZone.getChildren().clear();
			createCommonContainer(anchorZone, MainStage);
			createZoneAlcool(anchorZone, MainStage);
		});

		Button btChemise = new Button("_Chemise");
		btChemise.setOnAction(e -> {
			anchorZone.getChildren().clear();
			createCommonContainer(anchorZone, MainStage);
			createZoneChemise(anchorZone, MainStage);
		});
		
		
	    vboxRightButton.getChildren().addAll(btVin, btAlcool, btChemise);
	    anchorZone.getChildren().addAll(vboxRightButton,HbImage);
		
	}

	// clear AnchorProduct
	public void clearAnchorProduct() {
		hboxTopSearch.getChildren().clear();
		hboxMid.getChildren().clear();
		vinTable.getColumns().clear();
		alcoolTable.getColumns().clear();
		chemiseTable.getColumns().clear();
		gridChange.getChildren().clear();
		vinTable.setVisible(false);
		alcoolTable.setVisible(false);
		chemiseTable.setVisible(false);
	}

	

	// createHboxMidManageProduct
	public void createHboxMidManageProduct(AnchorPane anchorZone, Stage MainStage) {

		anchorZone.setBottomAnchor(hboxMid, 275.0);
		anchorZone.setRightAnchor(hboxMid, 260.0);
	
		// création hboxMid ---> STOCK,MODIFIER,AJOUTER
		
		//bouton MODIFIER
		btModifier.setVisible(false);
		btModifier.setOnAction(e -> 
		{
			if(vinTable.isVisible())
			{
				createGridePaneChangeVin(anchorZone, gridChange, MainStage);
				gridChange.setVisible(true);
			}
			else if (alcoolTable.isVisible())
			{
				createGridePaneChangeAlcool(anchorZone, gridChange, MainStage);
				gridChange.setVisible(true);
			}
			else if (chemiseTable.isVisible())
			{
				try {
					createGridePaneChangeChemise(anchorZone, gridChange,MainStage);
				} catch (ExceptionAccesBd e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				gridChange.setVisible(true);
			}
		}); 
	
		//bouton AJOUTER
		
		btAjouter.setOnAction(e -> 
		{
			anchorZone.getChildren().remove(gridChange);
			btStock.setVisible(false);
			btModifier.setVisible(false);
			
			if(vinTable.isVisible())
			{
				leVin = new Vin();
				createGridePaneChangeVin(anchorZone, gridChange, MainStage);
			}

			else if (alcoolTable.isVisible())
			{
				lAlcool = new Alcool();
				createGridePaneChangeAlcool(anchorZone, gridChange,MainStage);
			}
			else if (chemiseTable.isVisible())
			{
				laChemise=new Chemise();
				try {
					createGridePaneChangeChemise(anchorZone, gridChange,MainStage);
				} catch (ExceptionAccesBd e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			gridChange.setVisible(true);
		}); 
		
		btStock.setVisible(false);

		if (vinTable.isVisible())
		{
			btStock.setOnAction(e -> {
				try 
				{
					new GestionStockVin(MainStage,leVin,anchorZone);
					
				} 
				catch (ExceptionAccesBd e1) {
					e1.printStackTrace();
				}
				});
		} 
		else if (alcoolTable.isVisible())
		{
			btStock.setOnAction(e -> {
				try {
					new GestionStockAlcool(MainStage,lAlcool,anchorZone);
				} catch (ExceptionAccesBd e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				});
		} 
		else if (chemiseTable.isVisible())
		{
			btStock.setOnAction(e -> {
				new GestionStockChemise(MainStage);
			});
		}
	
		hboxMid.getChildren().addAll(btStock, btModifier, btAjouter);
		anchorZone.getChildren().addAll(hboxMid);
	}

	/*
	 * 
	 * Zone Vin
	 * 
	 */
	
	// createVinzone
	public void createZoneVin(AnchorPane anchorZone, Stage MainStage,HBox HbImage) {
		clearAnchorProduct();
		vinTable.setVisible(true);
		createTableVin(anchorZone,MainStage, HbImage);
		createHboxMidManageProduct(anchorZone, MainStage);
		
	}

	// createTableVin
	public void createTableVin(AnchorPane anchorZone,Stage MainStage,HBox HbImage) {
		
		// Positionnement et css
		anchorZone.setTopAnchor(vinTable, 90.0);
		anchorZone.setLeftAnchor(vinTable, 50.0);
		vinTable.getStyleClass().add("Table");
		vinTable.setColumnResizePolicy(vinTable.UNCONSTRAINED_RESIZE_POLICY);
		
		
		// création tableau vin
		TableColumn<Vin, String> idCol = new TableColumn<Vin, String>("ID Produit");
		idCol.setCellValueFactory(new PropertyValueFactory<>("idVin"));
		TableColumn<Vin, String> descriptionCol = new TableColumn<Vin, String>("Appelation");
		descriptionCol.prefWidthProperty().bind(vinTable.widthProperty().multiply(0.22));
		descriptionCol.setCellValueFactory(new PropertyValueFactory<Vin, String>("nomVin"));
		TableColumn<Vin, String> typeVinCol = new TableColumn<Vin, String>("Type");
		typeVinCol.setCellValueFactory(new PropertyValueFactory<Vin, String>("typeVin"));
		TableColumn<Vin, String> origineCol = new TableColumn<Vin, String>("Origine");
		origineCol.setCellValueFactory(new PropertyValueFactory<Vin, String>("provenanceVin"));
		origineCol.prefWidthProperty().bind(vinTable.widthProperty().multiply(0.2));
		TableColumn<Vin, String> milleCol = new TableColumn<Vin, String>("Millésime");
		milleCol.setCellValueFactory(new PropertyValueFactory<Vin, String>("millesime"));
		milleCol.setPrefWidth(100);
		TableColumn<Vin, Float> prixCol = new TableColumn<Vin, Float>("Prix");
		prixCol.setCellValueFactory(new PropertyValueFactory<Vin, Float>("PrixUnitaire"));
		TableColumn<Vin, Float> StickCol = new TableColumn<Vin, Float>("Stock");
		StickCol.setCellValueFactory(new PropertyValueFactory<>("stockVin"));
		vinTable.getColumns().addAll(idCol, descriptionCol, typeVinCol, origineCol, milleCol, prixCol, StickCol);
		anchorZone.getChildren().add(vinTable);
		
		//Ajout des donner depuis db
		try
		{
		vinTable.itemsProperty().setValue(FXCollections.observableArrayList(FXCollections.observableArrayList(laCoucheMétier.ListerVin())));
		}catch(Exception ex)
		{			
		new MessageBox(MainStage, AlertType.ERROR,"Accès à la BD impossible (" + ex.getMessage() + ")");
		}
		
		//quand un enregistrement est sélectionné
		vinTable.getSelectionModel().selectedItemProperty().addListener((obs, ancVin, nouvVin) ->
		{
			Vin tempVin = new Vin();
			if (nouvVin != null) tempVin = nouvVin;

			Image image = null;
			
			//constructFullVin
			try 
			{
				leVin=laCoucheMétier.LireVinSpecifique(tempVin.getIdVin());
				image = new Image("file:image/imgVin/" +leVin.getImageVin());
				imgView.setImage(image);
			} 
			
			catch (ExceptionAccesBd e)
			{
				new MessageBox(MainStage, AlertType.ERROR,"Accès à la BD impossible (" + e.getMessage() + ")");
			}
			anchorZone.getChildren().remove(gridChange);
			btStock.setVisible(true);
			btModifier.setVisible(true);
			
		});		
		
		
	}

	// create GridPane Change VIN
	public void createGridePaneChangeVin(AnchorPane anchorZone, GridPane gridChange,Stage MainStage) {
		
		gridChange.setHgap(10);
		gridChange.setVgap(5);
		gridChange.setAlignment(Pos.CENTER);
		gridChange.setVisible(false);
		
		gridChange.getStyleClass().add("gridChange");
	
		anchorZone.setBottomAnchor(gridChange, 20.0);
		anchorZone.setLeftAnchor(gridChange, 50.0);
		
		TextField tfNomSearch = new TextField();
		tfNomSearch.setPromptText("Nom");
		gridChange.add(tfNomSearch, 0, 0,1 , 1);
		tfNomSearch.getStyleClass().add("tfNomSearch");
	
		ComboBox<String> cbMat = new ComboBox<>();
		cbMat.setValue("Maturité");
		gridChange.add(cbMat, 4, 1, 1, 1);
		cbMat.setItems(laListeMaturation);
		cbMat.getStyleClass().add("cbMat");
		
		TextField tfPrix = new TextField ();
		tfPrix.setPromptText("Prix Unitaire");
		gridChange.add(tfPrix, 1,0, 1, 1);
	
		TextField tfQuantiteCaisse = new TextField();
		tfQuantiteCaisse.setPromptText("Q/caisse");
		gridChange.add(tfQuantiteCaisse, 1, 1, 1, 1);
		tfQuantiteCaisse.getStyleClass().add("tfQuantiteCaisse");
	
		ComboBox<String> cbSaveur = new ComboBox<>();
	
		cbSaveur.setValue("Saveur");
		gridChange.add(cbSaveur, 3, 1, 1, 1);
		
		cbSaveur.setItems(laListeSaveur);
		cbSaveur.getStyleClass().add("cbSaveur");
	
	
		TextField tfStockVin = new TextField();
		tfStockVin.setPromptText("Stock");
		gridChange.add(tfStockVin, 1, 2, 1, 1);
		tfStockVin.getStyleClass().add("tfStockVin");
	
		ComboBox<String> cbType = new ComboBox<>();
		cbType.setValue("Type de vin");
		gridChange.add(cbType, 3, 0, 1, 1);
		cbType.setItems(laListeType);
		cbType.getStyleClass().add("cbType");
	
		ComboBox<String> cbProvenance = new ComboBox<>();
		cbProvenance.setValue("Provenance");
		gridChange.add(cbProvenance, 4, 0, 1, 1);
	
		cbProvenance.setItems(laListeProvenanceVin);
		cbProvenance.getStyleClass().add("cbProvenance");
	
		TextField tfMillesime = new TextField();
		tfMillesime.setPromptText("Millésime");
		gridChange.add(tfMillesime, 0, 1, 1, 1);
	
		TextField tfImageName = new TextField();
		tfImageName.setPromptText("Image");
		gridChange.add(tfImageName, 3, 2, 1, 1);
	
		ToggleButton rbAfficher = new RadioButton("Afficher le produit");
		gridChange.add(rbAfficher, 0, 2, 1, 1);
		rbAfficher.getStyleClass().add("rbAfficher");
		
		Button btImage = new Button("Img");
		btImage.setOnAction(e -> {
			ajouterImageVin(tfImageName, imgView, MainStage);
	
		});
		gridChange.add(btImage, 4, 2, 1, 1);
		btImage.getStyleClass().add("btImage");
	
		Button btAnnuler = new Button("_X");
		btAnnuler.setOnAction(e -> {
			anchorZone.getChildren().remove(gridChange);
			btAjouter.setVisible(true);
			btModifier.setVisible(false);
			btStock.setVisible(false);
		});
		
		gridChange.add(btAnnuler, 3, 3, 1, 1);
		
		anchorZone.getChildren().addAll( gridChange);
	
		// encodage
	
		if (leVin.getIdVin() == null) {
			Button btValider = new Button("_V");
			
			btValider.setOnAction(e -> {
			AjouterUnVin(anchorZone, gridChange, MainStage, tfNomSearch, cbMat, tfPrix, tfQuantiteCaisse, cbSaveur,
					tfStockVin, cbType, cbProvenance, tfMillesime, tfImageName, rbAfficher);
				
				
			});
			gridChange.add(btValider, 4, 3, 1, 1);
			
			}
		else //Modifier
			{
				
				
				if(leVin.getAfficherVin()==1)rbAfficher.setSelected(true);
				else rbAfficher.setSelected(false);
				tfNomSearch.setText(leVin.getNomVin());
				tfQuantiteCaisse.setText(String.valueOf(leVin.getQuantitéCaisse()));
				tfMillesime.setText(leVin.getMillesime());
				tfPrix.setText(String.valueOf(leVin.getPrixUnitaire()));
				tfStockVin.setText(String.valueOf(leVin.getStockVin()));
				cbMat.setValue(laListeMaturation.get(leVin.getIdMaturation()));
				cbProvenance.setValue(laListeProvenanceVin.get(leVin.getIdProvenance()));
				cbSaveur.setValue(laListeSaveur.get(leVin.getIdSaveur()));
				cbType.setValue(laListeType.get(leVin.getIdTypeVin()));
				tfImageName.setText(leVin.getImageVin());
				
				Button btValider = new Button("_V");
				
				
				
				btValider.setOnAction(e -> {
					
					
				ModifierUnVin(anchorZone, gridChange, MainStage, tfNomSearch, cbMat, tfPrix, tfQuantiteCaisse, cbSaveur,
						tfStockVin, cbType, cbProvenance, tfMillesime, tfImageName, rbAfficher);
					
				});
				
				gridChange.add(btValider, 4, 3, 1, 1);
			}
		
		
	}

	//Modifier leVin selectionné
	public void ModifierUnVin(AnchorPane anchorZone, GridPane gridChange, Stage MainStage, TextField tfNomSearch,
			ComboBox<String> cbMat, TextField tfPrix, TextField tfQuantiteCaisse, ComboBox<String> cbSaveur,
			TextField tfStockVin, ComboBox<String> cbType, ComboBox<String> cbProvenance, TextField tfMillesime,
			TextField tfImageName, ToggleButton rbAfficher) {
			gridChange.setVisible(false);
			//imgVin.setVisible(false);
			
		
		//Ajoutdes propriété à LeVin
		
			Integer afficher;
			Integer laMaturation = cbMat.getSelectionModel().getSelectedIndex();
			if(rbAfficher.isSelected()) afficher=1 ;
			else afficher= 0;
			leVin.setNomVin(tfNomSearch.getText());
			leVin.setPrixUnitaire(Float.valueOf(tfPrix.getText()));
			leVin.setIdTypeVin(Integer.valueOf(cbType.getSelectionModel().getSelectedIndex()));
			leVin.setIdSaveur(Integer.valueOf(cbSaveur.getSelectionModel().getSelectedIndex()));
			leVin.setIdProvenance(Integer.valueOf(cbProvenance.getSelectionModel().getSelectedIndex()));
			leVin.setIdMaturation(laMaturation);
			leVin.setMillesime(tfMillesime.getText());
			leVin.setQuantitéCaisse(Integer.valueOf(tfQuantiteCaisse.getText()));
			leVin.setStockVin(Integer.valueOf(tfStockVin.getText()));
			leVin.setImageVin(tfImageName.getText());
			leVin.setIdTypeProduit(Integer.valueOf("0"));
			leVin.setAfficherVin(afficher);
			
			try {
				if(laCoucheMétier.ModifierVin(leVin)==0){
					new MessageBox(MainStage, AlertType.WARNING, "L'ajout n'a pas eu lieu!");}
				
				else{ 
					new MessageBox(MainStage, AlertType.INFORMATION, "L'ajout s'est bien déroulé!");
					
					anchorZone.getChildren().clear();
					clearAnchorProduct();
					createZoneVin(anchorZone, MainStage, null);
					createCommonContainer(anchorZone, MainStage);
					
				}
			} 
			catch (ExceptionMetier e1) {
				// TODO Auto-generated catch block
				//e1.printStackTrace();
			} catch (ExceptionAccesBd e1) {
				// TODO Auto-generated catch block
				//e1.printStackTrace();
			}
	}

	//Ajouter leVin
	public void AjouterUnVin(AnchorPane anchorZone, GridPane gridChange, Stage MainStage, TextField tfNomSearch,
			ComboBox<String> cbMat, TextField tfPrix, TextField tfQuantiteCaisse, ComboBox<String> cbSaveur,
			TextField tfStockVin, ComboBox<String> cbType, ComboBox<String> cbProvenance, TextField tfMillesime,
			TextField tfImageName, ToggleButton rbAfficher) {
		gridChange.setVisible(false);
		
		//Ajouter Vin
		
		Integer afficher;
		Integer laMaturation = cbMat.getSelectionModel().getSelectedIndex();
		
		if(rbAfficher.isSelected()) afficher=1 ;
		else afficher= 0;

		leVin.setIdVin("00."+String.valueOf(leMaxNumVin)+".0"+cbType.getSelectionModel().getSelectedIndex()+
				"0"+cbProvenance.getSelectionModel().getSelectedIndex());
		leVin.setNomVin(tfNomSearch.getText());
		leVin.setPrixUnitaire(Float.valueOf(tfPrix.getText()));
		leVin.setIdTypeVin(Integer.valueOf(cbType.getSelectionModel().getSelectedIndex()));
		leVin.setIdSaveur(Integer.valueOf(cbSaveur.getSelectionModel().getSelectedIndex()));
		leVin.setIdProvenance(Integer.valueOf(cbProvenance.getSelectionModel().getSelectedIndex()));
		leVin.setIdMaturation(laMaturation);
		leVin.setMillesime(tfMillesime.getText());
		leVin.setQuantitéCaisse(Integer.valueOf(tfQuantiteCaisse.getText()));
		leVin.setStockVin(Integer.valueOf(tfStockVin.getText()));
		leVin.setImageVin(tfImageName.getText());
		leVin.setIdTypeProduit(Integer.valueOf("0"));
		leVin.setAfficherVin(afficher);
		
		try {
			if(laCoucheMétier.AjouterVin(leVin)==0){
				new MessageBox(MainStage, AlertType.WARNING, "L'ajout n'a pas eu lieu!");}
			
			else{ 
				new MessageBox(MainStage, AlertType.INFORMATION, "L'ajout s'est bien déroulé!");
				
				anchorZone.getChildren().clear();
				clearAnchorProduct();
				createCommonContainer(anchorZone, MainStage);
				createZoneVin(anchorZone, MainStage, null);
			}
		} 
		catch (ExceptionMetier e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (ExceptionAccesBd e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	// Attribuer l'image sélectionnée et la copier dasn le dossier choisi
		private void ajouterImageVin(TextField tfImageName,ImageView imgVin,Stage MainStage) {
			
			FileChooser btNomImage = new FileChooser();
			btNomImage.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("JPG", "*.jpg"));
			File fichier = btNomImage.showOpenDialog(null);
			
			if (fichier != null)
			{
				try
				{
				// copier le fichier d'image vers le répertoire de l'application
				File fichierDst = new File(
				System.getProperty("user.dir") + "/image/imgVin/" + fichier.getName());
				Files.copy(fichier.toPath(), fichierDst.toPath(), REPLACE_EXISTING);
				// si la copie a réussi, mettre à jour l'image à l'écran
				tfImageName.setText(fichier.getName());
				imgVin.setImage(new Image("file:image/imgVin/" + fichier.getName()));
				}
				
				catch (IOException e)
				{
				new MessageBox(MainStage, AlertType.WARNING, e.getMessage());
				}
			}
			
		}
	/*
	 * 
	 * Zone Alcool
	 * 
	 */
	
	// create Zone Alcool
	public void createZoneAlcool(AnchorPane anchorZone, Stage MainStage) {
		clearAnchorProduct();
		createTableAlcool(anchorZone,MainStage);
		alcoolTable.setVisible(true);
		createHboxMidManageProduct(anchorZone, MainStage);
	}

	// create alcoolTable
	private void createTableAlcool(AnchorPane anchorZone, Stage MainStage) {
		anchorZone.setTopAnchor(alcoolTable, 90.0);
		anchorZone.setLeftAnchor(alcoolTable, 50.0);
		alcoolTable.setColumnResizePolicy(alcoolTable.CONSTRAINED_RESIZE_POLICY);
		alcoolTable.getStyleClass().add("Table");

		//Ajout des donner depuis db
			try
			{
			alcoolTable.itemsProperty().setValue(FXCollections.observableArrayList(laCoucheMétier.ListerAlcool()));
			}catch(Exception ex)
			{			
			new MessageBox(MainStage, AlertType.ERROR,"Accès à la BD impossible (" + ex.getMessage() + ")");
			}
				
		// création tableau alcool
		TableColumn<Alcool, String> idCol = new TableColumn<Alcool, String>("ID Produit");
		idCol.setCellValueFactory(new PropertyValueFactory<Alcool, String>("idAlcool"));
		
		TableColumn<Alcool, String> descriptionCol = new TableColumn<Alcool, String>("Description");
		descriptionCol.prefWidthProperty().bind(alcoolTable.widthProperty().multiply(0.445));
		descriptionCol.setCellValueFactory(new PropertyValueFactory<Alcool, String>("nomAlcool"));
		
		TableColumn<Alcool, Float> prixCol = new TableColumn<Alcool, Float>("Prix Unitaire");
		prixCol.setCellValueFactory(new PropertyValueFactory<Alcool, Float>("prixUnitaire"));
		
		TableColumn<Alcool, String> familleCol = new TableColumn<Alcool, String>("Famille");
		familleCol.setCellValueFactory(new PropertyValueFactory<Alcool, String>("famille"));
		
		TableColumn<Alcool, String> origineCol = new TableColumn<Alcool, String>("Origine");
		origineCol.setCellValueFactory(new PropertyValueFactory<Alcool, String>("provenanceAlcool"));
		
		TableColumn<Alcool, Integer> StockCol = new TableColumn<Alcool, Integer>("Stock");
		StockCol.setCellValueFactory(new PropertyValueFactory<Alcool, Integer>("stockAlcool"));
	
		alcoolTable.getColumns().addAll(idCol, descriptionCol,prixCol , familleCol, origineCol, StockCol);
		alcoolTable.setVisible(false);
		anchorZone.getChildren().addAll(alcoolTable);
		
		//quand un enregistrement est sélectionné
		alcoolTable.getSelectionModel().selectedItemProperty().addListener((obs, ancAlcool, nouvAlcool) ->
		{
			
		//	Alcool tempAlcool = new Alcool();
			if (nouvAlcool != null) 
			{
				//constructFullAlcool
				try 
				{
				lAlcool=laCoucheMétier.LireAlcoolSpecifique(nouvAlcool.getIdAlcool());
				imgView.setImage(new Image("file:image/imgAlcool/" +lAlcool.getImageAlcool()));
				} 
				
				catch (ExceptionAccesBd e)
				{
					new MessageBox(MainStage, AlertType.ERROR,"Accès à la BD impossible (" + e.getMessage() + ")");
				}
			}
			anchorZone.getChildren().remove(gridChange);
			btStock.setVisible(true);
			btModifier.setVisible(true);
		});
		
	}

	// create GridPane Change Alcool
	public void createGridePaneChangeAlcool(AnchorPane anchorZone, GridPane gridChange, Stage MainStage) {
		
		gridChange.setHgap(10);
		gridChange.setVgap(5);
		gridChange.setAlignment(Pos.CENTER);
		gridChange.setVisible(false);
	
		gridChange.getStyleClass().add("gridChange");
	
		anchorZone.setBottomAnchor(gridChange, 20.0);
		anchorZone.setLeftAnchor(gridChange, 50.0);
		
	
		TextField tfNomSearch = new TextField();
		tfNomSearch.setPromptText("Nom");
		gridChange.add(tfNomSearch, 0, 0, 2, 1);
		tfNomSearch.getStyleClass().add("tfNomSearch");
		
		TextField tfPrix = new TextField();
		tfPrix.setPromptText("Prix");
		gridChange.add(tfPrix, 0,1, 1, 1);
		tfPrix.getStyleClass().add("tfDegre");
		
	
		TextField tfQuantiteCaisse = new TextField();
		tfQuantiteCaisse.setPromptText("Q/Caisse");
		gridChange.add(tfQuantiteCaisse, 0, 2, 1, 1);
		tfQuantiteCaisse.getStyleClass().add("tfQuantiteCaisse");
	
		TextField tfGout = new TextField();
		tfGout.setPromptText("Gout");
		gridChange.add(tfGout, 3, 1, 1, 1);
		tfGout.getStyleClass().add("tfGout");
	
		TextField tfStockAlcool = new TextField();
		tfStockAlcool.setPromptText("Stock");
		gridChange.add(tfStockAlcool, 1, 2, 1, 1);
		tfStockAlcool.getStyleClass().add("tfStockAlcool");
		
		TextField tfDate = new TextField();
		tfDate.setPromptText("Date");
		gridChange.add(tfDate, 0,3,1,1);
		tfDate.getStyleClass().add("tfDate");
		
		ComboBox<String> cbFamille = new ComboBox<>();
		cbFamille.setValue("Famille");
		cbFamille.setItems(laListeFamilleAlcool);
		gridChange.add(cbFamille, 3, 0, 1, 1);
		cbFamille.getStyleClass().add("cbFamille");
	
		ComboBox<String> cbProvenance = new ComboBox<>();
		cbProvenance.setValue("Provenance");
		cbProvenance.setItems(laListeProvenanceAlcool);
		gridChange.add(cbProvenance, 4, 0, 1, 1);
		cbProvenance.getStyleClass().add("cbProvenance");
	
		TextField tfDegreAlcool = new TextField();
		tfDegreAlcool.setPromptText("Degré");
		gridChange.add(tfDegreAlcool, 4, 1, 1, 1);
		tfDegreAlcool.getStyleClass().add("tfDegre");
	
		TextField tfImageName = new TextField();
		tfImageName.setPromptText("Image");
		gridChange.add(tfImageName, 3, 2, 1, 1);
	
		Button btImage = new Button("Img");
		btImage.setOnAction(e -> 
		{ajouterImageAlcool(tfImageName, imgView,MainStage);});
		gridChange.add(btImage, 4, 2, 1, 1);
		btImage.getStyleClass().add("btImage");
	
		ToggleButton rbAfficher = new RadioButton("Afficher le produit");
		gridChange.add(rbAfficher, 3, 3, 1, 1);
		rbAfficher.getStyleClass().add("rbAfficher");
		
		HBox HBbouton = new HBox(5);
		Button btValider = new Button("_V");
		if (lAlcool.getIdAlcool() == null) 
		{
			
			btValider.setOnAction(e -> 
			{
			ajouterUnAlcool(anchorZone, gridChange, MainStage, tfNomSearch, tfPrix, tfQuantiteCaisse, tfGout,
					tfStockAlcool, tfDate, cbFamille, cbProvenance, tfDegreAlcool, rbAfficher,tfImageName);
				});
			}
			else //Modifier
				{
				if(lAlcool.getAfficherAlcool()==1)rbAfficher.setSelected(true);
				else rbAfficher.setSelected(false);
				tfNomSearch.setText(lAlcool.getNomAlcool());
				tfQuantiteCaisse.setText(String.valueOf(lAlcool.getQuantitéCaisse()));
				tfPrix.setText(String.valueOf(lAlcool.getPrixUnitaire()));
				tfStockAlcool.setText(String.valueOf(lAlcool.getStockAlcool()));
				tfDegreAlcool.setText(String.valueOf(lAlcool.getDegréAlcool()));
				cbProvenance.setValue(laListeProvenanceAlcool.get(lAlcool.getIdProvenanceAlcool()));
				tfGout.setText(lAlcool.getGoutAlcool());
				tfDate.setText(lAlcool.getDatePeremption());
				cbFamille.setValue(laListeFamilleAlcool.get(lAlcool.getIdFamille()));
				tfImageName.setText(lAlcool.getImageAlcool());
				
				
				btValider.setOnAction(e -> {
				modifierUnAlcool(anchorZone, gridChange, MainStage, tfNomSearch, tfPrix, tfQuantiteCaisse, tfGout,
						tfStockAlcool, tfDate, cbFamille, cbProvenance, tfDegreAlcool, tfImageName, rbAfficher);
				});
				}
		
				gridChange.add(btValider, 4, 3, 1, 1);
		
		Button btAnnuler = new Button("_X");
		btAnnuler.setOnAction(e -> {
			anchorZone.getChildren().remove(gridChange);
			btAjouter.setVisible(true);
			btModifier.setVisible(false);
			btStock.setVisible(false);
			//imgVin.setVisible(false);
		});
		HBbouton.getChildren().addAll(btAnnuler,btValider);
		gridChange.add(HBbouton, 4, 3, 1, 1);
		btValider.getStyleClass().add("btImage");
		btAnnuler.getStyleClass().add("btImage");
		// afficher gridChange
	
		anchorZone.getChildren().addAll(gridChange);
	}

	//Modifier lAlcool selectionné
	public void modifierUnAlcool(AnchorPane anchorZone, GridPane gridChange, Stage MainStage, TextField tfNomSearch,
			TextField tfPrix, TextField tfQuantiteCaisse, TextField tfGout, TextField tfStockAlcool, TextField tfDate,
			ComboBox<String> cbFamille, ComboBox<String> cbProvenance, TextField tfDegreAlcool, TextField tfImageName,
			ToggleButton rbAfficher) {
		gridChange.setVisible(false);
		//imgVin.setVisible(false);
		
		//Ajoutdes propriété à lAlcool
		Integer afficher;
		if(rbAfficher.isSelected()) afficher=1 ;
		else afficher= 0;
		
		lAlcool.setNomAlcool(tfNomSearch.getText());
		lAlcool.setPrixUnitaire(Float.valueOf(tfPrix.getText()));
		lAlcool.setIdFamille(Integer.valueOf(cbFamille.getSelectionModel().getSelectedIndex()));
		lAlcool.setIdProvenanceAlcool(Integer.valueOf(cbProvenance.getSelectionModel().getSelectedIndex()));
		lAlcool.setQuantitéCaisse(Integer.valueOf(tfQuantiteCaisse.getText()));
		lAlcool.setStockAlcool(Integer.valueOf(tfStockAlcool.getText()));
		lAlcool.setDegréAlcool(Integer.valueOf(tfDegreAlcool.getText()));
		lAlcool.setGoutAlcool(tfGout.getText());
		lAlcool.setDatePeremption(tfDate.getText());
		lAlcool.setImageAlcool(tfImageName.getText());
		lAlcool.setIdTypeProduit(Integer.valueOf("0"));
		lAlcool.setAfficherAlcool(afficher);
		
		try {
			if(laCoucheMétier.ModifierAlcool(lAlcool)==0){
				new MessageBox(MainStage, AlertType.WARNING, "La modification n'a pas eu lieu!");}
			
			else{ 
				new MessageBox(MainStage, AlertType.INFORMATION, "La modification s'est bien déroulé!");
				
				anchorZone.getChildren().clear();
				clearAnchorProduct();
				createZoneAlcool(anchorZone, MainStage);
				createCommonContainer(anchorZone, MainStage);
				
			}
		} 
		catch (ExceptionMetier e1) {
			// TODO Auto-generated catch block
			//e1.printStackTrace();
		} catch (ExceptionAccesBd e1) {
			// TODO Auto-generated catch block
			//e1.printStackTrace();
		}
	}
	
	//Ajouter lAlcool
	public void ajouterUnAlcool(AnchorPane anchorZone, GridPane gridChange, Stage MainStage, TextField tfNomSearch,
			TextField tfPrix, TextField tfQuantiteCaisse, TextField tfGout, TextField tfStockAlcool, TextField tfDate,
			ComboBox<String> cbFamille, ComboBox<String> cbProvenance, TextField tfDegreAlcool,
			ToggleButton rbAfficher,TextField tfImageName) {
		gridChange.setVisible(false);
			
			//Ajouter Alcool
			
			Integer afficher;
			
			if(rbAfficher.isSelected()) afficher=1 ;
			else afficher= 0;
			lAlcool.setIdAlcool("01."+String.valueOf(leMaxNumAlcool+1)+".0"+cbFamille.getSelectionModel().getSelectedIndex()+
					"0"+cbProvenance.getSelectionModel().getSelectedIndex());
			lAlcool.setNomAlcool(tfNomSearch.getText());
			lAlcool.setPrixUnitaire(Float.valueOf(tfPrix.getText()));
			lAlcool.setIdFamille(Integer.valueOf(cbFamille.getSelectionModel().getSelectedIndex()));
			lAlcool.setDegréAlcool(Integer.valueOf(tfDegreAlcool.getText()));
			lAlcool.setIdProvenanceAlcool(Integer.valueOf(cbProvenance.getSelectionModel().getSelectedIndex()));
			lAlcool.setDatePeremption(tfDate.getText());
			lAlcool.setGoutAlcool(tfGout.getText());
			lAlcool.setQuantitéCaisse(Integer.valueOf(tfQuantiteCaisse.getText()));
			lAlcool.setStockAlcool(Integer.valueOf(tfStockAlcool.getText()));
			lAlcool.setImageAlcool(tfImageName.getText());
			lAlcool.setIdTypeProduit(Integer.valueOf("1"));
			lAlcool.setAfficherAlcool(afficher);
			
			try 
			{
				if(laCoucheMétier.AjouterAlcool(lAlcool)==0){
					new MessageBox(MainStage, AlertType.WARNING, "L'ajout n'a pas eu lieu!");}
				
				else{ 
					new MessageBox(MainStage, AlertType.INFORMATION, "L' alcool a été ajouté!");
					
					anchorZone.getChildren().clear();
					clearAnchorProduct();
					createCommonContainer(anchorZone, MainStage);
					createZoneAlcool(anchorZone, MainStage);
				}
			} 
			catch (ExceptionMetier e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (ExceptionAccesBd e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	}
	
	// Attribuer l'image sélectionnée et la copier dasn le dossier choisi 
	private void ajouterImageAlcool(TextField tfImageName,ImageView imgAlcool,Stage MainStage) {
		
		FileChooser btNomImage = new FileChooser();
		btNomImage.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("JPG", "*.jpg"));
		File fichier = btNomImage.showOpenDialog(null);
		
		if (fichier != null)
		{
			try
			{
			// copier le fichier d'image vers le répertoire de l'application
			File fichierDst = new File(
			System.getProperty("user.dir") + "/image/imgAlcool/" + fichier.getName());
			Files.copy(fichier.toPath(), fichierDst.toPath(), REPLACE_EXISTING);
			// si la copie a réussi, mettre à jour l'image à l'écran
			tfImageName.setText(fichier.getName());
			imgAlcool.setImage(new Image("file:image/imgAlcool/" + fichier.getName()));
			}
			
			catch (IOException e)
			{
			new MessageBox(MainStage, AlertType.WARNING, e.getMessage());
			}
		}
		
	}
	
	/*
	 * 
	 * Zone Chemise
	 * 
	 */
	
	// create zone chemise
	public void createZoneChemise(AnchorPane anchorZone, Stage MainStage) {
		clearAnchorProduct();
		createTableChemise(anchorZone, MainStage);
		chemiseTable.setVisible(true);
		createHboxMidManageProduct(anchorZone, MainStage);
	}

	// create chemiseTable
	private void createTableChemise(AnchorPane anchorZone,Stage MainStage) {
		anchorZone.setTopAnchor(chemiseTable, 90.0);
		anchorZone.setLeftAnchor(chemiseTable, 50.0);
		laChemise=null;
		chemiseTable.getStyleClass().add("Table");
		//chemiseTable.setColumnResizePolicy(chemiseTable.CONSTRAINED_RESIZE_POLICY);
		chemiseTable.setColumnResizePolicy(chemiseTable.UNCONSTRAINED_RESIZE_POLICY);
		//SmartResize.POLICY.requestResize(chemiseTable);
		//Ajout des donner depuis db
		try
		{
		chemiseTable.itemsProperty().setValue(FXCollections.observableArrayList(laCoucheMétier.ListerChemise()));
		}catch(Exception ex)
		{			
		new MessageBox(MainStage, AlertType.ERROR,"Accès à la BD impossible (" + ex.getMessage() + ")");
		}
		// création tableau Chemise
		TableColumn<Chemise, String> idCol = new TableColumn<Chemise, String>("ID");
		idCol.setCellValueFactory(new PropertyValueFactory<Chemise, String>("idProduit"));
		
		TableColumn<Chemise, String> descriptionCol = new TableColumn<Chemise, String>("Description");
		descriptionCol.setCellValueFactory(new PropertyValueFactory<Chemise, String>("nomChemise"));
		descriptionCol.prefWidthProperty().bind(chemiseTable.widthProperty().multiply(0.3));
		descriptionCol.getStyleClass().add("descriptionCol");
		TableColumn<Chemise, Float> prixCol = new TableColumn<Chemise, Float>("Prix");
		prixCol.setCellValueFactory(new PropertyValueFactory<Chemise, Float>("prixUnitaire"));
		
		TableColumn<Chemise, String> matiereCol = new TableColumn<Chemise, String>("Matière");
		matiereCol.setCellValueFactory(new PropertyValueFactory<Chemise, String>("matiere"));
		
		TableColumn<Chemise, String> couleurCol = new TableColumn<Chemise, String>("Couleur");
		couleurCol.setCellValueFactory(new PropertyValueFactory<Chemise, String>("couleurChemise"));
		
		TableColumn<Chemise, Integer> StockCol = new TableColumn<Chemise, Integer>("Stock");
		StockCol.setCellValueFactory(new PropertyValueFactory<Chemise, Integer>("StockChemise"));
		StockCol.prefWidthProperty().bind(chemiseTable.widthProperty().multiply(0.1));
		TableColumn<Chemise, String> tailleCol = new TableColumn<Chemise, String>("Taille");
		tailleCol.setCellValueFactory(new PropertyValueFactory<Chemise, String>("taille"));
		tailleCol.prefWidthProperty().bind(chemiseTable.widthProperty().multiply(0.1));
		chemiseTable.getColumns().addAll(idCol, descriptionCol,prixCol,matiereCol,couleurCol, StockCol,tailleCol  );
		//chemiseTable.setVisible(false);
		anchorZone.getChildren().addAll(chemiseTable);
		
		//quand un enregistrement est sélectionné
		chemiseTable.getSelectionModel().selectedItemProperty().addListener((obs, ancChemise, nouvChemise) ->
		{
			
			laChemise = new Chemise();
			laListeChemise = new ArrayList<Chemise>();
			//Chemise tempAlcool = new Alcool();
			if (nouvChemise.getIdProduit() != null) 
			{
				//constructFullChemise
				try
				{
				laChemise = laCoucheMétier.LireUneChemise(nouvChemise.getIdProduit());
				laListeChemise= laCoucheMétier.LireChemiseSpecifique(Integer.valueOf(laChemise.getModel()));
				imgView.setImage(new Image("file:image/imgChemise/" +laChemise.getimageChemise()));
				} 
				
				catch (ExceptionAccesBd | NumberFormatException | ExceptionMetier e)
				{
					new MessageBox(MainStage, AlertType.ERROR,"Accès à la BD impossible (" + e.getMessage() + ")");
				}
				anchorZone.getChildren().remove(gridChange);
				btModifier.setVisible(true);
			}
		});
	}

	// create GridPane Change Chemise
	public void createGridePaneChangeChemise(AnchorPane anchorZone, GridPane gridChange,Stage MainStage) throws ExceptionAccesBd {
		
		gridChange.setHgap(10);
		gridChange.setVgap(5);
		gridChange.setAlignment(Pos.CENTER);
		//gridChange.setVisible(false);

		gridChange.getStyleClass().add("gridChange");

		anchorZone.setBottomAnchor(gridChange, 20.0);
		anchorZone.setLeftAnchor(gridChange, 50.0);
	

		TextField tfNomSearch = new TextField();
		tfNomSearch.setPromptText("Nom");
		gridChange.add(tfNomSearch, 0, 0, 2, 1);
		tfNomSearch.getStyleClass().add("tfNomSearch");

		ComboBox<String> cbMat = new ComboBox<>();
		cbMat.setValue("Matière");
		cbMat.setItems(laListeMatiere);
		gridChange.add(cbMat, 3, 0, 1, 1);
		cbMat.getStyleClass().add("cbMat");
		
		HBox taille1 = new HBox(5);
		gridChange.add(taille1, 0, 1, 1, 1);
		TextField tfXs = new TextField();
		tfXs.setPromptText("XS");
		tfXs.getStyleClass().add("tfStock");
		TextField tfS = new TextField();
		tfS.setPromptText("S");
		tfS.getStyleClass().add("tfStock");
		TextField tfM = new TextField();
		tfM.setPromptText("M");
		tfM.getStyleClass().add("tfStock");
		taille1.getChildren().addAll(tfXs,tfS,tfM);
		
		HBox taille2 = new HBox(5);
		gridChange.add(taille2, 0, 2, 1, 1);
		TextField tfL = new TextField();
		tfL.setPromptText("L");
		tfL.getStyleClass().add("tfStock");
		TextField tfXl = new TextField();
		tfXl.setPromptText("XL");
		tfXl.getStyleClass().add("tfStock");
		TextField tfXXl = new TextField();
		tfXXl.setPromptText("XXL");
		tfXXl.getStyleClass().add("tfStock");
		taille2.getChildren().addAll(tfL,tfXl,tfXXl);
		
		TextField tfCouleur = new TextField();
		tfCouleur.setPromptText("Couleur");
		gridChange.add(tfCouleur, 4, 0, 1, 1);
		TextField tfPrix = new TextField();
		tfPrix.setPromptText("Prix");
		gridChange.add(tfPrix,3,1, 1, 1);
		tfPrix.getStyleClass().add("tfDegre");
		TextField tfImageName = new TextField();
		tfImageName.setPromptText("Image");
		gridChange.add(tfImageName, 3, 2, 1, 1);

		Button btImage = new Button("Img");
		gridChange.add(btImage, 4, 2, 1, 1);
		btImage.setOnAction(e -> 
		{ajouterImageChemise(tfImageName, imgView,MainStage);});
		btImage.getStyleClass().add("btImage");

		
		ToggleButton rbAfficher = new RadioButton("Afficher le produit");
		gridChange.add(rbAfficher, 0,3, 1, 1);
		rbAfficher.getStyleClass().add("rbAfficher");
		
		HBox hbLabelModel = new HBox(5);
		Label lbNumModel1 = new Label("numéro de modéle : ");
		gridChange.add(hbLabelModel, 4, 1, 1, 1);
		Label lbNumModel2 = new Label();
		lbNumModel2.setText(String.valueOf(laCoucheMétier.GetMaxNumModelChemise()+1));
		hbLabelModel.getChildren().addAll(lbNumModel1,lbNumModel2);
		
		HBox hbButton = new HBox(5);
		Button btValider = new Button("_V");
		
		if (laChemise.getIdProduit() == null)
		{
			tfNomSearch.setOnMouseClicked(e -> {tfNomSearch.setText("");});
			tfCouleur.setOnMouseClicked(e -> {tfCouleur.setText("");});
			tfXs.setOnMouseClicked(e -> {tfXs.setText("");});
			tfS.setOnMouseClicked(e -> {tfS.setText("");});
			tfM.setOnMouseClicked(e -> {tfM.setText("");});
			tfL.setOnMouseClicked(e -> {tfL.setText("");});
			tfXl.setOnMouseClicked(e -> {tfXl.setText("");});
			tfXXl.setOnMouseClicked(e -> {tfXXl.setText("");});
			tfPrix.setOnMouseClicked(e -> {tfPrix.setText("");});
			
			// Ajouter une chemise
			btValider.setOnAction(e -> {				
				//	imgVin.setVisible(false);
				
				ajouterUnechemise(anchorZone, MainStage, tfNomSearch, tfImageName, cbMat, tfXs, tfS, tfM, tfL, tfXl, tfXXl,
						tfCouleur, tfPrix, rbAfficher, lbNumModel2);
				
				//UpdateNumModel	
				try {
					laCoucheMétier.UpdateNumModel(Integer.valueOf(lbNumModel2.getText()));
				} catch (NumberFormatException | ExceptionAccesBd | ExceptionMetier e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				gridChange.getChildren().clear();
				anchorZone.getChildren().remove(gridChange);
				btAjouter.setVisible(true);
			});
		}
		
		else //Modifier
		{
			lbNumModel2.setText("");
		if(laListeChemise.get(0).getAfficherProduit()==0)
			rbAfficher.setSelected(false);
		else rbAfficher.setSelected(true);
		tfNomSearch.setText(laListeChemise.get(0).getNomChemise());
		tfPrix.setText(String.valueOf(laListeChemise.get(0).getPrixUnitaire()));
		cbMat.setValue(laListeMatiere.get(laListeChemise.get(0).getIdMatiere()));
		tfCouleur.setText(laListeChemise.get(0).getCouleurChemise());
		lbNumModel2.setText(String.valueOf(laListeChemise.get(0).getModel()));
		tfXs.setText(String.valueOf(laListeChemise.get(0).getStockChemise()));
		tfS.setText(String.valueOf(laListeChemise.get(1).getStockChemise()));
		tfM.setText(String.valueOf(laListeChemise.get(2).getStockChemise()));
		tfL.setText(String.valueOf(laListeChemise.get(3).getStockChemise()));
		tfXl.setText(String.valueOf(laListeChemise.get(4).getStockChemise()));
		tfXXl.setText(String.valueOf(laListeChemise.get(5).getStockChemise()));
		
		tfImageName.setText(laListeChemise.get(0).getimageChemise());

		btValider.setOnAction(e -> {
			modifierUnechemise(anchorZone,  MainStage, tfNomSearch, tfImageName,cbMat,
					tfXs, tfS, tfM, tfL, tfXl, tfXXl,
					 tfCouleur, tfPrix, rbAfficher, lbNumModel2);
			gridChange.getChildren().clear();
			anchorZone.getChildren().remove(gridChange);
			btAjouter.setVisible(true);
		});
		}
		btValider.getStyleClass().add("btImage");
		
		Button btAnnuler = new Button("_X");
		gridChange.add(hbButton, 4, 3, 1, 1);
		btAnnuler.setOnAction(e -> {			
			btAjouter.setVisible(true);
			btModifier.setVisible(false);
			anchorZone.getChildren().remove(gridChange);
			hbLabelModel.getChildren().remove(lbNumModel2);
		//	imgVin.setVisible(false);
		
		});
		
		btAnnuler.getStyleClass().add("btImage");
		hbButton.getChildren().addAll(btAnnuler, btValider);
		anchorZone.getChildren().add( gridChange);
	}

	public void ajouterUnechemise(AnchorPane anchorZone, Stage MainStage, TextField tfNomSearch,TextField tfImageName, ComboBox<String> cbMat,
			TextField tfXs, TextField tfS, TextField tfM, TextField tfL, TextField tfXl, TextField tfXXl,
			TextField tfCouleur, TextField tfPrix, ToggleButton rbAfficher, Label lbNumModel2) {
		//Ajouter Chemise
		
		Integer afficher;
		Integer compteurAjout=0;
		ArrayList<String> listeErreurAjout = new ArrayList<String>();  
		
		if(rbAfficher.isSelected()) afficher=1 ;
		else afficher= 0;

		laChemise.setNomChemise(tfNomSearch.getText());
		laChemise.setPrixUnitaire(Float.valueOf(tfPrix.getText()));
		laChemise.setIdMatiere(Integer.valueOf(cbMat.getSelectionModel().getSelectedIndex()));
		laChemise.setCouleurChemise(tfCouleur.getText());
		laChemise.setimageChemise(tfImageName.getText());
		laChemise.setIdTypeProduit(Integer.valueOf("2"));
		laChemise.setAfficherProduit(afficher);
		laChemise.setModel(Integer.valueOf(lbNumModel2.getText()));
		
		//ajout de chaque Taille
		//taille0
		if(tfXs.getText()!="XS" ||tfXs.getText()!="")
		{	
			laChemise.setIdProduit("02."+"0"+String.valueOf(lbNumModel2.getText())+".0"+"0");
			laChemise.setIdTaille(0);
			if(tfXs.getText().isEmpty())
			{
				laChemise.setStockChemise(0);
			}
			else laChemise.setStockChemise(Integer.valueOf(tfXs.getText())); 
			try 
				{
					if(laCoucheMétier.AjouterChemise(laChemise)==0){
						listeErreurAjout.add("Xs");
					}
					else{ 
						compteurAjout++;
						
					}
				} 
				catch (ExceptionMetier e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ExceptionAccesBd e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		
		}
		//taille1
		if(tfS.getText()!="S" ||tfS.getText()!="" )
		{	
			laChemise.setIdProduit("02."+"0"+String.valueOf(lbNumModel2.getText())+".0"+"1");
			laChemise.setIdTaille(1);
			
			if(tfS.getText().isEmpty())
			{
				laChemise.setStockChemise(0);
			}
			else laChemise.setStockChemise(Integer.valueOf(tfS.getText())); 
			
			try 
				{
				if(laCoucheMétier.AjouterChemise(laChemise)==0){
					listeErreurAjout.add("S");
				}
				else{ 
					compteurAjout++;
				} 
				}
				catch (ExceptionMetier e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ExceptionAccesBd e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		
		}

		//taille2
		if(tfM.getText()!="M" ||tfXs.getText()!="" )
		{	
			laChemise.setIdProduit("02."+"0"+String.valueOf(lbNumModel2.getText())+".0"+"2");
			laChemise.setIdTaille(2);
			
			if(tfM.getText().isEmpty())
			{
				laChemise.setStockChemise(0);
			}
			else laChemise.setStockChemise(Integer.valueOf(tfM.getText())); 
			
			try 
				{if(laCoucheMétier.AjouterChemise(laChemise)==0){
					listeErreurAjout.add("M");
				}
				else{ 
					compteurAjout++;
				}
				} 
				catch (ExceptionMetier e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ExceptionAccesBd e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		
		}
		//taille3
		if(tfL.getText()!="L" ||tfL.getText()!="" )
		{	
			laChemise.setIdProduit("02."+"0"+String.valueOf(lbNumModel2.getText())+".0"+"3");
			laChemise.setIdTaille(3);
			if(tfL.getText().isEmpty())
			{
				laChemise.setStockChemise(0);
			}
			else laChemise.setStockChemise(Integer.valueOf(tfL.getText())); 
			
			try 
				{
				if(laCoucheMétier.AjouterChemise(laChemise)==0){
					listeErreurAjout.add("L");
				}
				else{ 
					compteurAjout++;
					
					}
				} 
				catch (ExceptionMetier e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ExceptionAccesBd e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		
		}
		//taille4
		if(tfXl.getText()!="XL" ||tfXl.getText()!="" )
		{	
			laChemise.setIdProduit("02."+"0"+String.valueOf(lbNumModel2.getText())+".0"+"4");
			laChemise.setIdTaille(4);
			if(tfXl.getText().isEmpty())
			{
				laChemise.setStockChemise(0);
			}
			else laChemise.setStockChemise(Integer.valueOf(tfXl.getText())); 
			
			try 
				{
				if(laCoucheMétier.AjouterChemise(laChemise)==0){
					listeErreurAjout.add("XL");
				}
				else{ 
					compteurAjout++;
						
					}
				} 
				catch (ExceptionMetier e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ExceptionAccesBd e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		
		}
		//taille5
		if(tfXXl.getText()!="XXL" ||tfXXl.getText()!="" )
		{	
			tfXXl.promptTextProperty().equals(true);
			
			laChemise.setIdProduit("02."+"0"+lbNumModel2.getText()+".0"+"5");
			laChemise.setIdTaille(5);
			//if(tfXs.getText()=="XXL" ||tfXs.getText()=="")
				if(tfXXl.getText().isEmpty())
			{
				laChemise.setStockChemise(0);
			}
			else laChemise.setStockChemise(Integer.valueOf(tfXXl.getText())); 
			try 
				{
				if(laCoucheMétier.AjouterChemise(laChemise)==0){
					listeErreurAjout.add("XXl");
				}
				else{ 
					compteurAjout++;	
				}
				
				
				} 
				catch (ExceptionMetier e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ExceptionAccesBd e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			if(compteurAjout!=6){
				String leMessage=new String();
				for (String t : listeErreurAjout)
					leMessage = leMessage +"," + t; 
				new MessageBox(MainStage, AlertType.WARNING, "L'ajout n'a pas eu lieu pour les tailles :"+ listeErreurAjout+ "!");}
			
			else{ 
				new MessageBox(MainStage, AlertType.INFORMATION, "Les " +String.valueOf(compteurAjout) +" chemises ont été ajoutées!");
				
				
			}
		
			anchorZone.getChildren().clear();
			clearAnchorProduct();
			createCommonContainer(anchorZone, MainStage);
			createZoneChemise(anchorZone, MainStage);
}
	}

	public void modifierUnechemise(AnchorPane anchorZone, Stage MainStage, TextField tfNomSearch,TextField tfImageName, ComboBox<String> cbMat,
			TextField tfXs, TextField tfS, TextField tfM, TextField tfL, TextField tfXl, TextField tfXXl,
			TextField tfCouleur, TextField tfPrix, ToggleButton rbAfficher, Label lbNumModel2)
	{
		Integer afficher;
		Integer compteurAjout=0;
		ArrayList<String> listeErreurAjout = new ArrayList<String>();  
		
		if(rbAfficher.isSelected()) afficher=1 ;
		else afficher= 0;
		for(int i=0;i<=5;i++)
		{
			laListeChemise.get(i).setNomChemise(tfNomSearch.getText());
			laListeChemise.get(i).setPrixUnitaire(Float.valueOf(tfPrix.getText()));
			laListeChemise.get(i).setIdMatiere(Integer.valueOf(cbMat.getSelectionModel().getSelectedIndex()));
			laListeChemise.get(i).setCouleurChemise(tfCouleur.getText());
			laListeChemise.get(i).setimageChemise(tfImageName.getText());
			laListeChemise.get(i).setAfficherProduit(afficher);
		}
		
		//ajout de chaque Taille
		//taille0
		if(tfXs.getText()!="XS" ||tfXs.getText()!="" )
		{	
			if(tfXs.getText().isEmpty())
			{
				laListeChemise.get(0).setStockChemise(0);
			}
			else laListeChemise.get(0).setStockChemise(Integer.valueOf(tfXs.getText())); 
			try 
				{
					if(laCoucheMétier.ModifierChemise(laListeChemise.get(0))==0){
						listeErreurAjout.add("Xs");
					}
					else{ 
						compteurAjout++;
						
					}
				} 
				catch (ExceptionMetier e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ExceptionAccesBd e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		
		}
		//taille1
		if(tfS.getText()!="S" ||tfS.getText()!="" )
		{	
			
			
			if(tfS.getText().isEmpty())
			{
				laListeChemise.get(1).setStockChemise(0);
			}
			else laListeChemise.get(1).setStockChemise(Integer.valueOf(tfS.getText())); 
			
			try 
				{
				if(laCoucheMétier.ModifierChemise(laListeChemise.get(1))==0){
					listeErreurAjout.add("S");
				}
				else{ 
					compteurAjout++;
				} 
				}
				catch (ExceptionMetier e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ExceptionAccesBd e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		
		}

		//taille2
		if(tfM.getText()!="M" ||tfM.getText()!="" )
		{	
			
			if(tfM.getText().isEmpty())
			{
				laListeChemise.get(2).setStockChemise(0);
			}
			else laListeChemise.get(2).setStockChemise(Integer.valueOf(tfM.getText())); 
			
			try 
				{if(laCoucheMétier.ModifierChemise(laListeChemise.get(2))==0){
					listeErreurAjout.add("M");
				}
				else{ 
					compteurAjout++;
				}
				} 
				catch (ExceptionMetier e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ExceptionAccesBd e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		
		}
		//taille3
		if(tfL.getText()!="L" ||tfL.getText()!="" )
		{	
			
			if(tfL.getText().isEmpty())
			{
				laListeChemise.get(3).setStockChemise(0);
			}
			else laListeChemise.get(3).setStockChemise(Integer.valueOf(tfL.getText())); 
			
			try 
				{
				if(laCoucheMétier.ModifierChemise(laListeChemise.get(3))==0){
					listeErreurAjout.add("L");
				}
				else{ 
					compteurAjout++;
					
					}
				} 
				catch (ExceptionMetier e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ExceptionAccesBd e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		
		}
		//taille4
		if(tfXl.getText()!="XL" ||tfXl.getText()!="" )
		{	
			
			if(tfXl.getText().isEmpty())
			{
				laListeChemise.get(4).setStockChemise(0);
			}
			else laListeChemise.get(4).setStockChemise(Integer.valueOf(tfXl.getText())); 
			
			try 
				{
				
				if(laCoucheMétier.ModifierChemise(laListeChemise.get(4))==0){
					listeErreurAjout.add("XL");
				}
				else{ 
					compteurAjout++;
					}

				} 
				catch (ExceptionMetier e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ExceptionAccesBd e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		
		}
		//taille5
		if(tfXXl.getText()!="XXL" ||tfXXl.getText()!="" )
		{	
			
			if(tfXXl.getText().isEmpty())
			{
				laListeChemise.get(5).setStockChemise(0);
			}
			else laListeChemise.get(5).setStockChemise(Integer.valueOf(tfXXl.getText())); 
			try 
				{
				if(laCoucheMétier.ModifierChemise(laListeChemise.get(5))==0){
					listeErreurAjout.add("XXl");
				}
				else{ 
					compteurAjout++;	
				}
				
				
				} 
				catch (ExceptionMetier e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ExceptionAccesBd e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			
			
			if(compteurAjout!=6){
				String leMessage=new String();
				for (String t : listeErreurAjout)
					leMessage = leMessage +"," + t; 
				new MessageBox(MainStage, AlertType.WARNING, "La modification n'a pas eu lieu pour les tailles : "+ listeErreurAjout+ " !");
			}
			
			else{ 
				new MessageBox(MainStage, AlertType.INFORMATION, "Les " +String.valueOf(compteurAjout) +" chemises ont été modifiées!");
				
			}

		}
		
		anchorZone.getChildren().clear();
		clearAnchorProduct();
		createCommonContainer(anchorZone, MainStage);
		createZoneChemise(anchorZone, MainStage);
	}

	private void ajouterImageChemise(TextField tfImageName,ImageView imgChemise,Stage MainStage) {
		
		FileChooser btNomImage = new FileChooser();
		btNomImage.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("JPG", "*.jpg"));
		File fichier = btNomImage.showOpenDialog(null);
		
		if (fichier != null)
		{
			try
			{
			// copier le fichier d'image vers le répertoire de l'application
			File fichierDst = new File(
			System.getProperty("user.dir") + "/image/imgChemise/" + fichier.getName());
			Files.copy(fichier.toPath(), fichierDst.toPath(), REPLACE_EXISTING);
			// si la copie a réussi, mettre à jour l'image à l'écran
			tfImageName.setText(fichier.getName());
			imgChemise.setImage(new Image("file:image/imgChemise/" + fichier.getName()));
			}
			
			catch (IOException e)
			{
			new MessageBox(MainStage, AlertType.WARNING, e.getMessage());
			}
		}
		
	}
}
