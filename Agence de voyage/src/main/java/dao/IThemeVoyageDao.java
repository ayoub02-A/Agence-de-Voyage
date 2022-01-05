package dao;

import java.util.List;

import metier.Voyage_a_themes;



public interface IThemeVoyageDao {
	public void  addTheme(Voyage_a_themes T);
	public void deleteTheme(int id);
	public List<Voyage_a_themes> listeTheme();
	public Voyage_a_themes getTheme(int id);

}
