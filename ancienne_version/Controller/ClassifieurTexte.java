package Controller;

import Model.FicheNom;

public class ClassifieurTexte extends ClassifieurComparaison<FicheNom, String> {

	@Override
	public boolean correspond(FicheNom fiche) {
		if (getComparateur().compareTo(fiche.getNom()) == 0)
			return true;
		return false;
	}

	@Override
	public boolean inferieur(FicheNom fiche) {
		if (getComparateur().compareTo(fiche.getNom()) > 0)
			return true;
		return false;
	}

	@Override
	public boolean superieur(FicheNom fiche) {
		if (getComparateur().compareTo(fiche.getNom()) < 0)
			return true;
		return false;
	}

}
