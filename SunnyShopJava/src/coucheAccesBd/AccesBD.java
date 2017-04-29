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
	 
	/*
	 * 
	 * Region Vin
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
	 
	 public Vin LireVinSpecifique(String numVin) throws ExceptionAccesBd
	 {
		 LireVinSpecifiqueBd operation = new LireVinSpecifiqueBd(numVin);
		 ExecuterRequete(operation);
		 return operation.getVin();
	 }
	
	 public int ModifierVin(Vin vin)throws ExceptionAccesBd, ExceptionMetier{
		  ModifierVinBd operation = new ModifierVinBd(vin);
		  return ExecuterRequete(operation);
	  }
	
	
	 
	 /*
	  * 
	  * Region Alcool
	  * 
	  */
	 
	 public List<String> ListerProvenanceAlcool() throws ExceptionAccesBd{
			ListerProvenanceAlcoolBd opération = new ListerProvenanceAlcoolBd();
			ExecuterRequete(opération);
			return opération.getListe();
		}
	 
	 public List<String> ListerFamilleAlcool() throws ExceptionAccesBd{
			ListerFamilleAlcoolBd opération = new ListerFamilleAlcoolBd();
			ExecuterRequete(opération);
			return opération.getListe();
		}
	 
	 public int AjouterAlcool(Alcool alcool)throws ExceptionAccesBd, ExceptionMetier{
		  AjouterAlcoolBd operation = new AjouterAlcoolBd(alcool);
		  return ExecuterRequete(operation);
	  }
	 
	 public List<Alcool> ListerAlcool() throws ExceptionAccesBd{
			ListerAlcoolBd opération = new ListerAlcoolBd();
			ExecuterRequete(opération);
			return opération.getListe();
		}
	 
	 public Alcool LireAlcoolSpecifique(String numAlcool) throws ExceptionAccesBd
	 {
		 LireAlcoolSpecifiqueBd operation = new LireAlcoolSpecifiqueBd(numAlcool);
		 ExecuterRequete(operation);
		 return operation.getAlcool();
	 }
	 
	 public int ModifierAlcool(Alcool alcool)throws ExceptionAccesBd, ExceptionMetier{
		  ModifierAlcoolBd operation = new ModifierAlcoolBd(alcool);
		  return ExecuterRequete(operation);
	  }
	 
	 public int GetMaxNumAlcool() throws ExceptionAccesBd{
		 GetMaxNumAlcoolBd operation = new GetMaxNumAlcoolBd();
		 return ExecuterRequete(operation);
	 }
	 
	 /*
	  * 
	  * Region Chemise
	  * 
	  * 
	  */
	 
	 public List<String> ListerMatièreChemise() throws ExceptionAccesBd{
		 ListerMatièreChemiseBd opération = new ListerMatièreChemiseBd();
			ExecuterRequete(opération);
			return opération.getListe();
		}
	 
	 public List<Chemise> ListerChemise() throws ExceptionAccesBd{
			ListerChemiseBd opération = new ListerChemiseBd();
			ExecuterRequete(opération);
			return opération.getListe();
		}
	 
	 public int GetMaxNumModelChemise() throws ExceptionAccesBd{
		 GetMaxNumModelChemiseBd operation = new GetMaxNumModelChemiseBd();
		 return ExecuterRequete(operation);
	 }
	 
	 public int AjouterChemise(Chemise chemise)throws ExceptionAccesBd, ExceptionMetier{
		  AjouterChemiseBd operation = new AjouterChemiseBd(chemise);
		  return ExecuterRequete(operation);
	  }
	 
	 public int UpdateNumModel(Integer numModel)throws ExceptionAccesBd, ExceptionMetier{
		 UpdateNumModelBd operation = new UpdateNumModelBd(numModel);
		  return ExecuterRequete(operation);
	  }
	 
	 public List<Chemise> LireChemiseSpecifique(Integer numModel)throws ExceptionAccesBd, ExceptionMetier{
		 LireChemiseSpecifiqueBd operation = new LireChemiseSpecifiqueBd(numModel);
		 ExecuterRequete(operation); 
		 return operation.getListe();
	  }
	 
	 public Chemise LireUneChemise(String idProd)throws ExceptionAccesBd, ExceptionMetier{

		  LireUneChemiseBd operation = new LireUneChemiseBd(idProd);
		  ExecuterRequete(operation); 
		  return operation.getChemise();
		  }

	 public int ModifierChemise(Chemise chemise)throws ExceptionAccesBd, ExceptionMetier{
		  ModifierChemiseBd operation = new ModifierChemiseBd(chemise);
		  return ExecuterRequete(operation);
	  }
	 
	 /*
	  * 
	  * region Commande
	  * 
	  */
	 
	 public List<Order> ListerOrder() throws ExceptionAccesBd{
			ListerOrderBd opération = new ListerOrderBd();
			ExecuterRequete(opération);
			return opération.getListe();
		}
	 
	 public List<LigneCommande> ListerOrderDetails(Integer idOrder) throws ExceptionAccesBd{
			ListerOrderDetailsBd opération = new ListerOrderDetailsBd(idOrder);
			ExecuterRequete(opération);
			return opération.getListe();
		}
	 
	 public int setDelivered(Order laCommande)throws ExceptionAccesBd, ExceptionMetier{
			setDeliveredBd operation = new setDeliveredBd(laCommande);
			  return ExecuterRequete(operation);
		  }

	 /*
	  * 
	  * region Client
	  * 
	  * 
	  */

	 public List<User> ListerClients() throws ExceptionAccesBd{
		 	ListerClientsBd opération = new ListerClientsBd();
			ExecuterRequete(opération);
			return opération.getListe();
		}
	 public List<Order> ListerOrderClients(Integer idUser) throws ExceptionAccesBd{
		 	ListerOrderClientsBd opération = new ListerOrderClientsBd(idUser);
			ExecuterRequete(opération);
			return opération.getListe();
		}
	 public User LireUserSpecifique(Integer idUser)throws ExceptionAccesBd, ExceptionMetier{

		 	LireUserSpecifiqueBd operation = new LireUserSpecifiqueBd(idUser);
			ExecuterRequete(operation); 
			return operation.getUser();
	}

}

