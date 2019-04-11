
public class CommandeEditerScenario implements Commande {

	Scenario scenario;
	/*
	 * initialise le scénario à éditer
	 */
	public CommandeEditerScenario(Scenario scenario) {
		this.scenario = scenario;
	}
	@Override
	public void executer() {
		
	}

	@Override
	public boolean estExecutable() {
		// TODO Auto-generated method stub
		return true;
	}

}
