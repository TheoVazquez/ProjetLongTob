package controller.menu.commande.ajout;

import java.util.Scanner;

import controller.menu.Commande;
import model.fiche.Categorie;
import model.fiche.Fiche;

public class CommandeAjouterCategorie implements Commande {

	private Fiche conteneurPere;

	public CommandeAjouterCategorie(Fiche conteneurPere) {
		this.conteneurPere = conteneurPere;
	}

	@Override
	public void executer() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Entrer le nom de la nouvelle cat�gorie : ");
		this.conteneurPere.ajouterCategorie(new Categorie(scan.next()));
	}

	@Override
	public boolean estExecutable() {
		return true;
	}

}