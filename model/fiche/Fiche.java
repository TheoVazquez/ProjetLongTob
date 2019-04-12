package model.fiche;

import java.util.Iterator;

public interface Fiche {

	
	String getNom();
	
	void setNom(String nom);
	
	void ajouterCategorie(Categorie ajout);
	
	Iterator<Categorie> iteratorCategories();
	
	void supprimerCategorie(Categorie categorie);
	
}
