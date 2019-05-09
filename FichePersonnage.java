import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Scanner;

public class FichePersonnage implements Fiche {
	private String nomFiche;
	private String nom;
	private String prenom;
	private List<Stat> stats;
	private List<Competence> competences;
	
	public FichePersonnage() {
		
	}
	
	
	public FichePersonnage (String nomFiche, Jeu jeu){
		this.nomFiche = nomFiche;
		this.stats = jeu.getStats();
		this.competences = jeu.getCompetences();
	}	
	
	public String getNomFiche() {
		return this.nomFiche;
	}
	
	public void setNomFiche(String nom) {
		this.nomFiche = nom;
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
		System.out.println("PrÃ©nom du personnage : " + prenom);
		if (stats != null ) {
			
			System.out.println("Statistiques : ");
		for (int i = 0; i < stats.size(); i++){
			stats.get(i).afficher();
			System.out.println("");
		}
		}
		if(competences != null ) {
			System.out.println("Comp�tences : ");
		for (int i = 0; i < competences.size(); i++) {
			competences.get(i).afficher();
			System.out.println("");
		}		
		}
	}

	@Override
	public void editer() {	
		System.out.println("Votre fiche : ");
		this.afficher();
		System.out.println("Que voulez vous modifier ? ");
		

		
	}
	
	public void sauvegarder() {
		
		PrintWriter writer;
		try {
			writer = new PrintWriter(this.nomFiche + ".txt", "UTF-8");

		writer.println("Fiche personnage");
		writer.println("Fiche : " + this.nomFiche);
		writer.println("Nom:" + this.nom);
		writer.println("PrÃ©nom:" + this.prenom);
		writer.println("Statistiques");
		if (this.stats != null) { 
			for(int i=1; i<= this.stats.size()+1; i++) {
				writer.print(this.stats.get(i-1).getNom() + ":");
				writer.println(this.stats.get(i-1).getValeur());
			}
		}
		writer.println("CompÃ©tences");
		if (this.competences != null) {
			for(int i=1; i<= this.competences.size()+1; i++) {
				writer.print(this.competences.get(i-1).getNom() + ":");
				writer.println(this.competences.get(i-1).getValeur());
			}
		}					  
	}		
	catch (FileNotFoundException e) {
		System.out.println("Fichier non trouvé");
	} catch (UnsupportedEncodingException e) {
		System.out.println("Erreur d'encodage");
	}
	}
	
	public FichePersonnage charger(String nomFichier, Jeu jeu) {
		FichePersonnage personnage = new FichePersonnage();
		try{
			InputStream flux=new FileInputStream("test.txt"); 
			InputStreamReader lecture=new InputStreamReader(flux);
			BufferedReader buff=new BufferedReader(lecture);
			String ligne = buff.readLine();
			while ((ligne=buff.readLine()) != "Statistiques") {
				String[] parts = ligne.split(":");
				String identifiant = parts[0];
				String valeur = parts[1];
				if (identifiant == "Nom") {
					personnage = new FichePersonnage(identifiant, jeu);
				} else if (identifiant == "PrÃ©nom") {
					personnage.setPrenom(identifiant);					
				}
			}
			while ((ligne=buff.readLine()) != "CompÃ©tences") {
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
		return personnage;
		
	}

	@Override 
	public String toString() {
		return this.nomFiche;
	}
}
