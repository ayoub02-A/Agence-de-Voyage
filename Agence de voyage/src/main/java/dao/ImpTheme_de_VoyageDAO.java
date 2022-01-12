package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import metier.Voyage_a_themes;

public class ImpTheme_de_VoyageDAO implements ITheme_de_VoyageDAO {

	@Override
	public List<Voyage_a_themes> list_Themes_de_Voyage() {
			// TODO Auto-generated method stub
				List<Voyage_a_themes> Voyage_a_themes = new ArrayList<Voyage_a_themes>();
				Connection conn = DAOFACTORY.getConnection();
				try {
					PreparedStatement ps = conn.prepareStatement("SELECT distinct * from voyage_a_themes ;");
					ResultSet rs = ps.executeQuery();
					while(rs.next()) {
						Voyage_a_themes v = new Voyage_a_themes();
						v.setId_vtheme(rs.getInt("id_vtheme"));
						v.setNom_theme(rs.getString("nom_theme"));//noms de la base de donnés
						

						Voyage_a_themes.add(v);	
					}
					ps.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				return Voyage_a_themes;
				
	}

	@Override
	public String ObtenirNomThemeV(int fk_idthemev) {
		// TODO Auto-generated method stub
		String nom=null;
		try {
			Connection connection = DAOFACTORY.getConnection();
			PreparedStatement ps= connection.prepareStatement("select * from voyage_a_themes where id_vtheme = ?");
			ps.setInt(1, fk_idthemev);
			ResultSet rs = ps.executeQuery();
			if  (rs.next()) {
				nom=rs.getString("nom_theme");
				System.out.println(nom);
			}
		}
		catch (SQLException e) {
			 e.printStackTrace();
		}
		return nom;
	}

}
