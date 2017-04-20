package coucheAccesBd;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import classesMétiers.Order;

public class ListerOrderClientsBd extends OperationBd{
	private List<Order> laListe;
	private Integer leNum;
	
	public List<Order> getListe() { return laListe; }
	
	public ListerOrderClientsBd(Integer idUser)
	{
	super("ListerOrderClients");
	leNum=idUser;
	}
	
	
	public int ExecuterRequete(Connection SqlConn) throws Exception
	{
	laListe = new ArrayList<Order>();
	
	CallableStatement sqlCmd = SqlConn.prepareCall("{ call ListerOrderClients(?) }");
	sqlCmd.setInt(1, leNum);
	ResultSet sqlRes = sqlCmd.executeQuery();
	while (sqlRes.next() == true)
	laListe.add(new Order(sqlRes.getInt(1),
						sqlRes.getString(2),
						sqlRes.getString(3),
						sqlRes.getFloat(4),
						sqlRes.getString(5)
						));
	sqlRes.close();
	return laListe.size();
	}
}
