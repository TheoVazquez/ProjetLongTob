import java.util.ArrayList;

public class Scenario {
	
	private String nom;
	private ArrayList<FicheLieu> listeLieux = new ArrayList<FicheLieu>();
	private ArrayList<FichePersonnage> listePersonnages = new ArrayList<FichePersonnage>();
	
	public Scenario(String nom) {
		this.nom = nom;
	}
	
	public String getNom() {
		return this.nom;
	}
	public void ajouterLieu(FicheLieu nouveauLieu) {
		
		listeLieux.add(nouveauLieu);
		
	}
	
	public void ajouterPersonnage(FichePersonnage nouveauPersonnage) {
		listePersonnages.add(nouveauPersonnage);
	}
	
	public ArrayList<FicheLieu> getListeLieux() {
		
		return listeLieux;
		
	}
	
    public ArrayList<FichePersonnage> getListePersonnage() {
		
		return listePersonnages;
		
	}
    
    @Override 
    public String toString() {
    	return this.nom;
    }

}
