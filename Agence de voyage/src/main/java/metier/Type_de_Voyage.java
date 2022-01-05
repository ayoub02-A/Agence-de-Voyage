package metier;

import java.io.Serializable;

public class Type_de_Voyage implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private int id_typev;
	private String nom_typev;
	
	public Type_de_Voyage() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Type_de_Voyage(int id_typev, String nom_typev) {
		super();
		this.id_typev = id_typev;
		this.nom_typev = nom_typev;
	}

	public int getId_typev() {
		return id_typev;
	}

	public void setId_typev(int id_typev) {
		this.id_typev = id_typev;
	}

	public String getNom_typev() {
		return nom_typev;
	}

	public void setNom_typev(String nom_typev) {
		this.nom_typev = nom_typev;
	}

	@Override
	public String toString() {
		return "Type_de_Voyage [id_typev=" + id_typev + ", nom_typev=" + nom_typev + "]";
	}
	

}
