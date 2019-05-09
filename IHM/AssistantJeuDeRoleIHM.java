package IHM;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
/** 
 * 
 * Notre assistant qui pour le moment est chargé avec un jeu et un scénario pré-définis 
 *
 */
public class AssistantJeuDeRoleIHM extends JPanel {
		private Jeu jeu;
		private Scenario scenario;
		private JFrame fenetre;
		private JList<Scenario> jListeScenario;
		private JList<Fiche> jListeFiche;
		private JPanel panelAffichage;
		private JPanel grilleAffichage;
		private Fiche ficheSelectionnee; // La fiche sélectionnée à afficher
		private JMenuBar menuBar;
		private JMenu menuFiche;
		
		DefaultListModel<Fiche> modelFiche; //Le modèle des fiches pour rafraichir 
		
		public AssistantJeuDeRoleIHM(Scenario scenario) {
			this.jeu = scenario.getJeu();
			this.scenario = scenario;

			//Fenetre principal
			this.fenetre = new JFrame("Assistant de Jeu de Role ");
			this.fenetre.setLayout(new BorderLayout(30,15));
			
			
			//Création de la barre de menu
			this.menuBar = new JMenuBar();
			
			//Menu des fiches
			this.menuFiche = new JMenu("Fiche");
			//item ajouter une fiche perso
			JMenuItem menuItemAjouter = new JMenuItem("Ajouter une fiche personnage");
			menuItemAjouter.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent ev) {
					ajouterFiche();
					
				}
				
			});
			
			//ajout de l'item
			this.menuFiche.add(menuItemAjouter);
			
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
			this.modelFiche = new DefaultListModel<Fiche>();
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
			this.panelAffichage = new JPanel();
		
			this.grilleAffichage = new JPanel();
			this.panelAffichage.add(this.grilleAffichage);
			
			//Ajout des panels
			this.fenetre.add(panelListe, BorderLayout.WEST);
			this.fenetre.add(this.panelAffichage,BorderLayout.EAST);
			
			//Ajout du menu
			this.menuBar.add(this.menuFiche);
			fenetre.setJMenuBar(this.menuBar);
			
			fenetre.pack();
			fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			fenetre.setVisible(true);
		}
		
		
		
		
		
		
		
		protected void ajouterFiche() {
			Fiche nouvelleFiche = new FichePersonnage("nouvelle fiche", this.jeu);
			this.scenario.addFiche(nouvelleFiche);
			this.modelFiche.addElement(nouvelleFiche);
			
		}


		




		//Lorsque l'on clique sur une fiche
		private void jListeFicheValueChanged(javax.swing.event.ListSelectionEvent evt) {
			System.out.println("Changement fiche");
			this.ficheSelectionnee = jListeFiche.getSelectedValue();
			miseAJourAffichage();
			
		}
		
		/**Met a jour la fiche à afficher**/
		private void miseAJourAffichage() {
			HashMap<String, String> composants = this.ficheSelectionnee.getComposants();
			int nombreComposant = composants.size();
			GridLayout layout = new GridLayout(nombreComposant, 2, 10, 10);
			this.grilleAffichage = new JPanel(layout);

			for (Map.Entry<String, String> entree : composants.entrySet()) {
				
				this.grilleAffichage.add(new JLabel(entree.getKey()));
				JTextArea zoneTexte = new JTextArea(entree.getValue());
				this.grilleAffichage.add(zoneTexte);
				//Ajout d'un listener sur le texte
				zoneTexte.getDocument().addDocumentListener(new ActionZoneTexte(entree.getKey(),entree.getValue()));
			}
			this.panelAffichage = new JPanel();
			this.panelAffichage.add(this.grilleAffichage);
			this.fenetre.add(this.panelAffichage,BorderLayout.EAST);
			
			this.fenetre.setSize(new Dimension (800,600));
			
		}
		
		private void miseAJourValeur(String cle, String valeur) {
			System.out.println("changement");
			this.ficheSelectionnee.getComposants().replace(cle, valeur);
		}

		private class ActionZoneTexte implements DocumentListener {
			private String cle; // La clé à changer
			private String valeur; //La nouvelle valeur;
			
			public ActionZoneTexte(String cle, String valeur) {
				this.cle = cle;
				this.valeur = valeur;
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				miseAJourValeur(cle,valeur); //mise a jour 
				
			}

			@Override
			public void insertUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		}
}
