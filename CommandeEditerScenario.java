import java.util.Scanner;

public class CommandeEditerScenario implements Commande {

	Scenario scenario;
	/*
	 * initialise le scénario à éditer
	 */
	public CommandeEditerScenario(Scenario scenario) {
		this.scenario = scenario;
	}
	@Override
	public void executer() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Voulez-vous modifier/créer une fiche lieu ? o/n ");
		
		if (sc.next() == "o") {
			
			System.out.println("Entrer le nom de la fiche a créer ou modifier : ");
			
			String nomFiche = sc.next();
			
			for (int i = 0; i < scenario.getListeLieux().size();i++) {
				
				if (scenario.getListeLieux().get(i).getNomLieu() == nomFiche) {
					
					scenario.getListeLieux().get(i).editer();
					return;
					
				}
			}
			
			System.out.println("la fiche n'existe pas creation de cette dernière...");
			FicheLieu nouvelleFiche = new FicheLieu(nomFiche);
	        scenario.ajouterLieu(nouvelleFiche);
			return;	
		
		}
		
		else {
			
			System.out.println("Voulez vous modifier/créer une fiche personnage ? o/n" );
			
			////////////////////// TO DO ////////////////////////////////////////////////
			
		}
			
		
		
	}

	@Override
	public boolean estExecutable() {
		// TODO Auto-generated method stub
		return true;
	}

}
