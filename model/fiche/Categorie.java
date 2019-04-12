package model.fiche;

import java.util.ArrayList;
import java.util.Iterator;

import model.fiche.attribut.Attribut;

public class Categorie extends FicheBase{
	
	private ArrayList<Attribut> attributs;
	
	public Categorie(String nom) {
		super(nom);
		this.attributs = new ArrayList<>();
	}
	
	public void ajouterAttribut(Attribut ajout) {
		this.attributs.add(ajout);
	}
	
	public Iterator<Attribut> iteratorAttributs() {
		return this.attributs.iterator();
	}
	
	public void supprimerAttribut(Attribut attribut) {
		this.attributs.remove(attribut);
	}
	
	public String toString() {
		StringBuilder description = new StringBuilder();
		description.append("--------------------------------------------\n");
		description.append(getNom() + "\n");
		for (Attribut attribut : this.attributs) {
			description.append(attribut.toString() + "\n");
		}
		Iterator<Categorie> iterateur = iteratorCategories();
		while (iterateur.hasNext()) {
			description.append(iterateur.next().toString());
		}
		description.append("--------------------------------------------\n");
		return description.toString();
	}

}
