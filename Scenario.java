import java.util.ArrayList;

public class Scenario {
	
	private ArrayList<FicheLieu> listeLieux;
	private ArrayList<FichePersonnage> listePersonnages;
	
	public Scenario() {
		this.listeLieux = new ArrayList<FicheLieu>();
		this.listePersonnages = new ArrayList<FichePersonnage>();
	}
	public void ajouterLieu(FicheLieu nouveauLieu) {
		
		listeLieux.add(nouveauLieu);
		
	}
	
	public ArrayList<FicheLieu> getListeLieux() {
		
		return listeLieux;
		
	}
	
    public ArrayList<FichePersonnage> getListePersonnage() {
		
		return listePersonnages;
		
	}

}
