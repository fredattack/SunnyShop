package coucheAccesBd;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import classesMétiers.Vin;

public class ListerVinBd  extends OperationBd{
	
	private ArrayList<Vin> laListe;
	
	public List<Vin> getListe() { return laListe; }
	
	public ListerVinBd()
	{
	super("ListerVin");
	}
	
	
	public int ExecuterRequete(Connection SqlConn) throws Exception
	{
	laListe = new ArrayList<Vin>();
	
	CallableStatement sqlCmd = SqlConn.prepareCall("{ call ListerVins() }");
	ResultSet sqlRes = sqlCmd.executeQuery();
	while (sqlRes.next() == true)
	laListe.add(new Vin(sqlRes.getInt(1),
						sqlRes.getString(2),
						sqlRes.getFloat(3),
						sqlRes.getInt(4),
						sqlRes.getInt(5),
						sqlRes.getInt(6),
						sqlRes.getInt(7),
						sqlRes.getString(8), 
						sqlRes.getInt(9),
						sqlRes.getInt(10), 
						sqlRes.getString(11), 
						sqlRes.getInt(12),
						sqlRes.getInt(13)));
	sqlRes.close();
	return laListe.size();
	}
}
