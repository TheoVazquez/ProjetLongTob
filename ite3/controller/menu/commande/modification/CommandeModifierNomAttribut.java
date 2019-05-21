package controller.menu.commande.modification;

import java.util.Scanner;

import controller.menu.Commande;
import model.fiche.attribut.Attribut;

public class CommandeModifierNomAttribut implements Commande {

	private Attribut attribut;

	public CommandeModifierNomAttribut(Attribut attribut) {
		this.attribut = attribut;
	}

	@Override
	public void executer() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Entrer le nouveau nom de l'attribut : ");
		this.attribut.setNom(scan.next());
	}

	@Override
	public boolean estExecutable() {
		return true;
	}

}
