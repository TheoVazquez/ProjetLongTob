package model;

import controller.recherche.Classeur;
import model.fiche.Fiche;
import model.fiche.FicheLieu;
import model.fiche.FichePersonnage;

public class Scenario {
	
	private Classeur<FicheLieu> listeLieux = new Classeur<FicheLieu>();
	private Classeur<FichePersonnage> listePersonnages = new Classeur<FichePersonnage>();
	private Fiche ficheCourante;
	
	public void ajouterLieu(FicheLieu nouveauLieu) {
		listeLieux.add(nouveauLieu);
	}

	public void ajouterPersonnage(FichePersonnage nouveauPersonnage) {
		listePersonnages.add(nouveauPersonnage);
	}
	
	public void supprimerFicheCourante() {
		this.listeLieux.remove(this.ficheCourante);
		this.listePersonnages.remove(this.ficheCourante);
		this.ficheCourante = null;
	}
	
	public int nombreLieux() {
		return this.listeLieux.size();
	}
	
	public int nombrePersonnages() {
		return this.listePersonnages.size();
	}
	
	public int nombreFiches() {
		return this.listeLieux.size() + this.listePersonnages.size();
	}
	
	public Fiche getFicheCourante() {
		return this.ficheCourante;
	}
	
	public Classeur<FicheLieu> getListeLieux() {
		return listeLieux;
	}
	
    public Classeur<FichePersonnage> getListePersonnage() {
		return listePersonnages;
	}
    
    public void setFicheCourante(Fiche fiche) {
    	this.ficheCourante = fiche;
    }
    
    public String toString() {
    	StringBuilder fiches = new StringBuilder();
    	for (FicheLieu fiche : this.listeLieux) {
    		fiches.append(fiche.toString() + "\n");
    	}
    	for (FichePersonnage fiche : this.listePersonnages) {
    		fiches.append(fiche.toString() + "\n");
    	}
    	return fiches.toString();
    }

}
