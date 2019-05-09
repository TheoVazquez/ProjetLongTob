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
		for (int i = 0; i < scenario.getListePersonnage().size();i++) {
			System.out.println(scenario.getListePersonnage().get(i).getNomFiche());
		}
		String nomPerso = sc.next();
		for (int i = 0; i < scenario.getListePersonnage().size();i++) {
				
			if (scenario.getListePersonnage().get(i).getNom().equals(nomPerso)) {
				System.out.println("Edition de " + scenario.getListePersonnage().get(i).getNomFiche() + " : ");
				scenario.getListePersonnage().get(i).editer();
				return;
					
				}
			}
		System.out.println("le personnage n'existe pas, création de ce dernier...");
		FichePersonnage nouvelleFiche = new FichePersonnage(nomPerso);
		
	    this.scenario.ajouterPersonnage(nouvelleFiche);
	    System.out.println("Fiche ajout�e");
	    
	  //sauvegarde de la fiche vierge
	    nouvelleFiche.sauvegarder();
		return;
	}

	@Override
	public boolean estExecutable() {
		// TODO Auto-generated method stub
		return true;
	}

}
