package coucheAccesBd;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


import classesMétiers.Chemise;

public class LireChemiseSpecifiqueBd extends OperationBd{

	private ArrayList<Chemise> laListe;
	private Integer leNum;
	
	public List<Chemise> getListe() { return laListe; }
	
	public LireChemiseSpecifiqueBd(Integer numModel){ 
		super("LireChemiseSpecifique");
		leNum=numModel;
	}
	
	public int ExecuterRequete (Connection SqlConn) throws Exception
	{
	
		laListe =new ArrayList<Chemise>();
	
		CallableStatement sqlCmd = SqlConn.prepareCall("{ call ListerChemiseSpecifique(?) }");
		
		sqlCmd.setInt(1, leNum);
		
		ResultSet sqlRes = sqlCmd.executeQuery();
		
		while (sqlRes.next() == true)
			laListe.add(new Chemise(sqlRes.getString(1),
					sqlRes.getString(2),
					sqlRes.getFloat(3),
					sqlRes.getInt(4),
					sqlRes.getString(5),
					sqlRes.getInt(6),
					sqlRes.getString(7),
					sqlRes.getInt(8),
					sqlRes.getInt(9),
					sqlRes.getInt(10),
					sqlRes.getInt(11)));

		sqlRes.close();
		return laListe.size();
	}
}
