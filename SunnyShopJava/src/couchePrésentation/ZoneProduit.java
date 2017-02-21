package couchePrésentation;

import coucheMétier.*;
import coucheAccesBd.*;
import classesMétiers.*;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ZoneProduit {
	ObservableList<String> laListeMaturation = null;
	ObservableList<String> laListeProvenance = null;
	ObservableList<String> laListeType = null;
	ObservableList<String> laListeSaveur = null;
	ObservableList<Vin> laListeDeVin = null;
	Vin leVin;
	int leNum;
	Alcool A = new Alcool();
	Chemise c = new Chemise();
	
	Metier laCoucheMétier = new Metier();
	private static TableView<Vin> vinTable = new TableView<Vin>();
	private static TableView<Alcool> alcoolTable = new TableView<Alcool>();
	private static TableView<Chemise> chemiseTable = new TableView<Chemise>();
	private static HBox hboxTopSearch = new HBox(27);
	private static HBox hboxMid = new HBox(10);
	private static VBox vboxRightButton = new VBox(10);
	private static VBox vboxRightImage = new VBox(10);
	private static GridPane gridChange = new GridPane();

	public ZoneProduit() throws ExceptionAccesBd {
		//leVin.setIdVin(2);
		laListeProvenance = FXCollections.observableArrayList(laCoucheMétier.ListerProvenanceVin());
		laListeType = FXCollections.observableArrayList(laCoucheMétier.ListerTypeVin());
		laListeMaturation = FXCollections.observableArrayList(laCoucheMétier.ListerMaturationVin());
		laListeSaveur = FXCollections.observableArrayList(laCoucheMétier.ListerSaveurVin());
		leNum = laCoucheMétier.GetMaxNumVin()+1;
	
	}

	public void createZoneProduit(AnchorPane anchorZone, Stage MainStage) {
		createCommonContainer(anchorZone, MainStage);
		
	}

	// createCommonPane Container (Multiple Pane usable)
	@SuppressWarnings({ "static-access" })
	public void createCommonContainer(AnchorPane anchorZone, Stage MainStage) {

		vboxRightButton.getChildren().clear();
		// Css Conteneur
		vboxRightButton.getStyleClass().add("vboxRightButton");
		vboxRightButton.getStyleClass().add("vboxRight");

		// Position AnchorPane
		anchorZone.setTopAnchor(vboxRightButton, 150.0);
		anchorZone.setRightAnchor(vboxRightButton, 25.0);

		Button btVin = new Button("Vin");
		btVin.setOnAction(e -> {
			anchorZone.getChildren().clear();
			createCommonContainer(anchorZone, MainStage);
			createZoneVin(anchorZone, null);
		});

		Button btAlcool = new Button("Alcool");
		btAlcool.setOnAction(e -> {
			anchorZone.getChildren().clear();
			createCommonContainer(anchorZone, MainStage);
			createZoneAlcool(anchorZone, MainStage);
		});

		Button btChemise = new Button("Chemise");
		btChemise.setOnAction(e -> {
			anchorZone.getChildren().clear();
			createCommonContainer(anchorZone, MainStage);
			createZoneChemise(anchorZone, MainStage);
		});

		vboxRightButton.getChildren().addAll(btVin, btAlcool, btChemise);
		anchorZone.getChildren().addAll(vboxRightButton);
	}

	// createVinzone
	private void createZoneVin(AnchorPane anchorZone, Stage MainStage) {
		clearAnchorProduct();
		vinTable.setVisible(true);
		createHboxSearch(anchorZone);
		createTableVin(anchorZone,MainStage);
		createHboxMidManageProduct(anchorZone, MainStage);
		createGridePaneChangeVin(anchorZone, gridChange, vboxRightImage, MainStage);
	}

	// create Zone Alcool
	private void createZoneAlcool(AnchorPane anchorZone, Stage MainStage) {
		clearAnchorProduct();
		createTableAlcool(anchorZone);
		alcoolTable.setVisible(true);
		createHboxSearch(anchorZone);
		createHboxMidManageProduct(anchorZone, MainStage);
		createGridePaneChangeAlcool(anchorZone, gridChange, vboxRightImage);
	}

	// create zone chemise
	private void createZoneChemise(AnchorPane anchorZone, Stage MainStage) {
		clearAnchorProduct();
		createTableChemise(anchorZone);
		chemiseTable.setVisible(true);
		createHboxSearch(anchorZone);
		createHboxMidManageProduct(anchorZone, MainStage);
		createGridePaneChangeChemise(anchorZone, gridChange, vboxRightImage);
	}

	// clear AnchorProduct
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

	// createHboxSearch (Multiple Pane usable)
	public void createHboxSearch(AnchorPane anchorZone) {
		anchorZone.setTopAnchor(hboxTopSearch, 25.0);
		anchorZone.setRightAnchor(hboxTopSearch, 25.0);

		hboxTopSearch.getStyleClass().add("hboxTopSearch");

		TextField tfCol1 = new TextField();
		TextField tfCol2 = new TextField();
		TextField tfCol3 = new TextField();
		Button btChercher = new Button("Chercher");
		hboxTopSearch.getChildren().addAll(tfCol1, tfCol2, tfCol3, btChercher);
		btChercher.getStyleClass().add("btChercher");
		anchorZone.getChildren().addAll(hboxTopSearch);
	}

	// createTableVin
	public void createTableVin(AnchorPane anchorZone,Stage MainStage) {

		// Position AnchorPane
		anchorZone.setTopAnchor(vinTable, 90.0);
		anchorZone.setLeftAnchor(vinTable, 50.0);
		//laListeDeVin = FXCollections.observableArrayList(laCoucheMétier.ListerVin());
		vinTable.getStyleClass().add("Table");

		try
		{
		vinTable.itemsProperty().setValue(FXCollections.observableArrayList(FXCollections.observableArrayList(laCoucheMétier.ListerVin())));
		}catch(Exception ex)
		{			
		new MessageBox(MainStage, AlertType.ERROR,"Accès à la BD impossible (" + ex.getMessage() + ")");
		}
		
		// création tableau vin
		TableColumn<Vin, String> idCol = new TableColumn<Vin, String>("ID Produit");
		idCol.setCellValueFactory(new PropertyValueFactory<>("idVin"));
		TableColumn<Vin, String> descriptionCol = new TableColumn<Vin, String>("Nom");
		descriptionCol.prefWidthProperty().bind(vinTable.widthProperty().multiply(0.15));
		descriptionCol.setCellValueFactory(new PropertyValueFactory<Vin, String>("nomVin"));
		TableColumn<Vin, String> typeVinCol = new TableColumn<Vin, String>("Type de vin");
		typeVinCol.setCellValueFactory(new PropertyValueFactory<Vin, String>("typeVin"));
		TableColumn<Vin, String> origineCol = new TableColumn<Vin, String>("Origine");
		origineCol.setCellValueFactory(new PropertyValueFactory<Vin, String>("provenanceVin"));
		TableColumn<Vin, String> milleCol = new TableColumn<Vin, String>("Millésime");
		milleCol.setCellValueFactory(new PropertyValueFactory<Vin, String>("millesime"));
		TableColumn<Vin, Float> prixCol = new TableColumn<Vin, Float>("Prix Unitaire");
		prixCol.setCellValueFactory(new PropertyValueFactory<Vin, Float>("PrixUnitaire"));
		TableColumn<Vin, Float> StickCol = new TableColumn<Vin, Float>("Stock");
		StickCol.setCellValueFactory(new PropertyValueFactory<>("stockVin"));
		vinTable.getColumns().addAll(idCol, descriptionCol, typeVinCol, origineCol, milleCol, prixCol, StickCol);
		anchorZone.getChildren().add(vinTable);
		
		
	}

	// create alcoolTable
	private void createTableAlcool(AnchorPane anchorZone) {
		anchorZone.setTopAnchor(alcoolTable, 90.0);
		anchorZone.setLeftAnchor(alcoolTable, 50.0);

		alcoolTable.getStyleClass().add("Table");

		// création tableau alcool
		TableColumn<Alcool, String> idCol = new TableColumn<Alcool, String>("ID Produit");
		TableColumn<Alcool, String> descriptionCol = new TableColumn<Alcool, String>("Description");
		descriptionCol.prefWidthProperty().bind(alcoolTable.widthProperty().multiply(0.445));
		TableColumn<Alcool, String> familleCol = new TableColumn<Alcool, String>("Famille");
		TableColumn<Alcool, String> origineCol = new TableColumn<Alcool, String>("Origine");
		TableColumn<Alcool, Float> prixCol = new TableColumn<Alcool, Float>("Prix Unitaire");
		TableColumn<Alcool, Float> StockCol = new TableColumn<Alcool, Float>("Stock");

		alcoolTable.getColumns().addAll(idCol, descriptionCol, familleCol, origineCol, prixCol, StockCol);
		alcoolTable.setVisible(false);
		anchorZone.getChildren().addAll(alcoolTable);
	}

	// create chemiseTable
	private void createTableChemise(AnchorPane anchorZone) {
		anchorZone.setTopAnchor(chemiseTable, 90.0);
		anchorZone.setLeftAnchor(chemiseTable, 50.0);

		chemiseTable.getStyleClass().add("Table");

		// création tableau alcool
		TableColumn<Chemise, String> idCol = new TableColumn<Chemise, String>("ID Produit");
		TableColumn<Chemise, String> descriptionCol = new TableColumn<Chemise, String>("Description");
		descriptionCol.prefWidthProperty().bind(chemiseTable.widthProperty().multiply(0.4045));
		TableColumn<Chemise, String> tailleCol = new TableColumn<Chemise, String>("Taille");
		TableColumn<Chemise, Float> prixCol = new TableColumn<Chemise, Float>("Prix Unitaire");
		TableColumn<Chemise, Float> StockCol = new TableColumn<Chemise, Float>("Stock");

		chemiseTable.getColumns().addAll(idCol, descriptionCol, tailleCol, prixCol, StockCol);
		chemiseTable.setVisible(false);
		anchorZone.getChildren().addAll(chemiseTable);
	}

	// createHboxMidManageProduct
	public void createHboxMidManageProduct(AnchorPane anchorZone, Stage MainStage) {
		anchorZone.setBottomAnchor(hboxMid, 275.0);
		anchorZone.setRightAnchor(hboxMid, 260.0);

		// création hboxMid ---> STOCK,MODIFIER,AJOUTER

		Button btModifier = new Button("Modifier article");
		btModifier.setVisible(false);
		btModifier.setOnAction(e -> {
			gridChange.setVisible(true);
			vboxRightImage.setVisible(true);
		}); // afficher gridChange

		Button btAjouter = new Button("Ajouter");
		btAjouter.setOnAction(e -> {
			gridChange.setVisible(true);
			vboxRightImage.setVisible(true);
			
		}); // afficher gridChange

		Button btStock = new Button("Gestion stock");
		btStock.setVisible(false);
		if (vinTable.isVisible()) {
			btStock.setOnAction(e -> {
				new GestionStockVin(MainStage);
			});
		} else if (alcoolTable.isVisible()) {
			btStock.setOnAction(e -> {
				new GestionStockAlcool(MainStage);
			});
		} else if (chemiseTable.isVisible()) {
			btStock.setOnAction(e -> {
				new GestionStockChemise(MainStage);
			});
		}

		hboxMid.getChildren().addAll(btStock, btModifier, btAjouter);
		anchorZone.getChildren().addAll(hboxMid);
	}

	// create GridPane Change VIN
	public void createGridePaneChangeVin(AnchorPane anchorZone, GridPane gridChange, VBox vboxRightImage,Stage MainStage) {
		leVin= new Vin();
		gridChange.setHgap(10);
		gridChange.setVgap(5);
		gridChange.setAlignment(Pos.CENTER);
		gridChange.setVisible(false);
		//HBox hbBouton = new HBox(10); 
		
		gridChange.getStyleClass().add("gridChange");

		anchorZone.setBottomAnchor(gridChange, 20.0);
		anchorZone.setLeftAnchor(gridChange, 50.0);
		anchorZone.setBottomAnchor(vboxRightImage, 20.0);
		anchorZone.setRightAnchor(vboxRightImage, 25.0);

		TextField tfNomSearch = new TextField("Nom");
		gridChange.add(tfNomSearch, 0, 0,1 , 1);
		tfNomSearch.getStyleClass().add("tfNomSearch");

		ComboBox<String> cbMat = new ComboBox<>();
		cbMat.setValue("Maturité");
		gridChange.add(cbMat, 4, 1, 1, 1);
		cbMat.setItems(laListeMaturation);
		cbMat.getStyleClass().add("cbMat");
		
		TextField tfPrix = new TextField ("Prix Unitaire");
		gridChange.add(tfPrix, 1,0, 1, 1);

		TextField tfQuantiteCaisse = new TextField("Q/caisse");
		gridChange.add(tfQuantiteCaisse, 1, 1, 1, 1);
		tfQuantiteCaisse.getStyleClass().add("tfQuantiteCaisse");

		ComboBox<String> cbSaveur = new ComboBox<>();

		cbSaveur.setValue("Saveur");
		gridChange.add(cbSaveur, 3, 1, 1, 1);
		
		cbSaveur.setItems(laListeSaveur);
		cbSaveur.getStyleClass().add("cbSaveur");


		TextField tfStockVin = new TextField("Stock");
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
	
		cbProvenance.setItems(laListeProvenance);
		cbProvenance.getStyleClass().add("cbProvenance");

		TextField tfMillesime = new TextField("Millésime");
		gridChange.add(tfMillesime, 0, 1, 1, 1);

		TextField tfImageName = new TextField("Image");
		gridChange.add(tfImageName, 3, 2, 1, 1);

		Button btImage = new Button("Img");
		gridChange.add(btImage, 4, 2, 1, 1);
		btImage.getStyleClass().add("btImage");

		
		Button btValider = new Button("V");
		btValider.setOnAction(e -> {
		gridChange.setVisible(false);
		vboxRightImage.setVisible(false);
		
		ToggleButton rbAfficher = new RadioButton("Afficher le produit");
		gridChange.add(rbAfficher, 0, 2, 1, 1);
		rbAfficher.getStyleClass().add("rbAfficher");
		
		
		//Ajouter Vin
		
			Integer afficher;
			Integer laMaturation = cbMat.getSelectionModel().getSelectedIndex();
			if(rbAfficher.isSelected()) afficher=1 ;
			else afficher= 0;
			leVin.setIdVin(String.valueOf(00)+String.valueOf(leNum)+"0"+cbType.getSelectionModel().getSelectedIndex()+
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
			leVin.setImageVin("ImageTest 0009999");
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
					createZoneVin(anchorZone, MainStage);
				}
			} 
			catch (ExceptionMetier e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (ExceptionAccesBd e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		});
		gridChange.add(btValider, 4, 3, 1, 1);
		Button btAnnuler = new Button("X");
		btAnnuler.setOnAction(e -> {
		
		gridChange.setVisible(false);
		vboxRightImage.setVisible(false);
		});
		
		gridChange.add(btAnnuler, 3, 3, 1, 1);
		

		// image
		vboxRightImage.getStyleClass().add("vboxRightImage");
		vboxRightImage.setVisible(false);

		anchorZone.getChildren().addAll(vboxRightImage, gridChange);

		// encodage

		if (leVin.getIdVin() == null) {
			tfNomSearch.setOnMouseClicked(e -> {
				tfNomSearch.setText("");
			});
			tfQuantiteCaisse.setOnMouseClicked(e -> {
				tfQuantiteCaisse.setText("");
			});
			tfMillesime.setOnMouseClicked(e -> {
				tfMillesime.setText("");
			});
			tfPrix.setOnMouseClicked(e -> {
				tfPrix.setText("");
			});
			tfQuantiteCaisse.setOnMouseClicked(e -> {
				tfQuantiteCaisse.setText("");
			});
			tfStockVin.setOnMouseClicked(e -> {
				tfStockVin.setText("");
			});
		
		}
	}

	// create GridPane Change ALCOOl
	public void createGridePaneChangeAlcool(AnchorPane anchorZone, GridPane gridChange, VBox vboxRightImage) {
		gridChange.setHgap(10);
		gridChange.setVgap(5);
		gridChange.setAlignment(Pos.CENTER);
		gridChange.setVisible(false);

		gridChange.getStyleClass().add("gridChange");

		anchorZone.setBottomAnchor(gridChange, 20.0);
		anchorZone.setLeftAnchor(gridChange, 50.0);
		anchorZone.setBottomAnchor(vboxRightImage, 20.0);
		anchorZone.setRightAnchor(vboxRightImage, 25.0);

		TextField tfNomSearch = new TextField("Nom");
		gridChange.add(tfNomSearch, 0, 0, 2, 1);
		tfNomSearch.getStyleClass().add("tfNomSearch");

		Label laQuantiteCaisse = new Label("Quantité par Caisse");
		gridChange.add(laQuantiteCaisse, 0, 2, 1, 1);

		TextField tfQuantiteCaisse = new TextField();
		gridChange.add(tfQuantiteCaisse, 1, 2, 1, 1);
		tfQuantiteCaisse.getStyleClass().add("tfQuantiteCaisse");

		TextField tfGout = new TextField("Gout");
		gridChange.add(tfGout, 3, 1, 1, 1);
		tfGout.getStyleClass().add("tfGout");

		Label laStock = new Label("Quantité en stock");
		gridChange.add(laStock, 0, 3, 1, 1);

		TextField tfStockAlcool = new TextField();
		gridChange.add(tfStockAlcool, 1, 3, 1, 1);
		tfStockAlcool.getStyleClass().add("tfStockAlcool");

		ComboBox<String> cbFamille = new ComboBox<>();
		cbFamille.setValue("Famille");
		gridChange.add(cbFamille, 3, 0, 1, 1);
		cbFamille.getStyleClass().add("cbFamille");

		ComboBox<String> cbProvenance = new ComboBox<>();
		cbProvenance.setValue("Provenance");
		gridChange.add(cbProvenance, 4, 0, 1, 1);
		cbProvenance.getStyleClass().add("cbProvenance");

		TextField tfDegreAlcool = new TextField("Degré");
		gridChange.add(tfDegreAlcool, 4, 1, 1, 1);
		tfDegreAlcool.getStyleClass().add("tfDegre");

		TextField tfImageName = new TextField("Image");
		gridChange.add(tfImageName, 3, 2, 1, 1);

		Button btImage = new Button("Img");
		gridChange.add(btImage, 4, 2, 1, 1);
		btImage.getStyleClass().add("btImage");

		Button btValider = new Button("Valider");
		gridChange.add(btValider, 4, 3, 1, 1);
		btValider.setOnAction(e -> {
			gridChange.setVisible(false);
			vboxRightImage.setVisible(false);
		});
		btValider.getStyleClass().add("btValider");

		// afficher gridChange
		ToggleButton rbAfficher = new RadioButton("Afficher le produit");
		gridChange.add(rbAfficher, 3, 3, 1, 1);
		rbAfficher.getStyleClass().add("rbAfficher");

		// image
		vboxRightImage.getStyleClass().add("vboxRightImage");
		vboxRightImage.setVisible(false);

		anchorZone.getChildren().addAll(vboxRightImage, gridChange);
	}

	// create GridPane Change VIN
	public void createGridePaneChangeChemise(AnchorPane anchorZone, GridPane gridChange, VBox vboxRightImage) {
		gridChange.setHgap(10);
		gridChange.setVgap(5);
		gridChange.setAlignment(Pos.CENTER);
		gridChange.setVisible(false);

		gridChange.getStyleClass().add("gridChange");

		anchorZone.setBottomAnchor(gridChange, 20.0);
		anchorZone.setLeftAnchor(gridChange, 50.0);
		anchorZone.setBottomAnchor(vboxRightImage, 20.0);
		anchorZone.setRightAnchor(vboxRightImage, 25.0);

		TextField tfNomSearch = new TextField("Nom");
		gridChange.add(tfNomSearch, 0, 0, 2, 1);
		tfNomSearch.getStyleClass().add("tfNomSearch");

		ComboBox<String> cbMat = new ComboBox<>();
		cbMat.setValue("Matière");
		gridChange.add(cbMat, 0, 1, 1, 1);
		cbMat.getStyleClass().add("cbMat");

		ComboBox<String> cbSaveur = new ComboBox<>();
		cbSaveur.setValue("Saveur");
		gridChange.add(cbSaveur, 3, 1, 1, 1);
		cbSaveur.getStyleClass().add("cbSaveur");

		Label laStock = new Label("Quantité en stock");
		gridChange.add(laStock, 0, 3, 1, 1);

		TextField tfStockVin = new TextField();
		gridChange.add(tfStockVin, 1, 3, 1, 1);
		tfStockVin.getStyleClass().add("tfStockVin");

		ComboBox<String> cbTaille = new ComboBox<>();
		cbTaille.setValue("Taille");
		gridChange.add(cbTaille, 3, 0, 1, 1);
		cbTaille.getStyleClass().add("cbTaille");

		TextField tfCouleur = new TextField("Couleur");
		gridChange.add(tfCouleur, 4, 0, 1, 1);

		TextField tfImageName = new TextField("Image");
		gridChange.add(tfImageName, 3, 2, 1, 1);

		Button btImage = new Button("Img");
		gridChange.add(btImage, 4, 2, 1, 1);
		btImage.getStyleClass().add("btImage");

		Button btValider = new Button("Valider");
		gridChange.add(btValider, 4, 3, 1, 1);
		btValider.setOnAction(e -> {
			gridChange.setVisible(false);
			vboxRightImage.setVisible(false);
		});
		btValider.getStyleClass().add("btValider");

		// afficher gridChange
		ToggleButton rbAfficher = new RadioButton("Afficher le produit");
		gridChange.add(rbAfficher, 3, 3, 1, 1);
		rbAfficher.getStyleClass().add("rbAfficher");

		// image
		vboxRightImage.getStyleClass().add("vboxRightImage");
		vboxRightImage.setVisible(false);

		anchorZone.getChildren().addAll(vboxRightImage, gridChange);
	}
}
