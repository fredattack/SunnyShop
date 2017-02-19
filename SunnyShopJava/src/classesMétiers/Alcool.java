package classesM�tiers;

import coucheM�tier.ExceptionMetier;
public class Alcool {
	
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
	public Alcool() {
		
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
	public Alcool(Alcool a) {
		super();
		this.idAlcool = a.idAlcool;
		this.idProduit = a.idProduit;
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
		this.afficherProduit = a.afficherProduit;
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
	public Alcool(Integer idAlcool, Integer idProduit, String nomAlcool, Integer prixUnitaire, Integer idFamille,
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
