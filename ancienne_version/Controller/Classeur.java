package Controller;

import java.util.ArrayList;
import Model.Fiche;

public class Classeur<F extends Fiche> {
	
	private ArrayList<F> fiches;
	
	public Classeur(){
		this.fiches = new ArrayList<>();
	}
	
	public void ajouterFiche(F fiche) {
		this.fiches.add(fiche);
	}
	
	public <C extends Classifieur<? super F>> F rechercherPremier(C classifieur) {
		F resultat = null;
		for (F fiche : this.fiches)
			if (classifieur.correspond(fiche))
				resultat = fiche;
		return resultat;
	}
	
	public <C extends Classifieur<? super F>> ArrayList<F> rechercherOccurrences(C classifieur) {
		ArrayList<F> resultat = new ArrayList<>();
		for (F fiche : this.fiches)
			if (classifieur.correspond(fiche))
				resultat.add(fiche);
		return resultat;
	}
	
	public <C extends Classifieur<? super F>> ArrayList<F> rechercherInferieurs(C classifieur) {
		ArrayList<F> resultat = new ArrayList<>();
		for (F fiche : this.fiches)
			if (classifieur.inferieur(fiche))
				resultat.add(fiche);
		return resultat;
	}
	
	public <C extends Classifieur<? super F>> ArrayList<F> rechercherSuperieurs(C classifieur) {
		ArrayList<F> resultat = new ArrayList<>();
		for (F fiche : this.fiches)
			if (classifieur.superieur(fiche))
				resultat.add(fiche);
		return resultat;
	}

}
