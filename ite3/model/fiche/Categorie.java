package model.fiche;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;

import model.fiche.attribut.Attribut;

/**
 * Classe des catégories des fiches des jeux
 * @author E12
 */
public class Categorie extends FicheBase {

	/**
	 * Liste des attributs de la catégorie
	 */
	private ArrayList<Attribut<?>> attributs;
	private ArrayList<Attribut<String>> attributsString;
	private ArrayList<Attribut<Integer>> attributsInteger;
	private ArrayList<Attribut<Float>> attributsFloat;
	private ArrayList<Attribut<Fiche>> attributsFiche;
	
	/**
	 * Constructeur de catégorie
	 * @param nom Nom de la catégorie
	 */
	public Categorie(String nom) {
		super("", nom);
		this.attributs = new ArrayList<>();
		this.attributsString = new ArrayList<>();
		this.attributsFloat = new ArrayList<>();
		this.attributsInteger = new ArrayList<>();
		this.attributsFiche = new ArrayList<>();
	}
	
	public int getNombreAttributs() {
		return this.attributs.size();
	}
	
	/**
	 * Reinitialise les valeurs des attributs de la catégorie
	 */
	public void reinitialiserAttributs() {
		super.reinitialiserAttributs();
		for (Attribut<?> attribut : this.attributs)
			attribut.reinitialiser();
	}
	
	/**
	 * Ajoute un attribut à la catégorie
	 * @param ajout Attribut à ajouter à la catégorie
	 */
	public void ajouterAttributString(Attribut<String> ajout) {
		Attribut<String> copie = ajout.copier();
		this.attributs.add(copie);
		this.attributsString.add(copie);
	}
	
	/**
	 * Ajoute un attribut à la catégorie
	 * @param ajout Attribut à ajouter à la catégorie
	 */
	public void ajouterAttributInteger(Attribut<Integer> ajout) {
		Attribut<Integer> copie = ajout.copier();
		this.attributs.add(copie);
		this.attributsInteger.add(copie);
	}
	
	/**
	 * Ajoute un attribut à la catégorie
	 * @param ajout Attribut à ajouter à la catégorie
	 */
	public void ajouterAttributFloat(Attribut<Float> ajout) {
		Attribut<Float> copie = ajout.copier();
		this.attributs.add(copie);
		this.attributsFloat.add(copie);
	}
	
	/**
	 * Ajoute un attribut à la catégorie
	 * @param ajout Attribut à ajouter à la catégorie
	 */
	public void ajouterAttributFiche(Attribut<Fiche> ajout) {
		Attribut<Fiche> copie = ajout.copier();
		this.attributs.add(copie);
		this.attributsFiche.add(copie);
	}
	
	/**
	 * Retire un des attributs de la catégorie
	 * @param retrait Attribut à retirer de la catégorie
	 */
	public void retirerAttributString(Attribut<String> retrait) {
		this.attributs.remove(retrait);
		this.attributsString.remove(retrait);
	}
	
	/**
	 * Retire un des attributs de la catégorie
	 * @param retrait Attribut à retirer de la catégorie
	 */
	public void retirerAttributInteger(Attribut<Integer> retrait) {
		this.attributs.remove(retrait);
		this.attributsInteger.remove(retrait);
	}
	
	/**
	 * Retire un des attributs de la catégorie
	 * @param retrait Attribut à retirer de la catégorie
	 */
	public void retirerAttributFloat(Attribut<Float> retrait) {
		this.attributs.remove(retrait);
		this.attributsFloat.remove(retrait);
	}
	
	/**
	 * Retire un des attributs de la catégorie
	 * @param retrait Attribut à retirer de la catégorie
	 */
	public void retirerAttributFiche(Attribut<Fiche> retrait) {
		this.attributs.remove(retrait);
		this.attributsFiche.remove(retrait);
	}
	
	/**
	 * Retourne un itérateur de la liste des attributs de la catégorie
	 * @return Un itérateur de la liste des attributs de la catégorie
	 */
	public Iterator<Attribut<String>> iteratorAttributsString() {
		return this.attributsString.iterator();
	}
	
	/**
	 * Retourne un itérateur de la liste des attributs de la catégorie
	 * @return Un itérateur de la liste des attributs de la catégorie
	 */
	public Iterator<Attribut<Integer>> iteratorAttributsInteger() {
		return this.attributsInteger.iterator();
	}
	
	/**
	 * Retourne un itérateur de la liste des attributs de la catégorie
	 * @return Un itérateur de la liste des attributs de la catégorie
	 */
	public Iterator<Attribut<Float>> iteratorAttributsFloat() {
		return this.attributsFloat.iterator();
	}
	
	/**
	 * Retourne un itérateur de la liste des attributs de la catégorie
	 * @return Un itérateur de la liste des attributs de la catégorie
	 */
	public Iterator<Attribut<Fiche>> iteratorAttributsFiche() {
		return this.attributsFiche.iterator();
	}

}
