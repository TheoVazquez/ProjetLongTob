import java.util.ArrayList;
import java.util.Scanner;

public class FicheLieu implements Fiche {
	
    private String titreFiche ;
    
    private ArrayList<ComposantFicheLieu> composants;

    private ArrayList<FichePersonnage> listePersonnagesDuLieu = new ArrayList<FichePersonnage>();

    
    
    public FicheLieu(String titre) {
    	
    	titreFiche = titre;
    	
    }
    
    
    public String getTitreFiche() {	
    	return this.titreFiche;
    }
    
    
    
    // methode permettant de retirer un personnage associé au lieu (mort, disparition, etc ...)
    public void retirerPersonnage(FichePersonnage personnageARetirer) {
    	listePersonnagesDuLieu.remove(personnageARetirer);
    }
    
    
    // methode permettant d'ajouter un nouveau personnage associe au lieu
    public void ajouterPersonnage(FichePersonnage nouveauPersonnage) {
    	listePersonnagesDuLieu.add(nouveauPersonnage);
    }


	@Override
	public void afficher() {
		
		System.out.println(this.titreFiche + " : ");
		//On affiche chacun des composants
		for(int i=0; i <= this.composants.size() ; i++) {
			composants.get(i).afficher();
		}
		
		System.out.println("Liste des personnages associés au lieu : ");
		System.out.print("");
		for (int i = 0; i <= listePersonnagesDuLieu.size(); i++) {
			
			listePersonnagesDuLieu.get(i).afficher();
			
		}
		
	}


	@Override
	public void editer() {
		int selection;
		
		System.out.println("Que voulez vous modifier ? ");
		for(int i=1; i<= this.composants.size()+1;i++) {
			this.composants.get(i-1).afficher(i-1);
		}
		System.out.println("Votre choix :");
		boolean choixValide;
		do {
			Scanner sc = new Scanner(System.in);
			System.out.println("Votre choix :");
			selection = sc.nextInt();
			choixValide = 0 <= selection && selection <= this.composants.size();
			if(!choixValide) {
				System.out.println("Choix invalide !");
			}
			
		} while (!choixValide);
		System.out.println("Modification de : "+ this.composants.get(selection));
		System.out.println("Veuillez saisir la modification");
		Scanner sc = new Scanner(System.in);
		String modification = sc.next();
		System.out.println("Votre modification : "+ modification);
		System.out.println("Valider ? 0 : non / 1 : oui");
		int valider = sc.nextInt();
		if (valider == 1) {
			this.composants.get(selection).setContenu(modification);
			System.out.println("Modification annulée");
		}
		else {
			System.out.println("Annulation de la modification");
		}
		
		
	}
    
    

}
