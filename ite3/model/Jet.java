package model;
/**
 * 
 * Un jet sera vu comme un ensemble de dés
 *
 */


public class Jet {
	
	private Des[] dés;
	private int somme; //la somme de tous les dés
	
	public Jet(int nombreDés, int face) {
		this.somme = 0;
		this.dés = new Des[nombreDés];
		for(int i = 0 ; i<nombreDés;i++) {
			this.dés[i] = new Des(face);
			this.dés[i].lancer();
			this.somme += this.dés[i].getValeur();
		}
		
		
	}
	
	public int getSomme() {
		return this.somme;
	}

}
