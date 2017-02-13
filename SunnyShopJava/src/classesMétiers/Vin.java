package classesM�tiers;

public class Vin {

	 private Integer idVin;
	 private String nomVin;
	 private Float prixUnitaire;
	 private Integer idTypeVin;
	 private Integer idSaveur;
	 private Integer idProvenanceVin;
	 private Integer idMaturation;
	 private String millesime;
	 private Integer quantit�Caisse;
	 private Integer stockVin;
	 private String imageVin;
	 private Integer idTypeProduit;
	 private Integer afficherVin;
	 
	/**
	 * 
	 */
	public Vin() {}

	/**
	 * @param Vin v
	 */
	public Vin(Vin v) {
		super();
		this.idVin = v.idVin;
		this.nomVin = v.nomVin;
		this.prixUnitaire = v.prixUnitaire;
		this.idTypeVin = v.idTypeVin;
		this.idSaveur = v.idSaveur;
		this.idProvenanceVin = v.idProvenanceVin;
		this.idMaturation = v.idMaturation;
		this.millesime = v.millesime;
		this.quantit�Caisse = v.quantit�Caisse;
		this.stockVin = v.stockVin;
		this.imageVin = v.imageVin;
		this.idTypeProduit = v.idTypeProduit;
		this.afficherVin = v.afficherVin;
	}

	/**
	 * @param idVin
	 * @param nomVin
	 * @param prixUnitaire
	 * @param idTypeVin
	 * @param idSaveur
	 * @param idProvenanceVin
	 * @param idMaturation
	 * @param millesime
	 * @param quantit�Caisse
	 * @param stockVin
	 * @param imageVin
	 * @param idTypeProduit
	 * @param afficherVin
	 */
	public Vin(Integer idVin, String nomVin, Float prixUnitaire, Integer idTypeVin, Integer idSaveur,
			Integer idProvenanceVin, Integer idMaturation, String millesime, Integer quantit�Caisse, Integer stockVin,
			String imageVin, Integer idTypeProduit, Integer afficherVin) {
		super();
		this.idVin = idVin;
		this.nomVin = nomVin;
		this.prixUnitaire = prixUnitaire;
		this.idTypeVin = idTypeVin;
		this.idSaveur = idSaveur;
		this.idProvenanceVin = idProvenanceVin;
		this.idMaturation = idMaturation;
		this.millesime = millesime;
		this.quantit�Caisse = quantit�Caisse;
		this.stockVin = stockVin;
		this.imageVin = imageVin;
		this.idTypeProduit = idTypeProduit;
		this.afficherVin = afficherVin;
	}

	public Integer getIdVin() {
		return idVin;
	}

	public void setIdVin(Integer idVin) {
		this.idVin = idVin;
	}

	public String getNomVin() {
		return nomVin;
	}

	public void setNomVin(String nomVin) {
		this.nomVin = nomVin;
	}

	public Float getPrixUnitaire() {
		return prixUnitaire;
	}

	public void setPrixUnitaire(Float prixUnitaire) {
		this.prixUnitaire = prixUnitaire;
	}

	public Integer getIdTypeVin() {
		return idTypeVin;
	}

	public void setIdTypeVin(Integer idTypeVin) {
		this.idTypeVin = idTypeVin;
	}

	public Integer getIdSaveur() {
		return idSaveur;
	}

	public void setIdSaveur(Integer idSaveur) {
		this.idSaveur = idSaveur;
	}

	public Integer getIdProvenanceVin() {
		return idProvenanceVin;
	}

	public void setIdProvenanceVin(Integer idProvenanceVin) {
		this.idProvenanceVin = idProvenanceVin;
	}

	public Integer getIdMaturation() {
		return idMaturation;
	}

	public void setIdMaturation(Integer idMaturation) {
		this.idMaturation = idMaturation;
	}

	public String getMillesime() {
		return millesime;
	}

	public void setMillesime(String millesime) {
		this.millesime = millesime;
	}

	public Integer getQuantit�Caisse() {
		return quantit�Caisse;
	}

	public void setQuantit�Caisse(Integer quantit�Caisse) {
		this.quantit�Caisse = quantit�Caisse;
	}

	public Integer getStockVin() {
		return stockVin;
	}

	public void setStockVin(Integer stockVin) {
		this.stockVin = stockVin;
	}

	public String getImageVin() {
		return imageVin;
	}

	public void setImageVin(String imageVin) {
		this.imageVin = imageVin;
	}

	public Integer getIdTypeProduit() {
		return idTypeProduit;
	}

	public void setIdTypeProduit(Integer idTypeProduit) {
		this.idTypeProduit = idTypeProduit;
	}

	public Integer getAfficherVin() {
		return afficherVin;
	}

	public void setAfficherVin(Integer afficherVin) {
		this.afficherVin = afficherVin;
	}
	
	
	
	
	
	 
	 
}
