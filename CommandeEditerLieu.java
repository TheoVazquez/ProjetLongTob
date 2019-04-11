import java.util.Scanner;

public class CommandeEditerLieu implements Commande {
	
	Scenario scenario;
	Jeu jeu;
	public CommandeEditerLieu(Scenario scenario, Jeu jeu) {
		this.scenario = scenario;
		this.jeu = jeu;
	}
	@Override
	public void executer() {
		
	
        Scanner sc = new Scanner(System.in);
		
			
		System.out.println("Entrer le nom de la fiche a créer ou modifier : ");
		System.out.println("Fiches disponibles : ");
		String nomFiche = sc.next();
		for (int i = 0; i < scenario.getListeLieux().size();i++) {
			System.out.println(scenario.getListeLieux().get(i).getTitreFiche());
		}
		for (int i = 0; i < scenario.getListeLieux().size();i++) {
				
			if (scenario.getListeLieux().get(i).getTitreFiche() == nomFiche) {
					
				scenario.getListeLieux().get(i).editer();
				return;
					
				}
			}
		System.out.println("la fiche n'existe pas creation de cette dernière...");
		FicheLieu nouvelleFiche = new FicheLieu(nomFiche);
		
	    this.scenario.ajouterLieu(nouvelleFiche);
	    
		return;

	}

	@Override
	public boolean estExecutable() {
		// TODO Auto-generated method stub
		return true;
	}

}
