package dao;



import java.io.ByteArrayOutputStream;


import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import metier.Circuit_accompagnes;


public class CircuitAccompagnesAdminDaoImpl implements ICircuitAccompagnesAdmin{
	Connection conn=SingletonConnection.getConnection();
	

	@Override
	public void addCircuit(Circuit_accompagnes c) {
		// TODO Auto-generated method stub
		try {
			PreparedStatement ps= conn.prepareStatement("INSERT INTO circuit_accompagnes(nom_circuit,email_circuit,tel_circuit,langues_circuit,photo_circuit,description_circuit) VALUES(?,?,?,?,?,?)");
			ps.setString(1, c.getNom_circuit());
			ps.setString(2, c.getEmail_circuit());
			ps.setString(3, c.getTel_circuit());
			ps.setString(4, c.getLangues_circuit());
			ps.setBlob(5, c.getPhoto_circuit());
			ps.setString(6, c.getDescription_circuit());
			ps.executeUpdate();
			ps.close();
			System.out.println("valide");
		}
		catch (SQLException e) {
			 e.printStackTrace();
		}
		
	}


	@Override
	public List<Circuit_accompagnes> listeCircuit() {
		// TODO Auto-generated method stub
		List<Circuit_accompagnes> cir=new ArrayList<Circuit_accompagnes>();
		try {
			PreparedStatement ps= conn.prepareStatement("select * from circuit_accompagnes");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Circuit_accompagnes c = new Circuit_accompagnes();
				c.setId_circuit(rs.getInt("id_circuit"));	
				c.setNom_circuit(rs.getString("nom_circuit"));
				c.setEmail_circuit(rs.getString("email_circuit"));
				c.setTel_circuit(rs.getString("tel_circuit"));
				c.setLangues_circuit(rs.getString("langues_circuit"));
				c.setDescription_circuit(rs.getString("description_circuit"));
				System.out.println(1);
				
				System.out.println("chuf :"+rs.getBinaryStream("photo_circuit"));
				
				InputStream inputStream = rs.getBinaryStream("photo_circuit");
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
                c.setBase64Image(base64Image);

				cir.add(c);	
				System.out.println("valide");
			}
			ps.close();
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return cir;
	}


	@Override
	public void deleteCircuit(int id) {
		// TODO Auto-generated method stub
		try {
			PreparedStatement ps= conn.prepareStatement("DELETE FROM circuit_accompagnes WHERE id_circuit = ?");
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
	public Circuit_accompagnes getCircuit(int id) {
		// TODO Auto-generated method stub
		Circuit_accompagnes c=new Circuit_accompagnes();
		try {
			PreparedStatement ps= conn.prepareStatement("select * from circuit_accompagnes where id_circuit = ?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if  (rs.next()) {
				
				c.setId_circuit(rs.getInt("id_circuit"));	
				c.setNom_circuit(rs.getString("nom_circuit"));
				c.setEmail_circuit(rs.getString("email_circuit"));
				c.setTel_circuit(rs.getString("tel_circuit"));
				c.setLangues_circuit(rs.getString("langues_circuit"));
				c.setDescription_circuit(rs.getString("description_circuit"));
				System.out.println(1);
				
				System.out.println("chuf :"+rs.getBinaryStream("photo_circuit"));
				
				InputStream inputStream = rs.getBinaryStream("photo_circuit");
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
                c.setBase64Image(base64Image);
				
				System.out.println("valide");
			}
		}
		catch (SQLException e) {
			 e.printStackTrace();
		}
		return c;
		
	}


	@Override
	public void updateCircuit(int id, Circuit_accompagnes c) {
		// TODO Auto-generated method stub
		try{
			PreparedStatement ps= conn.prepareStatement("UPDATE circuit_accompagnes SET nom_circuit=?,email_circuit=?,tel_circuit=?,langues_circuit=?,description_circuit=? WHERE id_circuit=?");
			ps.setString(1, c.getNom_circuit());
			ps.setString(2, c.getEmail_circuit());
			ps.setString(3,c.getTel_circuit());
			ps.setString(4, c.getLangues_circuit());
			ps.setString(5, c.getDescription_circuit());
			
			ps.setInt(6, id);
			ps.executeUpdate();
			ps.close();
			System.out.println("valide");
		}
		catch (SQLException e) {
			 e.printStackTrace();
		}
		
	}


	@Override
	public List<Circuit_accompagnes> listeCircuitAvailable() {
		// TODO Auto-generated method stub
		List<Circuit_accompagnes> cir=new ArrayList<Circuit_accompagnes>();
		try {
			PreparedStatement ps= conn.prepareStatement("select * \r\n"
					+ "from circuit_accompagnes \r\n"
					+ "where id_circuit not in (select distinct T.id_circuit from  circuit_accompagnes T, voyage B where B.fk_id_circuit =T.id_circuit and B.date_depart = ? ) ");
			ps.setDate(1,new java.sql.Date(System.currentTimeMillis()));
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Circuit_accompagnes c = new Circuit_accompagnes();
				c.setId_circuit(rs.getInt("id_circuit"));	
				c.setNom_circuit(rs.getString("nom_circuit"));
				c.setEmail_circuit(rs.getString("email_circuit"));
				c.setTel_circuit(rs.getString("tel_circuit"));
				c.setLangues_circuit(rs.getString("langues_circuit"));
				c.setDescription_circuit(rs.getString("description_circuit"));
				cir.add(c);	
				System.out.println("valide");
			}
			ps.close();
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return cir;
	}

}
