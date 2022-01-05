package metier;

import java.io.InputStream;




import java.io.Serializable;

import java.sql.Date;

public class Voyage implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private int id_voyage;
	private String nom_voyage;
	private String destination;
	private String duree;
	private Date date_depart;
	private float budget;
	private int nbr_participant;
	private float prix;
	private int fk_id_circuit;
	private int fk_id_typev;
	private int fk_id_heberg;
	private int fk_id_vtheme;
	private InputStream photo_voyage;
	private String Base64Image;
	private int nbrPlace;
	
	public Voyage() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Voyage(int id_voyage, String nom_voyage, String destination, String duree, Date date_depart, float budget,
			int nbr_participant, float prix, int fk_id_circuit, int fk_id_typev, int fk_id_heberg, int fk_id_vtheme
			,InputStream photo_voyage) {
		super();
		this.id_voyage = id_voyage;
		this.nom_voyage = nom_voyage;
		this.destination = destination;
		this.duree = duree;
		this.date_depart = date_depart;
		this.budget = budget;
		this.nbr_participant = nbr_participant;
		this.prix = prix;
		this.fk_id_circuit = fk_id_circuit;
		this.fk_id_typev = fk_id_typev;
		this.fk_id_heberg = fk_id_heberg;
		this.fk_id_vtheme = fk_id_vtheme;
		this.photo_voyage= photo_voyage;
	}

	
	public int getId_voyage() {
		return id_voyage;
	}

	public void setId_voyage(int id_voyage) {
		this.id_voyage = id_voyage;
	}

	public String getNom_voyage() {
		return nom_voyage;
	}

	public void setNom_voyage(String nom_voyage) {
		this.nom_voyage = nom_voyage;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getDuree() {
		return duree;
	}

	public void setDuree(String duree) {
		this.duree = duree;
	}

	public Date getDate_depart() {
		return date_depart;
	}

	public void setDate_depart(Date date_depart) {
		this.date_depart = date_depart;
	}

	public float getBudget() {
		return budget;
	}

	public void setBudget(float budget) {
		this.budget = budget;
	}

	public int getNbr_participant() {
		return nbr_participant;
	}

	public void setNbr_participant(int nbr_participant) {
		this.nbr_participant = nbr_participant;
	}

	public float getPrix() {
		return prix;
	}

	public void setPrix(float prix) {
		this.prix = prix;
	}

	public int getFk_id_circuit() {
		return fk_id_circuit;
	}

	public void setFk_id_circuit(int fk_id_circuit) {
		this.fk_id_circuit = fk_id_circuit;
	}

	public int getFk_id_typev() {
		return fk_id_typev;
	}

	public void setFk_id_typev(int fk_id_typev) {
		this.fk_id_typev = fk_id_typev;
	}

	public int getFk_id_heberg() {
		return fk_id_heberg;
	}

	public void setFk_id_heberg(int fk_id_heberg) {
		this.fk_id_heberg = fk_id_heberg;
	}

	public int getFk_id_vtheme() {
		return fk_id_vtheme;
	}

	public void setFk_id_vtheme(int fk_id_vtheme) {
		this.fk_id_vtheme = fk_id_vtheme;
	}

	public InputStream getPhoto_voyage() {
		return photo_voyage;
	}

	public void setPhoto_voyage(InputStream photo_voyage) {
		this.photo_voyage = photo_voyage;
	}

	
	
	public String getBase64Image() {
		return Base64Image;
	}

	public void setBase64Image(String base64Image) {
		Base64Image = base64Image;
	}
	
	

	public int getNbrPlace() {
		return nbrPlace;
	}

	public void setNbrPlace(int nbrPlace) {
		this.nbrPlace = nbrPlace;
	}

	@Override
	public String toString() {
		return "Voyage [id_voyage=" + id_voyage + ", nom_voyage=" + nom_voyage + ", destination=" + destination
				+ ", duree=" + duree + ", date_depart=" + date_depart + ", budget=" + budget + ", nbr_participant="
				+ nbr_participant + ", prix=" + prix + ", fk_id_circuit=" + fk_id_circuit + ", fk_id_typev="
				+ fk_id_typev + ", fk_id_heberg=" + fk_id_heberg + ", fk_id_vtheme=" + fk_id_vtheme + ", photo_voyage="
				+ photo_voyage + ", Base64Image=" + Base64Image + ", nbrPlace=" + nbrPlace + "]";
	}
	

}
