package dao;

import java.util.List;

import metier.Circuit_accompagnes;


public interface ICircuitAccompagnesAdmin {
	
	public void addCircuit(Circuit_accompagnes c);
	public List<Circuit_accompagnes> listeCircuit();
	public List<Circuit_accompagnes> listeCircuitAvailable();
	public void deleteCircuit(int id);
	public Circuit_accompagnes getCircuit(int id);
	public void updateCircuit(int id,Circuit_accompagnes c);

}
