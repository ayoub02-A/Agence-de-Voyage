package metier;

import java.io.Serializable;
import java.sql.Date;

public class Panier implements Serializable{

	private static final long serialVersionUID = 1L;
	
	
	private int fk_id_client;
	private int fk_id_voyage;
	private Date date_ajoutpanier;
	private boolean voyage_confirme;
	
	public Panier() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Panier(int fk_id_client, int fk_id_voyage, Date date_ajoutpanier, boolean voyage_confirme) {
		super();
		this.fk_id_client = fk_id_client;
		this.fk_id_voyage = fk_id_voyage;
		this.date_ajoutpanier = date_ajoutpanier;
		this.voyage_confirme = voyage_confirme;
	}

	public int getFk_id_client() {
		return fk_id_client;
	}

	public void setFk_id_client(int fk_id_client) {
		this.fk_id_client = fk_id_client;
	}

	public int getFk_id_voyage() {
		return fk_id_voyage;
	}

	public void setFk_id_voyage(int fk_id_voyage) {
		this.fk_id_voyage = fk_id_voyage;
	}

	public Date getDate_ajoutpanier() {
		return date_ajoutpanier;
	}

	public void setDate_ajoutpanier(Date date_ajoutpanier) {
		this.date_ajoutpanier = date_ajoutpanier;
	}

	public boolean isVoyage_confirme() {
		return voyage_confirme;
	}

	public void setVoyage_confirme(boolean voyage_confirme) {
		this.voyage_confirme = voyage_confirme;
	}

	@Override
	public String toString() {
		return "Panier [fk_id_client=" + fk_id_client + ", fk_id_voyage=" + fk_id_voyage + ", date_ajoutpanier="
				+ date_ajoutpanier + ", voyage_confirme=" + voyage_confirme + "]";
	}
		
	
}
