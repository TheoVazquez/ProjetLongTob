package controller.menu.commande;

import controller.menu.Commande;
import model.Scenario;
import model.fiche.Fiche;

public class CommandeSelectionnerFiche implements Commande {

	private Scenario scenario;
	private Fiche fiche;
	
	public CommandeSelectionnerFiche(Scenario scenario, Fiche fiche) {
		this.scenario = scenario;
		this.fiche = fiche;
	}
	
	@Override
	public void executer() {
		this.scenario.setFicheCourante(this.fiche);
	}

	@Override
	public boolean estExecutable() {
		return this.fiche != null;
	}

}
