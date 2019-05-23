package model.fiche.attribut;

import java.util.Scanner;

public class ValeurString implements Valeur {

	private String donnee;
	
	public ValeurString(String donnee) {
		this.donnee = donnee;
	}
	
	@Override
	public ValeurString copier() {
		return new ValeurString(this.donnee);
	}

	@Override
	public void modifier() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Entrer la nouvelle valeur : ");
		this.donnee = scan.next();
	}
	
	public String toString() {
		return this.donnee;
	}

}
