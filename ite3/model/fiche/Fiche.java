package model.fiche;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/**
 * Interface des fiches des jeux
 * @author E12
 */
public interface Fiche {

	/**
	 * Retourne le type de la fiche
	 * @return Le type de la fiche
	 */
	String getType();
	
	int getNombreCategories();
	
	/**
	 * Reinitialise les valeurs des attributs de la fiche
	 */
	void reinitialiserAttributs();
	
	/**
	 * Ajoute une catégorie d'attribut dans la fiche
	 * @param ajout Catégorie à ajouter dans la fiche
	 */
	void ajouterCategorie(Categorie ajoute);
	
	/**
	 * Retire une des catégories de la fiche
	 * @param retrait Catégorie à retirer de la fiche 
	 */
	void retirerCategorie(Categorie retrait);
	
	/**
	 * Retourne un itérateur de la liste des catégories de la fiche
	 * @return Un itérateur de la liste des catégories de la fiche
	 */
	Iterator<Categorie> iteratorCategories();
	
	/**
	 * permet de renommer une fiche
	 */
	void setNomFiche(String nom);
	
	/**
	 * retourne le nom de la fiche
	 * @return le nom de la fiche
	 */
	String getNomFiche();
	
	/**
	 * 
	 * @return la liste des catégories
	 */
	ArrayList<Categorie> getCategories();

	/**
	 * réinitialise la liste des attributs
	 */
	void reinitialiser();
}
