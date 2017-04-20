package classesMétiers;

public class Chemise {
	
	private String idProduit;
	private String nomChemise;
	private Float prixUnitaire;
	private Integer idMatiere;
	private String matiere;
	private String couleurChemise;	
	private Integer stockChemise;
	private String imageChemise;
	private Integer idTypeProduit;
	private Integer afficherProduit;
	private Integer idTaille;
	private String taille;
	private Integer model;
	
	
	public Chemise(){
		 
	 }
	
	/*Constructeur Ajouter
	
	/**
	 * @param idProduit
	 * @param nomChemise
	 * @param prixUnitaire
	 * @param idMatiere
	 * @param couleurChemise
	 * @param stockChemise
	 * @param imageChemise
	 * @param idTypeProduit
	 * @param afficherProduit
	 * @param model
	 * @param taill
	 */
	public Chemise(String idProduit, String nomChemise, Float prixUnitaire, 
					Integer idMatiere, String couleurChemise,
			Integer stockChemise, String imageChemise, Integer idTypeProduit, 
			Integer afficherProduit, Integer idTaille,Integer model) {
		super();
		this.idProduit = idProduit;
		this.nomChemise = nomChemise;
		this.prixUnitaire = prixUnitaire;
		this.idMatiere = idMatiere;
		this.couleurChemise = couleurChemise;
		this.stockChemise = stockChemise;
		this.imageChemise = imageChemise;
		this.idTypeProduit = idTypeProduit;
		this.afficherProduit = afficherProduit;
		this.idTaille = idTaille;
		this.model= model;
	}

	
	
	/*Constructeur Lister
	/**
	 * @param idProduit
	 * @param nomChemise
	 * @param prix
	 * @param matiere
	 * @param couleurChemise
	 * @param stockChemise
	 * @param taille
	 */
	public Chemise(String idProduit, String nomChemise, Float prixUnitaire, 
			String matiere, String couleurChemise,
			Integer stockChemise, String taille) {
		super();
		this.idProduit = idProduit;
		this.nomChemise = nomChemise;
		this.prixUnitaire = prixUnitaire;
		this.matiere = matiere;
		this.couleurChemise = couleurChemise;
		this.stockChemise = stockChemise;
		this.taille = taille;
	}

	public Chemise(Chemise c) {
		super();
		this.idProduit = c.idProduit;
		this.nomChemise = c.nomChemise;
		this.prixUnitaire = c.prixUnitaire;
		this.idMatiere = c.idMatiere;
		this.couleurChemise = c.couleurChemise;
		this.stockChemise = c.stockChemise;
		this.imageChemise = c.imageChemise;
		this.idTypeProduit = c.idTypeProduit;
		this.afficherProduit = c.afficherProduit;
		this.idTaille = c.idTaille;
		this.model= c.model;
	}

	public String getIdProduit() {
		return idProduit;
	}

	public void setIdProduit(String idProduit) {
		this.idProduit = idProduit;
	}

	public String getNomChemise() {
		return nomChemise;
	}

	public void setNomChemise(String nomChemise) {
		this.nomChemise = nomChemise;
	}

	public Float getPrixUnitaire() {
		return prixUnitaire;
	}

	public void setPrixUnitaire(Float prixUnitaire) {
		this.prixUnitaire = prixUnitaire;
	}

	public Integer getIdMatiere() {
		return idMatiere;
	}

	public void setIdMatiere(Integer idMatiere) {
		this.idMatiere = idMatiere;
	}

	public String getMatiere() {
		return matiere;
	}

	public void setMatiere(String matiere) {
		this.matiere = matiere;
	}

	public String getCouleurChemise() {
		return couleurChemise;
	}

	public void setCouleurChemise(String couleurChemise) {
		this.couleurChemise = couleurChemise;
	}

	public Integer getStockChemise() {
		return stockChemise;
	}

	public void setStockChemise(Integer stockChemise) {
		this.stockChemise = stockChemise;
	}

	public String getimageChemise() {
		return imageChemise;
	}

	public void setimageChemise(String imageChemise) {
		this.imageChemise = imageChemise;
	}

	public Integer getIdTypeProduit() {
		return idTypeProduit;
	}

	public void setIdTypeProduit(Integer idTypeProduit) {
		this.idTypeProduit = idTypeProduit;
	}

	public Integer getAfficherProduit() {
		return afficherProduit;
	}

	public void setAfficherProduit(Integer afficherProduit) {
		this.afficherProduit = afficherProduit;
	}

	public Integer getIdTaille() {
		return idTaille;
	}

	public void setIdTaille(Integer taille) {
		this.idTaille = taille;
	}
	

	public Integer getModel() {
		return model;
	}

	public void setModel(Integer model) {
		this.model = model;
	}

	public String getTaille() {
		return taille;
	}

	public void setTaille(String taille) {
		this.taille = taille;
	}

	
	

}
