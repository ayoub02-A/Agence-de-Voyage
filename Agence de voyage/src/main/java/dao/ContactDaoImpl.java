package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import metier.Contact;
import metier.Type_de_Voyage;
import metier.Voyage_a_themes;

public class ContactDaoImpl implements IContactDao{
	Connection conn=SingletonConnection.getConnection();
	@Override
	public int nbrMessage() {
		// TODO Auto-generated method stub
		int nbr=0;
		try {
			PreparedStatement ps= conn.prepareStatement("SELECT COUNT(id_contact) FROM contact where vu is null");
			ResultSet rs = ps.executeQuery();
			if  (rs.next()) {
				nbr=rs.getInt("COUNT(id_contact)");
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return nbr;
	}
	@Override
	public List<Contact> Nonvue() {
		// TODO Auto-generated method stub
		List<Contact> contact=new ArrayList<Contact>();
		try {
			PreparedStatement ps= conn.prepareStatement("select * from contact  where vu is null");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Contact T = new Contact();
				T.setId_contact(rs.getInt("id_contact"));	
				T.setNom(rs.getString("nom"));
				T.setPrenom(rs.getString("prenom"));
				T.setEmail(rs.getString("email"));
				T.setMessage(rs.getString("message"));
				contact.add(T);	
				System.out.println("valide");
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return contact;
	}
	@Override
	public List<Contact> Vue() {
		// TODO Auto-generated method stub
		List<Contact> contact=new ArrayList<Contact>();
		try {
			PreparedStatement ps= conn.prepareStatement("select * from contact  where vu = '1'");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Contact T = new Contact();
				T.setId_contact(rs.getInt("id_contact"));	
				T.setNom(rs.getString("nom"));
				T.setPrenom(rs.getString("prenom"));
				T.setEmail(rs.getString("email"));
				T.setMessage(rs.getString("message"));
				contact.add(T);	
				System.out.println("valide");
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return contact;
		
	}
	@Override
	public Contact getMessage(int id) {
		// TODO Auto-generated method stub
		Contact v=new Contact();
		try {
			PreparedStatement ps= conn.prepareStatement("select * from contact where id_contact = ?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if  (rs.next()) {
				v.setId_contact(rs.getInt("id_contact"));
				v.setNom(rs.getString("nom"));
				v.setPrenom(rs.getString("prenom"));
				v.setEmail(rs.getString("email"));
				v.setMessage(rs.getString("message"));
				System.out.println("valide");
			}
		}
		catch (SQLException e) {
			 e.printStackTrace();
		}
		
		return v;
	}
	@Override
	public void removeMessage(int id) {
		// TODO Auto-generated method stub
		try {
			PreparedStatement ps= conn.prepareStatement("DELETE FROM contact WHERE id_contact = ?");
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
	public void setVue(int id) {
		// TODO Auto-generated method stub
		try{
			PreparedStatement ps= conn.prepareStatement("UPDATE contact SET vu=? WHERE id_contact=?");
			ps.setBoolean(1, true);
			ps.setInt(2, id);
			ps.executeUpdate();
			ps.close();
			System.out.println("valide");
		}
		catch (SQLException e) {
			 e.printStackTrace();
		}

		
		
	}

}


