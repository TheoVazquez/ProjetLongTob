import java.util.Random;
import java.util.Scanner;

public class CommandeFaireUnJet implements Commande {

	private Scanner sc = new Scanner(System.in);
	private Random nbAlea = new Random();

	@Override
	public void executer() {
		Integer resultat = 0;
		Integer nbr_de = null;
		do {
			System.out.println("Combien de dés souhaitez-vous lancer ? ");
			try {
				nbr_de = Integer.parseInt(this.sc.nextLine());
			} catch(NumberFormatException e) {
				System.out.println("Vous devez donner un entier.");
			}
		} while ( nbr_de == null);

		for (int i = 1; i <= nbr_de; i++) {
			Integer nbr_faces = null;
			Integer resultat_lancer;
			do {
				System.out.println("Combien de faces possède le dé " + i );
				try {
					nbr_faces = Integer.parseInt(this.sc.nextLine());
				} catch(NumberFormatException e) {
					System.out.println("Vous devez donner un entier.");
				}
			} while ( nbr_faces == null);
			resultat_lancer = this.nbAlea.nextInt(nbr_faces) + 1;
			resultat = resultat + resultat_lancer;
			System.out.println("Resultat du lancer : " + resultat_lancer);
			System.out.println("Resultat total : " + resultat);
		}

		Integer modificateur = null;
		do {
			System.out.println("Souhaitez vous ajouter un modificateur de résultat ? (tapez 0 si vous ne voulez pas en appliquer)");
			try {
				modificateur = Integer.parseInt(this.sc.nextLine());
			} catch(NumberFormatException e) {
				System.out.println("Vous devez donner un entier.");
			}
		} while ( modificateur == null);
		resultat = resultat + modificateur;
		System.out.println("Resultat total : " + resultat);
		
		Integer multiplicateur = null;
		do {
			System.out.println("Souhaitez vous ajouter un multiplicateur au résultat ? (tapez 1 si vous ne voulez pas en appliquer)");
			try {
				multiplicateur = Integer.parseInt(this.sc.nextLine());
			} catch(NumberFormatException e) {
				System.out.println("Vous devez donner un entier.");
			}
		} while ( multiplicateur == null);
		resultat = resultat * multiplicateur;
		System.out.println("Resultat total : " + resultat);
	}

	@Override
	public boolean estExecutable() {
		//Toujours executable
		return true;
	}

}
