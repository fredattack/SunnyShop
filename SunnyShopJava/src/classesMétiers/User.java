package classesMétiers;

public class User {

	private int idUser;
	private String nameUser;
	private String login;
	private String surnameUser;
	private String adresUser;
	private String password;
	private String birthDate;
	private String role;
	
// constructors
	
	/**
	 * 
	 */
	public User() {	}
	

	/**
	 * @param User
	 */
	public User(User user) {
		idUser =user.idUser;
		nameUser = user.nameUser;
		login = user.login;
		surnameUser = user.surnameUser;
		adresUser = user.adresUser;
		password = user.password;
		birthDate = user.birthDate;
		role = user.role;		
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
	 */
	public User(int idUser, String nameUser, String login, String surnameUser, String adresUser, String password,
			String birthDate, String role) {		
		this.idUser = idUser;
		this.nameUser = nameUser;
		this.login = login;
		this.surnameUser = surnameUser;
		this.adresUser = adresUser;
		this.password = password;
		this.birthDate = birthDate;
		this.role = role;
	}

//Methods get set
	
	public int getIdUser() {
		return idUser;
	}


	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}


	public String getNameUser() {
		return nameUser;
	}


	public void setNameUser(String nameUser) {
		this.nameUser = nameUser;
	}


	public String getLogin() {
		return login;
	}


	public void setLogin(String login) {
		this.login = login;
	}


	public String getSurnameUser() {
		return surnameUser;
	}


	public void setSurnameUser(String surnameUser) {
		this.surnameUser = surnameUser;
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

	
	
	
	
	
	
}
