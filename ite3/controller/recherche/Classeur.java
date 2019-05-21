package controller.recherche;

import java.util.ArrayList;
import model.fiche.Fiche;

public class Classeur<F extends Fiche> extends ArrayList<F> {
	
	private String type;
	
	public Classeur(String type) {
		super();
		this.type = type;
	}
	
	public String getType() {
		return this.type;
	}
	
	public <C extends Classifieur<? super F>> F rechercherPremier(C classifieur) {
		F resultat = null;
		for (F fiche : this)
			if (classifieur.correspond(fiche))
				resultat = fiche;
		return resultat;
	}
	
	public <C extends Classifieur<? super F>> ArrayList<F> rechercherOccurrences(C classifieur) {
		ArrayList<F> resultat = new ArrayList<>();
		for (F fiche : this)
			if (classifieur.correspond(fiche))
				resultat.add(fiche);
		return resultat;
	}
	
	public <C extends Classifieur<? super F>> ArrayList<F> rechercherInferieurs(C classifieur) {
		ArrayList<F> resultat = new ArrayList<>();
		for (F fiche : this)
			if (classifieur.inferieur(fiche))
				resultat.add(fiche);
		return resultat;
	}
	
	public <C extends Classifieur<? super F>> ArrayList<F> rechercherSuperieurs(C classifieur) {
		ArrayList<F> resultat = new ArrayList<>();
		for (F fiche : this)
			if (classifieur.superieur(fiche))
				resultat.add(fiche);
		return resultat;
	}

}
