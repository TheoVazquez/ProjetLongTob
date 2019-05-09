package IHM;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.HashMap;
import java.util.Map;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
/** 
 * 
 * Notre assistant qui pour le moment est chargé avec un jeu et un scénario pré-définis 
 *
 */
public class AssistantJeuDeRoleIHM extends JPanel{
		private Jeu jeu;
		private Scenario scenario;
		private JFrame fenetre;
		private JList<Scenario> jListeScenario;
		private JList<Fiche> jListeFiche;
		private JPanel grilleAffichage;
		private Fiche ficheSelectionnee; // La fiche sélectionnée à afficher
		
		public AssistantJeuDeRoleIHM(Scenario scenario) {
			this.jeu = scenario.getJeu();
			this.scenario = scenario;

			//Fenetre principal
			this.fenetre = new JFrame("Assistant de Jeu de Role ");
			this.fenetre.setLayout(new BorderLayout(30,15));
			
			
			//A l'ouest la liste des scénarios et des fiches
			JPanel panelListe = new JPanel(new BorderLayout());
		
			//Dans ce panel, à l'ouest la liste des scénarios :
			JPanel panelScenario = new JPanel();
			panelScenario.setLayout(new BoxLayout(panelScenario, BoxLayout.Y_AXIS));
			panelScenario.add(new JLabel("Scénarios : "));
			//Notre liste de scénario : 
			DefaultListModel<Scenario> modelScenario = new DefaultListModel<Scenario>();
			modelScenario.addElement(scenario);
			this.jListeScenario = new JList<Scenario>(modelScenario);
			
			

			//On l'ajoute ensuite au panel
			panelScenario.add(jListeScenario);
			
			
			
			// A l'est la liste des fiches 
			JPanel panelFiche = new JPanel();
			panelFiche.setLayout(new BoxLayout(panelFiche,BoxLayout.Y_AXIS));
			panelFiche.add(new JLabel("Fiches"));
			//Notre liste de Fiche : 
			DefaultListModel<Fiche> modelFiche = new DefaultListModel<Fiche>();
			for(Fiche fiche: scenario.getListeFiche()) {
				modelFiche.addElement(fiche);
			}
			this.jListeFiche = new JList<Fiche>(modelFiche);

			//ajout du listener quand on clique sur un élément de la liste
			jListeFiche.addListSelectionListener(new ListSelectionListener() {

				@Override
				public void valueChanged(ListSelectionEvent evt) {
				    if (!evt.getValueIsAdjusting()) {//Cette ligne évite les doublons

				    
					jListeFicheValueChanged(evt);
				    }
				}
				
			});
			//On l'ajoute ensuite au panel
			panelFiche.add(jListeFiche);
			
			
			
			
			//Ajout des deux colonnes de listes :
			panelListe.add(panelScenario, BorderLayout.WEST);
			panelListe.add(new JSeparator(SwingConstants.VERTICAL));
			panelListe.add(panelFiche, BorderLayout.EAST);
			
			
			
			
			//A l'est un panel affichant la fiche selectionnée 
			JPanel panelAffichage = new JPanel();
		
			this.grilleAffichage = new JPanel();
			panelAffichage.add(this.grilleAffichage);
			//Ajout des panels
			this.fenetre.add(panelListe, BorderLayout.WEST);
			this.fenetre.add(panelAffichage,BorderLayout.EAST);
			fenetre.pack();
			fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			fenetre.setVisible(true);
		}
		
		
		
		
		
		
		
		//Lorsque l'on clique sur une fiche
		private void jListeFicheValueChanged(javax.swing.event.ListSelectionEvent evt) {
			System.out.println("Changement fiche");
			this.ficheSelectionnee = jListeFiche.getSelectedValue();
			miseAJour();
			
		}
		
		/**Met a jour la fiche à afficher**/
		private void miseAJour() {
			HashMap<String, String> composants = this.ficheSelectionnee.getComposants();
			int nombreComposant = composants.size();
			GridLayout layout = new GridLayout(nombreComposant, 2, 10, 10);
			this.grilleAffichage.setLayout(layout);
			
			int i =1;
			for (Map.Entry<String, String> entree : composants.entrySet()) {
				
				this.grilleAffichage.add(new JLabel(entree.getKey()));
				this.grilleAffichage.add(new JTextArea(entree.getValue()));
				i++;
				System.out.println(i);
				
			}
			this.fenetre.pack();
			
		}
		
}
