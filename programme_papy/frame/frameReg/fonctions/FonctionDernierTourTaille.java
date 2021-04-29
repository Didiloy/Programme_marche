package frame.frameReg.fonctions;

import frame.frameReg.FrameReg;
import graph.GraphPoids;
import graph.GraphTourTaille;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import static frame.frameReg.FrameReg.panelReg;

public class FonctionDernierTourTaille implements ActionListener {
    JPanel ancienTourTaille = new JPanel();
    public FonctionDernierTourTaille() {
        File f = new File("programme_papy/donnee/tourTaille.txt");
        JLabel labelDernierTourTaille = new JLabel();
        JLabel labelTitreDernierTourTaille = new JLabel("Dernier tour de taille:");
        if (f.isFile()) {
            DerniereLigneFichier tmp = new DerniereLigneFichier();
            String dernierTourTaille = tmp.derniereLigne("programme_papy/donnee/tourTaille.txt");//aller chercher le dernier poids
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
            JButton boutonAfficherAncienTourTaille = new JButton();
            boutonAfficherAncienTourTaille.setText("Afficher les anciens tour de taille");
            boutonAfficherAncienTourTaille.addActionListener(this);
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

    @Override
    public void actionPerformed(ActionEvent e) {
        FrameReg.setPanel(getGraphTourTaille());
    }

    public JPanel getGraphTourTaille(){
        JPanel panelAnciensTourTaille = new JPanel(new BorderLayout());
        JPanel panelGraphAnciensTourTaille = new JPanel(new GridLayout(1, 1));
        JPanel panelSudAnciensTourTaille = new JPanel(new GridLayout(1, 1));


        GraphTourTaille graphTourTaille = new GraphTourTaille();
        panelGraphAnciensTourTaille.add(graphTourTaille.getCharPanel());
        panelAnciensTourTaille.add(panelGraphAnciensTourTaille, BorderLayout.CENTER); //J'ajoute le panel des graphs au panel

        JButton boutonRetour = new JButton("retour a l'acceuil");//ajout du bouton pour le retour à l'acceuil
        boutonRetour.addActionListener(listenerBoutonRetour);
        panelSudAnciensTourTaille.add(boutonRetour);
        panelAnciensTourTaille.add(panelSudAnciensTourTaille, BorderLayout.SOUTH);

        return panelAnciensTourTaille;
    }
    ActionListener listenerBoutonRetour = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            FrameReg.setPanel(panelReg);
        }
    };

    public JPanel getAncienTourTaille() {
        return ancienTourTaille;
    }
}
