package IHM;

import javax.swing.JTextArea;
import controller.GestionnaireAttribut;

public class JPanelAttributInteger extends JPanelAttribut {

	private JTextArea entree;
	private GestionnaireAttribut<Integer> gestionnaire;

	public JPanelAttributInteger(GestionnaireAttribut<Integer> gestionnaire) {
		super(gestionnaire.getNomAttribut());
		this.entree = new JTextArea(3,40);
		this.entree.setText(gestionnaire.getValeurAttribut().toString());
		add(this.entree);
		this.gestionnaire = gestionnaire;
	}

	@Override
	public void enregistrer() {
		this.gestionnaire.setValeurAttribut(Integer.valueOf(this.entree.getText()));
	}
	
	@Override
	public String externalSave() {
		return "NI"+gestionnaire.getNomAttribut()+"#"+gestionnaire.getValeurAttribut().toString();
		
	}
	
	@Override
	public void charger(String nom, String valeur) {
		gestionnaire.setNomAttribut(nom);
		gestionnaire.setValeurAttribut(Integer.valueOf(valeur));		
	}

}
