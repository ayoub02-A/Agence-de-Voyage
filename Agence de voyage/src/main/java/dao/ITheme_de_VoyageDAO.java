package dao;



import java.util.List;
import metier.Voyage_a_themes;

public interface ITheme_de_VoyageDAO {
	
	public List<Voyage_a_themes> list_Themes_de_Voyage() ;
	public String ObtenirNomThemeV(int fk_idthemev);

}
