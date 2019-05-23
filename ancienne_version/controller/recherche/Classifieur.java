package controller.recherche;

import model.fiche.Fiche;

public interface Classifieur<F extends Fiche> {
	
	public boolean correspond(F fiche);
	
	public boolean inferieur(F fiche);
	
	public boolean superieur(F fiche);
	
}
