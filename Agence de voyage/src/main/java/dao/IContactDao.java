package dao;

import java.util.List;

import metier.Contact;

public interface IContactDao {
	public int nbrMessage();
	public List<Contact> Nonvue();
	public List<Contact> Vue();
	public void setVue(int id);
	public Contact getMessage(int id);
	public void removeMessage(int id);
}
