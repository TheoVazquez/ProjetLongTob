package controller.menu.commande.affichage;

import controller.menu.Commande;
import model.Scenario;

public class CommandeAfficherFiche implements Commande {

	private Scenario scenario;
	
	public CommandeAfficherFiche(Scenario scenario) {
		this.scenario = scenario;
	}
	
	@Override
	public void executer() {
		System.out.println(this.scenario.getFicheCourante());
	}

	@Override
	public boolean estExecutable() {
		return this.scenario.getFicheCourante() != null;
	}
	
	

}
