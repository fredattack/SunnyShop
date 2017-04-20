package coucheAccesBd;

import java.sql.CallableStatement;
import java.sql.Connection;

import classesM�tiers.Alcool;

public class AjouterAlcoolBd extends OperationBd{

private Alcool lAlcool;
	
	public AjouterAlcoolBd(Alcool alcool){
		
		super("AjouterAlcool");
		lAlcool=alcool;
		
	}
	
	public int ExecuterRequete(Connection SqlConn) throws Exception
	{
	CallableStatement sqlCmd = SqlConn.prepareCall("{ call AjouterAlcool( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) }");
	sqlCmd.setString(1, lAlcool.getIdAlcool());
	sqlCmd.setString(2, lAlcool.getNomAlcool());
	sqlCmd.setFloat(3, lAlcool.getPrixUnitaire());
	sqlCmd.setInt(4, lAlcool.getIdFamille());
	sqlCmd.setInt(5, lAlcool.getIdProvenanceAlcool());
	sqlCmd.setInt(6, lAlcool.getDegr�Alcool());
	sqlCmd.setString(7, lAlcool.getGoutAlcool());
	sqlCmd.setString(8, lAlcool.getDatePeremption());
	sqlCmd.setInt(9, lAlcool.getStockAlcool());
	sqlCmd.setInt(10, lAlcool.getQuantit�Caisse());
	sqlCmd.setString(11, lAlcool.getImageAlcool());
	sqlCmd.setInt(12, lAlcool.getIdTypeProduit());
	sqlCmd.setInt(13, lAlcool.getAfficherAlcool());
	
	
	sqlCmd.registerOutParameter(14, java.sql.Types.INTEGER);
	sqlCmd.executeUpdate();
	
	return sqlCmd.getInt(14);
	
	}

}
