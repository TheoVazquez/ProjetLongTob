package controller.menu.commande.affichage;

import controller.menu.Commande;
import model.fiche.Categorie;

public class CommandeAfficherCategorie implements Commande {

	private Categorie categorie;
	
	public CommandeAfficherCategorie(Categorie categorie) {
		this.categorie = categorie;
	}
	
	@Override
	public void executer() {
		System.out.println(this.categorie);
	}

	@Override
	public boolean estExecutable() {
		return true;
	}

}
