package controller.menu.commande.suppression;

import controller.menu.Commande;
import controller.menu.ConditionArret;
import model.fiche.Categorie;
import model.fiche.attribut.Attribut;

public class CommandeSupprimerAttribut implements Commande {

	private Attribut attribut;
	private Categorie conteneurPere;
	private ConditionArret etat;
	
	public CommandeSupprimerAttribut(Attribut attribut, Categorie conteneurPere, ConditionArret etat) {
		this.attribut = attribut;
		this.conteneurPere = conteneurPere;
		this.etat = etat;
	}
	
	@Override
	public void executer() {
		this.conteneurPere.supprimerAttribut(this.attribut);
		this.etat.arret();
	}

	@Override
	public boolean estExecutable() {
		return true;
	}

}
