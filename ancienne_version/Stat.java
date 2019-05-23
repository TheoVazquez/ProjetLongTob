
public class Stat {
	private String nom; //nom de la statistique
	private int valeur; //sa valeur
	
	public Stat(String nom, int valeur) {
		this.nom = nom;
		this.valeur = valeur;
	}
	
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public void setValeur(int valeur) {
		this.valeur = valeur;
	}
	
	public String getNom() {
		return nom;
	}
	
	public int getValeur() {
		return valeur;
	}
	
	public void afficher(){
		System.out.print(this.nom + " : " + this.valeur);		
	}
}
