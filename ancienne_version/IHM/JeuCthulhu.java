package IHM;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 * 
 * adaptation de l'appel de Cthulhu
 *
 */
public class JeuCthulhu implements Jeu {

	/**J'utilise des linked map pour conserver l'ordre**/
	@Override
	public HashMap<String, String> chargerComposantPersonnage() {
		LinkedHashMap<String, String> composantsPersonnage = new LinkedHashMap<String, String>();
		composantsPersonnage.put("Nom", null);
		composantsPersonnage.put("Prénom", null);
		composantsPersonnage.put("FOR", "0");
		composantsPersonnage.put("DEX", "0");
		composantsPersonnage.put("POU", "0");
		composantsPersonnage.put("CON", "0");
		composantsPersonnage.put("APP", "0");
		composantsPersonnage.put("EDU", "0");
		composantsPersonnage.put("TAI", "0");
		composantsPersonnage.put("INT", "0");
		composantsPersonnage.put("MVT", "0");
		return composantsPersonnage;
	}

	@Override
	public HashMap<String, String> chargerComposantLieu() {
		LinkedHashMap<String, String> composantLieu = new LinkedHashMap<String, String>();
		composantLieu.put("Nom", null);
		composantLieu.put("Description", null);
		return composantLieu;
	}

}
