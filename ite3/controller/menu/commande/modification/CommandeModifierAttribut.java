package controller.menu.commande.modification;

import controller.menu.Commande;
import model.fiche.attribut.Attribut;

public class CommandeModifierAttribut implements Commande {

	private Attribut attribut;
	
	public CommandeModifierAttribut(Attribut attribut) {
		this.attribut = attribut;
	}
	
	@Override
	public void executer() {
		this.attribut.modifierValeur();

	}

	@Override
	public boolean estExecutable() {
		return true;
	}

}
