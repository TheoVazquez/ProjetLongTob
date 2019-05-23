package model.fiche;

import java.util.List;

import model.Jeu;

public class FicheLieu extends FicheBase {

	public FicheLieu(Jeu jeu, String nom) {
		super(nom);
		List<Categorie> categories = jeu.getPatronLieu();
		for (Categorie categorie : categories) {
			ajouterCategorie(categorie);
		}
	}

}
