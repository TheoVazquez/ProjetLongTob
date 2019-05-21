package controller.menu.commande.ajout;

import java.util.Scanner;

import controller.menu.Commande;
import model.Jeu;
import model.Scenario;
import model.fiche.FichePersonnage;

public class CommandeAjouterFichePersonnage implements Commande {

	private Jeu jeu;
	private Scenario scenario;
	
	public CommandeAjouterFichePersonnage(Jeu jeu, Scenario scenario) {
		this.jeu = jeu;
		this.scenario = scenario;
	}
	
	@Override
	public void executer() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Entrer le nom de la nouvelle fiche personnage : ");
		this.scenario.ajouterPersonnage(new FichePersonnage(this.jeu, scan.next()));
	}

	@Override
	public boolean estExecutable() {
		return true;
	}

}
