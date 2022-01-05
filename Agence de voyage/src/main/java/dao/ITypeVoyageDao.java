package dao;

import java.util.List;


import metier.Type_de_Voyage;

public interface ITypeVoyageDao {
	
	public void  addTypeVoyage(Type_de_Voyage T);
	public void deleteTypeVoyage(int id);
	public List<Type_de_Voyage> listeTypeVoyage();
	public Type_de_Voyage getType(int id);

}
