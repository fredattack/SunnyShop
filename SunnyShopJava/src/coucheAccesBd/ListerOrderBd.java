package coucheAccesBd;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import classesMétiers.Order;

public class ListerOrderBd extends OperationBd {
private List<Order> laListe;
	
	public List<Order> getListe() { return laListe; }
	
	public ListerOrderBd()
	{
	super("ListerOrder");
	}
	
	
	public int ExecuterRequete(Connection SqlConn) throws Exception
	{
	laListe = new ArrayList<Order>();
	
	CallableStatement sqlCmd = SqlConn.prepareCall("{ call ListerOrder() }");
	ResultSet sqlRes = sqlCmd.executeQuery();
	while (sqlRes.next() == true)
	laListe.add(new Order(sqlRes.getInt(1),
						sqlRes.getString(2),
						sqlRes.getFloat(3),
						sqlRes.getString(4),
						sqlRes.getInt(5),
						sqlRes.getString(6)));
	sqlRes.close();
	return laListe.size();
	}


}
