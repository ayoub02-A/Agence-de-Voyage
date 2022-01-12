package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class ImpCircuitAccompDAO implements ICircuitAccompDAO {

	@Override
	public String ObtenirNomCircuit(int fk_idcircuit) {
		// TODO Auto-generated method stub
		String nom=null;
		try {
			Connection connection = DAOFACTORY.getConnection();
			PreparedStatement ps= connection.prepareStatement("select * from circuit_accompagnes where id_circuit=?");
			ps.setInt(1, fk_idcircuit);
			ResultSet rs = ps.executeQuery();
			if  (rs.next()) {
				nom=rs.getString("nom_circuit");
				System.out.println(nom);
				System.out.println("why?");
			}
		}
		catch (SQLException e) {
			 e.printStackTrace();
		}
		return nom;
		
	}

}
