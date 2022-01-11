package metier;

import java.io.Serializable;

public class Contact implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int id_contact;
	private String nom;
	private String prenom;
	private String Email;
	private String message;
	
	
	
	public Contact() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Contact(int id_contact, String nom, String prenom, String email, String message) {
		super();
		this.id_contact = id_contact;
		this.nom = nom;
		this.prenom = prenom;
		Email = email;
		this.message = message;
	}


	public int getId_contact() {
		return id_contact;
	}


	public void setId_contact(int id_contact) {
		this.id_contact = id_contact;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public String getPrenom() {
		return prenom;
	}


	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}


	public String getEmail() {
		return Email;
	}


	public void setEmail(String email) {
		Email = email;
	}


	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}


	@Override
	public String toString() {
		return "Contact [id_contact=" + id_contact + ", nom=" + nom + ", prenom=" + prenom + ", Email=" + Email
				+ ", message=" + message + "]";
	}
	
	

	

}
