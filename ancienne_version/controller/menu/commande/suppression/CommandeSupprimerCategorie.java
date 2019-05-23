package controller.menu.commande.suppression;

import controller.menu.Commande;
import controller.menu.ConditionArret;
import model.fiche.Categorie;
import model.fiche.Fiche;

public class CommandeSupprimerCategorie implements Commande {

	private Categorie categorie;
	private Fiche conteneurPere;
	private ConditionArret etat;
	
	public CommandeSupprimerCategorie(Categorie categorie, Fiche conteneurPere, ConditionArret etat) {
		this.categorie = categorie;
		this.conteneurPere = conteneurPere;
		this.etat = etat;
	}
	
	@Override
	public void executer() {
		this.conteneurPere.supprimerCategorie(this.categorie);
		this.etat.arret();
	}

	@Override
	public boolean estExecutable() {
		return true;
	}

}
