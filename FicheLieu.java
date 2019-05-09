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
		if(composants != null ) {
		for(int i=0; i < this.composants.size() ; i++) {
			composants.get(i).afficher();
		}
		}
		
		System.out.println("Liste des personnages associés au lieu : ");
		System.out.print("");
		if(listePersonnagesDuLieu != null ) {
		for (int i = 0; i < listePersonnagesDuLieu.size(); i++) {
			
			listePersonnagesDuLieu.get(i).afficher();
			
		}
		}
		
	}


	@Override
	public void editer() {
		System.out.println("Votre fiche lieu : ");
		this.afficher();
		System.out.println("Que voulez vous modifier ? ");
		System.out.println("0)Ajouter un composant");
		if (composants != null) {
			for (int i = 0 ; i < composants.size() ; i++) {
				System.out.println(i + ")" + this.composants.get(i).getNom());
			}
		}
		
	}
    
    @Override
    public String toString() {
    	return this.titreFiche;
    }

}
