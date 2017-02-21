package coucheAccesBd;
import java.sql.*;
import java.util.*;
import classesM�tiers.*;
import coucheM�tier.ExceptionMetier;


public class AccesBD 
{
	private Connection SqlConn = null;
	private final int MaxTentatives = 3;
	/**
	* Constructeur : ouvrir une premi�re connexion avec la base de donn�es
	*/
	public AccesBD() throws ExceptionAccesBd
	{
	if(SqlConn == null)
	{
	int nbTentatives = 0;
	while (true)
	{
	try
	{
	OuvrirConnexion();
	return;
	}
	catch (Exception e)
	{
	nbTentatives++;
	if (nbTentatives == MaxTentatives)
	throw new ExceptionAccesBd("Connexion � la BD", e.getMessage());
	}
	}
	}
	}
	/**
	* Ouvrir une connexion avec la base de donn�es
	*/
	private void OuvrirConnexion() throws Exception
	{
	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	SqlConn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;" +
	"database=SunnyShopDb;user=sunnyDb;password=sunny;");
	}
	/**
	* Ex�cuter une requ�te avec tentatives de reprise si un probl�me est rencontr�
	* @param operation : l'objet OperationBD ex�cutant la requ�te
	* @return le nombre de lignes affect�es dans la base de donn�es
	*/
	
	
	
	private int ExecuterRequete(OperationBd op) throws ExceptionAccesBd
	{
	int nbTentatives = 0;
		while (true)
		{
			try
			{
				if(nbTentatives > 0) OuvrirConnexion();
				return op.ExecuterRequete(SqlConn);
			}
			catch(Exception e)
			{
				nbTentatives++;
				if (nbTentatives == MaxTentatives)
				throw new ExceptionAccesBd(op.getNom(), e.getMessage());
			}
		}
	}
	 /**
	  * 
	  * Region Vin  ------->
	  * 
	  */
	
	public List<Vin> listerVin() throws ExceptionAccesBd{
		ListerVinBd op�ration = new ListerVinBd();
		ExecuterRequete(op�ration);
		return op�ration.getListe();
	}

	public List<String> listerProvenanceVin() throws ExceptionAccesBd{
		ListerProvenanceVinBd op�ration = new ListerProvenanceVinBd();
		ExecuterRequete(op�ration);
		return op�ration.getListe();
	}
	
	  public List<String> ListerTypeVin() throws ExceptionAccesBd{
		ListerTypeVinBd op�ration = new ListerTypeVinBd();
		ExecuterRequete(op�ration);
		return op�ration.getListe();
	}
	 
	
	
	  public List<String> ListerSaveurVin() throws ExceptionAccesBd{
		ListerSaveurVinBd op�ration = new ListerSaveurVinBd();
		ExecuterRequete(op�ration);
		return op�ration.getListe();
	}
	
	
	
	  public List<String> ListerMaturationVin() throws ExceptionAccesBd{
		ListerMaturationVinBd op�ration = new ListerMaturationVinBd();
		ExecuterRequete(op�ration);
		return op�ration.getListe();
	}
	  
	  public int AjouterVin(Vin vin)throws ExceptionAccesBd, ExceptionMetier{
		  AjouterVinBd operation = new AjouterVinBd(vin);
		  return ExecuterRequete(operation);
	  }
	
	 public int GetMaxNumVin() throws ExceptionAccesBd{
		 GetMaxNumVinBd operation = new GetMaxNumVinBd();
		 return ExecuterRequete(operation);
	 }
	
	
	/**
	 * 
	 * ------> region vin End
	 * 
	 * 
	 */
}
