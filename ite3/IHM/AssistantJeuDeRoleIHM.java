package IHM;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import controller.GestionnaireAttribut;
import controller.recherche.Classeur;
import model.Jeu;
import model.fiche.Categorie;
import model.fiche.Fiche;
import model.fiche.FicheBase;
import model.fiche.attribut.Attribut;

/**  
 * Notre assistant qui pour le moment est charg� avec un jeu et un sc�nario pr�-d�finis 
 *
 */
public class AssistantJeuDeRoleIHM extends JPanel {
	
		private Jeu jeu;
		private model.Scenario scenario;
		private JFrame fenetre;
		private JList<model.Scenario> jListeScenario;
		private JList<Fiche> jListeFiche;
		private JPanel panelAffichage;
		private JPanel grilleAffichage;
		private JPanel panelFiche;
		private Fiche ficheSelectionnee; // La fiche s�lectionn�e à afficher
		private JMenuBar menuBar;
		private JMenu menuFiche;
		private JButton bEnregistrer; 
		private ActionListener actionEnregistrer;
		private ArrayList<JPanelAttribut> listeChamp; //La liste des champs modifiables
		private JButton bNouvelAttribut;	
		private ActionListener actionNouvelAttribut;
		private JFrame fenetreNouvelAttribut;
		private JTextArea zoneNom; //utile pour ajouter un nouvel attribut

		
		DefaultListModel<Fiche> modelFiche; //Le modèle des fiches pour rafraichir 
		
		public AssistantJeuDeRoleIHM(model.Scenario scenario) {
			this.jeu = scenario.getJeu();
			this.scenario = scenario;

			//Fenetre principal
			this.fenetre = new JFrame("Assistant de Jeu de Role ");
			this.fenetre.setLayout(new BorderLayout(30,15));
			
			
			//Cr�ation de la barre de menu
			this.menuBar = new JMenuBar();
			
			//Cr�ation des boutons
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
			
			//A l'ouest la liste des sc�narios et des fiches
			JPanel panelListe = new JPanel(new BorderLayout());
		
			//Dans ce panel, � l'ouest la liste des sc�narios :
			JPanel panelScenario = new JPanel();
			panelScenario.setLayout(new BoxLayout(panelScenario, BoxLayout.Y_AXIS));
			panelScenario.add(new JLabel("Scenarios : "));
			//Notre liste de scenario : 
			DefaultListModel<model.Scenario> modelScenario = new DefaultListModel<>();
			modelScenario.addElement(scenario);
			this.jListeScenario = new JList<>(modelScenario);
			
			

			//On l'ajoute ensuite au panel
			panelScenario.add(jListeScenario);
			
			
			
			// A l'est la liste des fiches 
			this.panelFiche = new JPanel();
			panelFiche.setLayout(new BoxLayout(panelFiche,BoxLayout.Y_AXIS));
			panelFiche.add(new JLabel("Fiches"));
			//Notre liste de Fiche : 
			this.modelFiche = new DefaultListModel<Fiche>();
	    	for (String cle : this.scenario.getTypes()) {
				for(FicheBase fiche: this.scenario.getClasseur(cle)) {
					modelFiche.addElement(fiche);
				}
	    	}
			this.jListeFiche = new JList<Fiche>(modelFiche);

			//ajout du listener quand on clique sur un �l�ment de la liste
			jListeFiche.addListSelectionListener(new ListSelectionListener() {

				@Override
				public void valueChanged(ListSelectionEvent evt) {
				    if (!evt.getValueIsAdjusting()) {//Cette ligne �vite les doublons

				    
					jListeFicheValueChanged(evt);
				    }
				}
				
			});
			
			//Ajout d'un listener de clique droit
			jListeFiche.addMouseListener(new MouseAdapter() {
				public void mousePressed(MouseEvent e) {
					fiche_mousePressed(e);
				}
			});
			
			//On l'ajoute ensuite au panel
			panelFiche.add(jListeFiche);
			
			
			
			
			//Ajout des deux colonnes de listes :
			panelListe.add(panelScenario, BorderLayout.WEST);
			panelListe.add(new JSeparator(SwingConstants.VERTICAL));
			panelListe.add(panelFiche, BorderLayout.EAST);
			
			
			
			
			//A l'est un panel affichant la fiche selectionn�e 
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
		}
		
		
		
		
		/**Action de l'ajout des fiches **/
		
		
		protected void ajouterFichePerso() {
			Fiche nouvelleFiche = this.scenario.ajouterFiche("Personnage");
			this.modelFiche.addElement(nouvelleFiche); //ajoute la fiche au mod�le pour rafraichir la liste des fiches
			
		}
		
