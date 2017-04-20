package classesM�tiers;

import coucheM�tier.ExceptionMetier;
public class Alcool {
	
	 private String idAlcool;
	 private String nomAlcool;
	 private Float prixUnitaire;
	 private Integer idFamille;
	 private String familleAlcool;
	 private Integer idProvenanceAlcool;
	 private String provenanceAlcool;
	
	private Integer degr�Alcool;
	 private String goutAlcool;
	 private String datePeremption;
	 private Integer stockAlcool;
	 private Integer quantit�Caisse;
	 private String imageAlcool;
	 private Integer idTypeProduit;
	 private Integer afficherAlcool;
	 
	 //Constructeur Affichage Table
	 /**
		 * @param idAlcool
		 * @param nomAlcool
		 * @param prixUnitaire
		 * @param familleAlcool
		 * @param provenanceAlcool
		 * @param stockAlcool
		 */
		public Alcool(String idAlcool, String nomAlcool, Float prixUnitaire,
				String familleAlcool, String provenanceAlcool,
				Integer stockAlcool) {
			super();
			this.idAlcool = idAlcool;
			this.nomAlcool = nomAlcool;
			this.prixUnitaire = prixUnitaire;
			this.familleAlcool = familleAlcool;
			this.provenanceAlcool = provenanceAlcool;
			this.stockAlcool = stockAlcool;
		}
	 /**
	 * 
	 */
	public Alcool() {
		
	}
	/**
	 * @param other Alcool
	 *
	 */
	public Alcool(Alcool a) {
		super();
		this.idAlcool = a.idAlcool;
		this.nomAlcool = a.nomAlcool;
		this.prixUnitaire = a.prixUnitaire;
		this.idFamille = a.idFamille;
		this.idProvenanceAlcool = a.idProvenanceAlcool;
		this.degr�Alcool = a.degr�Alcool;
		this.goutAlcool = a.goutAlcool;
		this.datePeremption = a.datePeremption;
		this.stockAlcool = a.stockAlcool;
		this.quantit�Caisse = a.quantit�Caisse;
		this.imageAlcool = a.imageAlcool;
		this.idTypeProduit = a.idTypeProduit;
		this.afficherAlcool = a.afficherAlcool;
	}
	
	/**
	 * @param idAlcool
	 * @param idProduit
	 * @param nomAlcool
	 * @param prixUnitaire
	 * @param idFamille
	 * @param familleAlcool
	 * @param idProvenanceAlcool
	 * @param provenanceAlcool
	 * @param degr�Alcool
	 * @param goutAlcool
	 * @param datePeremption
	 * @param stockAlcool
	 * @param quantit�Caisse
	 * @param imageAlcool
	 * @param idTypeProduit
	 * @param afficherProduit
	 */
	public Alcool(String idAlcool,  String nomAlcool, Float prixUnitaire, 
			Integer idFamille,String familleAlcool, Integer idProvenanceAlcool,
			String provenanceAlcool, Integer degr�Alcool,String goutAlcool,
			String datePeremption, Integer stockAlcool, Integer quantit�Caisse, 
			String imageAlcool,	Integer idTypeProduit, Integer afficherProduit) 
	{
		super();
		this.idAlcool = idAlcool;
		this.nomAlcool = nomAlcool;
		this.prixUnitaire = prixUnitaire;
		this.idFamille = idFamille;
		this.familleAlcool = familleAlcool;
		this.idProvenanceAlcool = idProvenanceAlcool;
		this.provenanceAlcool = provenanceAlcool;
		this.degr�Alcool = degr�Alcool;
		this.goutAlcool = goutAlcool;
		this.datePeremption = datePeremption;
		this.stockAlcool = stockAlcool;
		this.quantit�Caisse = quantit�Caisse;
		this.imageAlcool = imageAlcool;
		this.idTypeProduit = idTypeProduit;
		this.afficherAlcool = afficherProduit;
	}
	
