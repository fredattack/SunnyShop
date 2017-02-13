package classesMétiers;

public class Chemise {
	
	 private Integer idAlcool;
	 private Integer idProduit;
	 private String nomAlcool;
	 private Integer prixUnitaire;
	 private Integer idFamille;
	 private Integer idProvenanceAlcool;
	 private Integer degréAlcool;
	 private String goutAlcool;
	 private String datePeremption;
	 private Integer stockAlcool;
	 private Integer quantitéCaisse;
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
		this.degréAlcool = c.degréAlcool;
		this.goutAlcool = c.goutAlcool;
		this.datePeremption = c.datePeremption;
		this.stockAlcool = c.stockAlcool;
		this.quantitéCaisse = c.quantitéCaisse;
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
	 * @param degréAlcool
	 * @param goutAlcool
	 * @param datePeremption
	 * @param stockAlcool
	 * @param quantitéCaisse
	 * @param imageAlcool
	 * @param idTypeProduit
	 * @param afficherProduit
	 */
	public Chemise(Integer idAlcool, Integer idProduit, String nomAlcool, Integer prixUnitaire, Integer idFamille,
			Integer idProvenanceAlcool, Integer degréAlcool, String goutAlcool, String datePeremption,
			Integer stockAlcool, Integer quantitéCaisse, String imageAlcool, Integer idTypeProduit,
			Integer afficherProduit) {
		super();
		this.idAlcool = idAlcool;
		this.idProduit = idProduit;
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
	public Integer getAfficherProduit() {
		return afficherProduit;
	}
	public void setAfficherProduit(Integer afficherProduit) {
		this.afficherProduit = afficherProduit;
	}
	 
	
	
	 

}
