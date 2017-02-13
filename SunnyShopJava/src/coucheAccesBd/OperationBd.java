package coucheAccesBd;

import java.sql.Connection;

public abstract class OperationBd 
{
	protected String Nom = "";
	/**
	* Obtenir le nom de la procédure stockée
	* @return le nom de la procédure stockée
	*/
	public String getNom() { return Nom; }
	/**
	* Constructeur
	* @param nom : le nom de le procédure stockée
	*/
	protected OperationBd(String nom)
	{
	Nom = nom;
	}
	/**
	* Exécuter une requête SQL ou appeler une procédure stockée
	* @param SqlConn : la connexion à la base de données
	* @return le nombre de lignes affectées dans la base de données
	*/
	public abstract int ExecuterRequete(Connection SqlConn) throws Exception;
}
