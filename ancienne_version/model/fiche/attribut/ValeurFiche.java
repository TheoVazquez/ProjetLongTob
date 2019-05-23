package model.fiche.attribut;

import java.util.Scanner;

import controller.menu.Menu;
import controller.menu.MenuSelection;
import controller.menu.commande.CommandeRechercherFiche;
import model.Scenario;
import model.fiche.Fiche;

public class ValeurFiche implements Valeur {

	private Scenario scenario;
	private Fiche donnee;
	
	public ValeurFiche(Fiche donnee) {
		this.donnee = donnee;
	}
	
	@Override
	public ValeurFiche copier() {
		return new ValeurFiche(this.donnee);
	}

	@Override
	public void modifier() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Choisissez la nouvelle valeur : ");
		Menu menuAjouterAttributFiche = new Menu("Choisir un attribut fiche");
		menuAjouterAttributFiche.ajouter("Rechercher une fiche du scénario", new CommandeRechercherFiche(scenario));
		menuAjouterAttributFiche.ajouter("Selectionner une fiche du scénario", new MenuSelection("Selectionner une fiche du scénario", scenario));
		menuAjouterAttributFiche.gerer();
		this.donnee = this.scenario.getFicheCourante();
	}
	
	public String toString() {
		return this.donnee.toString();
	}

}