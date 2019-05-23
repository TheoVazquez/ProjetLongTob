package controller.recherche;

import model.fiche.FicheBase;

public class ClassifieurNom extends ClassifieurComparaison<FicheBase, String> {

	@Override
	public boolean correspond(FicheBase fiche) {
		if (getComparateur().compareTo(fiche.getNom()) == 0)
			return true;
		return false;
	}

	@Override
	public boolean inferieur(FicheBase fiche) {
		if (getComparateur().compareTo(fiche.getNom()) > 0)
			return true;
		return false;
	}

	@Override
	public boolean superieur(FicheBase fiche) {
		if (getComparateur().compareTo(fiche.getNom()) < 0)
			return true;
		return false;
	}

}
