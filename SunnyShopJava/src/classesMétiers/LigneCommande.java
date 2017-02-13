package classesM�tiers;

public class LigneCommande {
	
	public Integer idLigneCommande;
	public Integer idOrder;
	public Integer idProduit;
	public Integer quantit�;

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
		this.quantit� = ligne.quantit�;
	}

	/**
	 * @param idLigneCommande
	 * @param idOrder
	 * @param idProduit
	 * @param quantit�
	 */
	public LigneCommande(Integer idLigneCommande, Integer idOrder, Integer idProduit, Integer quantit�) {
		
		this.idLigneCommande = idLigneCommande;
		this.idOrder = idOrder;
		this.idProduit = idProduit;
		this.quantit� = quantit�;
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

	public Integer getQuantit�() {
		return quantit�;
	}

	public void setQuantit�(Integer quantit�) {
		this.quantit� = quantit�;
	}
	
	
	
	

	 

}
