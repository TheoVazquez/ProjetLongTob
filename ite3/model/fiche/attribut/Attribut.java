package model.fiche.attribut;

/**
 * Classe des attributs des fiches des jeux
 * @author E12
 */
public class Attribut<T> {
	
	/**
	 * Nom de l'attribut
	 */
	public String nom;
	
	/**
	 * Valeur de l'attribut
	 */
	private T valeur;
	private T valeurInitiale;
	
	/**
	 * Constructeur d'attribut
	 * @param nom Nom de l'attribut
	 * @param valeur Valeur de l'attribut
	 */
	public Attribut(String nom, T valeur) {
		this.nom = nom;
		this.valeur = valeur;
		this.valeurInitiale = valeur;
	}
	
	/**
	 * Retourne le nom de l'attribut
	 * @return Le nom de l'attribut
	 */
	public String getNom() {
		return this.nom;
	}
	
	/**
	 * Modifie le nom de l'attribut
	 * @param nom Nouveau nom de l'attribut
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	/**
	 * Retourne la valeur de l'attribut
	 * @return La valeur de l'attribut
	 */
	public T getValeur() {
		return this.valeur;
	}
	
	/**
	 * Modifie la valeur de l'attribut
	 */
	public void setValeur(T valeur) {
		this.valeur = valeur;
	}
	
	/**
	 * Réinitialise la valeur de l'attribut
	 */
	public void reinitialiser() {
		this.valeur = this.valeurInitiale;
	}
	
	/**
	 * Affiche l'attribut
	 */
	public String toString() {
		return this.nom + " : " + this.valeur.toString();
	}

}
