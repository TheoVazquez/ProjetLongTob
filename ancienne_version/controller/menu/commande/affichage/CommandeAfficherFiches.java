package controller.menu.commande.affichage;

import controller.menu.Commande;
import model.Scenario;

public class CommandeAfficherFiches implements Commande{

	private Scenario scenario;
	
	public CommandeAfficherFiches(Scenario scenario) {
		this.scenario = scenario;
	}
	
	@Override
	public void executer() {
		System.out.println(this.scenario);
	}

	@Override
	public boolean estExecutable() {
		return this.scenario.nombreFiches() > 0;
	}

}
