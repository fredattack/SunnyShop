package classesMétiers;

public class Vin {

	 private String idVin;
	 private String nomVin;
	 private Float prixUnitaire;
	 private Integer idTypeVin;
	private String typeVin;
	 private Integer idSaveur;
	 private String saveur;
	 private Integer idProvenance;
	 private String provenanceVin;
	 private Integer idMaturation;
	 private String maturation;
	 private String millesime;
	 private Integer quantitéCaisse;
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
		this.typeVin = v.typeVin;
		this.saveur = v.saveur;
		this.provenanceVin = v.provenanceVin;
		this.maturation = v.maturation;
		this.millesime = v.millesime;
		this.quantitéCaisse = v.quantitéCaisse;
		this.stockVin = v.stockVin;
		this.imageVin = v.imageVin;
		this.idTypeProduit = v.idTypeProduit;
		this.afficherVin = v.afficherVin;
	}

	/**
	 * @param idVin
	 * @param nomVin
	 * @param prixUnitaire
	 * @param typeVin
	 * @param saveur
	 * @param provenanceVin
	 * @param maturation
	 * @param millesime
	 * @param quantitéCaisse
	 * @param stockVin
	 * @param imageVin
	 * @param idTypeProduit
	 * @param afficherVin
	 */
	public Vin(String idVin, String nomVin, Float prixUnitaire, String typeVin, String saveur,
			String provenanceVin, String maturation, String millesime, Integer quantitéCaisse, Integer stockVin,
			String imageVin, Integer idTypeProduit, Integer afficherVin) {
		super();
		this.idVin = idVin;
		this.nomVin = nomVin;
		this.prixUnitaire = prixUnitaire;
		this.typeVin = typeVin;
		this.saveur = saveur;
		this.provenanceVin = provenanceVin;
		this.maturation = maturation;
		this.millesime = millesime;
		this.quantitéCaisse = quantitéCaisse;
		this.stockVin = stockVin;
		this.imageVin = imageVin;
		this.idTypeProduit = idTypeProduit;
		this.afficherVin = afficherVin;
	}
	
	// Constructeur Select
	public Vin(String idVin, String nomVin, Float prixUnitaire, 
		String typeVin,String provenanceVin, String millesime,  Integer stockVin
			) {
		super();
		this.idVin = idVin;
		this.nomVin = nomVin;
		this.prixUnitaire = prixUnitaire;
		this.typeVin = typeVin;
		this.provenanceVin = provenanceVin;
		this.millesime = millesime;
		this.stockVin = stockVin;
	}
	
	// constructeur Insert
	/**
	 * @param idVin
	 * @param nomVin
	 * @param prixUnitaire
	 * @param idTypeVin
	 * @param idSaveur
	 * @param idProvenance
	 * @param idMaturation
	 * @param millesime
	 * @param quantitéCaisse
	 * @param stockVin
	 * @param imageVin
	 * @param idTypeProduit
	 * @param afficherVin
	 */
	public Vin(String idVin, String nomVin, Float prixUnitaire, 
			Integer idTypeVin, Integer idSaveur, Integer idProvenance,
			Integer idMaturation, String millesime, Integer quantitéCaisse, 
			Integer stockVin, String imageVin,
			Integer idTypeProduit, Integer afficherVin) {
		super();
		this.idVin = idVin;
		this.nomVin = nomVin;
		this.prixUnitaire = prixUnitaire;
		this.idTypeVin = idTypeVin;
		this.idSaveur = idSaveur;
		this.idProvenance = idProvenance;
		this.idMaturation = idMaturation;
		this.millesime = millesime;
		this.quantitéCaisse = quantitéCaisse;
		this.stockVin = stockVin;
		this.imageVin = imageVin;
		this.idTypeProduit = idTypeProduit;
		this.afficherVin = afficherVin;
	}

	
	public String getIdVin() {
		return idVin;
	}

	public void setIdVin(String idVin) {
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

	public int getIdTypeVin() {
		return idTypeVin;
	}

	public void setIdTypeVin(Integer idTypeVin) {
		this.idTypeVin = idTypeVin;
	}

	public String getTypeVin() {
		return typeVin;
	}

	public void setTypeVin(String typeVin) {
		this.typeVin = typeVin;
	}

	public int getIdSaveur() {
		return idSaveur;
	}

	public void setIdSaveur(Integer idSaveur) {
		this.idSaveur = idSaveur;
	}

	public String getSaveur() {
		return saveur;
	}

	public void setSaveur(String saveur) {
		this.saveur = saveur;
	}

	public int getIdProvenance() {
		return idProvenance;
	}

	public void setIdProvenance(Integer idProvenance) {
		this.idProvenance = idProvenance;
	}

	public String getProvenanceVin() {
		return provenanceVin;
	}

	public void setProvenanceVin(String provenanceVin) {
		this.provenanceVin = provenanceVin;
	}

	public int getIdMaturation() {
		return idMaturation;
	}

	public void setIdMaturation(Integer idMaturation) {
		this.idMaturation = idMaturation;
	}

	public String getMaturation() {
		return maturation;
	}

	public void setMaturation(String maturation) {
		this.maturation = maturation;
	}

	public String getMillesime() {
		return millesime;
	}

	public void setMillesime(String millesime) {
		this.millesime = millesime;
	}

	public Integer getQuantitéCaisse() {
		return quantitéCaisse;
	}

	public void setQuantitéCaisse(Integer quantitéCaisse) {
		this.quantitéCaisse = quantitéCaisse;
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
