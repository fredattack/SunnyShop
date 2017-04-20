package coucheAccesBd;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;

import classesMétiers.Alcool;
import classesMétiers.User;

public class ListerUserSpecifiqueBd extends OperationBd {

	private User lUser;
	private Integer leNum;
	
	public User getUser(){ return lUser;}
	
	public ListerUserSpecifiqueBd(Integer LeNum){ 
		super("ListerUserSpecifique");
		leNum=LeNum;
	}
	
	public int ExecuterRequete (Connection SqlConn) throws Exception
	{
		CallableStatement sqlCmd = SqlConn.prepareCall("{ call ListerUserSpecifique(?) }");
	sqlCmd.setInt(1, leNum);
	ResultSet sqlRes = sqlCmd.executeQuery();
	while (sqlRes.next() == true)
	lUser = new User(sqlRes.getInt(1),
					sqlRes.getString(2),
					sqlRes.getString(3),
					sqlRes.getString(4),
					sqlRes.getString(5),
					sqlRes.getFloat(6));
	sqlRes.close();
	return (lUser != null)? 1 : 0;
	}

}
