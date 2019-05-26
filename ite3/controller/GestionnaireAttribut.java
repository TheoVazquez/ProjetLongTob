package controller;

import model.fiche.attribut.Attribut;

public class GestionnaireAttribut<T> {

	private Attribut<T> attribut;
	
	public GestionnaireAttribut(Attribut<T> attribut) {
		this.attribut = attribut;
	}
	
	public String getNomAttribut() {
		return this.attribut.getNom();
	}
	
	public T getValeurAttribut() {
		return this.attribut.getValeur();
	}
	
	public void setValeurAttribut(T valeur) {
		this.attribut.setValeur(valeur);
	}
	
	public void setNomAttribut(String nom) {
		this.attribut.setNom(nom);
	}
	
}
