package controller.menu;

import java.util.Iterator;

import controller.menu.commande.CommandeRechercherFiche;
import controller.menu.commande.affichage.CommandeAfficherCategorie;
import controller.menu.commande.ajout.CommandeAjouterAttributEntier;
import controller.menu.commande.ajout.CommandeAjouterAttributFiche;
import controller.menu.commande.ajout.CommandeAjouterAttributTexte;
import controller.menu.commande.ajout.CommandeAjouterCategorie;
import controller.menu.commande.ajout.CommandeAjouterFicheLieu;
import controller.menu.commande.ajout.CommandeAjouterFichePersonnage;
import controller.menu.commande.modification.CommandeModifierAttribut;
import controller.menu.commande.modification.CommandeModifierNomFiche;
import controller.menu.commande.suppression.CommandeSupprimerCategorie;
import model.Scenario;
import model.fiche.Categorie;
import model.fiche.Fiche;
import model.fiche.attribut.Attribut;

public class MenuEditionCategorie extends Menu {

	private Scenario scenario;
	private Categorie categorie;
	private Fiche conteneurPere;
	private ConditionArret etat;
	
	public MenuEditionCategorie(String titre, Scenario scenario, Categorie categorie, Fiche conteneurPere) {
		super(titre);
		this.scenario = scenario;
		this.categorie = categorie;
		this.conteneurPere = conteneurPere;
		this.etat = new ConditionArret();
	}
	
	private void initialiser() {
		ajouter("Afficher la catégorie", new CommandeAfficherCategorie(this.categorie));
		ajouter("Modifier le nom de la catégorie", new CommandeModifierNomFiche(this.categorie));
		ajouter("Supprimer la catégorie", new CommandeSupprimerCategorie(this.categorie, this.conteneurPere, this.etat));
		Menu menuAjouterAttribut = new Menu("Ajouter un attribut");
		menuAjouterAttribut.ajouter("Ajouter un attribut entier", new CommandeAjouterAttributEntier(this.categorie));
		menuAjouterAttribut.ajouter("Ajouter un attribut texte", new CommandeAjouterAttributTexte(this.categorie));
		menuAjouterAttribut.ajouter("Ajouter un attribut fiche", new CommandeAjouterAttributFiche(this.categorie, this.scenario));
		ajouter("Ajouter un attribut", menuAjouterAttribut);
		Iterator<Attribut> iterateurAttribut = categorie.iteratorAttributs();
		Attribut attributCourant;
		while (iterateurAttribut.hasNext()) {
			attributCourant = iterateurAttribut.next();
			ajouter(attributCourant.toString(), new MenuEditionAttribut(attributCourant.toString(), this.scenario, attributCourant, this.categorie));
		}
		ajouter("Ajouter une sous-catégorie", new CommandeAjouterCategorie(this.categorie));
		Iterator<Categorie> iterateurCategorie = categorie.iteratorCategories();
		Categorie categorieCourante;
		while (iterateurCategorie.hasNext()) {
			categorieCourante = iterateurCategorie.next();
			ajouter(categorieCourante.getType(), new MenuEditionCategorie("Modifier la catégorie", this.scenario, categorieCourante, this.categorie));
		}
	}
	
	public void gerer() {
		do {
			initialiser();
			this.afficher();
			this.selectionner();
			this.valider();
			this.vider();
		} while (!estTermine() && !this.etat.estArrete());
	}

	@Override
	public boolean estExecutable() {
		return true;
	}

}