		protected void ajouterFicheLieu() {
			Fiche nouvelleFiche = this.scenario.ajouterFiche("Lieu");
			this.modelFiche.addElement(nouvelleFiche);
			
		}


		/**Action de clique sur les fiches**/
		protected void fiche_mousePressed(MouseEvent e) {
			
			int buttonDown = e.getButton(); //le bouton press�
			
			if (buttonDown == MouseEvent.BUTTON3) { //le clique droit
				JPopupMenu menu = new JPopupMenu();
				JMenuItem itemRenommer = new JMenuItem("renommer");
				JMenuItem itemSupprimer = new JMenuItem("supprimer");
				//ajout des items
				menu.add(itemRenommer);
				menu.add(itemSupprimer);
				menu.show(this.panelFiche,e.getX(),e.getY());
			}
			
		}




		//Lorsque l'on clique sur une fiche
		private void jListeFicheValueChanged(javax.swing.event.ListSelectionEvent evt) {
			this.ficheSelectionnee = jListeFiche.getSelectedValue();
			miseAJourAffichage();
			
		}
		
		/**Met a jour la fiche � afficher**/
		private void miseAJourAffichage() {
			this.grilleAffichage = new JPanel();
			this.grilleAffichage.setLayout(new BoxLayout(this.grilleAffichage, BoxLayout.PAGE_AXIS));
			this.listeChamp = new ArrayList<JPanelAttribut>();
			Iterator<Categorie> iterateur = this.ficheSelectionnee.iteratorCategories();
			while (iterateur.hasNext()) {	
				this.grilleAffichage.add(miseAJourAffichageCategorie(iterateur.next()));
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
		
		private JPanel miseAJourAffichageCategorie(Categorie categorie) {
			JPanel grille = new JPanel();
			grille.setLayout(new BoxLayout(grille, BoxLayout.PAGE_AXIS));
			grille.add(new JLabel(categorie.getType()));
			Iterator<Attribut<String>> iterateurString = categorie.iteratorAttributsString();
			while (iterateurString.hasNext()) {
				Attribut<String> attribut = iterateurString.next();
				GestionnaireAttribut<String> gestionnaire = new GestionnaireAttribut<>(attribut);
				JPanelAttribut panel = new JPanelAttributString(gestionnaire);
				grille.add(panel);
				this.listeChamp.add(panel);
			}
			Iterator<Attribut<Integer>> iterateurInteger = categorie.iteratorAttributsInteger();
			while (iterateurInteger.hasNext()) {
				Attribut<Integer> attribut = iterateurInteger.next();
				GestionnaireAttribut<Integer> gestionnaire = new GestionnaireAttribut<>(attribut);
				JPanelAttribut panel = new JPanelAttributInteger(gestionnaire);
				grille.add(panel);
				this.listeChamp.add(panel);
			}
			Iterator<Categorie> iterateurCategorie = categorie.iteratorCategories();
			while (iterateurCategorie.hasNext()) {
				grille.add(miseAJourAffichageCategorie(iterateurCategorie.next()));
			}
			return grille;
		}
		
		/**
		 * Sauvegarde la fiche selection�e 
		 */
		private void sauvegarder() {
			for (JPanelAttribut panel : this.listeChamp) {
				panel.enregistrer();
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
			Iterator<Categorie> iterateur = this.ficheSelectionnee.iteratorCategories();
			iterateur.next().ajouterAttributString(new Attribut<String>(this.zoneNom.getText(), ""));//On ajoute un nouvel attribut dont le nom est dans la zone de texte
			this.fenetreNouvelAttribut.dispose();//on ferme cette fenetre
			miseAJourAffichage();
		}
		
		public class ActionEnregistrer implements ActionListener {
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