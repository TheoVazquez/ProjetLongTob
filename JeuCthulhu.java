import java.util.ArrayList;
import java.util.List;

/*
 * 
 */
public class JeuCthulhu implements Jeu {

	
	private List<Stat> stats;
	private List<Competence> competences;
	
	private List<ComposantFicheLieu> contenuFicheLieu;

	/*
	 * Création du sytême de jeu issu du JDR Cthulhu
	 */

	JeuCthulhu(){
		
		//Statistiques
		this.stats = new ArrayList<Stat>();
		this.stats.add(new Stat("FOR",0));
		this.stats.add(new Stat("DEX",0));
		this.stats.add(new Stat("POU",0));
		this.stats.add(new Stat("CON",0));
		this.stats.add(new Stat("APP",0));
		this.stats.add(new Stat("EDU",0));
		this.stats.add(new Stat("TAI",0));
		this.stats.add(new Stat("INT",0));
		this.stats.add(new Stat("MVT",0));
		
		//Fiche lieu
		this.contenuFicheLieu = new ArrayList<ComposantFicheLieu>();
		this.contenuFicheLieu.add(new ComposantFicheLieu("titre"));
		this.contenuFicheLieu.add(new ComposantFicheLieu("description"));
		
	}
	
	
	@Override
	public List<Stat> getStats() {
		return this.stats;
	}
	
	@Override
	public List<Competence> getCompetences() {
		return this.competences;
	}
}
