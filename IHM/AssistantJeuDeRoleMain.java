package IHM;


public class AssistantJeuDeRoleMain {

	public static void main(String[] args) {
		System.out.println("Bienvenue sur la démonstration de notre assistant de JDR");
		System.out.println("Dans cette version, le jeu et le scénario seront préchargés");
		Jeu jeu = new JeuCthulhu();
		Scenario scenario = new Scenario("Mon sc�nario", jeu);
		//AssistantJeuDeRole assistant = new AssistantJeuDeRole(jeu, scenario);
		//assistant.utiliser();
		AssistantJeuDeRoleIHM assistant = new AssistantJeuDeRoleIHM(scenario);
	}

}
