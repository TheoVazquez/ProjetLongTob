import java.awt.BorderLayout;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class AssistantJeuDeRoleIHM extends JPanel{
		private Jeu jeu;
		private Scenario scenario;
		private JFrame fenetre;
		private JList jListeScenario;
		private JList jListeLieu;
		private JList jListePerso;
		public AssistantJeuDeRoleIHM(Jeu jeu,Scenario scenario) {
			this.jeu = jeu;
			this.scenario = scenario;

			//Fenetre principal
			this.fenetre = new JFrame("Assistant de Jeu de Role ");
			this.fenetre.setLayout(new BorderLayout());
			
			
			//A l'ouest la liste des scénarios et des fiches
			JPanel panelListe = new JPanel(new BorderLayout());
		
			//Dans ce panel, à l'ouest la liste des scénarios :
			JPanel panelScenario = new JPanel();
			panelScenario.setLayout(new BoxLayout(panelScenario, BoxLayout.Y_AXIS));
			panelScenario.add(new JLabel("Scénarios : "));
			//Notre liste de scénario : 
			jListeScenario = new JList();
			jListeScenario.setModel(new AbstractListModel() {
				Scenario[] listeScenario = {scenario};

				@Override
				public Object getElementAt(int i) {
					return listeScenario[i];
				}

				@Override
				public int getSize() {
					return listeScenario.length;
				}
				
			});

			//ajout du listener quand on clique sur un élément de la liste
			jListeScenario.addListSelectionListener(new ListSelectionListener() {

				@Override
				public void valueChanged(ListSelectionEvent evt) {
					jListeScenarioValueChanged(evt);
					
				}
				
			});
			//On l'ajoute ensuite au panel
			panelScenario.add(jListeScenario);
			
			
			
			// A l'est la liste des fiches 
			JPanel panelFiche = new JPanel();
			panelFiche.setLayout(new BoxLayout(panelFiche,BoxLayout.Y_AXIS));
			panelFiche.add(new JLabel("Fiche Personnage : "));
			//Notre liste de personnage : 
			jListePerso = new JList();
			jListePerso.setModel(new AbstractListModel() {
				FichePersonnage[] listePerso = {new FichePersonnage("Fiche test",jeu)};

				@Override
				public Object getElementAt(int i) {
					return listePerso[i];
				}

				@Override
				public int getSize() {
					return listePerso.length;
				}
				
			});

			//ajout du listener quand on clique sur un élément de la liste
			jListeScenario.addListSelectionListener(new ListSelectionListener() {

				@Override
				public void valueChanged(ListSelectionEvent evt) {
					jListePersoValueChanged(evt);
					
				}
				
			});
			//On l'ajoute ensuite au panel
			panelFiche.add(jListePerso);
			
			//Notre liste de lieux : 
			jListeLieu = new JList();
			jListeLieu.setModel(new AbstractListModel() {
				FicheLieu[] listeLieu = {new FicheLieu("Fiche test lieu")};

				@Override
				public Object getElementAt(int i) {
					return listeLieu[i];
				}

				@Override
				public int getSize() {
					return listeLieu.length;
				}
				
			});

			//ajout du listener quand on clique sur un élément de la liste
			jListeLieu.addListSelectionListener(new ListSelectionListener() {

				@Override
				public void valueChanged(ListSelectionEvent evt) {
					jListeLieuValueChanged(evt);
					
				}
				
			});
			//On l'ajoute ensuite au panel
			panelFiche.add(jListeLieu);
			
			
			//Ajout des deux colonnes de listes :
			panelListe.add(panelScenario, BorderLayout.WEST);
			panelListe.add(new JSeparator(SwingConstants.VERTICAL));
			panelListe.add(panelFiche, BorderLayout.EAST);
			
			
			
			
			//A l'est un panel affichant la fiche selectionnée 
			JPanel panelAffichage = new JPanel();
			
			JTextArea zoneTexte = new JTextArea("Fiche sélectionnée : ");
			panelAffichage.add(zoneTexte);
			
			//Ajout des panels
			this.fenetre.add(panelListe, BorderLayout.WEST);
			panelListe.add(new JSeparator(SwingConstants.VERTICAL),BorderLayout.CENTER);
			this.fenetre.add(panelAffichage,BorderLayout.EAST);
			fenetre.pack();
			fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			fenetre.setVisible(true);
		}
		
		
		
		
		
		//Lorsque l'on clique sur un scénario
		private void jListeScenarioValueChanged(javax.swing.event.ListSelectionEvent evt) {
			String choix = (String) jListeScenario.getSelectedValue();
			
		}
		
		
		//Lorsque l'on clique sur un personnage
		private void jListePersoValueChanged(javax.swing.event.ListSelectionEvent evt) {
			String choix = (String) jListePerso.getSelectedValue();
			
		}
		
		//Lorsque l'on clique sur un lieu
		private void jListeLieuValueChanged(javax.swing.event.ListSelectionEvent evt) {
			String choix = (String) jListeLieu.getSelectedValue();
			
		}
}
