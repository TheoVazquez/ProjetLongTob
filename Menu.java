import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {
	private String titre; //titre du menu
	private List<Entree> entrees; //entrees du menu
	private boolean estQuitte;
	private Commande selection; //la commande selectionnée
	static final private Commande CMD_QUITTER = new CommandeNOP();
	static final private Entree entreeQuitter = new Entree("Quitter",CMD_QUITTER);
	public Menu(String titre){
		
		this.titre = titre;
		this.entrees = new ArrayList<Entree>();
		this.estQuitte=false;
	}
	/**
	 * Ajoute une entrée au menu
	 * @param texte : le texte de l'entrée
	 * @param commande : la commande associée
	 */
	public void ajouter(String texte, Commande commande) {
		this.entrees.add(new Entree(texte,commande));
	}
	
	/*
	 * retourne le nombre d'entrée
	 */
	private int getNbrEntree() {
		return(this.entrees.size());
	}
	
	/*
	 * Retourne l'entrée à l'index indiqué
	 */
	private Entree getEntree(int index) {
		if(index > 0) {
			return entrees.get(index-1);
		}else {
			return entreeQuitter;
		}
	}
	
	/*
	 * affiche le menu
	 */
	public void afficher() {
		System.out.println(titre);
		
		for(int i=1; i<= this.getNbrEntree();i++) {
			this.getEntree(i-1).afficher(i-1);
		}
	}
	
	/*
	 * indique si le menu est quitté
	 */
	public boolean estquitte() {
		return this.estQuitte;
	}
	
	/*
	 * selectionne l'entrée
	 */
	public void selectionner() {
		this.estQuitte=false;
		int choix;
		boolean choixValide = false;
		do {
			Scanner sc = new Scanner(System.in);
			System.out.println("Votre choix :");
			choix = sc.nextInt();
			choixValide = 0 <= choix && choix <= this.getNbrEntree();
			if(!choixValide) {
				System.out.println("Choix invalide !");
			}
			
		} while (!choixValide);
		this.selection = this.getEntree(choix).getCommande();
	}
	public void valider() {
		if (this.selection == this.CMD_QUITTER) {
			this.estQuitte = true;
		} else {
			if (this.selection.estExecutable()) {
				this.selection.executer();
			} else {
				System.out.println("Opération non réalisable");
			}
		}
		
	}
}
