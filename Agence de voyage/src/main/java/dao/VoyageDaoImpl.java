package dao;

import java.io.ByteArrayOutputStream;


import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import metier.Clients;
import metier.Voyage;

public class VoyageDaoImpl implements IVoyageDao{
	Connection conn=SingletonConnection.getConnection();

	@Override
	public void addVoyage(Voyage v) {
		// TODO Auto-generated method stub
		try {
			PreparedStatement ps= conn.prepareStatement("INSERT INTO voyage(nom_voyage,destination,duree,date_depart,budget,nbr_participant,prix,fk_id_circuit,fk_id_typev,fk_id_heberg,fk_id_vtheme,photo_voyage) VALUES(?,?,?,?,?,?,?,?,?,?,?,?)");
			ps.setString(1, v.getNom_voyage());
			ps.setString(2, v.getDestination());
			ps.setString(3, v.getDuree());
			ps.setDate(4, v.getDate_depart());
			ps.setFloat(5, v.getBudget());
			ps.setInt(6, v.getNbr_participant());
			ps.setFloat(7, v.getPrix());
			ps.setInt(8, v.getFk_id_circuit());
			ps.setInt(9, v.getFk_id_typev());
			ps.setInt(10, v.getFk_id_heberg());
			ps.setInt(11, v.getFk_id_vtheme());
			ps.setBlob(12, v.getPhoto_voyage());
			ps.executeUpdate();
			ps.close();
			System.out.println("valide");
		}
		catch (SQLException e) {
			 e.printStackTrace();
		}
		
	}

