import java.util.ArrayList;
import java.util.Scanner;

public class FicheLieu implements Fiche {
	
    private String NomDuLieu ;
    
    private String DescriptionDuLieu;

    private ArrayList<FichePersonnage> listePersonnagesDuLieu = new ArrayList<FichePersonnage>();

    
    
    public FicheLieu(String nom) {
    	
    	NomDuLieu = nom;
    	
    }
    
    
    public String getNomLieu() {	
    	return NomDuLieu;
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
		System.out.println("Nom du Lieu : " + NomDuLieu);
		System.out.print("");
		System.out.println("Description du Lieu : " + DescriptionDuLieu);
		System.out.print("");
		
		System.out.println("Liste des personnages associés au lieu : ");
		System.out.print("");
		for (int i = 0; i <= listePersonnagesDuLieu.size(); i++) {
			
			listePersonnagesDuLieu.get(i).afficher();
			
		}
		
	}


	@Override
	public void editer() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Que voulez vous modifier ? ");
		System.out.println("1 = Nom");
		System.out.println("2 = Description");
		
		if (sc.next() == "1") {
			
			System.out.println("Entrez votre Nom : ");
			NomDuLieu = sc.next();
			
		}
		
		else if (sc.next() == "2") {
			
			System.out.println("Entrez votre Description : ");
			DescriptionDuLieu = sc.next();
			
		}
		
		
	}
    
    

}
