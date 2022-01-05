package dao;

import java.util.List;

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

}
