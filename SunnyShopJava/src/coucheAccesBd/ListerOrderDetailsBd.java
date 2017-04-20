package coucheAccesBd;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import classesMétiers.LigneCommande;

public class ListerOrderDetailsBd extends OperationBd{
	private List<LigneCommande> laListe;
	private Integer leNum;
	
	public List<LigneCommande> getListe() { return laListe; }
	
	public ListerOrderDetailsBd(Integer idOrder)
	{
	super("ListerOrderDetails");
	leNum=idOrder;
	}
	
	
	public int ExecuterRequete(Connection SqlConn) throws Exception
	{
	laListe = new ArrayList<LigneCommande>();
	
	CallableStatement sqlCmd = SqlConn.prepareCall("{ call ListerOrderDetails(?) }");
	sqlCmd.setInt(1, leNum);
	ResultSet sqlRes = sqlCmd.executeQuery();
	while (sqlRes.next() == true)
	laListe.add(new LigneCommande(sqlRes.getString(1),
						sqlRes.getString(2),
						sqlRes.getFloat(3),
						sqlRes.getInt(4),
						sqlRes.getFloat(5)
						));
	sqlRes.close();
	return laListe.size();
	}

}
