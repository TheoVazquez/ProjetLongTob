package model;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Set;

import model.fiche.Categorie;
import model.fiche.attribut.Attribut;

/**
 * 
 */
public class JeuCthulhu implements Jeu {

	private Hashtable<String, List<Categorie>> patrons = new Hashtable<>();
	
	/**
	 * Création du sytême de jeu issu du JDR Cthulhu
	 */
	public JeuCthulhu() {
		ArrayList<Categorie> personnage = new ArrayList<>();
		Categorie categoriePersonnage = new Categorie("Identité");
		categoriePersonnage.ajouterAttributString(new Attribut<String>("Nom", ""));
		categoriePersonnage.ajouterAttributString(new Attribut<String>("Prénom", ""));
		personnage.add(categoriePersonnage);
		categoriePersonnage = new Categorie("Caractéristiques");
		categoriePersonnage.ajouterAttributInteger(new Attribut<Integer>("FOR", 0));
		categoriePersonnage.ajouterAttributInteger(new Attribut<Integer>("DEX", 0));
		categoriePersonnage.ajouterAttributInteger(new Attribut<Integer>("POU", 0));
		categoriePersonnage.ajouterAttributInteger(new Attribut<Integer>("CON", 0));
		categoriePersonnage.ajouterAttributInteger(new Attribut<Integer>("APP", 0));
		categoriePersonnage.ajouterAttributInteger(new Attribut<Integer>("EDU", 0));
		categoriePersonnage.ajouterAttributInteger(new Attribut<Integer>("TAI", 0));
		categoriePersonnage.ajouterAttributInteger(new Attribut<Integer>("INT", 0));
		categoriePersonnage.ajouterAttributInteger(new Attribut<Integer>("MVT", 0));	
		personnage.add(categoriePersonnage);
		this.patrons.put("Personnage", personnage);
		ArrayList<Categorie> lieu = new ArrayList<>();
		Categorie categorieLieu = new Categorie("Description du lieu");
		categorieLieu.ajouterAttributString(new Attribut<String>("Nom", ""));
		categorieLieu.ajouterAttributString(new Attribut<String>("Description", ""));
		lieu.add(categorieLieu);
		this.patrons.put("Lieu", lieu);
	}
	
	@Override
	public List<Categorie> getPatron(String type) {
		return this.patrons.get(type);
	}

	@Override
	public Set<String> getTypes() {
		return this.patrons.keySet();
	}
	
}
