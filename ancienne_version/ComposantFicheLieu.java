
public class ComposantFicheLieu {
	/*Classe des composants d'une fiche lieu pouvant être modifiés et affichés
	 * 
	 */
	private String nom;
	private String contenu;
	public ComposantFicheLieu(String nom) {
		this.nom = nom;
	}
	public ComposantFicheLieu(String nom , String contenu) {
		this.nom = nom;
		this.contenu = contenu;
	}
	
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public void setContenu(String contenu) {
		this.contenu = contenu;
	}
	
	public String getNom() {
		return this.nom;
	}
	
	public String getContenu() {
		return this.contenu;
	}
	
	public void afficher() {
		System.out.println(this.nom + " : " + this.contenu);
	}
	
	/**Affiche uniquement le titre et le numero du composant*/
	public void afficher(int numero) {
		System.out.println(numero + ")" + this.nom);
	}
}
