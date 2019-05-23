package controller.recherche;

import model.fiche.Fiche;

public abstract class ClassifieurComparaison<F extends Fiche, C extends Comparable<C>> implements Classifieur<F> {
	
	private C comparateur;
	
	public ClassifieurComparaison() {}
	
	public void setComparateur(C comparateur) {
		this.comparateur = comparateur;
	}
	
	public C getComparateur() {
		return this.comparateur;
	}

}
