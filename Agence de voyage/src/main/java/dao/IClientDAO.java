package dao;

import java.util.List;

import metier.Clients;


public interface IClientDAO {

	
	public boolean login(String login, String pwd);
	public void Inscription(Clients p);
	public Clients getClients(String login, String pwd);
	public List<Clients> getClient(int id)  ;
	public Clients getClient1(int id)  ;
	public void modifierClientProfil(int cptUser, Clients u);
	void Contact(String nom, String prenom, String email, String message);
	public List<String> EmailsRegistration();
}
