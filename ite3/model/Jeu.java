package model;

import java.util.List;
import java.util.Set;
import model.fiche.Categorie;

/**
 * @author theo
 * Interface de Jeu, chaque jeu ayant ses propres règles
 */
public interface Jeu {
	
	
	Set<String> getTypes();
	
	/**
	 * Retourne les attributs de bases du jeu
	 */
	List<Categorie> getPatron(String type);
	
}
