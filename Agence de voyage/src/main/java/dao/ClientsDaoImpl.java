package dao;

import java.util.*;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import metier.Clients;
import metier.Voyage;

public class ClientsDaoImpl implements IClientsDao{
	Connection conn=SingletonConnection.getConnection();

	@Override
	public List<Clients> ClientsParMC(String mc) {
		// TODO Auto-generated method stub
		List<Clients> cls=new ArrayList<Clients>();
		try {
			
			PreparedStatement ps= conn.prepareStatement("select * from clients where nom_client LIKE ? or prenom_client LIKE ?");
			ps.setString(1, "%"+mc+"%");
			ps.setString(2, "%"+mc+"%");
			ResultSet rs = ps.executeQuery();
			System.out.println(rs);
			while (rs.next()) {
				Clients c = new Clients();
				c.setId_client(rs.getInt("id_client"));	
				c.setNom_client(rs.getString("nom_client"));
				c.setPrenom_client(rs.getString("prenom_client"));
				c.setEmail_client(rs.getString("email_client"));
				c.setTel_client(rs.getString("tel_client"));
				cls.add(c);	
				System.out.println("valide");
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return cls;
	}

	@Override
	public void deleteClients(int id) {
		// TODO Auto-generated method stub
		try {
			PreparedStatement ps= conn.prepareStatement("DELETE FROM clients WHERE id_client = ?");
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
	public List<Clients> listeClients() {
		// TODO Auto-generated method stub
		List<Clients> cls=new ArrayList<Clients>();
		try {
			PreparedStatement ps= conn.prepareStatement("select * from clients");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Clients c = new Clients();
				c.setId_client(rs.getInt("id_client"));	
				c.setNom_client(rs.getString("nom_client"));
				c.setPrenom_client(rs.getString("prenom_client"));
				c.setEmail_client(rs.getString("email_client"));
				c.setTel_client(rs.getString("tel_client"));
				cls.add(c);	
				System.out.println("valide");
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return cls;
	}

	@Override
	public List<Voyage> Panier(int id) {
		// TODO Auto-generated method stub
		List<Voyage> voy=new ArrayList<Voyage>();
		try {
			PreparedStatement ps= conn.prepareStatement("select distinct T.* from  voyage T, panier B where B.fk_id_client = ?  and B.fk_id_voyage = T.id_voyage and B.voyage_confirme = 1  and T.date_depart >= ? ");
			ps.setInt(1,id);
			ps.setDate(2,new java.sql.Date(System.currentTimeMillis()));
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Voyage v = new Voyage();
				v.setId_voyage(rs.getInt("id_voyage"));	
				v.setNom_voyage(rs.getString("nom_voyage"));	
				v.setDestination(rs.getString("destination"));
				v.setDuree(rs.getString("duree"));
				v.setDate_depart(rs.getDate("date_depart"));
				v.setPrix(rs.getInt("prix"));
				voy.add(v);	
				System.out.println("valide");
			}
			ps.close();
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return voy;
	}

	@Override
	public List<Voyage> PanierNon(int id) {
		// TODO Auto-generated method stub
		List<Voyage> voy=new ArrayList<Voyage>();
		try {
			PreparedStatement ps= conn.prepareStatement("select distinct T.* from  voyage T, panier B where B.fk_id_client = ?  and B.fk_id_voyage = T.id_voyage and B.voyage_confirme = 0  and T.date_depart >= ? ");
			ps.setInt(1,id);
			ps.setDate(2,new java.sql.Date(System.currentTimeMillis()));
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Voyage v = new Voyage();
				v.setId_voyage(rs.getInt("id_voyage"));	
				v.setNom_voyage(rs.getString("nom_voyage"));	
				v.setDestination(rs.getString("destination"));
				v.setDuree(rs.getString("duree"));
				v.setDate_depart(rs.getDate("date_depart"));
				v.setPrix(rs.getInt("prix"));
				voy.add(v);	
				System.out.println("valide");
			}
			ps.close();
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return voy;
	}
	
	

}
