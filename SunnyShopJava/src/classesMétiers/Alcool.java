package classesMétiers;

import coucheMétier.ExceptionMetier;
public class Alcool {
	
	 private String idAlcool;
	 private String nomAlcool;
	 private Float prixUnitaire;
	 private Integer idFamille;
	 private String familleAlcool;
	 private Integer idProvenanceAlcool;
	 private String provenanceAlcool;
	
	private Integer degréAlcool;
	 private String goutAlcool;
	 private String datePeremption;
	 private Integer stockAlcool;
	 private Integer quantitéCaisse;
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
		this.degréAlcool = a.degréAlcool;
		this.goutAlcool = a.goutAlcool;
		this.datePeremption = a.datePeremption;
		this.stockAlcool = a.stockAlcool;
		this.quantitéCaisse = a.quantitéCaisse;
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
	 * @param degréAlcool
	 * @param goutAlcool
	 * @param datePeremption
	 * @param stockAlcool
	 * @param quantitéCaisse
	 * @param imageAlcool
	 * @param idTypeProduit
	 * @param afficherProduit
	 */
	public Alcool(String idAlcool,  String nomAlcool, Float prixUnitaire, 
			Integer idFamille,String familleAlcool, Integer idProvenanceAlcool,
			String provenanceAlcool, Integer degréAlcool,String goutAlcool,
			String datePeremption, Integer stockAlcool, Integer quantitéCaisse, 
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
		this.degréAlcool = degréAlcool;
		this.goutAlcool = goutAlcool;
		this.datePeremption = datePeremption;
		this.stockAlcool = stockAlcool;
		this.quantitéCaisse = quantitéCaisse;
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
	 * @param degréAlcool
	 * @param goutAlcool
	 * @param datePeremption
	 * @param stockAlcool
	 * @param quantitéCaisse
	 * @param imageAlcool
	 * @param idTypeProduit
	 * @param afficherAlcool
	 */
	public Alcool(String idAlcool, String nomAlcool, Float prixUnitaire, 
				Integer idFamille, Integer idProvenanceAlcool,
			Integer degréAlcool, String goutAlcool, String datePeremption, 
			Integer stockAlcool, Integer quantitéCaisse,
			String imageAlcool, Integer idTypeProduit, Integer afficherAlcool) {
		super();
		this.idAlcool = idAlcool;
		this.nomAlcool = nomAlcool;
		this.prixUnitaire = prixUnitaire;
		this.idFamille = idFamille;
		this.idProvenanceAlcool = idProvenanceAlcool;
		this.degréAlcool = degréAlcool;
		this.goutAlcool = goutAlcool;
		this.datePeremption = datePeremption;
		this.stockAlcool = stockAlcool;
		this.quantitéCaisse = quantitéCaisse;
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
	public Integer getDegréAlcool() {
		return degréAlcool;
	}
	public void setDegréAlcool(Integer degréAlcool) {
		this.degréAlcool = degréAlcool;
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
	public Integer getQuantitéCaisse() {
		return quantitéCaisse;
	}
	public void setQuantitéCaisse(Integer quantitéCaisse) {
		this.quantitéCaisse = quantitéCaisse;
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
