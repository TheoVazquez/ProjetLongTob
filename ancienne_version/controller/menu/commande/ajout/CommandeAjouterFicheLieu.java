package controller.menu.commande.ajout;

import java.util.Scanner;

import controller.menu.Commande;
import model.Jeu;
import model.Scenario;
import model.fiche.FicheLieu;

public class CommandeAjouterFicheLieu implements Commande {

	private Jeu jeu;
	private Scenario scenario;
	
	public CommandeAjouterFicheLieu(Jeu jeu, Scenario scenario) {
		this.jeu = jeu;
		this.scenario = scenario;
	}
	
	@Override
	public void executer() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Entrer le nom de la nouvelle fiche lieu : ");
		this.scenario.ajouterLieu(new FicheLieu(this.jeu, scan.next()));
	}

	@Override
	public boolean estExecutable() {
		return true;
	}

}
