package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import metier.Type_de_Voyage;


public class TypeVoyageDaoImpl implements ITypeVoyageDao{
	Connection conn=SingletonConnection.getConnection();

	@Override
	public void addTypeVoyage(Type_de_Voyage T) {
		// TODO Auto-generated method stub
		try {
			PreparedStatement ps= conn.prepareStatement("INSERT INTO type_de_voyage(nom_typev) VALUES(?)");
			ps.setString(1, T.getNom_typev());
			ps.executeUpdate();
			ps.close();
			System.out.println("valide");
		}
		catch (SQLException e) {
			 e.printStackTrace();
		}
		
		
	}

	@Override
	public void deleteTypeVoyage(int id) {
		// TODO Auto-generated method stub
		try {
			PreparedStatement ps= conn.prepareStatement("DELETE FROM type_de_voyage WHERE id_typev = ?");
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
	public List<Type_de_Voyage> listeTypeVoyage() {
		// TODO Auto-generated method stub
		List<Type_de_Voyage> Type=new ArrayList<Type_de_Voyage>();
		try {
			PreparedStatement ps= conn.prepareStatement("select * from type_de_voyage");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Type_de_Voyage T = new Type_de_Voyage();
				T.setId_typev(rs.getInt("id_typev"));	
				T.setNom_typev(rs.getString("nom_typev"));
				Type.add(T);	
				System.out.println("valide");
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return Type;
	}

	@Override
	public Type_de_Voyage getType(int id) {
		// TODO Auto-generated method stub
		Type_de_Voyage T=new Type_de_Voyage();
		try {
			PreparedStatement ps= conn.prepareStatement("select * from type_de_voyage where id_typev = ?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if  (rs.next()) {
				T.setId_typev(rs.getInt("id_typev"));	
				T.setNom_typev(rs.getString("nom_typev"));
				
				System.out.println("valide");
			}
		}
		catch (SQLException e) {
			 e.printStackTrace();
		}
		
		return T;
		
	}
	
	

}
