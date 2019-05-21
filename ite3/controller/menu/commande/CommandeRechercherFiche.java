package controller.menu.commande;

import java.util.Scanner;

import controller.menu.Commande;
import controller.recherche.ClassifieurNom;
import model.Scenario;
import model.fiche.Fiche;

public class CommandeRechercherFiche implements Commande {

	private Scenario scenario;
	
	public CommandeRechercherFiche(Scenario scenario) {
		this.scenario = scenario;
	}

	@Override
	public void executer() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Entrer le nom de la fiche à rechercher : ");
		ClassifieurNom recherche = new ClassifieurNom();
		recherche.setComparateur(scan.next());
		Fiche fiche = this.scenario.getListeLieux().rechercherPremier(recherche);
		if (fiche == null)
			fiche = this.scenario.getListePersonnage().rechercherPremier(recherche);
		if (fiche != null) {
			this.scenario.setFicheCourante(fiche);
			System.out.println(fiche);
		}
	}

	@Override
	public boolean estExecutable() {
		return this.scenario.nombreFiches() > 0;
	}

}
