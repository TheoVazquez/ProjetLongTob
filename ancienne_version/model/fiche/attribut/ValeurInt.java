package model.fiche.attribut;

import java.util.Scanner;

public class ValeurInt implements Valeur{

	private int donnee;
	
	public ValeurInt(int donnee) {
		this.donnee = donnee;
	}
	
	@Override
	public ValeurInt copier() {
		return new ValeurInt(this.donnee);
	}

	@Override
	public void modifier() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Entrer la nouvelle valeur : ");
		this.donnee = scan.nextInt();
	}
	
	public String toString() {
		return Integer.toString(this.donnee);
	}

}
