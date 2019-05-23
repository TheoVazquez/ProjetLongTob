package controller.menu;

import java.util.List;
import controller.menu.commande.CommandeSelectionnerFiche;
import model.Scenario;
import model.fiche.FicheLieu;
import model.fiche.FichePersonnage;

public class MenuSelection extends Menu {

	private Scenario scenario;
	
	public MenuSelection(String titre, Scenario scenario) {
		super(titre);
		this.scenario = scenario;
	}
	
	private void initialiser() {
		List<FicheLieu> lieux = scenario.getListeLieux();
		for (FicheLieu lieu : lieux) {
			ajouter("fiche lieu " + lieu.getNom(), new CommandeSelectionnerFiche(scenario, lieu));
		}
		List<FichePersonnage> personnages = scenario.getListePersonnage();
		for (FichePersonnage personnage : personnages) {
			ajouter("fiche personnage " + personnage.getNom(), new CommandeSelectionnerFiche(scenario, personnage));
		}
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
		return this.scenario.nombreFiches() > 0;
	}
		
}
