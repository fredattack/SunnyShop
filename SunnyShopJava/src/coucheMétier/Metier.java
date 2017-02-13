package coucheMétier;

//import java.text.DecimalFormat;
//import java.util.*;
//import classesMétiers.*;
import coucheAccesBd.*; 

public class Metier 
{
	@SuppressWarnings("unused")
	private AccesBD CoucheAccesBD;
	/**
	* Constructeur: créer l'objet de type AccesBD
	*/
	public Metier() throws ExceptionAccesBd
	{
	CoucheAccesBD = new AccesBD();
	}
}
