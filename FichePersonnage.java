import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.List;
import java.util.Scanner;

public class FichePersonnage implements Fiche {
	private String nom;
	private String prenom;
	private List<Stat> stats;
	private List<Competence> competences;
	
	public FichePersonnage (String nom) {
		this.nom = nom;
	}
	
	public FichePersonnage (String nom, String prenom) {
		this.nom = nom;
		this.prenom = prenom;
	}
	
	public FichePersonnage (Jeu jeu, String nom, String Prenom){
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
		int selection;
		
		System.out.println("Que voulez vous modifier ? ");
		for(int i=1; i<= this.stats.size()+1; i++) {
			System.out.print("" + i + "--");
			this.stats.get(i-1).afficher();
		}
		for(int i=stats.size()+1; i<= this.competences.size()+stats.size()+1; i++) {
			System.out.print("" + i + "--");
			this.competences.get(i-1).afficher();
		}
		System.out.println("Votre choix :");
		boolean choixValide;
		do {
			Scanner sc = new Scanner(System.in);
			System.out.println("Votre choix :");
			selection = sc.nextInt();
			choixValide = 0 <= selection && selection <= (this.stats.size() + this.competences.size());
			if(!choixValide) {
				System.out.println("Choix invalide !");
			}
			
		} while (!choixValide);
		if (selection <= this.stats.size()) {
			System.out.println("Modification de : "+ this.stats.get(selection));
		} else {
			System.out.println("Modification de : "+ this.competences.get(selection - this.stats.size()));
		}
		System.out.println("que voulez-vous modifier?");
		System.out.print("1-- Le nom\n 2-- La Valeur");
		Scanner sc = new Scanner(System.in);
		int choix = sc.nextInt();
		System.out.println("Veuillez saisir la modification");
		sc = new Scanner(System.in);
		String modification = sc.next();
		System.out.println("Votre modification : "+ modification);
		System.out.println("Valider ? 0 : non / 1 : oui");
		int valider = sc.nextInt();
		if (choix == 1) {
				if (valider == 1) {
					if (selection <= this.stats.size()) {
						this.stats.get(selection).setNom(modification);
					} else {
						this.competences.get(selection - stats.size()).setNom(modification);
					}
				} else {
					if (selection <= this.stats.size()) {
						this.stats.get(selection).setValeur(Integer.parseInt(modification));
					} else {
						this.competences.get(selection - stats.size()).setValeur(Integer.parseInt(modification));
					}					
				}
			System.out.println("Modification réalisée");
		}
		else {
			System.out.println("Annulation de la modification");
		}
		
	}
	
	public void sauvegarder() {
		
		PrintWriter writer = new PrintWriter("Fiche_" + this.nom + "_" + this.prenom + ".txt", UTF-8);
		writer.println("Fiche personnage");
		writer.println("Nom:" + this.nom);
		writer.println("Prénom:" + this.prenom);
		writer.println("Statistiques");
		for(int i=1; i<= this.stats.size()+1; i++) {
			writer.print(this.stats.get(i-1).getNom() + ":");
			writer.println(this.stats.get(i-1).getValeur());
		}
		writer.println("Compétences");
		for(int i=1; i<= this.competences.size()+1; i++) {
			writer.print(this.competences.get(i-1).getNom() + ":");
			writer.println(this.competences.get(i-1).getValeur());
		}
								  
	}
	
	public FichePersonnage charger(String nomFichier) {
		try{
			FichePersonnage personnage ;
			InputStream flux=new FileInputStream("test.txt"); 
			InputStreamReader lecture=new InputStreamReader(flux);
			BufferedReader buff=new BufferedReader(lecture);
			String ligne = buff.readLine();
			while ((ligne=buff.readLine()) != "Statistiques") {
				String[] parts = ligne.split(":");
				String identifiant = parts[0];
				String valeur = parts[1];
				if (identifiant == "Nom") {
					personnage = new FichePersonnage(identifiant);
				} else if (identifiant == "Prénom") {
					personnage.setPrenom(identifiant);					
				}
			}
			while ((ligne=buff.readLine()) != "Compétences") {
				String[] parts = ligne.split(":");
				String nomStat = parts[0];
				int valeur = Integer.parseInt(parts[1]);
				Stat stat = new Stat(nomStat,valeur);
				personnage.ajouterStat(stat);
			}
			while ((ligne=buff.readLine()) != null) {
				String[] parts = ligne.split(":");
				String nomCompetence = parts[0];
				int valeur = Integer.parseInt(parts[1]);
				Competence competence = new Competence(nomCompetence,valeur);
				personnage.ajouterCompetence(competence);
			}
			buff.close(); 
		} catch (Exception e){
			System.out.println(e.toString());
		}
		return null;
	}

}
