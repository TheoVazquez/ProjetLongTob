import java.util.ArrayList;
import java.util.HashMap;

/**
 * 
 * Une fiche contenant les caractéristiques d'un lieu
 *
 */
public class FicheLieu implements Fiche {
	String type;
	String nomFiche; // Le nom de la fiche
	HashMap<String, String> listeComposant;
	
	public FicheLieu(String nom, Jeu jeu) {
		/**
		 * A la création, on donne un nom à la fiche et on charge le jeu qui servira de patron
		 */
		this.type = "fiche lieu";
		this.nomFiche = nom;
		this.listeComposant = jeu.chargerComposantLieu();
	}
	
	/**
	 * Permet l'affichage du nom de la fiche dans l'interface graphique 
	 */
	@Override
	public String toString() {
		return this.nomFiche;
	}

	@Override
	public HashMap<String, String> getComposants() {
		return this.listeComposant;
	}
}