package classesMétiers;

import coucheMétier.ExceptionMetier;
public class Alcool {
	
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
	public Alcool() {
		
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
	public Alcool(Alcool a) {
		super();
		this.idAlcool = a.idAlcool;
		this.idProduit = a.idProduit;
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
		this.afficherProduit = a.afficherProduit;
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
	public Alcool(Integer idAlcool, Integer idProduit, String nomAlcool, Integer prixUnitaire, Integer idFamille,
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
