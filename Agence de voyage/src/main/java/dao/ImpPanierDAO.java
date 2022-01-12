package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ImpPanierDAO implements IPanierDAO {

	Connection connection = DAOFACTORY.getConnection();
	@Override
	public void ajouterVAuPanier(int idClient,int idVoyage) {
		// TODO Auto-generated method stub
		try{
			PreparedStatement ps= connection.prepareStatement("insert into panier (fk_id_client, fk_id_voyage, date_ajoutpanier, voyage_confirme) values(?,?,?,?)");
			ps.setInt(1, idClient);
			ps.setInt(2, idVoyage);
			ps.setDate(3, new java.sql.Date(System.currentTimeMillis()));
			ps.setBoolean(4, false);
			ps.executeUpdate();
			ps.close();
			System.out.println("valide");
		}
		catch (SQLException e) {
			 e.printStackTrace();
		}
	}
	
	@Override
	public void SupprimerDuPanier(int idClient,int idVoyage) {
		// TODO Auto-generated method stub
		
		try {
			PreparedStatement ps = connection.prepareStatement("delete from panier where fk_id_client=? and fk_id_voyage=?");

			ps.setInt(1,idClient);
			ps.setInt(2,idVoyage);

			ps.executeUpdate();
			ps.close();
		}
		catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();


		}

	}

}
