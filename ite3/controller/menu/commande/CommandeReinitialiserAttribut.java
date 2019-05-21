package controller.menu.commande;

import controller.menu.Commande;
import model.fiche.Fiche;

public class CommandeReinitialiserAttribut implements Commande {

	private Fiche fiche;

	public CommandeReinitialiserAttribut(Fiche fiche) {
		this.fiche = fiche;
	}

	@Override
	public void executer() {
		this.fiche.reinitialiserAttributs();
	}

	@Override
	public boolean estExecutable() {
		return true;
	}

}
