package IHM;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

public abstract class JPanelAttribut extends JPanel {
	
	private JLabel titre;
	
	public JPanelAttribut(String titre) {
		super();
		setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));
		this.setBorder(BorderFactory.createLineBorder(Color.black));
		this.titre = new JLabel(titre);
		add(this.titre);
	}
	
	public abstract void enregistrer();
	
}
