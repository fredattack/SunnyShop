package coucheAccesBd;

import java.sql.CallableStatement;
import java.sql.Connection;

import classesMétiers.*;

public class ModifierAlcoolBd extends OperationBd {

	private Alcool lAlcool;

	public ModifierAlcoolBd(Alcool alcool){
		super("ModifierAlcool");
		lAlcool=alcool;
}
	@Override
	public int ExecuterRequete(Connection SqlConn) throws Exception {
		CallableStatement sqlCmd = SqlConn.prepareCall("{ call ModifierAlcool( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) }");
		sqlCmd.setString(1, lAlcool.getIdAlcool());
		sqlCmd.setString(2, lAlcool.getNomAlcool());
		sqlCmd.setFloat(3, lAlcool.getPrixUnitaire());
		sqlCmd.setInt(4, lAlcool.getIdFamille());
		sqlCmd.setInt(5, lAlcool.getIdProvenanceAlcool());
		sqlCmd.setInt(6, lAlcool.getDegréAlcool());
		sqlCmd.setString(7, lAlcool.getGoutAlcool());
		sqlCmd.setString(8, lAlcool.getDatePeremption());
		sqlCmd.setInt(9, lAlcool.getStockAlcool());
		sqlCmd.setInt(10, lAlcool.getQuantitéCaisse());
		sqlCmd.setString(11, lAlcool.getImageAlcool());
		sqlCmd.setInt(12, lAlcool.getIdTypeProduit());
		sqlCmd.setInt(13, lAlcool.getAfficherAlcool());
		
		
		sqlCmd.registerOutParameter(14, java.sql.Types.INTEGER);
		sqlCmd.executeUpdate();
		
		return sqlCmd.getInt(14);
		
	}
}
