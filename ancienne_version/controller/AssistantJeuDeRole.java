package controller;

import controller.menu.Menu;
import controller.menu.MenuEditionFiche;
import controller.menu.MenuSelection;
import controller.menu.commande.*;
import controller.menu.commande.affichage.CommandeAfficherFiche;
import controller.menu.commande.affichage.CommandeAfficherFiches;
import controller.menu.commande.ajout.CommandeAjouterFicheLieu;
import controller.menu.commande.ajout.CommandeAjouterFichePersonnage;
import controller.menu.commande.suppression.CommandeSupprimerFiche;
import model.Jeu;
import model.Scenario;

/*
 * Classe contenant le programme principal
 */
public class AssistantJeuDeRole {
	
	private Menu menuPrincipal;
	
	public AssistantJeuDeRole(Jeu jeu, Scenario scenario) {
		this.menuPrincipal = new Menu("Menu principal");
		
		Menu menuEditerScenario = new Menu("Editer le scénario");
		menuEditerScenario.ajouter("Afficher les fiches du scénario", new CommandeAfficherFiches(scenario));
		menuEditerScenario.ajouter("Rechercher une fiche du scénario", new CommandeRechercherFiche(scenario));
		menuEditerScenario.ajouter("Selectionner une fiche du scénario", new MenuSelection("Selectionner une fiche du scénario", scenario));
		menuEditerScenario.ajouter("Afficher la fiche courante", new CommandeAfficherFiche(scenario));
		
		Menu menuAjouterFiche = new Menu("Ajouter une fiche");
		menuAjouterFiche.ajouter("Ajouter une fiche lieu", new CommandeAjouterFicheLieu(jeu, scenario));
		menuAjouterFiche.ajouter("Ajouter une fiche personnage", new CommandeAjouterFichePersonnage(jeu, scenario));
		menuEditerScenario.ajouter("Ajouter une fiche au scénario", menuAjouterFiche);
		
		menuEditerScenario.ajouter("Supprimer la fiche courante", new CommandeSupprimerFiche(scenario));
		menuEditerScenario.ajouter("Modifier la fiche courante", new MenuEditionFiche("Modifier la fiche courante", scenario));
		
		this.menuPrincipal.ajouter("Afficher les fiches du scénario", new CommandeAfficherFiches(scenario));
		this.menuPrincipal.ajouter("Rechercher une fiche du scénario", new CommandeRechercherFiche(scenario));
		this.menuPrincipal.ajouter("Selectionner une fiche du scénario", new MenuSelection("Selectionner une fiche du scénario", scenario));
		this.menuPrincipal.ajouter("Afficher la fiche courante", new CommandeAfficherFiche(scenario));
		this.menuPrincipal.ajouter("Faire un jet", new CommandeFaireUnJet());
		this.menuPrincipal.ajouter("Editer le scenario", menuEditerScenario);
	}
	
	/**utilisation de l'assistant
	 * 
	 */
	public void utiliser() {
		do {
			System.out.println();
			//affiche la fiche en cours
			System.out.println();
			
			//affiche le menu principal
			this.menuPrincipal.afficher();
			
			//selectionner une entree dans le menu
			menuPrincipal.selectionner();
			
			//valide l'entrée selectionner;
			menuPrincipal.valider();
		} while (! menuPrincipal.estQuitte());
		
	}
	
}
