package model.fiche;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;

/**
 * Classe de base des fiches des jeux
 * @author E12
 */
public class FicheBase implements Fiche {

	/**
	 * Type de la fiche
	 */
	private String type;
	
	private String nomFiche;
	
	/**
	 * Liste des catégories de la fiche
	 */
	private ArrayList<Categorie> categories;

	/**
	 * Constructeur de fiche de base
	 * @param type Type de la fiche
	 */
	public FicheBase(String type, String nomFiche) {
		this.type = type;
		this.nomFiche = nomFiche;
		this.categories = new ArrayList<>();
	}
	
	/**
	 * Retourne le type de la fiche
	 * @return Le type de la fiche
	 */
	public String getType() {
		return this.type;
	}
	
	public int getNombreCategories() {
		return this.categories.size();
	}
	
	public void setNomFiche(String nom) {
		this.nomFiche = nom;
	}
	
	/**
	 * Reinitialise les valeurs des attributs de la fiche
	 */
	public void reinitialiserAttributs() {
		for (Categorie categorie : this.categories)
			categorie.reinitialiserAttributs();
	}
	
	/**
	 * Ajoute une catégorie d'attribut dans la fiche
	 * @param ajout Catégorie à ajouter dans la fiche
	 */
	public void ajouterCategorie(Categorie ajout) {
		this.categories.add(ajout);
	}
	
	/**
	 * Retire une des catégories de la fiche
	 * @param retrait Catégorie à retirer de la fiche 
	 */
	public void retirerCategorie(Categorie retrait) {
		this.categories.remove(retrait);
	}
	
	/**
	 * Retourne un itérateur de la liste des catégories de la fiche
	 * @return Un itérateur de la liste des catégories de la fiche
	 */
	public Iterator<Categorie> iteratorCategories() {
		return this.categories.iterator();
	}
	
	public String toString() {
		return "Fiche " + this.type + " : " + this.nomFiche;
	}
	
}
