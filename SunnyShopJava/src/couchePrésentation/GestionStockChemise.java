package couchePrésentation;



import classesMétiers.Chemise;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class GestionStockChemise {
	private static final int LARGEUR = 544;
	private static final int HAUTEUR = 394;

	// objet de la fenêtre 
	private Stage stage = new Stage();
	private Scene thisScene;
	private String StockVal = "25";
	
	private String quantitéCaisse = "6";
	
	private AnchorPane anchor = new AnchorPane();
	private HBox hboxBottom = new HBox(30);
	private GridPane grid =new GridPane();
	

	@SuppressWarnings("unchecked")
	public GestionStockChemise(Stage fenParent){

		 
		thisScene = new Scene(anchor,LARGEUR, HAUTEUR);
		stage.setScene(thisScene);
		anchor.getChildren().addAll(hboxBottom,grid);
		thisScene.getStylesheets().add("couchePrésentation/tabPane.css");
		thisScene.setFill(Color.TRANSPARENT);
		stage.setTitle("StockVal");
	    stage.initOwner(fenParent);
	    stage.initModality(Modality.APPLICATION_MODAL); 
	    stage.initStyle(StageStyle.TRANSPARENT);
	    
	    remplirAnchor(stage);
	    stage.showAndWait();
	}
	
	//@SuppressWarnings("static-access")
		private void remplirAnchor(Stage stage) {
			
			anchor.getStyleClass().add("anchor");
			
			// hboxBottom settings
			AnchorPane.setBottomAnchor(hboxBottom,40.0);
			AnchorPane.setRightAnchor(hboxBottom, 57.0);
				
				Button btValider=new Button("Valider");
				btValider.setOnAction(e -> { stage.close(); }); 
		        
				Button btAnnuler=new Button("Annuler");
		        btAnnuler.setOnAction(e -> { stage.close(); }); 
		        hboxBottom.getChildren().addAll(btAnnuler,btValider); 
	        
	        //gridPane
	        
	        grid.setHgap(12);
	        grid.setVgap(10);
	        grid.setAlignment(Pos.CENTER);
	        
	        grid.getStyleClass().add("grid");
	        
	        anchor.setBottomAnchor(grid, 200.0);
			anchor.setLeftAnchor(grid, 20.0);
			
				
				createLbSize();
				createLbStock();
				createTfStock();
				
		        
		}

	//Create Label Size
	public void createLbSize() {
		Label lbXS = new Label("XS");
		grid.add(lbXS,0,0,2,1);
		lbXS.getStyleClass().add("lbSize");
		grid.setHalignment(lbXS, HPos.CENTER); // To align horizontally in the cell
		grid.setValignment(lbXS, VPos.CENTER);
		
		Label lbS = new Label("S");
		grid.add(lbS,2,0,2,1);
		lbS.getStyleClass().add("lbSize");
		grid.setHalignment(lbS, HPos.CENTER); // To align horizontally in the cell
		grid.setValignment(lbS, VPos.CENTER);
		
		Label lbM = new Label("M");
		grid.add(lbM,4,0,2,1);
		lbM.getStyleClass().add("lbSize");
		grid.setHalignment(lbM, HPos.CENTER); // To align horizontally in the cell
		grid.setValignment(lbM, VPos.CENTER);
		
		Label lbL = new Label("L");
		grid.add(lbL,6,0,2,1);
		lbL.getStyleClass().add("lbSize");
		grid.setHalignment(lbL, HPos.CENTER); // To align horizontally in the cell
		grid.setValignment(lbL, VPos.CENTER);
		
		Label lbXL = new Label("XL");
		grid.add(lbXL,8,0,2,1);
		lbXL.getStyleClass().add("lbSize");
		grid.setHalignment(lbXL, HPos.CENTER); // To align horizontally in the cell
		grid.setValignment(lbXL, VPos.CENTER);
		
		Label lbXXL = new Label("XXL");
		grid.add(lbXXL,10,0,2,1);
		lbXXL.getStyleClass().add("lbSize");
		grid.setHalignment(lbXXL, HPos.CENTER); // To align horizontally in the cell
		grid.setValignment(lbXXL, VPos.CENTER);
	}


	//create lb Stock
	public void createLbStock(){
		Label lbStockXS = new Label("5");
		grid.add(lbStockXS,0,1,1,1);
		lbStockXS.getStyleClass().add("lbStock");
		
		Label lbStockS = new Label("0");
		grid.add(lbStockS,2,1,1,1);
		lbStockS.getStyleClass().add("lbStock");
		
		Label lbStockM = new Label("3");
		grid.add(lbStockM,4,1,1,1);
		lbStockM.getStyleClass().add("lbStock");
		
		Label lbStockL = new Label("1");
		grid.add(lbStockL,6,1,1,1);
		lbStockL.getStyleClass().add("lbStock");
		
		Label lbStockXL = new Label("2");
		grid.add(lbStockXL,8,1,1,1);
		lbStockXL.getStyleClass().add("lbStock");
		
		Label lbStockXXL = new Label("2");
		grid.add(lbStockXXL,10,1,1,1);
		lbStockXXL.getStyleClass().add("lbStock");
	}
	
	//create tf stock
	public void createTfStock(){
		TextField tfStockXS = new TextField("");
		grid.add(tfStockXS,1,1,1,1);
		tfStockXS.getStyleClass().add("tfStock");
		
		TextField tfStockS = new TextField("");
		grid.add(tfStockS,3,1,1,1);
		tfStockS.getStyleClass().add("tfStock");
		
		TextField tfStockM = new TextField("");
		grid.add(tfStockM,5,1,1,1);
		tfStockM.getStyleClass().add("tfStock");
		
		TextField tfStockL = new TextField("");
		grid.add(tfStockL,7,1,1,1);
		tfStockL.getStyleClass().add("tfStock");
		
		TextField tfStockXL = new TextField("");
		grid.add(tfStockXL,9,1,1,1);
		tfStockXL.getStyleClass().add("tfStock");
		
		TextField tfStockXXL = new TextField("");
		grid.add(tfStockXXL,11,1,1,1);
		tfStockXXL.getStyleClass().add("tfStock");
	}
}
