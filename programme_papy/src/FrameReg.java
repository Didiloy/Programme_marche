import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class FrameReg implements ActionListener{
	private JFrame frame;
	JButton boutonRetour = new JButton("Retour");
	////////////////Panel Haut///////////////
	private JPanel panelHaut = new JPanel();
	private JLabel titre= new JLabel("PlaceHolder");
	/////////////////////////////////////////
	
	/////////////Panel Droite////////////////
	Border borderNoir = BorderFactory.createLineBorder(Color.black);
	private JPanel panelDroite = new JPanel();
	JPanel ancienneMarche = new JPanel();
	JLabel labelDerniereMarche = new JLabel();
	JLabel labelTitreDerniereMarche = new JLabel("Derniere Marche:");
	JButton boutonAfficherAncienneMarche = new JButton();
	
	JPanel ancienPoids = new JPanel();
	JLabel labelDernierPoids = new JLabel();
	JLabel labelTitreDernierPoids = new JLabel("Votre Poids:");
	JButton boutonAfficherAncienPoids = new JButton();
	
	JPanel ancienTourTaille = new JPanel();
	JLabel labelDernierTourTaille = new JLabel();
	JLabel labelTitreDernierTourTaille = new JLabel("Votre tour de taille:");
	JButton boutonAfficherAncienTourTaille = new JButton();
	////////////////////////////////////////
	
	/////////////Panel Centre/////////////////
	private JPanel conteneurPanelCentre = new JPanel();
	private JPanel panelCentre = new JPanel();
	CardLayout cl = new CardLayout();
	//////////MArche////////////////////////
	private JPanel nouvelleMarche = new JPanel();
	private JLabel enregistrer = new JLabel("Enregistrer une nouvelle marche");
	private JLabel distance = new JLabel("Quelle distance avez-vous marché ? (m)");
	private JTextField textDistance = new JTextField(10);
	private JLabel temps = new JLabel("En combien de temps ? (min)");
	private JTextField textTemps = new JTextField(10);
	private JLabel date = new JLabel("Date du jour (format dd/mm/yyyy): ");
	private JTextField textDate = new JTextField(10);
	private JButton boutonMarche = new JButton("Enregistrer");
	private JButton boutonMarcheVisible = new JButton ("Enregistrer une nouvelle marche");
	private int userDistance;
	private int userTemps;
	private String userDate;
	private Marche m1;
	JPanel afficherAncienneMarche = new JPanel();
	JPanel afficherAncienPoids = new JPanel();
	////////////////////////////////////////
	////////////Poids///////////////////////
	private JPanel nouveauPoids = new JPanel();
	private JLabel labelNouveauPoids = new JLabel("Enregistrer un nouveau poids.");
	private JLabel labelPoids = new JLabel("Quel poids faites vous ? ");
	private JButton boutonPoids = new JButton("Enregistrer");
	private JTextField textNouveauPoids = new JTextField(3);
	private JButton boutonPoidsVisible = new JButton("Enregistrer un nouveau poids");
	private int userPoids;
	///////////////////////////////////////
	//////////Tour de Taille//////////////
	private JPanel nouveauTourTaille = new JPanel();
	JLabel labelNouveauTourTaille = new JLabel();
	private JLabel tourTaille = new JLabel("Quel est votre tour de taille actuel ? (cm) ");
	private JButton boutonTourTaille = new JButton("Enregistrer");
	private JTextField textNouveauTourTaille = new JTextField(3);
	private JButton boutonTourTailleVisible = new JButton("Enregistrer un nouveau tour de taille");
	private int userTourTaille;
	JPanel afficherAncienTourTaille = new JPanel();
	//////////////////////////////////////
	//////////////////////////////////////////

	
	public FrameReg(){	
		frame = new JFrame("Programme de Marche");
		frame.setSize(1200, 700);//dimensionnement de la fenetre
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//quand on ferme la fenetre le programme se ferme
		frame.setLocationRelativeTo(null);//afficher la fenetre au milieu pour les non tiling WM
		Image icon = new ImageIcon("image/marche.jpg").getImage(); // J'ajoute l'icone de l'app
		frame.setIconImage(icon);//Je met l'icone
		
		///////Arrangement de la frame///////////////////
		frame.setLayout(new BorderLayout(5, 5));
		frame.add(panelHaut, BorderLayout.NORTH);
		frame.add(panelDroite, BorderLayout.EAST);
		frame.add(conteneurPanelCentre, BorderLayout.CENTER);
		/////////////////////////////////////////////////

		/////////Arrangement du panel du HAUT/////////////
		panelHaut.setPreferredSize(new Dimension(100, 100));
//		panelHaut.setBackground(Color.black);
		panelHaut.setLayout(new GridBagLayout());
		GridBagConstraints ctntHaut = new GridBagConstraints();
		ctntHaut.gridx = 0;
		ctntHaut.gridy = 0;
		panelHaut.add(titre, ctntHaut);
		/////////////////////////////////////////////////


		/////////Arrangement du panel de DROITE/////////////
		panelDroite.setPreferredSize(new Dimension(350, 100));
//		panelDroite.setBackground(Color.blue);
		panelDroite.setBorder(borderNoir); //Bordure
		panelDroite.setLayout(new FlowLayout());
		fonctionDerniereMarche();
		panelDroite.add(ancienneMarche);
		fonctionDernierPoids();
		panelDroite.add(ancienPoids);
		panelDroite.add(ancienTourTaille);
		
		
		////////////////////////////////////////////

		/////////Arrangement du panel du CENTRE/////////////
		conteneurPanelCentre.setLayout(cl);
//		panelCentre.setBackground(Color.magenta);
		panelCentre.setLayout(new GridLayout(10, 1, 5, 5));
		panelCentre.add(boutonMarcheVisible);
		boutonMarcheVisible.addActionListener(listenerBoutonMarcheVisible);
		
		panelCentre.add(boutonPoidsVisible);
		boutonPoidsVisible.addActionListener(listenerBoutonPoidsVisible);
		
		panelCentre.add(boutonTourTailleVisible);
		boutonTourTailleVisible.addActionListener(listenerBoutonTourTailleVisible);
		conteneurPanelCentre.add(panelCentre, "panelCentre");
		cl.show(conteneurPanelCentre, "panelCentre"); //Montrer ce panel de base au centre
		////////////////////////////////////////////////////
		
		frame.setVisible(true);
		
		//Je met ici les fonctions au lieu de les mettres dans les actions listener
		//comme ça ça n'enregistre pas les données plusieurs fois d'affilée
		fonctionNouvelleMarche();
		fonctionAfficherAncienneMarche();
		fonctionAfficherAncienPoids();
		fonctionNouveauPoids();
		fonctionNouveauTourTaille();
		fonctionDernierTourTaille();
		fonctionAfficherAncienTourTaille();
		///////////////////////////////////////////
	}

	//++++++++++++++++++++++++++++++++ACTION LISTENER++++++++++++++++++++++++++++++++++++++++++++++//
	ActionListener listenerBoutonRetour = new ActionListener() { // Afficher le panel pour enregistrer une nouvelle marche
		@Override
		public void actionPerformed(ActionEvent e) {
			cl.show(conteneurPanelCentre,"panelCentre");
		}
	};
	
	ActionListener listenerBoutonMarcheVisible = new ActionListener() { // Afficher le panel pour enregistrer une nouvelle marche
		@Override
		public void actionPerformed(ActionEvent e) {
//			fonctionNouvelleMarche();
			//Obligé de refaire des gridConstraint pour le bouton retour
			GridBagConstraints ctntMarche = new GridBagConstraints();
			ctntMarche.insets = new Insets(10, 10, 10, 10);//padding des éléments du panel
			ctntMarche.gridx = 0;
			ctntMarche.gridwidth = 2;
			ctntMarche.gridy = 4;
			boutonRetour.setText("Annuler");
			nouvelleMarche.add(boutonRetour, ctntMarche);
			boutonRetour.addActionListener(listenerBoutonRetour);
			conteneurPanelCentre.add(nouvelleMarche, "nouvelleMarche");
			cl.show(conteneurPanelCentre,"nouvelleMarche");
		}
	};
	
	ActionListener listenerBoutonMarche = new ActionListener() {//ce que fait le bouton qui enregistre la nouvelle marche
		@Override
		public void actionPerformed(ActionEvent e) {
			userDistance = Integer.parseInt(textDistance.getText());
			userTemps = Integer.parseInt(textTemps.getText());
			userDate = textDate.getText();
			m1 = new Marche(userDistance, userTemps, userDate);
//			System.out.println(m1.toString()); //recup les infos. a changer
			ecrireMarche(m1);//J'écrit les infos de la marche dans le fichier
			cl.show(conteneurPanelCentre, "panelCentre"); //On repasse au panelCentre
			JOptionPane.showMessageDialog(null, "Nouvelle marche enregistrée !",
					"Programme de Marche", JOptionPane.INFORMATION_MESSAGE);//Je met le popup qui indique que la marche est enregistrée
		}
	};
	
	ActionListener listenerBoutonAfficherAncienneMarche = new ActionListener() { // Enregistrer le nouveau poids et revenir au panel d'avant
		@Override
		public void actionPerformed(ActionEvent e) {
//			fonctionAfficherAncienneMarche();
			GridBagConstraints ctntAfficherAncienneMarche = new GridBagConstraints();
			ctntAfficherAncienneMarche.insets = new Insets(10, 10, 10, 10);//padding des éléments du panel
			ctntAfficherAncienneMarche.gridx = 0;
			ctntAfficherAncienneMarche.gridy = 0;
			afficherAncienneMarche.add(boutonRetour, ctntAfficherAncienneMarche);
			boutonRetour.setText("Retour");
			boutonRetour.addActionListener(listenerBoutonRetour);
			conteneurPanelCentre.add(afficherAncienneMarche, "afficherAncienneMarche");
			cl.show(conteneurPanelCentre, "afficherAncienneMarche");
		}
	};
	
	ActionListener listenerBoutonAfficherAncienPoids = new ActionListener() { // Enregistrer le nouveau poids et revenir au panel d'avant
		@Override
		public void actionPerformed(ActionEvent e) {
//			fonctionAfficherAncienPoids();
			GridBagConstraints ctntAfficherAncienPoids = new GridBagConstraints();
			ctntAfficherAncienPoids.insets = new Insets(10, 10, 10, 10);//padding des éléments du panel
			ctntAfficherAncienPoids.gridx = 0;
			ctntAfficherAncienPoids.gridy = 0;
			afficherAncienPoids.add(boutonRetour, ctntAfficherAncienPoids);
			boutonRetour.setText("Retour");
			boutonRetour.addActionListener(listenerBoutonRetour);
			conteneurPanelCentre.add(afficherAncienPoids, "afficherAncienPoids");
			cl.show(conteneurPanelCentre, "afficherAncienPoids");
		}
	};
	
	ActionListener listenerBoutonPoidsVisible = new ActionListener() { // Afficher le panel pour enregistrer un nouveau poids
		@Override
		public void actionPerformed(ActionEvent e) {
//			fonctionNouveauPoids();
			GridBagConstraints ctntPoids = new GridBagConstraints();
			ctntPoids.insets = new Insets(10, 10, 10, 10);//padding des éléments du panel
			ctntPoids.gridx = 0;
			ctntPoids.gridwidth =2;
			ctntPoids.gridy = 2;
			boutonRetour.setText("Annuler");
			nouveauPoids.add(boutonRetour, ctntPoids);		
			boutonRetour.addActionListener(listenerBoutonRetour);
			conteneurPanelCentre.add(nouveauPoids, "nouveauPoids");
			cl.show(conteneurPanelCentre,"nouveauPoids"); //On passe au panel pour changer de poids
		}
	};
	
	ActionListener listenerBoutonPoids = new ActionListener() { // Enregistrer le nouveau poids et revenir au panel d'avant
		@Override
		public void actionPerformed(ActionEvent e) {
			userPoids = Integer.parseInt(textNouveauPoids.getText());
			ecrirePoids(userPoids);
			cl.show(conteneurPanelCentre, "panelCentre");//On remontre le panel du centre
			JOptionPane.showMessageDialog(null, "Nouveau poids enregistré !",
					"Programme de Marche", JOptionPane.INFORMATION_MESSAGE);//Je met le popup qui indique que la marche est enregistrée
		}
	};
	
	ActionListener listenerBoutonTourTailleVisible = new ActionListener() { // Afficher le panel pour enregistrer une nouvelle marche
		@Override
		public void actionPerformed(ActionEvent e) {
//			fonctionNouveauTourTaille();
			GridBagConstraints ctntTourTaille = new GridBagConstraints();
			ctntTourTaille.insets = new Insets(10, 10, 10, 10);//padding des éléments du panel
			ctntTourTaille.gridx = 0;
			ctntTourTaille.gridwidth =2;
			ctntTourTaille.gridy = 2;
			nouveauTourTaille.add(boutonRetour, ctntTourTaille);		
			boutonRetour.addActionListener(listenerBoutonRetour);
			conteneurPanelCentre.add(nouveauTourTaille, "nouveauTourTaille");
			cl.show(conteneurPanelCentre,"nouveauTourTaille");
		}
	};
	
	ActionListener listenerBoutonTourTaille = new ActionListener() { // Enregistrer le nouveau poids et revenir au panel d'avant
		@Override
		public void actionPerformed(ActionEvent e) {
			userTourTaille = Integer.parseInt(textNouveauTourTaille.getText());
			ecrireTourTaille(userTourTaille);
			cl.show(conteneurPanelCentre, "panelCentre");//On remontre le panel du centre
			JOptionPane.showMessageDialog(null, "Nouveau tour de taille enregistré !",
					"Programme de Marche", JOptionPane.INFORMATION_MESSAGE);//Je met le popup qui indique que la marche est enregistrée
		}
	};
	
	ActionListener listenerBoutonAfficherAncienTourTaille = new ActionListener() { // Enregistrer le nouveau poids et revenir au panel d'avant
		@Override
		public void actionPerformed(ActionEvent e) {
//			fonctionAfficherAncienPoids();
			GridBagConstraints ctntAfficherAncienTourTaille = new GridBagConstraints();
			ctntAfficherAncienTourTaille.insets = new Insets(10, 10, 10, 10);//padding des éléments du panel
			ctntAfficherAncienTourTaille.gridx = 0;
			ctntAfficherAncienTourTaille.gridy = 0;
			afficherAncienTourTaille.add(boutonRetour, ctntAfficherAncienTourTaille);
			boutonRetour.setText("Retour");
			boutonRetour.addActionListener(listenerBoutonRetour);
			conteneurPanelCentre.add(afficherAncienTourTaille, "afficherAncienTourTaille");
			cl.show(conteneurPanelCentre, "afficherAncienTourTaille");
		}
	};


	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++/:
	
	
//+++++++++++++++++++++++++++++MARCHE+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++//
	public void ecrireMarche(Marche marche) {
		try {//Le true du filewriter c'est pour ouvrir le fichier en mode append
			BufferedWriter bw = new BufferedWriter(new FileWriter("donnee/marche.txt", true));//On choisi le fichier dans lequel on écrit
			bw.write(marche.toString(1) + "\n");//On écrit
			bw.close();
		}
		catch (IOException e)//Si il y a une erreur on la récupère.
		{
			//Print the error message
			System.out.print(e.getMessage());
		}
	}
	
	

	public void fonctionNouvelleMarche() {
		//============Panel nouvelle marche=======
		nouvelleMarche.setLayout(new GridBagLayout());
		GridBagConstraints ctntMarche = new GridBagConstraints();
		ctntMarche.insets = new Insets(10, 10, 10, 10);//padding des éléments du panel
		ctntMarche.gridx = 0;
		ctntMarche.gridwidth = 2;
		ctntMarche.gridy = 0;
		nouvelleMarche.add(enregistrer, ctntMarche);

		ctntMarche.gridx = 0;
		ctntMarche.gridy = 1;
		ctntMarche.gridwidth = 1;
		nouvelleMarche.add(distance, ctntMarche);

		ctntMarche.gridx = 1;
		ctntMarche.gridy = 1;
		nouvelleMarche.add(textDistance, ctntMarche);

		ctntMarche.gridx = 0;
		ctntMarche.gridy = 2;
		nouvelleMarche.add(temps, ctntMarche);

		ctntMarche.gridx = 1;
		ctntMarche.gridy = 2;
		nouvelleMarche.add(textTemps, ctntMarche);

		ctntMarche.gridx = 0;
		ctntMarche.gridy = 3;
		nouvelleMarche.add(date, ctntMarche);

		ctntMarche.gridx = 1;
		ctntMarche.gridy = 3;
		nouvelleMarche.add(textDate, ctntMarche);

//		ctntMarche.gridx = 0;
//		ctntMarche.gridwidth = 2;
//		ctntMarche.gridy = 4;
//		boutonRetour.setText("Annuler");
//		nouvelleMarche.add(boutonRetour, ctntMarche);
//		boutonRetour.addActionListener(listenerBoutonRetour);
		
		ctntMarche.gridx = 1;
		ctntMarche.gridwidth = 2;
		ctntMarche.gridy = 4;
		nouvelleMarche.add(boutonMarche, ctntMarche);
		boutonMarche.addActionListener(listenerBoutonMarche);
		//========================================
	}	
	
	public void fonctionDerniereMarche() {
		File f = new File("donnee/marche.txt");
		if (f.isFile()) {
			String derniereMarche = derniereLigneFichier("donnee", "marche.txt");//aller chercher la derniere marche
			String derniereMarcheTab[] = new String[3];
			derniereMarcheTab = derniereMarche.split(",");	//Mettre tout les elements de la derniere marche dans un tableau

			int derniereMarcheKm = Integer.parseInt(derniereMarcheTab[0]);//Convertir la dernière marche en km
			double derniereMarcheKmDouble = ((double)derniereMarcheKm)/1000;

			int hours = Integer.parseInt(derniereMarcheTab[1]) / 60; //Convertir les minutes en heures et minutes
			int minutes = Integer.parseInt(derniereMarcheTab[1]) % 60; 
			if (hours == 0) {//Si il marche - de 1h on affiche pas les heures
				if (minutes < 10) {//Si les minutes sont inférieurs a 10
					labelDerniereMarche.setText("Le " + derniereMarcheTab[2]+ //Rempliir le label derniere marche
							" vous avez marché " + derniereMarcheKmDouble + 
							" km en " +
							"0" + minutes + "min");
				} else {
					labelDerniereMarche.setText("Le " + derniereMarcheTab[2]+ //Rempliir le label derniere marche
							" vous avez marché " + derniereMarcheKmDouble + 
							" km en " +
							minutes + "min");
				}

			} else {//Si il marche plus de 1h on affiche les heures
				if (minutes < 10) {//Si les minutes sont inférieurs a 10
					labelDerniereMarche.setText("Le " + derniereMarcheTab[2]+ //Rempliir le label derniere marche
							" vous avez marché " + derniereMarcheKmDouble + 
							" km en " +
							hours + "h0" + minutes);
				} else {//Si les minutes sont sup a 10 et l'heure aussi
					labelDerniereMarche.setText("Le " + derniereMarcheTab[2]+ //Rempliir le label derniere marche
							" vous avez marché " + derniereMarcheKmDouble + 
							" km en " +
							hours + "h" + minutes);
				}

			}
			ancienneMarche.setLayout(new GridBagLayout());
			GridBagConstraints ctntAncienneMarche = new GridBagConstraints();
			ctntAncienneMarche.insets = new Insets(10, 10, 10, 10);//padding des éléments du panel
			ctntAncienneMarche.gridx = 0;
			ctntAncienneMarche.gridwidth = 2;
			ctntAncienneMarche.gridy = 0;
			ancienneMarche.add(labelTitreDerniereMarche, ctntAncienneMarche);
			ctntAncienneMarche.gridx = 0;
			ctntAncienneMarche.gridy = 1;
			ancienneMarche.add(labelDerniereMarche, ctntAncienneMarche);
			ctntAncienneMarche.gridx = 0;
			ctntAncienneMarche.gridy = 2;
			boutonAfficherAncienneMarche.setText("Afficher les anciennes marches");
			boutonAfficherAncienneMarche.addActionListener(listenerBoutonAfficherAncienneMarche);
			ancienneMarche.add(boutonAfficherAncienneMarche, ctntAncienneMarche);
		} else {//Si il n'y a pas d'ancienne marche
			ancienneMarche.setLayout(new GridBagLayout());
			GridBagConstraints ctntAncienneMarche = new GridBagConstraints();
			ctntAncienneMarche.insets = new Insets(10, 10, 10, 10);//padding des éléments du panel
			ctntAncienneMarche.gridx = 0;
			ctntAncienneMarche.gridwidth = 2;
			ctntAncienneMarche.gridy = 0;
			ancienneMarche.add(labelTitreDerniereMarche, ctntAncienneMarche);
			ctntAncienneMarche.gridx = 0;
			ctntAncienneMarche.gridy = 1;
			labelDerniereMarche.setText("Il n'y a pas encore de marche enregistrée");
			ancienneMarche.add(labelDerniereMarche, ctntAncienneMarche);
		}

	}
	
	public void fonctionAfficherAncienneMarche() {
		afficherAncienneMarche.setLayout(new GridBagLayout());
		GridBagConstraints ctntAfficherAncienneMarche = new GridBagConstraints();
		ctntAfficherAncienneMarche.insets = new Insets(10, 10, 10, 10);//padding des éléments du panel
//		ctntAfficherAncienneMarche.gridx = 0;
//		ctntAfficherAncienneMarche.gridy = 0;
//		afficherAncienneMarche.add(boutonRetour, ctntAfficherAncienneMarche);
//		boutonRetour.setText("Retour");
//		boutonRetour.addActionListener(listenerBoutonRetour);
	}
//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++//

//++++++++++++++++++++++++++++++POIDS++++++++++++++++++++++++++++++++++++++++++++++++++++//
	public void fonctionNouveauPoids() {
		//================Panel nouveau Poids=============		
//		panelCentre.setLayout(new BorderLayout());
		nouveauPoids.setLayout(new GridBagLayout());
		GridBagConstraints ctntPoids = new GridBagConstraints();
		ctntPoids.insets = new Insets(10, 10, 10, 10);//padding des éléments du panel
		ctntPoids.gridx = 0;
		ctntPoids.gridy = 0;
		nouveauPoids.add(labelNouveauPoids, ctntPoids);

		ctntPoids.gridx = 0;
		ctntPoids.gridy = 1;
		nouveauPoids.add(labelPoids, ctntPoids);

		ctntPoids.gridx = 1;
		ctntPoids.gridy = 1;
		nouveauPoids.add(textNouveauPoids, ctntPoids);

//		ctntPoids.gridx = 0;
//		ctntPoids.gridwidth =2;
//		ctntPoids.gridy = 2;
//		boutonRetour.setText("Annuler");
//		nouveauPoids.add(boutonRetour, ctntPoids);		
//		boutonRetour.addActionListener(listenerBoutonRetour);
		
		ctntPoids.gridx = 1;
		ctntPoids.gridwidth =2;
		ctntPoids.gridy = 2;
		nouveauPoids.add(boutonPoids, ctntPoids);		
		boutonPoids.addActionListener(listenerBoutonPoids);
		//================================================	
	}
	
	public void ecrirePoids(int poids) {//Change le poids dans le fichier utilisateur.txt et met l'ancien dans ancienPoids.txt
		try {//Le true du filewriter c'est pour ouvrir le fichier en mode append
			BufferedReader br = new BufferedReader(new FileReader("donnee/utilisateur.txt"));
			String s="";
			String data[] = new String[4];
				while((s=br.readLine())!=null) {
					data = s.split(",");
//					System.out.println(data[3]);
				}
//				System.out.println(data[3]);
				br.close();//Avec le buffered reader j'obtiens l'ancien poids
			BufferedWriter bw = new BufferedWriter(new FileWriter("donnee/ancienPoids.txt", true));//On choisi le fichier dans lequel on écrit
			bw.write(data[3] + ",");//On écrit
			bw.close(); //Je met l'ancien poids dans le fichier des anciens poids
			Personne p1 = new Personne(data[0], data[1], Integer.parseInt(data[2]), poids);
			BufferedWriter bw1 = new BufferedWriter(new FileWriter("donnee/utilisateur.txt"));//On choisi le fichier dans lequel on écrit
			bw1.write(p1.toString());//On écrit
			bw1.close();
		}
		catch (IOException e)//Si il y a une erreur on la récupère.
		{
			//Print the error message
			System.out.print(e.getMessage());
		}
	}
	
	public void fonctionDernierPoids() {
		File f = new File("donnee/utilisateur.txt");
		if (f.isFile()) {
			String dernierPoids = derniereLigneFichier("donnee", "utilisateur.txt");//aller chercher le dernier poids
			ArrayList dernierPoidsArrayList = new ArrayList();
			String dernierPoidsTab[] = new String[4];
			dernierPoidsTab = dernierPoids.split(",");
			int i = 0;
			while (i < 4) {
				dernierPoidsArrayList.add(dernierPoidsTab[i]);//Mettre tout les elements de l'utilisateur dans un tableau
				i += 1;
			}
			int dernierPoidsInt = Integer.parseInt((String) dernierPoidsArrayList.get(3));//Convertir le poids en int

			labelDernierPoids.setText("Votre poids actuel est " + dernierPoidsInt + "kg.");
			ancienPoids.setLayout(new GridBagLayout());
			GridBagConstraints ctntAncienPoids = new GridBagConstraints();
			ctntAncienPoids.insets = new Insets(10, 10, 10, 10);//padding des éléments du panel
			ctntAncienPoids.gridx = 0;
			ctntAncienPoids.gridwidth = 2;
			ctntAncienPoids.gridy = 0;
			ancienPoids.add(labelTitreDernierPoids, ctntAncienPoids);
			ctntAncienPoids.gridx = 0;
			ctntAncienPoids.gridy = 1;
			ancienPoids.add(labelDernierPoids, ctntAncienPoids);
			ctntAncienPoids.gridx = 0;
			ctntAncienPoids.gridy = 2;
			boutonAfficherAncienPoids.setText("Afficher les anciens poids");
			boutonAfficherAncienPoids.addActionListener(listenerBoutonAfficherAncienPoids);
			ancienPoids.add(boutonAfficherAncienPoids, ctntAncienPoids);		
			}
		else {
			labelDernierPoids.setText("Vous n'avez pas encore enregistrer de poids.");
			ancienPoids.setLayout(new GridBagLayout());
			GridBagConstraints ctntAncienPoids = new GridBagConstraints();
			ctntAncienPoids.insets = new Insets(10, 10, 10, 10);//padding des éléments du panel
			ctntAncienPoids.gridx = 0;
			ctntAncienPoids.gridwidth = 2;
			ctntAncienPoids.gridy = 0;
			ancienPoids.add(labelTitreDernierPoids, ctntAncienPoids);
			ctntAncienPoids.gridx = 0;
			ctntAncienPoids.gridy = 1;
			ancienPoids.add(labelDernierPoids, ctntAncienPoids);
//			ctntAncienPoids.gridx = 0;
//			ctntAncienPoids.gridy = 2;
//			boutonAfficherAncienPoids.setText("Afficher les anciens poids");
//			boutonAfficherAncienPoids.addActionListener(listenerBoutonAfficherAncienPoids);
//			ancienPoids.add(boutonAfficherAncienPoids, ctntAncienPoids);	
		}
	}
	
	public void fonctionAfficherAncienPoids() {
		afficherAncienPoids.setLayout(new GridBagLayout());
		GridBagConstraints ctntAfficherAncienPoids = new GridBagConstraints();
		ctntAfficherAncienPoids.insets = new Insets(10, 10, 10, 10);//padding des éléments du panel
//		ctntAfficherAncienPoids.gridx = 0;
//		ctntAfficherAncienPoids.gridy = 0;
//		afficherAncienPoids.add(boutonRetour, ctntAfficherAncienPoids);
//		boutonRetour.setText("Retour");
//		boutonRetour.addActionListener(listenerBoutonRetour);
	}
	//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++//
	
	//++++++++++++++++++++++++++++++++++TOUR DE TAILLE +++++++++++++++++++++++++++++++++++++++++//
	public void fonctionNouveauTourTaille() {
		nouveauTourTaille.setLayout(new GridBagLayout());
		GridBagConstraints ctntTourTaille = new GridBagConstraints();
		ctntTourTaille.insets = new Insets(10, 10, 10, 10);//padding des éléments du panel
		ctntTourTaille.gridx = 0;
		ctntTourTaille.gridy = 0;
		nouveauTourTaille.add(labelNouveauTourTaille, ctntTourTaille);

		ctntTourTaille.gridx = 0;
		ctntTourTaille.gridy = 1;
		nouveauTourTaille.add(tourTaille, ctntTourTaille);

		ctntTourTaille.gridx = 1;
		ctntTourTaille.gridy = 1;
		nouveauTourTaille.add(textNouveauTourTaille, ctntTourTaille);

//		ctntTourTaille.gridx = 0;
//		ctntTourTaille.gridwidth =2;
//		ctntTourTaille.gridy = 2;
//		nouveauTourTaille.add(boutonRetour, ctntTourTaille);		
//		boutonRetour.addActionListener(listenerBoutonRetour);
		
		ctntTourTaille.gridx = 1;
		ctntTourTaille.gridwidth =2;
		ctntTourTaille.gridy = 2;
		boutonRetour.setText("Annuler");
		nouveauTourTaille.add(boutonTourTaille, ctntTourTaille);		
		boutonTourTaille.addActionListener(listenerBoutonTourTaille);
	}
	
	public void ecrireTourTaille(int tourTaille) {//Change le poids dans le fichier utilisateur.txt et met l'ancien dans ancienPoids.txt
		try {//Le true du filewriter c'est pour ouvrir le fichier en mode append
			BufferedWriter bw = new BufferedWriter(new FileWriter("donnee/tourTaille.txt", true));//On choisi le fichier dans lequel on écrit
			bw.write(tourTaille + "\n");//On écrit
			bw.close();
		}
		catch (IOException e)//Si il y a une erreur on la récupère.
		{
			//Print the error message
			System.out.print(e.getMessage());
		}
	}
	
	public void fonctionDernierTourTaille() {
		File f = new File("donnee/tourTaille.txt");
		if (f.isFile()) {
			String dernierTourTaille = derniereLigneFichier("donnee", "tourTaille.txt");//aller chercher le dernier poids
			int dernierTourTailleInt = Integer.parseInt(dernierTourTaille);//Convertir le poids en int

			labelDernierTourTaille.setText("Votre tour de taille actuel est " + dernierTourTailleInt + "cm.");
			ancienTourTaille.setLayout(new GridBagLayout());
			GridBagConstraints ctntAncienTourTaille = new GridBagConstraints();
			ctntAncienTourTaille.insets = new Insets(10, 10, 10, 10);//padding des éléments du panel
			ctntAncienTourTaille.gridx = 0;
			ctntAncienTourTaille.gridwidth = 2;
			ctntAncienTourTaille.gridy = 0;
			ancienTourTaille.add(labelTitreDernierTourTaille, ctntAncienTourTaille);
			ctntAncienTourTaille.gridx = 0;
			ctntAncienTourTaille.gridy = 1;
			ancienTourTaille.add(labelDernierTourTaille, ctntAncienTourTaille);
			ctntAncienTourTaille.gridx = 0;
			ctntAncienTourTaille.gridy = 2;
			boutonAfficherAncienTourTaille.setText("Afficher les anciens tour de taille");
			boutonAfficherAncienTourTaille.addActionListener(listenerBoutonAfficherAncienTourTaille);
			ancienTourTaille.add(boutonAfficherAncienTourTaille, ctntAncienTourTaille);		
			}
		else {
			labelDernierTourTaille.setText("Vous n'avez pas encore enregistrer de tour de taille.");
			ancienTourTaille.setLayout(new GridBagLayout());
			GridBagConstraints ctntAncienTourTaille = new GridBagConstraints();
			ctntAncienTourTaille.insets = new Insets(10, 10, 10, 10);//padding des éléments du panel
			ctntAncienTourTaille.gridx = 0;
			ctntAncienTourTaille.gridwidth = 2;
			ctntAncienTourTaille.gridy = 0;
			ancienTourTaille.add(labelTitreDernierTourTaille, ctntAncienTourTaille);
			ctntAncienTourTaille.gridx = 0;
			ctntAncienTourTaille.gridy = 1;
			ancienTourTaille.add(labelDernierTourTaille, ctntAncienTourTaille);	
		}
	}
	
	public void fonctionAfficherAncienTourTaille() {
		afficherAncienTourTaille.setLayout(new GridBagLayout());
		GridBagConstraints ctntAfficherAncienTourTaille = new GridBagConstraints();
		ctntAfficherAncienTourTaille.insets = new Insets(10, 10, 10, 10);//padding des éléments du panel
//		ctntAfficherAncienneMarche.gridx = 0;
//		ctntAfficherAncienneMarche.gridy = 0;
//		afficherAncienneMarche.add(boutonRetour, ctntAfficherAncienneMarche);
//		boutonRetour.setText("Retour");
//		boutonRetour.addActionListener(listenerBoutonRetour);
	}
	//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++//
	
	public String derniereLigneFichier(String nomDossier, String nomFichier){
		try {
			File file = new File(nomDossier +"/" + nomFichier);
			InputStreamReader streamReader = new InputStreamReader(new FileInputStream(file));
			BufferedReader br = new BufferedReader(streamReader);
			String line = new String();
			while (br.ready()) {
				line = br.readLine();
			}
			br.close();
			return line;
		}
		catch (IOException e)//Si il y a une erreur on la récupère.
		{
			//Print the error message
			System.out.print(e.getMessage());
			return null;
		}
	}

 }
