package classesMétiers;

public class User {

	private Integer idUser;
	private String firstName;
	private String login;
	private String lastName;
	private String adresUser;
	private String password;
	private String birthDate;
	private String role;
	private Float totalAchat;
	
	
// constructors
	
	/**
	 * 
	 */
	public User() {	}
	

	/**
	 * @param idUser
	 * @param nameUser
	 * @param surnameUser
	 * @param adresUser
	 * @param birthDate
	 * @param totalAchat
	 */
	public User(Integer idUser, String nameUser, String surnameUser, String adresUser, String birthDate,Float totalAchat) {
		super();
		this.idUser = idUser;
		this.firstName = nameUser;
		this.lastName = surnameUser;
		this.adresUser = adresUser;
		this.birthDate = birthDate;
		this.totalAchat = totalAchat;
	
	}


	/**
	 * @param User
	 */
	public User(User user) {
		idUser =user.idUser;
		firstName = user.firstName;
		login = user.login;
		lastName = user.lastName;
		adresUser = user.adresUser;
		password = user.password;
		birthDate = user.birthDate;
		role = user.role;	
		totalAchat = user.totalAchat;
	}
	
	/**
	 * @param idUser
	 * @param nameUser
	 * @param login
	 * @param surnameUser
	 * @param adresUser
	 * @param password
	 * @param birthDate
	 * @param role
	 * @param totalAchat 
	 */
	public User(Integer idUser, String nameUser, String login, 
			String surnameUser, String adresUser, String password,
			String birthDate, String role, Float totalAchat) {		
		this.idUser = idUser;
		this.firstName = nameUser;
		this.login = login;
		this.lastName = surnameUser;
		this.adresUser = adresUser;
		this.password = password;
		this.birthDate = birthDate;
		this.role = role;
		this.totalAchat = totalAchat;
	}

//Methods get set

	


	public Integer getIdUser() {
		return idUser;
	}


	public void setIdUser(Integer idUser) {
		this.idUser = idUser;
	}


	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String nameUser) {
		this.firstName = nameUser;
	}


	public String getLogin() {
		return login;
	}


	public void setLogin(String login) {
		this.login = login;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String surnameUser) {
		this.lastName = surnameUser;
	}


	public String getAdresUser() {
		return adresUser;
	}


	public void setAdresUser(String adresUser) {
		this.adresUser = adresUser;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getBirthDate() {
		return birthDate;
	}


	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}


	public String getRole() {
		return role;
	}


	public void setRole(String role) {
		this.role = role;
	}

	
	public Float getTotalAchat() {
		return totalAchat;
	}


	public void setTotalAchat(Float totalAchat) {
		this.totalAchat = totalAchat;
	}
	
	
	
	
}
