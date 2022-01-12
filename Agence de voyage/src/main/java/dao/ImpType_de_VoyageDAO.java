package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import metier.Type_de_Voyage;

public class ImpType_de_VoyageDAO implements IType_de_VoyageDAO {


	
	@Override
	public List<Type_de_Voyage> liste_Type_de_Voyage() {
		// TODO Auto-generated method stub
			List<Type_de_Voyage> Type_de_Voyage = new ArrayList<Type_de_Voyage>();
			Connection conn = DAOFACTORY.getConnection();
			try {
				PreparedStatement ps = conn.prepareStatement("SELECT distinct * from type_de_voyage ;");
				ResultSet rs = ps.executeQuery();
				while(rs.next()) {
					Type_de_Voyage v = new Type_de_Voyage();
					v.setId_typev(rs.getInt("id_typev"));
					v.setNom_typev(rs.getString("nom_typev"));//noms de la base de donnés
					

					Type_de_Voyage.add(v);	
				}
				ps.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			return Type_de_Voyage;
			}

	@Override
	public String ObtenirNomTypeV(int fk_idtypev) {
		// TODO Auto-generated method stub
				String nom=null;
				try {
					Connection connection = DAOFACTORY.getConnection();
					PreparedStatement ps= connection.prepareStatement("select * from type_de_voyage where id_typev = ?");
					ps.setInt(1, fk_idtypev);
					ResultSet rs = ps.executeQuery();
					if  (rs.next()) {
						nom=rs.getString("nom_typev");
						System.out.println(nom);
					}
				}
				catch (SQLException e) {
					 e.printStackTrace();
				}
				return nom;
	}
	@Override
	public List<Type_de_Voyage> liste_Type_de_Voyage1() {
		// TODO Auto-generated method stub
			List<Type_de_Voyage> Type_de_Voyage = new ArrayList<Type_de_Voyage>();
			Connection conn = DAOFACTORY.getConnection();
			try {
				PreparedStatement ps = conn.prepareStatement("select distinct B.* from  voyage T, type_de_voyage B where T.fk_id_typev = B.id_typev and T.date_depart >= ? ;");
				ps.setDate(1,new java.sql.Date(System.currentTimeMillis()));
				ResultSet rs = ps.executeQuery();
				while(rs.next()) {
					Type_de_Voyage v = new Type_de_Voyage();
					v.setId_typev(rs.getInt("id_typev"));
					v.setNom_typev(rs.getString("nom_typev"));//noms de la base de donnés
					

					Type_de_Voyage.add(v);	
				}
				ps.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			return Type_de_Voyage;
			}
	
	
	
	
	
	
	// select *
}
