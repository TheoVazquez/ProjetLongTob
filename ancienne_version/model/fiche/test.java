package model.fiche;

import model.Jeu;
import model.JeuCthulhu;

public class test {
	
	public static void main(String[] args) {
		Jeu jeu = new JeuCthulhu();
		FichePersonnage f = new FichePersonnage(jeu, "perso");
		System.out.println(f);
	}

}
