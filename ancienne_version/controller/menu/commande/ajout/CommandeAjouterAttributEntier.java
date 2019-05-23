package controller.menu.commande.ajout;

import java.util.Scanner;

import controller.menu.Commande;
import model.fiche.Categorie;
import model.fiche.attribut.Attribut;
import model.fiche.attribut.ValeurInt;

public class CommandeAjouterAttributEntier implements Commande {

	private Categorie conteneurPere;

	public CommandeAjouterAttributEntier(Categorie conteneurPere) {
		this.conteneurPere = conteneurPere;
	}

	@Override
	public void executer() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Entrer le nom du nouvel attribut : ");
		String nom = scan.next();
		System.out.println("Entrer la valeur du nouvel attribut : ");
		int valeur = scan.nextInt();
		this.conteneurPere.ajouterAttribut(new Attribut(nom, new ValeurInt(valeur)));
	}

	@Override
	public boolean estExecutable() {
		return true;
	}

}