package coucheAccesBd;

import java.sql.CallableStatement;
import java.sql.Connection;


public class UpdateNumModelBd extends OperationBd {
	
private Integer numModel;
	
	public UpdateNumModelBd(Integer lenumModel){
		
		super("UpdateNumModel");
		numModel=lenumModel;
		
	}
	
	public int ExecuterRequete(Connection SqlConn) throws Exception
	{
	CallableStatement sqlCmd = SqlConn.prepareCall("{ call UpdateModelNum( ?,?)}");
	
	sqlCmd.setInt(1, numModel);	
	sqlCmd.registerOutParameter(2, java.sql.Types.INTEGER);
	sqlCmd.executeUpdate();
	
	return sqlCmd.getInt(2);
	
	}

}
