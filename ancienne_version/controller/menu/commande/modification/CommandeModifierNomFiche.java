package controller.menu.commande.modification;

import java.util.Scanner;
import controller.menu.Commande;
import model.fiche.Fiche;

public class CommandeModifierNomFiche implements Commande {

	private Fiche fiche;
	
	public CommandeModifierNomFiche(Fiche fiche) {
		this.fiche = fiche;
	}
	
	@Override
	public void executer() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Entrer le nouveau nom de la cat�gorie : ");
		this.fiche.setNom(scan.next());
	}

	@Override
	public boolean estExecutable() {
		return true;
	}

}
