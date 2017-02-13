package classesM�tiers;

public class Chemise {
	
	 private Integer idAlcool;
	 private Integer idProduit;
	 private String nomAlcool;
	 private Integer prixUnitaire;
	 private Integer idFamille;
	 private Integer idProvenanceAlcool;
	 private Integer degr�Alcool;
	 private String goutAlcool;
	 private String datePeremption;
	 private Integer stockAlcool;
	 private Integer quantit�Caisse;
	 private String imageAlcool;
	 private Integer idTypeProduit;
	 private Integer afficherProduit;
	 
	/**
	 * 
	 */
	public Chemise() {
		
	}
	/**
	 * @param Chemise c
	 */
	public Chemise(Chemise c) {
		super();
		this.idAlcool = c.idAlcool;
		this.idProduit = c.idProduit;
		this.nomAlcool = c.nomAlcool;
		this.prixUnitaire = c.prixUnitaire;
		this.idFamille = c.idFamille;
		this.idProvenanceAlcool = c.idProvenanceAlcool;
		this.degr�Alcool = c.degr�Alcool;
		this.goutAlcool = c.goutAlcool;
		this.datePeremption = c.datePeremption;
		this.stockAlcool = c.stockAlcool;
		this.quantit�Caisse = c.quantit�Caisse;
		this.imageAlcool = c.imageAlcool;
		this.idTypeProduit = c.idTypeProduit;
		this.afficherProduit = c.afficherProduit;
	}
	/**
	 * @param idAlcool
	 * @param idProduit
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
	 * @param afficherProduit
	 */
	public Chemise(Integer idAlcool, Integer idProduit, String nomAlcool, Integer prixUnitaire, Integer idFamille,
			Integer idProvenanceAlcool, Integer degr�Alcool, String goutAlcool, String datePeremption,
			Integer stockAlcool, Integer quantit�Caisse, String imageAlcool, Integer idTypeProduit,
			Integer afficherProduit) {
		super();
		this.idAlcool = idAlcool;
		this.idProduit = idProduit;
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
		this.afficherProduit = afficherProduit;
	}
	
	public Integer getIdAlcool() {
		return idAlcool;
	}
	public void setIdAlcool(Integer idAlcool) {
		this.idAlcool = idAlcool;
	}
	public Integer getIdProduit() {
		return idProduit;
	}
	public void setIdProduit(Integer idProduit) {
		this.idProduit = idProduit;
	}
	public String getNomAlcool() {
		return nomAlcool;
	}
	public void setNomAlcool(String nomAlcool) {
		this.nomAlcool = nomAlcool;
	}
	public Integer getPrixUnitaire() {
		return prixUnitaire;
	}
	public void setPrixUnitaire(Integer prixUnitaire) {
		this.prixUnitaire = prixUnitaire;
	}
	public Integer getIdFamille() {
		return idFamille;
	}
	public void setIdFamille(Integer idFamille) {
		this.idFamille = idFamille;
	}
	public Integer getIdProvenanceAlcool() {
		return idProvenanceAlcool;
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
	public Integer getAfficherProduit() {
		return afficherProduit;
	}
	public void setAfficherProduit(Integer afficherProduit) {
		this.afficherProduit = afficherProduit;
	}
	 
	
	
	 

}
