package model;

import java.util.List;
import model.fiche.Categorie;

/**
 * @author theo
 * Interface de Jeu, chaque jeu ayant ses propres règles
 */
public interface Jeu {
	
	/**
	 * Retourne les attributs de bases du jeu
	 */
	List<Categorie> getPatronPersonnage();
	
	List<Categorie> getPatronLieu();
	
}
