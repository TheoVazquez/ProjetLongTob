import java.util.List;

public class FichePersonnage implements Fiche {
	private String nom;
	private List<Stat> stats;

	public FichePersonnage (Jeu jeu, String nom){
		stats = jeu.getStats();
		this.nom = nom;
	}

	@Override
	public void afficher() {
		for (int i = 0; i <= stats.size(); i++){
			stats.get(i).afficher();
		}
		
	}

	@Override
	public void editer() {
		// TODO Auto-generated method stub
		
	}

}
