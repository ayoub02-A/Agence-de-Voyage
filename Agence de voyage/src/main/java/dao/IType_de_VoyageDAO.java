package dao;

import java.util.List;
import metier.Type_de_Voyage;

public interface IType_de_VoyageDAO {
	
	public List<Type_de_Voyage> liste_Type_de_Voyage();
	public String ObtenirNomTypeV(int fk_idtypev);
	List<Type_de_Voyage> liste_Type_de_Voyage1();
	

	//une methode qui obtient comme parametre l id du type de voyage recuperé qui est foreign key  et nous donne son nom
}
