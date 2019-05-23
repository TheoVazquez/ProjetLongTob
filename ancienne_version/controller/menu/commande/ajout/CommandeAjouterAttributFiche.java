package controller.menu.commande.ajout;

import java.util.Scanner;

import controller.menu.Commande;
import controller.menu.Menu;
import controller.menu.MenuSelection;
import controller.menu.commande.CommandeRechercherFiche;
import model.Scenario;
import model.fiche.Categorie;
import model.fiche.Fiche;
import model.fiche.attribut.Attribut;
import model.fiche.attribut.ValeurFiche;
import model.fiche.attribut.ValeurInt;

public class CommandeAjouterAttributFiche implements Commande {

	private Categorie conteneurPere;
	private Scenario scenario;

	public CommandeAjouterAttributFiche(Categorie conteneurPere, Scenario scenario) {
		this.conteneurPere = conteneurPere;
		this.scenario = scenario;
	}

	@Override
	public void executer() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Entrer le nom du nouvel attribut : ");
		String nom = scan.next();
		Menu menuAjouterAttributFiche = new Menu("Ajouter un attribut fiche");
		menuAjouterAttributFiche.ajouter("Rechercher une fiche du sc�nario", new CommandeRechercherFiche(scenario));
		menuAjouterAttributFiche.ajouter("Selectionner une fiche du sc�nario", new MenuSelection("Selectionner une fiche du sc�nario", scenario));
		menuAjouterAttributFiche.gerer();
		Fiche valeur = this.scenario.getFicheCourante();
		this.conteneurPere.ajouterAttribut(new Attribut(nom, new ValeurFiche(valeur)));
	}

	@Override
	public boolean estExecutable() {
		return true;
	}

}