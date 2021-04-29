package frame.frameReg.fonctions;
import frame.*;
import frame.frameReg.FrameReg;
import graph.GraphDistanceDate;
import graph.GraphPoids;
import graph.GraphTempsDate;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import static frame.frameReg.FrameReg.panelReg;

public class FonctionDernierPoids implements ActionListener {
    JPanel ancienPoids = new JPanel();
    public FonctionDernierPoids() {
        File f = new File("programme_papy/donnee/utilisateur.txt");
        JLabel labelDernierPoids = new JLabel();
        JLabel labelTitreDernierPoids = new JLabel();
        if (f.isFile()) {
            DerniereLigneFichier tmp = new DerniereLigneFichier();//aller chercher le dernier poids
            String dernierPoids = tmp.derniereLigne("programme_papy/donnee/utilisateur.txt");
            ArrayList dernierPoidsArrayList = new ArrayList();
            String dernierPoidsTab[] = new String[4];
            dernierPoidsTab = dernierPoids.split(",");
            int i = 0;
            while (i < 4) {
                dernierPoidsArrayList.add(dernierPoidsTab[i]);//Mettre tout les elements de l'utilisateur dans un tableau
                i += 1;
            }
            int dernierPoidsInt = 0;//Convertir le poids en int
                dernierPoidsInt = Integer.parseInt((String) dernierPoidsArrayList.get(3));


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
            JButton boutonAfficherAncienPoids = new JButton();
            boutonAfficherAncienPoids.setText("Afficher les anciens poids");
            boutonAfficherAncienPoids.addActionListener(this);
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

    @Override
    public void actionPerformed(ActionEvent e) {
        FrameReg.setPanel(getGraphPoids());
    }

    public JPanel getGraphPoids(){
        JPanel panelAnciensPoids = new JPanel(new BorderLayout());
        JPanel panelGraphAnciensPoids = new JPanel(new GridLayout(1, 1));
        JPanel panelSudAnciensPoids = new JPanel(new GridLayout(2, 1));
            JPanel panelSudMoyennePoids = new JPanel(new FlowLayout());

        GraphPoids graphPoids = new GraphPoids();
        panelGraphAnciensPoids.add(graphPoids.getCharPanel());
        panelAnciensPoids.add(panelGraphAnciensPoids, BorderLayout.CENTER); //J'ajoute le panel des graphs au panel

        FonctionMoyennePoids moyennePoids = new FonctionMoyennePoids();
        JLabel labelMoyennePoids =new JLabel("La moyenne de tout les poids entrés est "+ moyennePoids.getMoyenne() + "kg.");
        panelSudMoyennePoids.add(labelMoyennePoids);
        panelSudAnciensPoids.add(panelSudMoyennePoids);
        JButton boutonRetour = new JButton("retour a l'acceuil");//ajout du bouton pour le retour à l'acceuil
        boutonRetour.addActionListener(listenerBoutonRetour);
        panelSudAnciensPoids.add(boutonRetour);
        panelAnciensPoids.add(panelSudAnciensPoids, BorderLayout.SOUTH);

        return panelAnciensPoids;
    }
    ActionListener listenerBoutonRetour = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            FrameReg.setPanel(panelReg);
        }
    };
    public JPanel getAncienPoids() {
        return ancienPoids;
    }
}
