package model.fiche.attribut;

public class Attribut {
	
	public String nom;
	public Valeur valeur;
	
	public Attribut(String nom, Valeur valeur) {
		this.nom = nom;
		this.valeur = valeur.copier();
	}
	
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public void modifierValeur() {
		this.valeur.modifier();
	}
	
	public String toString() {
		return this.nom + " : " + this.valeur.toString();
	}

}
