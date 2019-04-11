import java.util.List;

public class FichePersonnage implements Fiche {
	private String nom;
	private String prenom;
	private List<Stat> stats;
	private List<Competence> competences;

	public FichePersonnage (Jeu jeu, String name, String firstName){
		stats = jeu.getStats();
		competences = jeu.getCompetences();
		nom = name;
		prenom = firstName;
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
