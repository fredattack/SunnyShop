package coucheAccesBd;

import java.sql.CallableStatement;
import java.sql.Connection;

import classesMétiers.Chemise;

public class AjouterChemiseBd extends OperationBd {

private Chemise laChemise;
	
	public AjouterChemiseBd(Chemise chemise){
		
		super("AjouterChemise");
		laChemise=chemise;
		
	}
	
	public int ExecuterRequete(Connection SqlConn) throws Exception
	{
	CallableStatement sqlCmd = SqlConn.prepareCall("{ call AjouterChemise( ?,?,?,?,?,?,?,?,?,?,?,?)}");
	sqlCmd.setString(1, laChemise.getIdProduit());
	sqlCmd.setString(2, laChemise.getNomChemise());
	sqlCmd.setFloat(3, laChemise.getPrixUnitaire());
	sqlCmd.setInt(4, laChemise.getIdMatiere());
	sqlCmd.setString(5, laChemise.getCouleurChemise());
	sqlCmd.setInt(6, laChemise.getStockChemise());
	sqlCmd.setString(7, laChemise.getimageChemise());
	sqlCmd.setInt(8, laChemise.getIdTypeProduit());
	sqlCmd.setInt(9, laChemise.getAfficherProduit());
	sqlCmd.setInt(10, laChemise.getIdTaille());
	sqlCmd.setInt(11, laChemise.getModel());
	
	
	
	sqlCmd.registerOutParameter(12, java.sql.Types.INTEGER);
	sqlCmd.executeUpdate();
	
	return sqlCmd.getInt(12);
	
	}

}
