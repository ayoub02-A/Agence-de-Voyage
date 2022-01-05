package metier;

import java.io.Serializable;

public class Voyage_a_themes implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private int id_vtheme;
	private String nom_theme;
	
	public Voyage_a_themes() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Voyage_a_themes(int id_vtheme, String nom_theme) {
		super();
		this.id_vtheme = id_vtheme;
		this.nom_theme = nom_theme;
	}

	public int getId_vtheme() {
		return id_vtheme;
	}

	public void setId_vtheme(int id_vtheme) {
		this.id_vtheme = id_vtheme;
	}

	public String getNom_theme() {
		return nom_theme;
	}

	public void setNom_theme(String nom_theme) {
		this.nom_theme = nom_theme;
	}

	@Override
	public String toString() {
		return "voyage_a_themes [id_vtheme=" + id_vtheme + ", nom_theme=" + nom_theme + "]";
	}

	

}
