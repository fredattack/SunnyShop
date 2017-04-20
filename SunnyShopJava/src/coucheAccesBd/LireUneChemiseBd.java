package coucheAccesBd;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import classesMétiers.Chemise;

public class LireUneChemiseBd extends OperationBd{
	private Chemise laChemise;
	private String leNum;
	
	public Chemise getChemise() { return laChemise; }
	
	public LireUneChemiseBd(String LeNum){ 
		super("LireUneChemise");
		leNum=LeNum;
	}
	
	public int ExecuterRequete (Connection SqlConn) throws Exception
	{
	CallableStatement sqlCmd = SqlConn.prepareCall("{ call ListerUneChemiseSpecifique(?) }");
	sqlCmd.setString(1, leNum);
	ResultSet sqlRes = sqlCmd.executeQuery();
	while (sqlRes.next() == true)
	laChemise=new Chemise(sqlRes.getString(1),
				sqlRes.getString(2),
				sqlRes.getFloat(3),
				sqlRes.getInt(4),
				sqlRes.getString(5),
				sqlRes.getInt(6),
				sqlRes.getString(7),
				sqlRes.getInt(8),
				sqlRes.getInt(9),
				sqlRes.getInt(10),
				sqlRes.getInt(11));

	sqlRes.close();
	return (laChemise != null)? 1 : 0;
	}
}
