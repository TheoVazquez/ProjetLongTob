import java.util.Scanner;

public class CommandeEditerPersonnage implements Commande {
	
	private Scenario scenario;
	
	public CommandeEditerPersonnage(Scenario scenario){
		this.scenario = scenario;
	}
	
	@Override
	public void executer() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Entrer le nom de le personnage à créer ou modifier : ");
		System.out.println("Personnages disponibles : ");
		String nomPerso = sc.next();
		for (int i = 0; i < scenario.getListePersonnage().size();i++) {
			System.out.println(scenario.getListePersonnage().get(i).getNom() + " " + scenario.getListePersonnage().get(i).getPrenom());
		}
		for (int i = 0; i < scenario.getListePersonnage().size();i++) {
				
			if (scenario.getListePersonnage().get(i).getNom() == nomPerso) {
					
				scenario.getListePersonnage().get(i).editer();
				return;
					
				}
			}
		System.out.println("le personnage n'existe pas, création de ce dernier...");
		FichePersonnage nouvelleFiche = new FichePersonnage(nomPerso);
		
	    this.scenario.ajouterPersonnage(nouvelleFiche);
	    
		return;
	}

	@Override
	public boolean estExecutable() {
		// TODO Auto-generated method stub
		return true;
	}

}