	//Constructeur avec tous les champs de la Db
	/**
	 * @param idAlcool
	 * @param nomAlcool
	 * @param prixUnitaire
	 * @param idFamille
	 * @param idProvenanceAlcool
	 * @param degr�Alcool
	 * @param goutAlcool
	 * @param datePeremption
	 * @param stockAlcool
	 * @param quantit�Caisse
	 * @param imageAlcool
	 * @param idTypeProduit
	 * @param afficherAlcool
	 */
	public Alcool(String idAlcool, String nomAlcool, Float prixUnitaire, 
				Integer idFamille, Integer idProvenanceAlcool,
			Integer degr�Alcool, String goutAlcool, String datePeremption, 
			Integer stockAlcool, Integer quantit�Caisse,
			String imageAlcool, Integer idTypeProduit, Integer afficherAlcool) {
		super();
		this.idAlcool = idAlcool;
		this.nomAlcool = nomAlcool;
		this.prixUnitaire = prixUnitaire;
		this.idFamille = idFamille;
		this.idProvenanceAlcool = idProvenanceAlcool;
		this.degr�Alcool = degr�Alcool;
		this.goutAlcool = goutAlcool;
		this.datePeremption = datePeremption;
		this.stockAlcool = stockAlcool;
		this.quantit�Caisse = quantit�Caisse;
		this.imageAlcool = imageAlcool;
		this.idTypeProduit = idTypeProduit;
		this.afficherAlcool = afficherAlcool;
	}
	
	public String getIdAlcool() {
		return idAlcool;
	}
	public void setIdAlcool(String idAlcool) {
		this.idAlcool = idAlcool;
	}
	public String getNomAlcool() {
		return nomAlcool;
	}
	public void setNomAlcool(String nomAlcool) {
		this.nomAlcool = nomAlcool;
	}
	public Float getPrixUnitaire() {
		return prixUnitaire;
	}
	public void setPrixUnitaire(Float prixUnitaire) {
		this.prixUnitaire = prixUnitaire;
	}
	public Integer getIdFamille() {
		return idFamille;
	}
	public void setFamilleAlcool(String familleAlcool) {

		this.familleAlcool = familleAlcool;
	}
	public String getFamille() {
		return familleAlcool;
	}
	public void setIdFamille(Integer idFamille) {

		this.idFamille = idFamille;
	}
	public Integer getIdProvenanceAlcool() {
		return idProvenanceAlcool;
	}
	public void setIdProvenanceAlcool(String provenanceAlcool) {
		this.provenanceAlcool = provenanceAlcool;
	}
	public String getProvenanceAlcool() {
		return provenanceAlcool;
	}
	public void setIdProvenanceAlcool(Integer idProvenanceAlcool) {
		this.idProvenanceAlcool = idProvenanceAlcool;
	}
	public Integer getDegr�Alcool() {
		return degr�Alcool;
	}
	public void setDegr�Alcool(Integer degr�Alcool) {
		this.degr�Alcool = degr�Alcool;
	}
	public String getGoutAlcool() {
		return goutAlcool;
	}
	public void setGoutAlcool(String goutAlcool) {
		this.goutAlcool = goutAlcool;
	}
	public String getDatePeremption() {
		return datePeremption;
	}
	public void setDatePeremption(String datePeremption) {
		this.datePeremption = datePeremption;
	}
	public Integer getStockAlcool() {
		return stockAlcool;
	}
	public void setStockAlcool(Integer stockAlcool) {
		this.stockAlcool = stockAlcool;
	}
	public Integer getQuantit�Caisse() {
		return quantit�Caisse;
	}
	public void setQuantit�Caisse(Integer quantit�Caisse) {
		this.quantit�Caisse = quantit�Caisse;
	}
	public String getImageAlcool() {
		return imageAlcool;
	}
	public void setImageAlcool(String imageAlcool) {
		this.imageAlcool = imageAlcool;
	}
	public Integer getIdTypeProduit() {
		return idTypeProduit;
	}
	public void setIdTypeProduit(Integer idTypeProduit) {
		this.idTypeProduit = idTypeProduit;
	}
	public Integer getAfficherAlcool() {
		return afficherAlcool;
	}
	public void setAfficherAlcool(Integer afficherAlcool) {
		this.afficherAlcool = afficherAlcool;
	}
}
