package coucheM�tier;

//import java.text.DecimalFormat;
//import java.util.*;
//import classesM�tiers.*;
import coucheAccesBd.*; 

public class Metier 
{
	@SuppressWarnings("unused")
	private AccesBD CoucheAccesBD;
	/**
	* Constructeur: cr�er l'objet de type AccesBD
	*/
	public Metier() throws ExceptionAccesBd
	{
	CoucheAccesBD = new AccesBD();
	}
}
