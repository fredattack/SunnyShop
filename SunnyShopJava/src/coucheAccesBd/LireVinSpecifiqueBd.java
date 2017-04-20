package coucheAccesBd;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;

import classesMétiers.Vin;

public class LireVinSpecifiqueBd extends OperationBd {

	private Vin leVin =  new Vin();
	private String leNum;
	
	public Vin getVin(){ return leVin;}
	
	public LireVinSpecifiqueBd(String LeNum){ 
		super("LireVinSpecifique");
		leNum=LeNum;
	}
	
	public int ExecuterRequete (Connection SqlConn) throws Exception
	{
		CallableStatement sqlCmd = SqlConn.prepareCall("{ call LireVinSpecifique(?) }");
	sqlCmd.setString(1, leNum);
	ResultSet sqlRes = sqlCmd.executeQuery();
	while (sqlRes.next() == true)
	leVin = new Vin(sqlRes.getString(1),
					sqlRes.getString(2),
					sqlRes.getFloat(3),
					sqlRes.getInt(4),
					sqlRes.getInt(5),
					sqlRes.getInt(6),
					sqlRes.getInt(7),
					sqlRes.getString(8),
					sqlRes.getInt(9),
					sqlRes.getInt(10),
					sqlRes.getString(11),
					sqlRes.getInt(12),
					sqlRes.getInt(13));
	sqlRes.close();
	return (leVin != null)? 1 : 0;
		
	}
}
