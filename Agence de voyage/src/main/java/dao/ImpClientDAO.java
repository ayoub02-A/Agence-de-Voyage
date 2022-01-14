package dao;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import metier.Clients;



public class ImpClientDAO implements IClientDAO {

	Connection connection = DAOFACTORY.getConnection();
	@Override
	public boolean login(String login, String pwd) {
		// TODO Auto-generated method stub
		
		boolean a=false;		
		String s=getMd5(pwd);
		System.out.println("login: " + login + " mdp: " + s + " ");
		
		try {
			PreparedStatement ps  = connection.prepareStatement("SELECT mdp_client FROM clients WHERE email_client=? ");
			ps.setString(1, login);
			ResultSet rs = ps.executeQuery();
			if(rs.next() && (rs.getString("mdp_client")).equals(s) ){
				a=true;	
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return a;
	}

	@Override
	public void Inscription(Clients p) {
		// TODO Auto-generated method stub
		try {
			PreparedStatement ps = connection.prepareStatement("insert into clients(nom_client,prenom_client,mdp_client,email_client,tel_client) values(?,?,?,?,?)");
			ps.setString(1, p.getNom_client());
			ps.setString(2, p.getPrenom_client());
			String s= getMd5(p.getMdp_client());
			ps.setString(3, s);
			ps.setString(4, p.getEmail_client());
			ps.setString(5, p.getTel_client());
		

			ps.executeUpdate();

			ps.close();


		} catch (SQLException e1) {
			e1.printStackTrace();
		}

	}

	@Override
	public Clients getClients(String login, String pwd) {
		// TODO Auto-generated method stub
		Clients c  = new Clients();
		System.out.println("hieeer");
		try {
			PreparedStatement ps = connection.prepareStatement 
					("SELECT *  FROM clients  WHERE email_client=? and mdp_client=? ");	
			ps.setString(1, login);
			String s= getMd5(pwd);
			ps.setString(2, s);
			ResultSet rs = ps.executeQuery();

			if(rs.next()){
				c.setId_client(rs.getInt("id_client"));
				c.setNom_client(rs.getString("nom_client"));
				c.setPrenom_client(rs.getString("prenom_client"));
				c.setEmail_client(rs.getString("email_client"));
				c.setTel_client(rs.getString("tel_client"));
				
			}			
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return c;
	}
	
	///Pour le hashage du mdp dans la base de donnee
	public String getMd5(String input){
		try {
			// Static getInstance method is called with hashing MD5
			MessageDigest md = MessageDigest.getInstance("MD5");
			//  of an input digest() return array of byte
			byte[] messageDigest = md.digest(input.getBytes());
			// Convert byte array into signum representation
			BigInteger no = new BigInteger(1, messageDigest);
			// Convert message digest into hex value
			String hashtext = no.toString(16);
			while (hashtext.length() < 32) {
				hashtext = "0" + hashtext;
			}
			return hashtext;
		} 
		catch (NoSuchAlgorithmException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public List<Clients> getClient(int id) {
			Connection connection= DAOFACTORY.getConnection();
			Clients c  = new Clients();
			List<Clients> cL = new ArrayList<Clients>();
			try {
				PreparedStatement ps = connection.prepareStatement 
						("SELECT *  FROM clients  WHERE id_client=?");	
				ps.setInt(1, id);
	            ResultSet rs = ps.executeQuery();
				
				if(rs.next()){
					c.setId_client(rs.getInt("id_client"));
					c.setNom_client(rs.getString("nom_client"));
					c.setPrenom_client( rs.getString("prenom_client"));
					c.setMdp_client(rs.getString("mdp_client"));
					c.setEmail_client(rs.getString("email_client"));
					c.setTel_client(rs.getString("tel_client"));
					cL.add(c);
				}			
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return cL;
		
	}
	@Override
	public Clients getClient1(int id) {
			Connection connection= DAOFACTORY.getConnection();
			Clients c  = new Clients();
			
			try {
				PreparedStatement ps = connection.prepareStatement 
						("SELECT *  FROM clients  WHERE id_client=?");	
				ps.setInt(1, id);
	            ResultSet rs = ps.executeQuery();
				
				if(rs.next()){
					c.setId_client(rs.getInt("id_client"));
					c.setNom_client(rs.getString("nom_client"));
					c.setPrenom_client( rs.getString("prenom_client"));
					c.setMdp_client(rs.getString("mdp_client"));
					c.setEmail_client(rs.getString("email_client"));
					c.setTel_client(rs.getString("tel_client"));
					
				}			
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return c;
		
	}

	@Override
	public void modifierClientProfil(int cptUser, Clients u) {
		
			// TODO Auto-generated method stub
			try {
				PreparedStatement ps=connection.prepareStatement("update clients set  nom_client =?, prenom_client=?,email_client=? ,tel_client=? WHERE id_client=?");

				ps.setString(1, u.getNom_client());
				ps.setString(2, u.getPrenom_client());
				ps.setString(3, u.getEmail_client());
				ps.setString(4, u.getTel_client());

				ps.setInt(5,cptUser);
				ps.executeUpdate();
				ps.close();
			}catch (Exception e) {
				e.printStackTrace();
				System.out.println("error");
			}
		
		
	}
	
	
	@Override
	public void Contact(String nom, String prenom, String email, String message) {
		// TODO Auto-generated method stub
		try {
			PreparedStatement ps= connection.prepareStatement("INSERT INTO contact(nom,prenom,email,message) VALUES(?,?,?,?)");
			ps.setString(1, nom);
			ps.setString(2, prenom);
			ps.setString(3, email);
			ps.setString(4, message);
			ps.executeUpdate();
			ps.close();
			System.out.println("valide");
		}
		catch (SQLException e) {
			 e.printStackTrace();
		}
		
	}
	
	@Override
	public List<String> EmailsRegistration(){
		Connection connection= DAOFACTORY.getConnection();
		List<String> cL = new ArrayList<String>();
		try {
			PreparedStatement ps = connection.prepareStatement ("SELECT email_client  FROM clients ");	
            ResultSet rs = ps.executeQuery();
			
            while (rs.next()) {
            	String c  = new String();
				c=rs.getString("email_client");
				cL.add(c);
			}			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cL;
		
	}
	
	

}