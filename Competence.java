public class Competence {
	private String nom; //nom de la Compétence
	private int valeur; //sa valeur
	
	public Competence(String nom, int valeur) {
		this.nom = nom;
		this.valeur = valeur;
	}
	
	public void afficher() {
		System.out.print(this.nom + " : " + this.valeur);
	}
}