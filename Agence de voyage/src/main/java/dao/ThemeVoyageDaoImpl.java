package dao;





import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import java.util.List;


import metier.Voyage_a_themes;

public class ThemeVoyageDaoImpl implements IThemeVoyageDao{
	Connection conn=SingletonConnection.getConnection();

	@Override
	public void addTheme(Voyage_a_themes T) {
		// TODO Auto-generated method stub
		try {
			PreparedStatement ps= conn.prepareStatement("INSERT INTO voyage_a_themes(nom_theme) VALUES(?)");
			ps.setString(1, T.getNom_theme());
			ps.executeUpdate();
			ps.close();
			System.out.println("valide");
		}
		catch (SQLException e) {
			 e.printStackTrace();
		}
		
	}

	@Override
	public void deleteTheme(int id) {
		// TODO Auto-generated method stub
		try {
			PreparedStatement ps= conn.prepareStatement("DELETE FROM voyage_a_themes WHERE id_vtheme = ?");
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
	public List<Voyage_a_themes> listeTheme() {
		// TODO Auto-generated method stub
		List<Voyage_a_themes> Theme=new ArrayList<Voyage_a_themes>();
		try {
			PreparedStatement ps= conn.prepareStatement("select * from voyage_a_themes");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Voyage_a_themes T = new Voyage_a_themes();
				T.setId_vtheme(rs.getInt("id_vtheme"));	
				T.setNom_theme(rs.getString("nom_theme"));
				Theme.add(T);	
				System.out.println("valide");
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return Theme;
		
	}

	@Override
	public Voyage_a_themes getTheme(int id) {
		// TODO Auto-generated method stub
		Voyage_a_themes v=new Voyage_a_themes();
		try {
			PreparedStatement ps= conn.prepareStatement("select * from voyage_a_themes where id_vtheme = ?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if  (rs.next()) {
				v.setId_vtheme(rs.getInt("id_vtheme"));	
				v.setNom_theme(rs.getString("nom_theme"));
				
				System.out.println("valide");
			}
		}
		catch (SQLException e) {
			 e.printStackTrace();
		}
		
		return v;
	}
	

}
