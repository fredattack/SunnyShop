package coucheAccesBd;

import java.sql.CallableStatement;
import java.sql.Connection;

import classesMétiers.Vin;

public class ModifierVinBd extends OperationBd{
	
	private Vin leVin;

	public ModifierVinBd(Vin vin){
		super("ModifierVin");
		leVin=vin;
}
	@Override
	public int ExecuterRequete(Connection SqlConn) throws Exception {
		CallableStatement sqlCmd = SqlConn.prepareCall("{ call ModifierVin( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) }");
		sqlCmd.setString(1, leVin.getIdVin());
		sqlCmd.setString(2, leVin.getNomVin());
		sqlCmd.setFloat(3, leVin.getPrixUnitaire());
		sqlCmd.setInt(4, leVin.getIdTypeVin());
		sqlCmd.setInt(5, leVin.getIdSaveur());
		sqlCmd.setInt(6, leVin.getIdProvenance());
		sqlCmd.setInt(7, leVin.getIdMaturation());
		sqlCmd.setString(8, leVin.getMillesime());
		sqlCmd.setInt(9, leVin.getQuantitéCaisse());
		sqlCmd.setInt(10, leVin.getStockVin());
		sqlCmd.setString(11, leVin.getImageVin());
		sqlCmd.setInt(12, leVin.getIdTypeProduit());
		sqlCmd.setInt(13, leVin.getAfficherVin());
		
		
		sqlCmd.registerOutParameter(14, java.sql.Types.INTEGER);
		sqlCmd.executeUpdate();
		
		return sqlCmd.getInt(14);
		
	}
}