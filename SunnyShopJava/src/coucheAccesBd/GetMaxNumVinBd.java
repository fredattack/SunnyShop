package coucheAccesBd;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;


public class GetMaxNumVinBd extends OperationBd{
	
	private Integer leNum;

	/**
	 * @param nom
	 * @param leNum
	 */
	public GetMaxNumVinBd() {
		super("GetMaxNumVin");
		
	}
	
	public int ExecuterRequete(Connection SqlConn) throws Exception
	{
	
	
	CallableStatement sqlCmd = SqlConn.prepareCall("{ call MaxNumVin() }");
	ResultSet sqlRes = sqlCmd.executeQuery();
	while (sqlRes.next() == true)
	leNum = sqlRes.getInt(1);
	
	sqlRes.close();
	return leNum;
	}
	
	
}
