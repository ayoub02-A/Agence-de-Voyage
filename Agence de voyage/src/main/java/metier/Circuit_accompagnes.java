package metier;

import java.io.InputStream;

import java.io.Serializable;
import java.sql.Blob;



public class Circuit_accompagnes implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int id_circuit;
	private String nom_circuit;
	private String email_circuit;
	private String tel_circuit;
	private String langues_circuit;
	private InputStream photo_circuit;
	private String description_circuit;
	private String base64Image;
	
	public Circuit_accompagnes() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Circuit_accompagnes(int id_circuit, String nom_circuit, String email_circuit, String tel_circuit,
			String langues_circuit, InputStream photo_circuit, String description_circuit) {
		super();
		this.id_circuit = id_circuit;
		this.nom_circuit = nom_circuit;
		this.email_circuit = email_circuit;
		this.tel_circuit = tel_circuit;
		this.langues_circuit = langues_circuit;
		this.photo_circuit = photo_circuit;
		this.description_circuit = description_circuit;
	}

	public int getId_circuit() {
		return id_circuit;
	}

	public void setId_circuit(int id_circuit) {
		this.id_circuit = id_circuit;
	}

	public String getNom_circuit() {
		return nom_circuit;
	}

	public void setNom_circuit(String nom_circuit) {
		this.nom_circuit = nom_circuit;
	}

	public String getEmail_circuit() {
		return email_circuit;
	}

	public void setEmail_circuit(String email_circuit) {
		this.email_circuit = email_circuit;
	}

	public String getTel_circuit() {
		return tel_circuit;
	}

	public void setTel_circuit(String tel_circuit) {
		this.tel_circuit = tel_circuit;
	}

	public String getLangues_circuit() {
		return langues_circuit;
	}

	public void setLangues_circuit(String langues_circuit) {
		this.langues_circuit = langues_circuit;
	}

	public InputStream getPhoto_circuit() {
		return photo_circuit;
	}

	public void setPhoto_circuit(InputStream photo_circuit) {
		this.photo_circuit = photo_circuit;
	}

	public String getDescription_circuit() {
		return description_circuit;
	}

	public void setDescription_circuit(String description_circuit) {
		this.description_circuit = description_circuit;
	}
	
	public String getBase64Image() {
		return base64Image;
	}

	public void setBase64Image(String base64Image) {
		this.base64Image = base64Image;
	}

	@Override
	public String toString() {
		return "circuit_accompagnes [id_circuit=" + id_circuit + ", nom_circuit=" + nom_circuit + ", email_circuit="
				+ email_circuit + ", tel_circuit=" + tel_circuit + ", langues_circuit=" + langues_circuit
				+" description_circuit=" + description_circuit + "]";
	}
	

}
