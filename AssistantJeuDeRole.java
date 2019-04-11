/*
 * Classe contenant le programme principal
 */
public class AssistantJeuDeRole {
	
	private Jeu jeuCharge;
	private Scenario scenarioCharge;
	private Menu menuPrincipal;
	
	AssistantJeuDeRole(Jeu jeu, Scenario scenario ){
		this.jeuCharge = jeu;
		this.scenarioCharge = scenario;
		
		
		//Création du menu EditerScenario
		Menu menuEditionScenario = new Menu("Editer scénario");
		menuEditionScenario.ajouter("Créer/Editer un lieu", new CommandeEditerLieu());
		menuEditionScenario.ajouter("Créer/Editer un personnage", new CommandeEditerPersonnage());
		//Création du menu principal
		this.menuPrincipal = new Menu("Menu principal");
		menuPrincipal.ajouter("Edite le scenario", menuEditionScenario);
		menuPrincipal.ajouter("Jouer le scenario", new CommandeJouerScenario(scenarioCharge));
		menuPrincipal.ajouter("Faire un jet", new CommandeFaireUnJet());
	}
	
	public void chargerJeu(Jeu jeu) {
		this.jeuCharge = jeu;
	}
	
	public void chargerScenario(Scenario scenario) {
		this.scenarioCharge = scenario;
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
		}while (! menuPrincipal.estquitte());
		
	}
	
}
