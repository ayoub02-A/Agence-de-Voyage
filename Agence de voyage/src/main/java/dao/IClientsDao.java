package dao;

import metier.Clients;
import metier.Voyage;

import java.util.*;


public interface IClientsDao {
	public List<Clients> ClientsParMC(String mc);
	public void deleteClients(int id);
	public List<Clients> listeClients();
	public List<Voyage> Panier(int id);

}
