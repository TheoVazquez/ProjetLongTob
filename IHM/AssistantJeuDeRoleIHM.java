package IHM;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
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
		private JFrame fenetre; //fenetre principale
		private JList<Scenario> jListeScenario;
		private JList<Fiche> jListeFiche;
		private JPanel panelAffichage;
		private JPanel grilleAffichage;
		private Fiche ficheSelectionnee; // La fiche sélectionnée à afficher
		private JMenuBar menuBar;
		private JMenu menuFiche;
		private JButton bEnregistrer; 
		private ActionListener actionEnregistrer;
		private ArrayList<JTextArea> listeChamp; //La liste des champs modifiables
		private JButton bNouvelAttribut;	
		private ActionListener actionNouvelAttribut;
		private JFrame fenetreNouvelAttribut;
		private JTextArea zoneNom; //utile pour ajouter un nouvel attribut
		
		DefaultListModel<Fiche> modelFiche; //Le modèle des fiches pour rafraichir 
		
		public AssistantJeuDeRoleIHM(Scenario scenario) {
			this.jeu = scenario.getJeu();
			this.scenario = scenario;

			//Fenetre principal
			this.fenetre = new JFrame("Assistant de Jeu de Role ");
			this.fenetre.setLayout(new BorderLayout(30,15));
			
			
			//Création de la barre de menu
			this.menuBar = new JMenuBar();
			
			//Création des boutons
			this.bEnregistrer = new JButton("Enregistrer");
			this.bNouvelAttribut = new JButton("Ajouter un attribut");
			
			//ActionListener
			this.actionEnregistrer = new ActionEnregistrer();
			this.bEnregistrer.addActionListener(this.actionEnregistrer);
			this.actionNouvelAttribut = new ActionNouvelAttribut();
			this.bNouvelAttribut.addActionListener(this.actionNouvelAttribut);
			//Menu des fiches
			this.menuFiche = new JMenu("Fiche");
			//item ajouter une fiche perso
			JMenuItem menuItemAjouterPerso = new JMenuItem("Ajouter une fiche personnage");
			menuItemAjouterPerso.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent ev) {
					ajouterFichePerso();
				}
			});
			
			//item ajouter une fiche lieu
			JMenuItem menuItemAjouterLieu = new JMenuItem("Ajouter une fiche lieu");
			menuItemAjouterLieu.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent ev) {
					ajouterFicheLieu();
				}
			});
			
			//ajout de l'item
			this.menuFiche.add(menuItemAjouterPerso);
			this.menuFiche.add(menuItemAjouterLieu);
			
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
			this.fenetre.add(this.panelAffichage,BorderLayout.CENTER);
			
			//Ajout du menu
			this.menuBar.add(this.menuFiche);
			fenetre.setJMenuBar(this.menuBar);
			
			
			this.fenetre.setSize(new Dimension (800,600));
			fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			fenetre.setVisible(true);
			
			this.jListeScenario.setSelectedIndex(0); //On affiche par défaut le premier scénario
			this.jListeFiche.setSelectedIndex(0); //On affiche par défaut la première fiche
		}
		
		
		
		
		/**Action de l'ajout des fiches **/
		
		
		protected void ajouterFichePerso() {
			Fiche nouvelleFiche = new FichePersonnage("nouvelle fiche perso", this.jeu);
			this.scenario.addFiche(nouvelleFiche);
			this.modelFiche.addElement(nouvelleFiche);
			
		}
		
		protected void ajouterFicheLieu() {
			Fiche nouvelleFiche = new FicheLieu("nouvelle fiche lieu", this.jeu);
			this.scenario.addFiche(nouvelleFiche);
			this.modelFiche.addElement(nouvelleFiche);
			
		}


		




		//Lorsque l'on clique sur une fiche
		private void jListeFicheValueChanged(javax.swing.event.ListSelectionEvent evt) {
			this.ficheSelectionnee = jListeFiche.getSelectedValue();
			miseAJourAffichage();
			
		}
		
		/**Met a jour la fiche à afficher**/
		private void miseAJourAffichage() {
			HashMap<String, String> composants = this.ficheSelectionnee.getComposants();
			int nombreComposant = composants.size();
			GridLayout layout = new GridLayout(nombreComposant, 2, 0, 10);
			this.grilleAffichage = new JPanel(layout);
			this.listeChamp = new ArrayList<JTextArea>();
			
			for (Map.Entry<String, String> entree : composants.entrySet()) {
				
				this.grilleAffichage.add(new JLabel(entree.getKey()));
				JTextArea zoneTexte = new JTextArea(3,40);
				zoneTexte.setText(entree.getValue());
				this.grilleAffichage.add(zoneTexte);
				this.listeChamp.add(zoneTexte);
			}
			
			
			this.fenetre.remove(this.panelAffichage); //Reinitialisation
			this.panelAffichage = new JPanel(new BorderLayout());
			this.panelAffichage.add(this.grilleAffichage,BorderLayout.CENTER); //Ajout de la grille
			
			//On peut maintenant mettre nos boutons
			JPanel panelBouton = new JPanel(new FlowLayout());
			panelBouton.add(this.bEnregistrer);
			panelBouton.add(this.bNouvelAttribut);
			
			this.panelAffichage.add(panelBouton,BorderLayout.SOUTH);
			this.fenetre.add(this.panelAffichage,BorderLayout.CENTER);
			this.fenetre.pack();
			
		}
		
		/**
		 * Sauvegarde la fiche selectionée 
		 */
		private void sauvegarder() {
			HashMap<String, String> composants = this.ficheSelectionnee.getComposants();
			
			//Itéation de la hashmap
			int i =0;
			for (Map.Entry<String, String> entree : composants.entrySet()) {
				String cle = entree.getKey();
				System.out.println(cle);
				String oldvaleur = entree.getValue();
				JTextArea zoneTexte = this.listeChamp.get(i);
				String newValeur = zoneTexte.getText();
				i++;
				
				//Sauvegarde des attributs en interne
				composants.replace(cle, newValeur);
				
				//TODO Sauvegarde en externe pour pouvoir retrouver nos fiches après lors d'une autre session
				
				
			}
		}
		
		private void ajouterAttribut() {
			this.fenetreNouvelAttribut = new JFrame("ajouter attribut");
			fenetreNouvelAttribut.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			fenetreNouvelAttribut.setVisible(true);
			JPanel panelNouvelAttribut = new JPanel(new BorderLayout());
			panelNouvelAttribut.add(new JLabel("Entrez le nom du nouvel attribut : "),BorderLayout.NORTH);
			this.zoneNom = new JTextArea(1,10); 
			panelNouvelAttribut.add(zoneNom,BorderLayout.CENTER);
			JButton bValider = new JButton("Valider");
			bValider.addActionListener(new ActionOkNouvelAttribut());
			panelNouvelAttribut.add(bValider,BorderLayout.SOUTH);
			fenetreNouvelAttribut.add(panelNouvelAttribut);
			fenetreNouvelAttribut.setSize(400, 200);;
		}
		
		private void validerNouvelAttribut() {
			this.ficheSelectionnee.getComposants().put(this.zoneNom.getText(), "");//On ajoute un nouvel attribut dont le nom est dans la zone de texte
			this.fenetreNouvelAttribut.dispose();//on ferme cette fenetre
			miseAJourAffichage();
		}
		
		private class ActionEnregistrer implements ActionListener {
			//Quand j'appuie sur le bouton enregistrer
			@Override
			public void actionPerformed(ActionEvent ev) {
				sauvegarder();
				
			}
			
		}
		
		private class ActionNouvelAttribut implements ActionListener{
			//Quand j'appuie sur le bouton nouvel attribut
			@Override
			public void actionPerformed(ActionEvent ev) {
				
				ajouterAttribut();
				miseAJourAffichage();
			}
			
		}
		
		private class ActionOkNouvelAttribut implements ActionListener{
			@Override
			public void actionPerformed(ActionEvent e) {
				validerNouvelAttribut();
				
			}
			
		}
}
