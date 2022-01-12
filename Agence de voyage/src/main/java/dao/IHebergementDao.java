package dao;

import java.util.List;

import metier.Hebergement;



public interface IHebergementDao {
	public void  addHebergement(Hebergement h);
	public void deleteHebergement(int id);
	public List<Hebergement> listeHebergement();
	public Hebergement getHeberg(int id);
	public List<Hebergement> list_Hebergement() ;
	public String ObtenirNomHeberg(int fk_idhebergement);
}
