package coucheAccesBd;

import java.sql.Connection;

public abstract class OperationBd 
{
	protected String Nom = "";
	/**
	* Obtenir le nom de la proc�dure stock�e
	* @return le nom de la proc�dure stock�e
	*/
	public String getNom() { return Nom; }
	/**
	* Constructeur
	* @param nom : le nom de le proc�dure stock�e
	*/
	protected OperationBd(String nom)
	{
	Nom = nom;
	}
	/**
	* Ex�cuter une requ�te SQL ou appeler une proc�dure stock�e
	* @param SqlConn : la connexion � la base de donn�es
	* @return le nombre de lignes affect�es dans la base de donn�es
	*/
	public abstract int ExecuterRequete(Connection SqlConn) throws Exception;
}
