package controller.menu;

import controller.menu.commande.affichage.CommandeAfficherAttribut;
import controller.menu.commande.modification.CommandeModifierAttribut;
import controller.menu.commande.modification.CommandeModifierNomAttribut;
import controller.menu.commande.suppression.CommandeSupprimerAttribut;
import model.Scenario;
import model.fiche.Categorie;
import model.fiche.attribut.Attribut;

public class MenuEditionAttribut extends Menu {

	private Scenario scenario;
	private Attribut attribut;
	private Categorie conteneurPere;
	private ConditionArret etat;
	
	public MenuEditionAttribut(String titre, Scenario scenario, Attribut attribut, Categorie conteneurPere) {
		super(titre);
		this.scenario = scenario;
		this.attribut = attribut;
		this.conteneurPere = conteneurPere;
		this.etat = new ConditionArret();
		ajouter("Afficher l'attribut", new CommandeAfficherAttribut(this.attribut));
		ajouter("Modifier le nom de l'attribut", new CommandeModifierNomAttribut(this.attribut));
		ajouter("Modifier la valeur de l'attribut", new CommandeModifierAttribut(this.attribut));
		ajouter("Supprimer l'attribut", new CommandeSupprimerAttribut(this.attribut, this.conteneurPere, this.etat));
	}
	
	public void gerer() {
		do {
			this.afficher();
			this.selectionner();
			this.valider();
		} while (!estTermine() && !this.etat.estArrete());
	}

	@Override
	public boolean estExecutable() {
		return true;
	}
	
}
