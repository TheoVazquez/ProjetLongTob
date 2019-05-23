package model;

import java.util.ArrayList;
import java.util.List;

import model.fiche.Categorie;
import model.fiche.attribut.Attribut;
import model.fiche.attribut.ValeurInt;
import model.fiche.attribut.ValeurString;

/**
 * 
 */
public class JeuCthulhu implements Jeu {

	private List<Categorie> categoriesPersonnage;
	private List<Categorie> categoriesLieu;
	

	/**
	 * CrÃ©ation du sytÃªme de jeu issu du JDR Cthulhu
	 */
	public JeuCthulhu() {
		this.categoriesPersonnage = new ArrayList<>();
		Categorie categoriePersonnage = new Categorie("Identité");
		categoriePersonnage.ajouterAttribut(new Attribut("Nom", new ValeurString("")));
		categoriePersonnage.ajouterAttribut(new Attribut("Prénom", new ValeurString("")));
		categoriePersonnage = new Categorie("Caractéristiques");
		categoriePersonnage.ajouterAttribut(new Attribut("FOR", new ValeurInt(0)));
		categoriePersonnage.ajouterAttribut(new Attribut("DEX", new ValeurInt(0)));
		categoriePersonnage.ajouterAttribut(new Attribut("POU", new ValeurInt(0)));
		categoriePersonnage.ajouterAttribut(new Attribut("CON", new ValeurInt(0)));
		categoriePersonnage.ajouterAttribut(new Attribut("APP", new ValeurInt(0)));
		categoriePersonnage.ajouterAttribut(new Attribut("EDU", new ValeurInt(0)));
		categoriePersonnage.ajouterAttribut(new Attribut("TAI", new ValeurInt(0)));
		categoriePersonnage.ajouterAttribut(new Attribut("INT", new ValeurInt(0)));
		categoriePersonnage.ajouterAttribut(new Attribut("MVT", new ValeurInt(0)));	
		this.categoriesPersonnage.add(categoriePersonnage);
		this.categoriesLieu = new ArrayList<>();
		Categorie categorieLieu = new Categorie("Description de lieu");
		categorieLieu.ajouterAttribut(new Attribut("Nom", new ValeurString("")));
		categorieLieu.ajouterAttribut(new Attribut("Description", new ValeurString("")));
		this.categoriesLieu.add(categorieLieu);
	}
	
	@Override
	public List<Categorie> getPatronPersonnage() {
		return this.categoriesPersonnage;
	}
	
	@Override
	public List<Categorie> getPatronLieu() {
		return this.categoriesLieu;
	}
	
}
