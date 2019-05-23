package IHM;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * 
 * @author Theo
 *Un jeu contient les paramètres par défaut. Il faut le voir comme une sorte de patron qui servira de modèle pour la création de fiche par exemple.
 */
public interface Jeu {
	
	/**Permet de charger la liste des composants pour un personnage**/
	HashMap<String, String> chargerComposantPersonnage();

	/**Permet de charger la liste des composants pour un lieu**/
	HashMap<String, String> chargerComposantLieu();
}