	@Override
	public List<Voyage> listeVoyage() {
		// TODO Auto-generated method stub
		List<Voyage> voy=new ArrayList<Voyage>();
		try {
			PreparedStatement ps= conn.prepareStatement("select * from voyage where date_depart >= ?");
			ps.setDate(1,new java.sql.Date(System.currentTimeMillis()));
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Voyage v = new Voyage();
				v.setId_voyage(rs.getInt("id_voyage"));	
				v.setNom_voyage(rs.getString("nom_voyage"));	
				v.setDestination(rs.getString("destination"));
				v.setDuree(rs.getString("duree"));
				v.setDate_depart(rs.getDate("date_depart"));
				v.setBudget(rs.getInt("budget"));
				v.setNbr_participant(rs.getInt("nbr_participant"));
				v.setNbrPlace(rs.getInt("nbr_participant")-nbrPlace(rs.getInt("id_voyage")));
				v.setPrix(rs.getInt("prix"));
				v.setFk_id_circuit(rs.getInt("fk_id_circuit"));
				v.setFk_id_typev(rs.getInt("fk_id_typev"));
				v.setFk_id_heberg(rs.getInt("fk_id_heberg"));
				v.setFk_id_vtheme(rs.getInt("fk_id_vtheme"));
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
	public Voyage getVoyage(int id) {
		// TODO Auto-generated method stub
		Voyage v=new Voyage();
		try {
			PreparedStatement ps= conn.prepareStatement("select * from voyage where id_voyage = ?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if  (rs.next()) {
				
				v.setId_voyage(rs.getInt("id_voyage"));
				v.setNom_voyage(rs.getString("nom_voyage"));
				v.setDestination(rs.getString("destination"));
				v.setDuree(rs.getString("duree"));
				v.setDate_depart(rs.getDate("date_depart"));
				v.setBudget(rs.getFloat("budget"));
				v.setNbr_participant(rs.getInt("nbr_participant"));
				v.setNbrPlace(rs.getInt("nbr_participant")-nbrPlace(rs.getInt("id_voyage")));
				v.setPrix(rs.getFloat("prix"));
				v.setFk_id_circuit(rs.getInt("fk_id_circuit"));
				v.setFk_id_typev(rs.getInt("fk_id_typev"));
				v.setFk_id_heberg(rs.getInt("fk_id_heberg"));
				v.setFk_id_vtheme(rs.getInt("fk_id_vtheme"));
				
				System.out.println("chuf :"+rs.getBinaryStream("photo_voyage"));
				
				InputStream inputStream = rs.getBinaryStream("photo_voyage");
				ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
				byte[] buffer = new byte[4096];
	            int bytesRead = -1;
	            try {
					while ((bytesRead = inputStream.read(buffer)) != -1) {
					    outputStream.write(buffer, 0, bytesRead);
					}
					System.out.println(2);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	            byte[] imageBytes = outputStream.toByteArray();
                String base64Image = Base64.getEncoder().encodeToString(imageBytes);
                
                try {
					inputStream.close();
					outputStream.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
                v.setBase64Image(base64Image);
					
				
				
				System.out.println("valide");
			}
		}
		catch (SQLException e) {
			 e.printStackTrace();
		}
		return v;
	}

	@Override
	public void updateVoyage(int id, Voyage v) {
		// TODO Auto-generated method stub
		System.out.println("chuf chuf : "+v.getDate_depart());
	
		try{
			PreparedStatement ps= conn.prepareStatement("UPDATE voyage SET duree=?,date_depart=?,budget=?,nbr_participant=?,prix=?,fk_id_circuit=? WHERE id_voyage=?");
			ps.setString(1, v.getDuree());
			ps.setDate(2, v.getDate_depart());
			ps.setFloat(3, v.getBudget());
			ps.setInt(4, v.getNbr_participant());
			ps.setFloat(5, v.getPrix());
			ps.setInt(6, v.getFk_id_circuit());
			
			ps.setInt(7, id);
			ps.executeUpdate();
			ps.close();
			System.out.println("valide");
			
		}
		catch (SQLException e) {
			 e.printStackTrace();
		}
		
	}

	@Override
	public void deleteVoyage(int id) {
		// TODO Auto-generated method stub
		try {
			PreparedStatement ps= conn.prepareStatement("DELETE FROM voyage WHERE id_voyage = ?");
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
	public List<Voyage> listeVoyageExpir() {
		// TODO Auto-generated method stub
		List<Voyage> voy=new ArrayList<Voyage>();
		try {
			PreparedStatement ps= conn.prepareStatement("select * from voyage where date_depart < ? order by date_depart desc");
			//Date date=System.currentTimeMillis();
			ps.setDate(1,new java.sql.Date(System.currentTimeMillis()));
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Voyage v = new Voyage();
				v.setId_voyage(rs.getInt("id_voyage"));	
				v.setNom_voyage(rs.getString("nom_voyage"));
				v.setDestination(rs.getString("destination"));
				v.setDuree(rs.getString("duree"));
				v.setDate_depart(rs.getDate("date_depart"));
				v.setBudget(rs.getInt("budget"));
				v.setNbr_participant(rs.getInt("nbr_participant"));
				v.setNbrPlace(rs.getInt("nbr_participant")-nbrPlace(rs.getInt("id_voyage")));
				v.setPrix(rs.getInt("prix"));
				v.setFk_id_circuit(rs.getInt("fk_id_circuit"));
				v.setFk_id_typev(rs.getInt("fk_id_typev"));
				v.setFk_id_heberg(rs.getInt("fk_id_heberg"));
				v.setFk_id_vtheme(rs.getInt("fk_id_vtheme"));
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
	public List<String> listeVoyagDest() {
		// TODO Auto-generated method stub
		List<String> Dest=new ArrayList<String>();
		try {
			PreparedStatement ps= conn.prepareStatement("select destination from voyage where date_depart > ? ");
			ps.setDate(1,new java.sql.Date(System.currentTimeMillis()));
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				String h = rs.getString("destination");
				Dest.add(h);	
				System.out.println("valide");
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return Dest;
	}

	@Override
	public List<Voyage> listeVoyageParDEst(String dest) {
		// TODO Auto-generated method stub
		List<Voyage> voy=new ArrayList<Voyage>();
		try {
			PreparedStatement ps= conn.prepareStatement("select * from voyage where date_depart > ? and destination = ?");
			ps.setDate(1,new java.sql.Date(System.currentTimeMillis()));
			ps.setString(2,dest);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Voyage v = new Voyage();
				v.setId_voyage(rs.getInt("id_voyage"));	
				v.setNom_voyage(rs.getString("nom_voyage"));
				v.setDestination(rs.getString("destination"));
				v.setDuree(rs.getString("duree"));
				v.setDate_depart(rs.getDate("date_depart"));
				v.setBudget(rs.getInt("budget"));
				v.setNbr_participant(rs.getInt("nbr_participant"));
				v.setNbrPlace(rs.getInt("nbr_participant")-nbrPlace(rs.getInt("id_voyage")));
				v.setPrix(rs.getInt("prix"));
				v.setFk_id_circuit(rs.getInt("fk_id_circuit"));
				v.setFk_id_typev(rs.getInt("fk_id_typev"));
				v.setFk_id_heberg(rs.getInt("fk_id_heberg"));
				v.setFk_id_vtheme(rs.getInt("fk_id_vtheme"));
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
	public List<Voyage> listeVoyageParDate(String date) {
		// TODO Auto-generated method stub
		List<Voyage> voy=new ArrayList<Voyage>();
		try {
			PreparedStatement ps= conn.prepareStatement("select * from voyage where date_depart = ? ");
			ps.setString(1,date);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Voyage v = new Voyage();
				v.setId_voyage(rs.getInt("id_voyage"));	
				v.setNom_voyage(rs.getString("nom_voyage"));
				v.setDestination(rs.getString("destination"));
				v.setDuree(rs.getString("duree"));
				v.setDate_depart(rs.getDate("date_depart"));
				v.setBudget(rs.getInt("budget"));
				v.setNbr_participant(rs.getInt("nbr_participant"));
				v.setNbrPlace(rs.getInt("nbr_participant")-nbrPlace(rs.getInt("id_voyage")));
				v.setPrix(rs.getInt("prix"));
				v.setFk_id_circuit(rs.getInt("fk_id_circuit"));
				v.setFk_id_typev(rs.getInt("fk_id_typev"));
				v.setFk_id_heberg(rs.getInt("fk_id_heberg"));
				v.setFk_id_vtheme(rs.getInt("fk_id_vtheme"));
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
	public List<Voyage> listeVoyageParTheme(String idtheme) {
		// TODO Auto-generated method stub
		List<Voyage> voy=new ArrayList<Voyage>();
		try {
			PreparedStatement ps= conn.prepareStatement("select * from voyage where date_depart > ? and fk_id_vtheme = ? ");
			ps.setDate(1,new java.sql.Date(System.currentTimeMillis()));
			ps.setString(2,idtheme);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Voyage v = new Voyage();
				v.setId_voyage(rs.getInt("id_voyage"));	
				v.setNom_voyage(rs.getString("nom_voyage"));
				v.setDestination(rs.getString("destination"));
				v.setDuree(rs.getString("duree"));
				v.setDate_depart(rs.getDate("date_depart"));
				v.setBudget(rs.getInt("budget"));
				v.setNbr_participant(rs.getInt("nbr_participant"));
				v.setNbrPlace(rs.getInt("nbr_participant")-nbrPlace(rs.getInt("id_voyage")));
				v.setPrix(rs.getInt("prix"));
				v.setFk_id_circuit(rs.getInt("fk_id_circuit"));
				v.setFk_id_typev(rs.getInt("fk_id_typev"));
				v.setFk_id_heberg(rs.getInt("fk_id_heberg"));
				v.setFk_id_vtheme(rs.getInt("fk_id_vtheme"));
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
	public List<Voyage> listeVoyageParType(String idtype) {
		// TODO Auto-generated method stub
		List<Voyage> voy=new ArrayList<Voyage>();
		try {
			PreparedStatement ps= conn.prepareStatement("select * from voyage where date_depart > ? and fk_id_typev = ? ");
			ps.setDate(1,new java.sql.Date(System.currentTimeMillis()));
			ps.setString(2,idtype);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Voyage v = new Voyage();
				v.setId_voyage(rs.getInt("id_voyage"));	
				v.setNom_voyage(rs.getString("nom_voyage"));
				v.setDestination(rs.getString("destination"));
				v.setDuree(rs.getString("duree"));
				v.setDate_depart(rs.getDate("date_depart"));
				v.setBudget(rs.getInt("budget"));
				v.setNbr_participant(rs.getInt("nbr_participant"));
				v.setNbrPlace(rs.getInt("nbr_participant")-nbrPlace(rs.getInt("id_voyage")));
				v.setPrix(rs.getInt("prix"));
				v.setFk_id_circuit(rs.getInt("fk_id_circuit"));
				v.setFk_id_typev(rs.getInt("fk_id_typev"));
				v.setFk_id_heberg(rs.getInt("fk_id_heberg"));
				v.setFk_id_vtheme(rs.getInt("fk_id_vtheme"));
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
	public int nbrPlace(int idVoyage) {
		// TODO Auto-generated method stub
		int nbr=0;
		try {
			PreparedStatement ps= conn.prepareStatement("SELECT COUNT(fk_id_client) FROM panier where fk_id_voyage = ? and voyage_confirme = '1'");
			ps.setInt(1,idVoyage);
			ResultSet rs = ps.executeQuery();
			if  (rs.next()) {
				nbr=rs.getInt("COUNT(fk_id_client)");
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return nbr;
	}

	@Override
	public List<Voyage> listeVoyageParCircuit(int idCircuit) {
		// TODO Auto-generated method stub
		List<Voyage> voy=new ArrayList<Voyage>();
		try {
			PreparedStatement ps= conn.prepareStatement("select * from voyage where date_depart >= ? and fk_id_circuit = ? ");
			ps.setDate(1,new java.sql.Date(System.currentTimeMillis()));
			ps.setInt(2,idCircuit);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Voyage v = new Voyage();
				v.setId_voyage(rs.getInt("id_voyage"));	
				v.setNom_voyage(rs.getString("nom_voyage"));
				v.setDestination(rs.getString("destination"));
				v.setDuree(rs.getString("duree"));
				v.setDate_depart(rs.getDate("date_depart"));
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
	public List<Voyage> listeVoyageParCircuitExpirer(int idCircuit) {
		// TODO Auto-generated method stub
		List<Voyage> voy=new ArrayList<Voyage>();
		try {
			PreparedStatement ps= conn.prepareStatement("select * from voyage where date_depart < ? and fk_id_circuit = ? ");
			ps.setDate(1,new java.sql.Date(System.currentTimeMillis()));
			ps.setInt(2,idCircuit);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Voyage v = new Voyage();
				v.setId_voyage(rs.getInt("id_voyage"));	
				v.setNom_voyage(rs.getString("nom_voyage"));
				v.setDestination(rs.getString("destination"));
				v.setDuree(rs.getString("duree"));
				v.setDate_depart(rs.getDate("date_depart"));
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
	public List<Clients> listeParticipants(int idVoyage) {
		// TODO Auto-generated method stub
		List<Clients> cls=new ArrayList<Clients>();
		try {
			PreparedStatement ps= conn.prepareStatement("select distinct T.* from  clients T, panier B where B.fk_id_voyage = ? and B.fk_id_client = T.id_client and B.voyage_confirme = 1");
			ps.setInt(1,idVoyage);
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
	

}
