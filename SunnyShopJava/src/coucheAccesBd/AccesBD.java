package coucheAccesBd;
import java.sql.*;
import java.util.*;
import classesMétiers.*;
import coucheMétier.ExceptionMetier;


public class AccesBD 
{
	private Connection SqlConn = null;
	private final int MaxTentatives = 3;
	/**
	* Constructeur : ouvrir une première connexion avec la base de données
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
	throw new ExceptionAccesBd("Connexion à la BD", e.getMessage());
	}
	}
	}
	}
	/**
	* Ouvrir une connexion avec la base de données
	*/
	private void OuvrirConnexion() throws Exception
	{
	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	SqlConn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;" +
	"database=SunnyShopDb;user=sunnyDb;password=sunny;");
	}
	/**
	* Exécuter une requête avec tentatives de reprise si un problème est rencontré
	* @param operation : l'objet OperationBD exécutant la requête
	* @return le nombre de lignes affectées dans la base de données
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
		ListerVinBd opération = new ListerVinBd();
		ExecuterRequete(opération);
		return opération.getListe();
	}

	public List<String> listerProvenanceVin() throws ExceptionAccesBd{
		ListerProvenanceVinBd opération = new ListerProvenanceVinBd();
		ExecuterRequete(opération);
		return opération.getListe();
	}
	
	  public List<String> ListerTypeVin() throws ExceptionAccesBd{
		ListerTypeVinBd opération = new ListerTypeVinBd();
		ExecuterRequete(opération);
		return opération.getListe();
	}
	 
	
	
	  public List<String> ListerSaveurVin() throws ExceptionAccesBd{
		ListerSaveurVinBd opération = new ListerSaveurVinBd();
		ExecuterRequete(opération);
		return opération.getListe();
	}
	
	
	
	  public List<String> ListerMaturationVin() throws ExceptionAccesBd{
		ListerMaturationVinBd opération = new ListerMaturationVinBd();
		ExecuterRequete(opération);
		return opération.getListe();
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
