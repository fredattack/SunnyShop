package coucheAccesBd;

import java.sql.CallableStatement;
import java.sql.Connection;

import classesMétiers.Order;

public class setDeliveredBd extends OperationBd{

	private Order laCommande;
	
	public setDeliveredBd(Order commande){
		super("setDelivered");
		laCommande=commande;
	}
	public int ExecuterRequete(Connection SqlConn) throws Exception {
		
		CallableStatement sqlCmd = SqlConn.prepareCall("{ call setDeliveredOrder( ?, ?,?) }");
		sqlCmd.setInt(1, laCommande.getIdOrder());
		sqlCmd.setString(2, laCommande.getDeliveredOrder());
		sqlCmd.registerOutParameter(3, java.sql.Types.INTEGER);
		sqlCmd.executeUpdate();
		
		return sqlCmd.getInt(3);
		
	}
	
}
