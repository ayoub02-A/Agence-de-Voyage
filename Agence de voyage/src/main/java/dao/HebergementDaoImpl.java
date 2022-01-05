package dao;

import java.util.ArrayList;

import java.util.List;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import metier.Hebergement;


public class HebergementDaoImpl implements IHebergementDao{
	Connection conn=SingletonConnection.getConnection();

	@Override
	public void addHebergement(Hebergement h) {
		// TODO Auto-generated method stub
		try {
			PreparedStatement ps= conn.prepareStatement("INSERT INTO hebergement(nom_heberg) VALUES(?)");
			ps.setString(1, h.getNom_heberg());
			ps.executeUpdate();
			ps.close();
			System.out.println("valide");
		}
		catch (SQLException e) {
			 e.printStackTrace();
		}
	}

	@Override
	public void deleteHebergement(int id) {
		// TODO Auto-generated method stub
		try {
			PreparedStatement ps= conn.prepareStatement("DELETE FROM hebergement WHERE id_heberg = ?");
			ps.setInt(1, id);
			ps.executeUpdate();
			ps.close();
			System.out.println("valide");
		}
		catch (SQLException e) {
			 e.printStackTrace();
		}
	}

	@Override
	public List<Hebergement> listeHebergement() {
		// TODO Auto-generated method stub
		List<Hebergement> heberg=new ArrayList<Hebergement>();
		try {
			PreparedStatement ps= conn.prepareStatement("select * from hebergement");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Hebergement h = new Hebergement();
				h.setId_heberg(rs.getInt("id_heberg"));	
				h.setNom_heberg(rs.getString("nom_heberg"));
				heberg.add(h);	
				System.out.println("valide");
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return heberg;
	}

	@Override
	public Hebergement getHeberg(int id) {
		// TODO Auto-generated method stub
		Hebergement h=new Hebergement();
		try {
			PreparedStatement ps= conn.prepareStatement("select * from hebergement where id_heberg = ?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if  (rs.next()) {
				h.setId_heberg(rs.getInt("id_heberg"));	
				h.setNom_heberg(rs.getString("nom_heberg"));
				
				System.out.println("valide");
			}
		}
		catch (SQLException e) {
			 e.printStackTrace();
		}
		
		return h;
		
	}
	

}
