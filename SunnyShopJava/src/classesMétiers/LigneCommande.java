package classesMétiers;

public class LigneCommande {
	
	public Integer idLigneCommande;
	public Integer idOrder;
	public Integer idProduit;
	public Integer quantité;

	/**
	 * 
	 */
	public LigneCommande() {
		
	}
	
	/**
	 * @param LigneCommande ligne
	 */
	public LigneCommande(LigneCommande ligne) {
		this.idLigneCommande = ligne.idLigneCommande;
		this.idOrder = ligne.idOrder;
		this.idProduit = ligne.idProduit;
		this.quantité = ligne.quantité;
	}

	/**
	 * @param idLigneCommande
	 * @param idOrder
	 * @param idProduit
	 * @param quantité
	 */
	public LigneCommande(Integer idLigneCommande, Integer idOrder, Integer idProduit, Integer quantité) {
		
		this.idLigneCommande = idLigneCommande;
		this.idOrder = idOrder;
		this.idProduit = idProduit;
		this.quantité = quantité;
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

	public Integer getIdProduit() {
		return idProduit;
	}

	public void setIdProduit(Integer idProduit) {
		this.idProduit = idProduit;
	}

	public Integer getQuantité() {
		return quantité;
	}

	public void setQuantité(Integer quantité) {
		this.quantité = quantité;
	}
	
	
	
	

	 

}
