package coucheAccesBd;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;

public class GetMaxNumAlcoolBd extends OperationBd{

	private Integer leNum;

	/**
	 * @param nom
	 * @param leMaxNumVin
	 */
	public GetMaxNumAlcoolBd() {
		super("GetMaxNumAlcool");
		
	}
	
	public int ExecuterRequete(Connection SqlConn) throws Exception
	{
	
	
	CallableStatement sqlCmd = SqlConn.prepareCall("{ call MaxNumAlcool() }");
	ResultSet sqlRes = sqlCmd.executeQuery();
	while (sqlRes.next() == true)
	leNum = sqlRes.getInt(1);
	
	sqlRes.close();
	return leNum;
	}
}
