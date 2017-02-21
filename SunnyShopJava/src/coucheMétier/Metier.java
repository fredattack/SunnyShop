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
}
