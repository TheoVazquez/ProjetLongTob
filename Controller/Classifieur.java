package Controller;

import Model.Fiche;

public interface Classifieur<F extends Fiche> {
	
	public boolean correspond(F fiche);
	
	public boolean inferieur(F fiche);
	
	public boolean superieur(F fiche);
	
}
