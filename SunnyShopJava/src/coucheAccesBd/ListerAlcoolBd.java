package coucheAccesBd;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import classesMétiers.Alcool;
public class ListerAlcoolBd extends OperationBd{

	private ArrayList<Alcool> laListe;
	
	public List<Alcool> getListe() { return laListe; }
	
	public ListerAlcoolBd()
	{
	super("ListerAlcool");
	}
	
	
	public int ExecuterRequete(Connection SqlConn) throws Exception
	{
	laListe = new ArrayList<Alcool>();
	
	CallableStatement sqlCmd = SqlConn.prepareCall("{ call ListerAlcool() }");
	ResultSet sqlRes = sqlCmd.executeQuery();
	while (sqlRes.next() == true)
	laListe.add(new Alcool(sqlRes.getString(1),
						sqlRes.getString(2),
						sqlRes.getFloat(3),
						sqlRes.getString(4),
						sqlRes.getString(5),
						sqlRes.getInt(6)));
	sqlRes.close();
	return laListe.size();
	}
}
