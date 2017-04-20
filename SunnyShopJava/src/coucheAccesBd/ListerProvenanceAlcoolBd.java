package coucheAccesBd;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ListerProvenanceAlcoolBd extends OperationBd{
	
private ArrayList<String> laListe;
	
	public List<String> getListe() { return laListe; }
	
	public ListerProvenanceAlcoolBd()
	{
	super("ListerProvenanceAlcool");
	}
	
	
	public int ExecuterRequete(Connection SqlConn) throws Exception
	{
	laListe = new ArrayList<String>();
	
	CallableStatement sqlCmd = SqlConn.prepareCall("{ call ListerProvenanceAlcool() }");
	ResultSet sqlRes = sqlCmd.executeQuery();
	while (sqlRes.next() == true)
	laListe.add(new String(	sqlRes.getString(1)));
	
	sqlRes.close();
	return laListe.size();
	}

}
