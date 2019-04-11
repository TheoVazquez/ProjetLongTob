import java.util.List;

public class FichePersonnage implements Fiche {
	private String nom;
	private String prenom;
	private List<Stat> stats;
	private List<Competence> competences;
	

	public FichePersonnage (Jeu jeu, String titre){
		this.nom = nom;
		this.prenom = prenom;
		stats = jeu.getStats();
		competences = jeu.getCompetences();
	}
	
	public void setNom(String nom) {
		this.nom = nom;
	}
		
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	public String getNom() {
		return this.nom;
	}
	
	public String getPrenom() {
		return this.prenom;
	}
	
	public List<Stat> getStats() {
		return this.stats;
	}
	
	public List<Competence> getCompetences() {
		return this.competences;
	}
	
	public void ajouterStat(Stat stat) {
		stats.add(stat);
	}
	
	public void ajouterCompetence(Competence competence) {
		competences.add(competence);
	}
	
	public void supprimerStat(Stat stat) {
		stats.remove(stat);
	}
	
	public void supprimerCompetence(Competence competence) {
		competences.remove(competence);
	}
	
	@Override
	public void afficher() {
		System.out.println("Nom du personnage : " + nom);
		System.out.println("Prénom du personnage : " + prenom);
		for (int i = 0; i <= stats.size(); i++){
			stats.get(i).afficher();
		}
		for (int i = 0; i <= competences.size(); i++) {
			competences.get(i).afficher();
		}		
	}

	@Override
	public void editer() {
		// TODO Auto-generated method stub
		
	}

}
