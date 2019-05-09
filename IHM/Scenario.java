package IHM;
import java.util.ArrayList;

public class Scenario {
	
	private String nom;
	private ArrayList <Fiche> listeFiche = new ArrayList<Fiche>();;
	private Jeu jeu;
	public Scenario(String nom, Jeu jeu) {
		this.nom = nom;
		this.listeFiche.add(new FichePersonnage("Fiche vierge", jeu));
		this.jeu = jeu;
	}
	
	public String getNom() {
		return this.nom;
	}

	
	public ArrayList<Fiche> getListeFiche() {
		
		return this.listeFiche;
		
	}
	
	public Jeu getJeu() {
		return this.jeu;
	}
	
	/**Ajoute une fiche au scénario**/
	public void addFiche(Fiche fiche) {
		this.listeFiche.add(fiche);
	}

    
    @Override 
    public String toString() {
    	return this.nom;
    }

}
