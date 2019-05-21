package controller.menu;

import java.util.List;
import controller.menu.commande.CommandeSelectionnerFiche;
import model.Scenario;

public class MenuSelection extends Menu {

	private Scenario scenario;
	
	public MenuSelection(String titre, Scenario scenario) {
		super(titre);
		this.scenario = scenario;
	}
	
	private void initialiser() {
	}
	
	@Override
	public void gerer() {
		vider();
		initialiser();
		this.afficher();
		this.selectionner();
		this.valider();
	}
	
	public boolean estExecutable() {
		return true;
	}
		
}
