package coucheAccesBd;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;

public class GetMaxNumModelChemiseBd extends OperationBd {

	private Integer leNum;

	/**
	 * @param nom
	 * @param leMaxNumVin
	 */
	public GetMaxNumModelChemiseBd() {
		super("GetMaxNumModelChemise");
		
	}
	
	public int ExecuterRequete(Connection SqlConn) throws Exception
	{
	
	
	CallableStatement sqlCmd = SqlConn.prepareCall("{ call [maxNumModelChemise]() }");
	ResultSet sqlRes = sqlCmd.executeQuery();
	while (sqlRes.next() == true)
	leNum = sqlRes.getInt(1);
	
	sqlRes.close();
	return leNum;
	}
}
