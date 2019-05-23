
public class CommandeJouerScenario implements Commande {

	Scenario scenario;
	/*
	 * initialise le scénario à jouer
	 */
	public CommandeJouerScenario(Scenario scenario) {
		this.scenario = scenario;
	}
	
	@Override
	public void executer() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean estExecutable() {
		// TODO Auto-generated method stub
		return false;
	}

}
