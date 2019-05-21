package IHM;

import javax.swing.JTextArea;

import controller.GestionnaireAttribut;

public class JPanelAttributString extends JPanelAttribut {

	private JTextArea entree;
	private GestionnaireAttribut<String> gestionnaire;
	
	public JPanelAttributString(GestionnaireAttribut<String> gestionnaire) {
		super(gestionnaire.getNomAttribut());
		this.entree = new JTextArea(3,40);
		this.entree.setText(gestionnaire.getValeurAttribut());
		add(this.entree);
		this.gestionnaire = gestionnaire;
	}
	
	@Override
	public void enregistrer() {
		this.gestionnaire.setValeurAttribut(this.entree.getText());
	}

}
