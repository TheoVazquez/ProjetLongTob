
public class Stat {
	private String nom; //nom de la statistique
	private int valeur; //sa valeur
	
	public Stat(String nom, int valeur) {
		this.nom = nom;
		this.valeur = valeur;
	}
	
	public void afficher(){
		System.out.print(this.nom + " : " + this.valeur);		
	}
}
