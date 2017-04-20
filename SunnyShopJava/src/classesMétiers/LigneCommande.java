package classesMétiers;

public class LigneCommande {
	
	public Integer idLigneCommande;
	public Integer idOrder;
	public String idProduit;
	public String nom;
	public Float prixUnitaire;
	public Integer quantité;
	public Float sousTotal;
	
	
	/**
	 * @param idLigneCommande
	 * @param idOrder
	 * @param idProduit
	 * @param nom
	 * @param prixUnitaire
	 * @param quantité
	 * @param sousTotal
	 */
	public LigneCommande(Integer idLigneCommande, Integer idOrder, String idProduit, String nom, Float prixUnitaire,
			Integer quantité, Float sousTotal) {
		super();
		this.idLigneCommande = idLigneCommande;
		this.idOrder = idOrder;
		this.idProduit = idProduit;
		this.nom = nom;
		this.prixUnitaire = prixUnitaire;
		this.quantité = quantité;
		this.sousTotal = sousTotal;
	}
	/**
	 * @param idProduit
	 * @param nom
	 * @param prixUnitaire
	 * @param quantité
	 * @param sousTotal
	 */
	public LigneCommande(String idProduit, String nom, Float prixUnitaire, Integer quantité, Float sousTotal) {
		super();
		this.idProduit = idProduit;
		this.nom = nom;
		this.prixUnitaire = prixUnitaire;
		this.quantité = quantité;
		this.sousTotal = sousTotal;
	}
	/**
	 * 
	 */
	public LigneCommande() {
		super();
	}
	public Integer getIdLigneCommande() {
		return idLigneCommande;
	}
	public void setIdLigneCommande(Integer idLigneCommande) {
		this.idLigneCommande = idLigneCommande;
	}
	public Integer getIdOrder() {
		return idOrder;
	}
	public void setIdOrder(Integer idOrder) {
		this.idOrder = idOrder;
	}
	public String getIdProduit() {
		return idProduit;
	}
	public void setIdProduit(String idProduit) {
		this.idProduit = idProduit;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public Float getPrixUnitaire() {
		return prixUnitaire;
	}
	public void setPrixUnitaire(Float prixUnitaire) {
		this.prixUnitaire = prixUnitaire;
	}
	public Integer getQuantité() {
		return quantité;
	}
	public void setQuantité(Integer quantité) {
		this.quantité = quantité;
	}
	public Float getSousTotal() {
		return sousTotal;
	}
	public void setSousTotal(Float sousTotal) {
		this.sousTotal = sousTotal;
	}
	
	

	 

}
