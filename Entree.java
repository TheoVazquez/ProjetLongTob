
public class Entree {
	String texte;
	Commande commande;
	public Entree(String texte, Commande commande) {
		this.texte = texte;
		this.commande = commande;
	}
	public String getIntitule() {
		return texte;
	}
	
	public Commande getCommande() {
		return this.commande;
	}
	
	public void afficher(int numero) {
		if(commande.estExecutable()) {
			String num = ""+numero;
		
			System.out.print(numero);
		}else {
			System.out.print("-");
		}
		System.out.print(")");
		System.out.println(getIntitule());
		System.out.println();
		
	}

}
