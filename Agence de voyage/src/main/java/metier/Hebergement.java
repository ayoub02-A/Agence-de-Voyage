package metier;

import java.io.Serializable;

public class Hebergement implements Serializable{


	private static final long serialVersionUID = 1L;
	
	private int id_heberg;
	private String nom_heberg;
	
	public Hebergement() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Hebergement(int id_heberg, String nom_heberg) {
		super();
		this.id_heberg = id_heberg;
		this.nom_heberg = nom_heberg;
	}

	public int getId_heberg() {
		return id_heberg;
	}

	public void setId_heberg(int id_heberg) {
		this.id_heberg = id_heberg;
	}

	public String getNom_heberg() {
		return nom_heberg;
	}

	public void setNom_heberg(String nom_heberg) {
		this.nom_heberg = nom_heberg;
	}

	@Override
	public String toString() {
		return "hebergement [id_heberg=" + id_heberg + ", nom_heberg=" + nom_heberg + "]";
	}
	
}
