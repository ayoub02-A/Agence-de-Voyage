package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import metier.Hebergement;


public class ImpHebergementDAO implements IHebergementDao {

	@Override
	public List<Hebergement> list_Hebergement() {
				// TODO Auto-generated method stub
					List<Hebergement> Hebergement = new ArrayList<Hebergement>();
					Connection conn = DAOFACTORY.getConnection();
					try {
						PreparedStatement ps = conn.prepareStatement("SELECT distinct * from hebergement ;");
						ResultSet rs = ps.executeQuery();
						while(rs.next()) {
							Hebergement v = new Hebergement();
							v.setId_heberg(rs.getInt("id_heberg"));
							v.setNom_heberg(rs.getString("nom_heberg"));//noms de la base de donnés
							
							
							Hebergement.add(v);	
						}
						ps.close();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

					return Hebergement;
					
		
	}

	@Override
	public String ObtenirNomHeberg(int fk_idhebergement) {
		// TODO Auto-generated method stub
		String nom=null;
		try {
			Connection connection = DAOFACTORY.getConnection();
			PreparedStatement ps= connection.prepareStatement("select * from hebergement where id_heberg = ?");
			ps.setInt(1, fk_idhebergement);
			ResultSet rs = ps.executeQuery();
			if  (rs.next()) {
				nom=rs.getString("nom_heberg");
				System.out.println(nom);
			}
		}
		catch (SQLException e) {
			 e.printStackTrace();
		}
		return nom;
	}

	@Override
	public void addHebergement(Hebergement h) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteHebergement(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Hebergement> listeHebergement() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Hebergement getHeberg(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
