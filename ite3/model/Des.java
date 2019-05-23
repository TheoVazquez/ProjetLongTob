package model;

import java.util.Random;

public class Des {
	
	private int valeur; //La valeur du dé
	private int nombreFace; //Le nombre de face du dé
	
	public Des(int nombreFace) {
		this.nombreFace = nombreFace;
	}
	
	public int getValeur() {
		return this.valeur;
	}
	
	public int getNombreFace() {
		return this.nombreFace;
	}
	
	public void setValeur(int valeur) {
		
		this.valeur = valeur;
		
	}
	
	public void setNombreFace(int face) {
		this.nombreFace = face;
	}
	
	/*
	 * Lance le dés 
	 */
	public void lancer() {
		Random r = new Random();
		this.valeur = r.nextInt(this.nombreFace) +1; //r.nextInt((max - min) + 1) + min;
	}
}
