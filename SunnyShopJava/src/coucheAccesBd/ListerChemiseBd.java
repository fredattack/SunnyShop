package coucheAccesBd;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import classesMétiers.Chemise;;

public class ListerChemiseBd extends OperationBd{

	private ArrayList<Chemise> laListe;
	
	public List<Chemise> getListe() { return laListe; }
	
	public ListerChemiseBd()
	{
	super("ListerChemise");
	}
	
	
	public int ExecuterRequete(Connection SqlConn) throws Exception
	{
	laListe = new ArrayList<Chemise>();
	
	CallableStatement sqlCmd = SqlConn.prepareCall("{ call ListerChemise() }");
	ResultSet sqlRes = sqlCmd.executeQuery();
	while (sqlRes.next() == true)
	laListe.add(new Chemise(sqlRes.getString(1),
						sqlRes.getString(2),
						sqlRes.getFloat(3),
						sqlRes.getString(4),
						sqlRes.getString(5),
						sqlRes.getInt(6),
						sqlRes.getString(7)));
	sqlRes.close();
	return laListe.size();
	}


}
