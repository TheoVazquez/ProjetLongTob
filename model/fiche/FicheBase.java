package model.fiche;

import java.util.ArrayList;
import java.util.Iterator;

public abstract class FicheBase implements Fiche {

	private String nom;
	private ArrayList<Categorie> categories;
	
	public FicheBase(String nom) {
		this.nom = nom;
		this.categories = new ArrayList<>();
	}
	
	public String getNom() {
		return this.nom;
	}
	
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public void ajouterCategorie(Categorie ajout) {
		this.categories.add(ajout);
	}
	
	public void supprimerCategorie(Categorie categorie) {
		this.categories.remove(categorie);
	}
	
	public Iterator<Categorie> iteratorCategories() {
		return this.categories.iterator();
	}
	
	public String toString() {
		StringBuilder description = new StringBuilder();
		description.append("==========================================================================\n");
		description.append(this.nom + "\n");
		for (Categorie categorie : this.categories) {
			description.append(categorie.toString());
		}
		description.append("==========================================================================\n");
		return description.toString();
	}

}
