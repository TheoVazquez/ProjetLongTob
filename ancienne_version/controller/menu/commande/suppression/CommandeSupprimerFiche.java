package controller.menu.commande.suppression;

import controller.menu.Commande;
import model.Scenario;

public class CommandeSupprimerFiche implements Commande {

	private Scenario scenario;
	
	public CommandeSupprimerFiche(Scenario scenario) {
		this.scenario = scenario;
	}

	@Override
	public void executer() {
		this.scenario.supprimerFicheCourante();
	}

	@Override
	public boolean estExecutable() {
		return this.scenario.getFicheCourante() != null;
	}

}
