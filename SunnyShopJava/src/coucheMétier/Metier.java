package coucheM�tier;



import java.text.DecimalFormat;
import java.util.*;
import classesM�tiers.*;
import coucheAccesBd.*; 

public class Metier 
{
	///@SuppressWarnings("unused")
	private AccesBD CoucheAccesBd;
	/**
	* Constructeur: cr�er l'objet de type AccesBD
	*/
	public Metier() throws ExceptionAccesBd
	{
	CoucheAccesBd = new AccesBD();
	}
	
	
	/*
	 * 
	 * R�gion Vin ---------->
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
	
	
}
