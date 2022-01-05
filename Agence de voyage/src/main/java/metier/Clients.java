package metier;

import java.io.Serializable;

public class Clients implements Serializable{

	private static final long serialVersionUID = 1L;
	private int id_client;
	private String nom_client;
	private String prenom_client;
	private String mdp_client;
	private String email_client;
	private String tel_client;
	
	
	public Clients() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Clients(int id_client, String nom_client, String prenom_client, String mdp_client, String email_client,
			String tel_client) {
		super();
		this.id_client = id_client;
		this.nom_client = nom_client;
		this.prenom_client = prenom_client;
		this.mdp_client = mdp_client;
		this.email_client = email_client;
		this.tel_client = tel_client;
	}


	public int getId_client() {
		return id_client;
	}


	public void setId_client(int id_client) {
		this.id_client = id_client;
	}


	public String getNom_client() {
		return nom_client;
	}


	public void setNom_client(String nom_client) {
		this.nom_client = nom_client;
	}


	public String getPrenom_client() {
		return prenom_client;
	}


	public void setPrenom_client(String prenom_client) {
		this.prenom_client = prenom_client;
	}


	public String getMdp_client() {
		return mdp_client;
	}


	public void setMdp_client(String mdp_client) {
		this.mdp_client = mdp_client;
	}


	public String getEmail_client() {
		return email_client;
	}


	public void setEmail_client(String email_client) {
		this.email_client = email_client;
	}


	public String getTel_client() {
		return tel_client;
	}


	public void setTel_client(String tel_client) {
		this.tel_client = tel_client;
	}



	@Override
	public String toString() {
		return "clients [id_client=" + id_client + ", nom_client=" + nom_client + ", prenom_client=" + prenom_client
				+ ", mdp_client=" + mdp_client + ", email_client=" + email_client + ", tel_client=" + tel_client + "]";
	}
	

}
