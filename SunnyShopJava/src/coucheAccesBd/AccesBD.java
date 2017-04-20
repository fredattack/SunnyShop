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
	 
	/*
	 * 
	 * Region Vin
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
			ListerProvenanceAlcoolBd op�ration = new ListerProvenanceAlcoolBd();
			ExecuterRequete(op�ration);
			return op�ration.getListe();
		}
	 
	 public List<String> ListerFamilleAlcool() throws ExceptionAccesBd{
			ListerFamilleAlcoolBd op�ration = new ListerFamilleAlcoolBd();
			ExecuterRequete(op�ration);
			return op�ration.getListe();
		}
	 
	 public int AjouterAlcool(Alcool alcool)throws ExceptionAccesBd, ExceptionMetier{
		  AjouterAlcoolBd operation = new AjouterAlcoolBd(alcool);
		  return ExecuterRequete(operation);
	  }
	 
	 public List<Alcool> ListerAlcool() throws ExceptionAccesBd{
			ListerAlcoolBd op�ration = new ListerAlcoolBd();
			ExecuterRequete(op�ration);
			return op�ration.getListe();
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
	 
	 public List<String> ListerMati�reChemise() throws ExceptionAccesBd{
		 ListerMati�reChemiseBd op�ration = new ListerMati�reChemiseBd();
			ExecuterRequete(op�ration);
			return op�ration.getListe();
		}
	 
	 public List<Chemise> ListerChemise() throws ExceptionAccesBd{
			ListerChemiseBd op�ration = new ListerChemiseBd();
			ExecuterRequete(op�ration);
			return op�ration.getListe();
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
			ListerOrderBd op�ration = new ListerOrderBd();
			ExecuterRequete(op�ration);
			return op�ration.getListe();
		}
	 
	 public List<LigneCommande> ListerOrderDetails(Integer idOrder) throws ExceptionAccesBd{
			ListerOrderDetailsBd op�ration = new ListerOrderDetailsBd(idOrder);
			ExecuterRequete(op�ration);
			return op�ration.getListe();
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
		 	ListerClientsBd op�ration = new ListerClientsBd();
			ExecuterRequete(op�ration);
			return op�ration.getListe();
		}
	 public List<Order> ListerOrderClients(Integer idUser) throws ExceptionAccesBd{
		 	ListerOrderClientsBd op�ration = new ListerOrderClientsBd(idUser);
			ExecuterRequete(op�ration);
			return op�ration.getListe();
		}
	 public User ListerUserSpecifique(Integer idUser)throws ExceptionAccesBd, ExceptionMetier{

		 	ListerUserSpecifiqueBd operation = new ListerUserSpecifiqueBd(idUser);
			ExecuterRequete(operation); 
			return operation.getUser();
	}

}

