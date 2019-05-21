package model;

import java.util.Hashtable;
import java.util.List;
import java.util.Set;

import controller.recherche.Classeur;
import model.fiche.Categorie;
import model.fiche.Fiche;
import model.fiche.FicheBase;

public class Scenario {
	
	private String nom;
	private Jeu jeu;
	private Hashtable<String, Classeur<FicheBase>> classeurs = new Hashtable<>();
	private Fiche ficheCourante;
	
	public Scenario(String nom, Jeu jeu) {
		this.nom = nom;
		this.jeu = jeu;
    	for (String cle : this.jeu.getTypes()) {
    		ajouterFiche(cle);
    	}
	}
	
	public Fiche ajouterFiche(String type) {
		if (!this.classeurs.containsKey(type)) {
			this.classeurs.put(type, new Classeur<FicheBase>(type));
		}
    	FicheBase fiche = new FicheBase(type, "1");
    	List<Categorie> categories = this.jeu.getPatron(type);
	    for (Categorie categorie : categories) {
	    	fiche.ajouterCategorie(categorie);
	    }
	    this.classeurs.get(type).add(fiche);
	    return fiche;
	}
	
	public Jeu getJeu() {
		return this.jeu;
	}
	
	public void supprimerFicheCourante() {
		this.classeurs.get(this.ficheCourante.getType()).remove(this.ficheCourante);
	}
	
	public int nombreFiches(String type) {
		return this.classeurs.get(type).size();
	}
	
	public Fiche getFicheCourante() {
		return this.ficheCourante;
	}
	
	public Set<String> getTypes() {
		return this.classeurs.keySet();
	}
	
	public Classeur<FicheBase> getClasseur(String type) {
		return this.classeurs.get(type);
	}
    
    public void setFicheCourante(Fiche fiche) {
    	this.ficheCourante = fiche;
    }
    
    public String toString() {
    	return this.nom;
    }

}
