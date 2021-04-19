package frame.frameReg;


import frame.frameReg.fonctions.FonctionNouveauPoids;
import frame.frameReg.fonctions.FonctionNouveauTourTaille;
import frame.frameReg.fonctions.FonctionNouvelleMarche;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelCentreReg implements ActionListener {
    JPanel conteneurPanelCentre = new JPanel();
    JPanel panelCentre = new JPanel();
    CardLayout cl = new CardLayout();
    JButton boutonRetour = new JButton("Retour");
    JPanel nouvelleMarche;
    JPanel nouveauPoids;
    JPanel nouveauTourTaille;

    public PanelCentreReg(){
        conteneurPanelCentre.setLayout(cl);
		panelCentre.setBackground(Color.LIGHT_GRAY);
        panelCentre.setLayout(new GridLayout(10, 1, 5, 5));

        JButton boutonMarcheVisible = new JButton("Enregistrer une marche");
        panelCentre.add(boutonMarcheVisible);
        boutonMarcheVisible.addActionListener(listenerBoutonMarcheVisible);

        JButton boutonPoidsVisible = new JButton("Enregistrer un nouveau poids");
        panelCentre.add(boutonPoidsVisible);
        boutonPoidsVisible.addActionListener(listenerBoutonPoidsVisible);

        JButton boutonTourTailleVisible = new JButton("Enregistrer un nouveau tour de taille");
        panelCentre.add(boutonTourTailleVisible);
        boutonTourTailleVisible.addActionListener(listenerBoutonTourTailleVisible);
        conteneurPanelCentre.add(panelCentre, "panelCentre");
        cl.show(conteneurPanelCentre, "panelCentre"); //Montrer ce panel de base au centre

        //J'initialise les panels pour nouvelle marche etc
        FonctionNouvelleMarche tmp = new FonctionNouvelleMarche();
        nouvelleMarche = tmp.getNouvelleMarche();

        FonctionNouveauPoids tmp2 = new FonctionNouveauPoids();
        nouveauPoids = tmp2.getNouveauPoids();

        FonctionNouveauTourTaille tmp3 = new FonctionNouveauTourTaille();
        nouveauTourTaille = tmp3.getNouveauTourTaille();
        //////////////////////////////////////////////////
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {

    }

    ActionListener listenerBoutonMarcheVisible = new ActionListener() { // Afficher le panel pour enregistrer une nouvelle marche
        @Override
        public void actionPerformed(ActionEvent e) {
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

    ActionListener listenerBoutonPoidsVisible = new ActionListener() { // Afficher le panel pour enregistrer une nouvelle marche
        @Override
        public void actionPerformed(ActionEvent e) {
            GridBagConstraints ctntMarche = new GridBagConstraints();
            ctntMarche.insets = new Insets(10, 10, 10, 10);//padding des éléments du panel
            ctntMarche.gridx = 0;
            ctntMarche.gridwidth = 1;
            ctntMarche.gridy = 2;
            boutonRetour.setText("Annuler");
            nouveauPoids.add(boutonRetour, ctntMarche);
            boutonRetour.addActionListener(listenerBoutonRetour);
            conteneurPanelCentre.add(nouveauPoids, "nouveauPoids");
            cl.show(conteneurPanelCentre,"nouveauPoids");
        }
    };

    ActionListener listenerBoutonTourTailleVisible = new ActionListener() { // Afficher le panel pour enregistrer une nouvelle marche
        @Override
        public void actionPerformed(ActionEvent e) {
            GridBagConstraints ctntTourTaille = new GridBagConstraints();
            ctntTourTaille.insets = new Insets(10, 10, 10, 10);//padding des éléments du panel
            ctntTourTaille.gridx = 0;
            ctntTourTaille.gridwidth =1;
            ctntTourTaille.gridy = 2;
            nouveauTourTaille.add(boutonRetour, ctntTourTaille);
            boutonRetour.addActionListener(listenerBoutonRetour);
            conteneurPanelCentre.add(nouveauTourTaille, "nouveauTourTaille");
            cl.show(conteneurPanelCentre,"nouveauTourTaille");
        }
    };

    ActionListener listenerBoutonRetour = new ActionListener() { // Afficher le panel pour enregistrer une nouvelle marche
        @Override
        public void actionPerformed(ActionEvent e) {
            cl.show(conteneurPanelCentre, "panelCentre");
        }
    };

    public JPanel getConteneurPanelCentre() {
        return conteneurPanelCentre;
    }
}
