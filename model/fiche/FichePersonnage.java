package model.fiche;

import java.util.List;
import model.Jeu;

public class FichePersonnage extends FicheBase {

	public FichePersonnage(Jeu jeu, String nom) {
		super(nom);
		List<Categorie> categories = jeu.getPatronPersonnage();
		for (Categorie categorie : categories) {
			ajouterCategorie(categorie);
		}
	}

}