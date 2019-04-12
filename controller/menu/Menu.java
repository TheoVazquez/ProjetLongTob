package controller.menu;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import controller.menu.commande.CommandeNOP;

public class Menu implements Commande {
	
	private String titre; //titre du menu
	private List<Entree> entrees; //entrees du menu
	private boolean estQuitte;
	private Commande selection; //la commande selectionnée
	static final private Commande CMD_QUITTER = new CommandeNOP();
	static final private Entree entreeQuitter = new Entree("Quitter",CMD_QUITTER);
	public enum Mode { REMANANT, VOLATIL };
	private Mode mode;

	public Menu(String titre) {
		this.titre = titre;
		this.entrees = new ArrayList<Entree>();
		this.estQuitte=false;
		this.mode = Mode.REMANANT;
		this.selection = null;
	}
	
	/**
	 * Ajoute une entr�e au menu
	 * @param texte : le texte de l'entrée
	 * @param commande : la commande associée
	 */
	public void ajouter(String texte, Commande commande) {
		this.entrees.add(new Entree(texte,commande));
	}
	
	public void vider() {
		this.entrees.clear();
	}
	
	/** 
	 * mode du menu. 
	 */
	public /*@ pure @*/ Mode getMode() {
		return this.mode;
	}

	/** 
	 * Rendre le menu rémanant. 
	 */
	//@ ensures getMode() == Mode.REMANANT;
	public void setRemanant() {
		this.mode = Mode.REMANANT;
	}

	/** 
	 * Rendre le menu volatil. 
	 */
	//@ ensures getMode() == Mode.VOLATIL;
	public void setVolatil() {
		this.mode = Mode.VOLATIL;
	}
	
	/**
	 * retourne le nombre d'entrée
	 */
	private int getNbrEntree() {
		return(this.entrees.size());
	}
	
	/**
	 * Retourne l'entrée à l'index indiqué
	 */
	private Entree getEntree(int index) {
		if(index > 0) {
			return entrees.get(index-1);
		}else {
			return entreeQuitter;
		}
	}
	
	/**
	 * affiche le menu
	 */
	public void afficher() {
		System.out.println(titre);
		
		for(int i=1; i<= this.getNbrEntree()+1;i++) {
			this.getEntree(i-1).afficher(i-1);
		}
	}
	
	/**
	 * indique si le menu est quitté
	 */
	public boolean estQuitte() {
		return this.estQuitte;
	}
	
	public boolean estTermine() {
		return this.mode != Mode.REMANANT || this.estQuitte();
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
		if (this.selection == CMD_QUITTER) {
			this.estQuitte = true;
		} else {
			if (this.selection.estExecutable()) {
				this.selection.executer();
			} else {
				System.out.println("Opération non réalisable");
			}
		}
		
	}
	
	public void gerer() {
		do {
			// Afficher le menu
			this.afficher();

			// Sélectionner une entrée dans le menu
			this.selectionner();

			// Valider l'entrée sélectionnée
			this.valider();
		} while (this.mode == Mode.REMANANT && !this.estQuitte());
	}
	
	@Override
	public void executer() {
		this.gerer();
		
	}
	/** Un menu est exécutable dès que l'une de ses commandes l'est. */
	public boolean estExecutable() {
		boolean resultat = false;
		Iterator<Entree> it = this.entrees.iterator();
		while (!resultat && it.hasNext()) {
			Entree e = it.next();
			resultat = e.getCommande().estExecutable();
		}
		return resultat;
	}
}
