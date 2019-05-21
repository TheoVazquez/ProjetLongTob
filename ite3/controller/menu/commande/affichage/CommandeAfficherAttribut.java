package controller.menu.commande.affichage;

import controller.menu.Commande;
import model.fiche.attribut.Attribut;

public class CommandeAfficherAttribut implements Commande {

	private Attribut attribut;

	public CommandeAfficherAttribut(Attribut attribut) {
		this.attribut = attribut;
	}

	@Override
	public void executer() {
		System.out.println(this.attribut);
	}

	@Override
	public boolean estExecutable() {
		return true;
	}

}
