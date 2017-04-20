package coucheAccesBd;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import classesMétiers.User;

public class ListerClientsBd extends OperationBd {
private List<User> laListe;
	
	public List<User> getListe() { return laListe; }
	
	public ListerClientsBd()
	{
	super("ListerClients");
	}
	
	
	public int ExecuterRequete(Connection SqlConn) throws Exception
	{
	laListe = new ArrayList<User>();
	
	CallableStatement sqlCmd = SqlConn.prepareCall("{ call ListerClients() }");
	
	ResultSet sqlRes = sqlCmd.executeQuery();
	while (sqlRes.next() == true)
	laListe.add(new User(sqlRes.getInt(1),
						sqlRes.getString(2),
						sqlRes.getString(3),
						sqlRes.getString(4),
						sqlRes.getString(5),
						sqlRes.getFloat(6)));
	sqlRes.close();
	return laListe.size();
	}


}
