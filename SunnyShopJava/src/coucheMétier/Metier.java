package coucheMétier;



import java.text.DecimalFormat;
import java.util.*;
import classesMétiers.*;
import coucheAccesBd.*; 

public class Metier 
{
	///@SuppressWarnings("unused")
	private AccesBD CoucheAccesBd;
	/**
	* Constructeur: créer l'objet de type AccesBD
	*/
	public Metier() throws ExceptionAccesBd
	{
	CoucheAccesBd = new AccesBD();
	}
	
	
	/*
	 * 
	 * Région Vin ---------->
	 * 
	 */
	
	public List<Vin> ListerVin() throws ExceptionAccesBd{
		return CoucheAccesBd.listerVin();
	}
	
	public List<String> ListerProvenanceVin() throws ExceptionAccesBd{
		return CoucheAccesBd.listerProvenanceVin();
	}
	
	
	 public List<String> ListerTypeVin() throws ExceptionAccesBd{
		return CoucheAccesBd.ListerTypeVin();
	}
	
	 public List<String> ListerSaveurVin() throws ExceptionAccesBd{
		return CoucheAccesBd.ListerSaveurVin();
	}
	
	 public List<String> ListerMaturationVin() throws ExceptionAccesBd{
		return CoucheAccesBd.ListerMaturationVin();
	}
	 
	 public int AjouterVin (Vin vin) throws ExceptionAccesBd, ExceptionMetier{
		 return CoucheAccesBd.AjouterVin(vin);
	 }
	 
	 public int GetMaxNumVin() throws ExceptionAccesBd{
		return CoucheAccesBd.GetMaxNumVin();
	}
	
	 public Vin LireVinSpecifique(String numVin) throws ExceptionAccesBd{
		return CoucheAccesBd.LireVinSpecifique(numVin);
	}
	
	 public int ModifierVin (Vin vin) throws ExceptionAccesBd, ExceptionMetier{
		 return CoucheAccesBd.ModifierVin(vin);
	 }
	
	 /*
	  * 
	  *Zone Alcool 
	  * 
	  */
	
	 public List<String> ListerProvenanceAlcool() throws ExceptionAccesBd{
			return CoucheAccesBd.ListerProvenanceAlcool();
		}
	 
	
	 
	 public List<String> ListerFamilleAlcool() throws ExceptionAccesBd{
			return CoucheAccesBd.ListerFamilleAlcool();
		}
	 
	 public int AjouterAlcool (Alcool alcool) throws ExceptionAccesBd, ExceptionMetier{
		return CoucheAccesBd.AjouterAlcool(alcool);
	 }	

	 public List<Alcool> ListerAlcool() throws ExceptionAccesBd{
		return CoucheAccesBd.ListerAlcool();
		 
	 }
	 
	 public Alcool LireAlcoolSpecifique(String numAlcool) throws ExceptionAccesBd{
			return CoucheAccesBd.LireAlcoolSpecifique(numAlcool);
		}
	 
	 public int ModifierAlcool (Alcool alcool) throws ExceptionAccesBd, ExceptionMetier{
		 return CoucheAccesBd.ModifierAlcool(alcool);
	 }
	 
	 public int GetMaxNumAlcool() throws ExceptionAccesBd{
			return CoucheAccesBd.GetMaxNumAlcool();
		}
	 
	 /*
	  * 
	  * Zone Chemise
	  * 
	  */
	 
	 public List<String> ListerMatièreChemise() throws ExceptionAccesBd{
			return CoucheAccesBd.ListerMatièreChemise();
		}
	 
	 public List<Chemise> ListerChemise() throws ExceptionAccesBd{
			return CoucheAccesBd.ListerChemise();
			 
		 }
	 
	 public int GetMaxNumModelChemise() throws ExceptionAccesBd{
			return CoucheAccesBd.GetMaxNumModelChemise();
		}
	 
	 public int AjouterChemise (Chemise chemise) throws ExceptionAccesBd, ExceptionMetier{
			return CoucheAccesBd.AjouterChemise(chemise);
		 }
	 
	 public int UpdateNumModel (Integer NumModel) throws ExceptionAccesBd, ExceptionMetier{
			return CoucheAccesBd.UpdateNumModel(NumModel);
		 }
	 
	 public List<Chemise> LireChemiseSpecifique (Integer numModel) throws ExceptionAccesBd, ExceptionMetier{
			return CoucheAccesBd.LireChemiseSpecifique(numModel);
		 }
	 
	 public Chemise LireUneChemise(String idProd) throws ExceptionAccesBd, ExceptionMetier{
			return CoucheAccesBd.LireUneChemise(idProd);
		}
	 

	 public int ModifierChemise (Chemise chemise) throws ExceptionAccesBd, ExceptionMetier{
			return CoucheAccesBd.ModifierChemise(chemise);
		 }

	 /*
	  * Zone Commande
	  * 
	  */
	 
	 public List<Order> ListerOrder() throws ExceptionAccesBd{
			return CoucheAccesBd.ListerOrder();
			 
		 }
	 
	 public List<LigneCommande> ListerOrderDetails(Integer idOrder) throws ExceptionAccesBd{
			return CoucheAccesBd.ListerOrderDetails(idOrder);
		 }
	 public int SetDelivered (Order laCommande) throws ExceptionAccesBd, ExceptionMetier{
		 return CoucheAccesBd.setDelivered(laCommande);
	 }
	 
	 /*
	  * 
	  * Zone Client
	  * 
	  */
	 
	 public List<User> ListerClients() throws ExceptionAccesBd{
		 return CoucheAccesBd.ListerClients();
	 }
	 
	 public List<Order> ListerOrderClients(int idUser) throws ExceptionAccesBd{
		 return CoucheAccesBd.ListerOrderClients(idUser);
	 }
	 
	 public User LireUserSpecifique(Integer idUser) throws ExceptionAccesBd, ExceptionMetier{
			return CoucheAccesBd.LireUserSpecifique(idUser);
		}


	 
}
