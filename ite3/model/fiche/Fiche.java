package model.fiche;

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

}
