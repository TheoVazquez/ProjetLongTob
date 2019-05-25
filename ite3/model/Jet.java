package model;

import java.util.ArrayList;

public class Jet {
	
	private Des[] des;
	private int somme; //la somme de tous les des
	private ArrayList<Integer> jets = new ArrayList<Integer>(); // le resultat de chaque jet on utilise un ArrayList car plus simple pour affichage
	
	public Jet(int nombreDes, int face) {
		this.somme = 0;
		this.des = new Des[nombreDes];
		for(int i = 0 ; i<nombreDes;i++) {
			this.des[i] = new Des(face);
			this.des[i].lancer();
			this.jets.add(this.des[i].getValeur());  // on ajoute valeur du jet
			this.somme += this.des[i].getValeur();
		}
	}
	
	// constructeur avec modificateurs, additionneur vaut 0 si il y en a pas, multiplicateur vaut 0 si il y en a pas, surChaque vaut true si les modifications s'appliquent sur chaque jet
	public Jet(int nombreDes, int face, int additionneur, int multiplicateur, boolean surChaque) {
		
		this.somme = 0;
		
		if (!surChaque) { // les modifications s'appliquent au resultat final
		
			this.des = new Des[nombreDes];
			for(int i = 0 ; i<nombreDes;i++) {
				this.des[i] = new Des(face);
				this.des[i].lancer();
				this.jets.add(this.des[i].getValeur()); // on ajoute valeurs du jet 
				this.somme += this.des[i].getValeur();
			}
		
			if (additionneur == 0) { // on n'a que un multiplicateur
			
				this.somme = this.somme * multiplicateur;
			
			}
		
			else if(multiplicateur == 0 ) { // on n'a que un additionneur
			
				this.somme += additionneur;
			}
			
			else { // on a les deux, on fait d'abord multiplication
				this.somme = (this.somme * multiplicateur) + additionneur;
			}
		}
		
		else { // les modifications s'appliquent sur chaque jet 
			
			this.des = new Des[nombreDes];
			for(int i = 0 ; i<nombreDes;i++) {
				this.des[i] = new Des(face);
				this.des[i].lancer();
				
				if (additionneur == 0) { // pas d'addtionneur 
					this.jets.add(this.des[i].getValeur() * multiplicateur); // on ajoute jet modifie
					this.somme += (this.des[i].getValeur() * multiplicateur);
				}
				else if (multiplicateur == 0) { // pas de multiplicateur
					this.jets.add(this.des[i].getValeur() + additionneur); // idem 
					this.somme += (this.des[i].getValeur() + additionneur);
				}
				else { // additionneur et multiplicateur
					this.jets.add((this.des[i].getValeur() * multiplicateur)+additionneur); // idem
					this.somme += ((this.des[i].getValeur()*multiplicateur)+additionneur);
				}
			}
		}
	}
	
	public int getSomme() {
		return this.somme;
	}
	
	public ArrayList<Integer> getJets() {
		return this.jets;
	}

}
