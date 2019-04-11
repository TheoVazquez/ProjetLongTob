import java.util.Scanner;

public class CommandeEditerLieu implements Commande {
	
	Scenario scenario;
	
	@Override
	public void executer() {
		
	
        Scanner sc = new Scanner(System.in);
		
			
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

	@Override
	public boolean estExecutable() {
		// TODO Auto-generated method stub
		return false;
	}

}
