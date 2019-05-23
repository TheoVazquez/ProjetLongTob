package controller.menu;

import java.util.Iterator;

import controller.menu.commande.affichage.CommandeAfficherFiche;
import controller.menu.commande.ajout.CommandeAjouterCategorie;
import controller.menu.commande.modification.CommandeModifierNomFiche;
import model.Scenario;
import model.fiche.Categorie;
import model.fiche.Fiche;

public class MenuEditionFiche extends Menu {

	private Scenario scenario;
	private Fiche fiche;
	
	public MenuEditionFiche(String titre, Scenario scenario) {
		super(titre);
		this.scenario = scenario;
	}
	
	private void initialiser() {
		this.fiche = this.scenario.getFicheCourante();
		ajouter("Afficher la fiche", new CommandeAfficherFiche(scenario));
		ajouter("Modifier le nom de la fiche", new CommandeModifierNomFiche(fiche));
		ajouter("Ajouter une catégorie à la fiche", new CommandeAjouterCategorie(fiche));
		Iterator<Categorie> iterateur = fiche.iteratorCategories();
		Categorie categorie;
		while (iterateur.hasNext()) {
			categorie = iterateur.next();
			ajouter(categorie.getNom(), new MenuEditionCategorie("Modifier la catégorie", this.scenario, categorie, this.fiche));
		}
	}
	
	public void gerer() {
		do {
			initialiser();
			this.afficher();
			this.selectionner();
			this.valider();
			this.vider();
		} while (!estTermine());
	}
	
	@Override
	public boolean estExecutable() {
		return this.scenario.getFicheCourante() != null;
	}

}
