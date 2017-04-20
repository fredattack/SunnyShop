package coucheAccesBd;


import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;

import classesMétiers.Alcool;
import classesMétiers.Vin;

public class LireAlcoolSpecifiqueBd extends OperationBd {

	private Alcool lAlcool;
	private String leNum;
	
	public Alcool getAlcool(){ return lAlcool;}
	
	public LireAlcoolSpecifiqueBd(String LeNum){ 
		super("LireAlcoolSpecifique");
		leNum=LeNum;
	}
	
	public int ExecuterRequete (Connection SqlConn) throws Exception
	{
		CallableStatement sqlCmd = SqlConn.prepareCall("{ call LireAlcoolSpecifique(?) }");
	sqlCmd.setString(1, leNum);
	ResultSet sqlRes = sqlCmd.executeQuery();
	while (sqlRes.next() == true)
	lAlcool = new Alcool(sqlRes.getString(1),
					sqlRes.getString(2),
					sqlRes.getFloat(3),
					
					sqlRes.getInt(4),
					sqlRes.getInt(5),
					
					sqlRes.getInt(6),
					sqlRes.getString(7),
					
					sqlRes.getString(8),
					sqlRes.getInt(9),
					sqlRes.getInt(10),

					sqlRes.getString(11),
					sqlRes.getInt(12),
					sqlRes.getInt(13));

	sqlRes.close();
	return (lAlcool != null)? 1 : 0;
	}
}
