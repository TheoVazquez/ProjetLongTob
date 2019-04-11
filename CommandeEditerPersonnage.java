import java.util.Scanner;

public class CommandeEditerPersonnage implements Commande {
	
	private Scenario scenario;
	
	public CommandeEditerPersonnage(Scenario scenario){
		this.scenario = scenario;
	}
	
	@Override
	public void executer() {
		Scanner sc = new Scanner(System.in);

	}

	@Override
	public boolean estExecutable() {
		// TODO Auto-generated method stub
		return true;
	}

}
