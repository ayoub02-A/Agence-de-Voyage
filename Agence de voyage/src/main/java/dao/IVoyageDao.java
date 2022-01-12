package dao;

import java.util.List;

import metier.Clients;
import metier.Voyage;

public interface IVoyageDao {
	
	public void addVoyage(Voyage v);
	public List<Voyage> listeVoyage();
	public List<Voyage> listeVoyageExpir();
	public List<String> listeVoyagDest();
	public List<Voyage> listeVoyageParDEst(String dest);
	public List<Voyage> listeVoyageParDate(String date);
	public List<Voyage> listeVoyageParTheme(String idtheme);
	public List<Voyage> listeVoyageParType(String idtype);
	public int nbrPlace(int idVoyage);
	public Voyage getVoyage(int id);
	public void updateVoyage(int id,Voyage v);
	public void deleteVoyage(int id);
	public List<Voyage> listeVoyageParCircuit(int idCircuit);
	public List<Voyage> listeVoyageParCircuitExpirer(int idCircuit);
	public List<Clients> listeParticipants(int idVoyage); 
	public int nbrClient();
	public int nbrVoyage();
	public int nbrCircuit();
	public int nbrTheme();
	public int nbrType();
	public int nbrHeberg();
	
	
	
	public List<Voyage> liste_Voyage();
	public List<Voyage> liste_Voyage_TypeVoyage(int fk_idtypev);
	public List<Voyage> liste_VoyagePanier(int idClient);
	
	public List<Voyage> chercherVoyage(Voyage v) ;
	public List<Voyage> liste_Voyage_Theme(int fk_idthemev);
	public List<Voyage> liste_Voyage_Hebergement(int fk_idheberv);
	public List<Voyage> liste_Voyage(int id_Voyage);
	//Voyage getVoyage(int id_voyage);
	Voyage rejoindreVoyage(int id_voyage, int id_Client);
	List<Voyage> liste_VoyageConfirmer(int idClient);
	public List<Voyage> chercherVoyage(Voyage v, String budget,String type) ;
	

}
