package frame.frameReg.fonctions;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class FonctionDerniereMarche implements ActionListener {
    JPanel ancienneMarche = new JPanel();
    public FonctionDerniereMarche() {
        File f = new File("programme_papy/donnee/marche.txt");
        JLabel labelDerniereMarche = new JLabel();
        JLabel labelTitreDerniereMarche = new JLabel();
        if (f.isFile()) {
            DerniereLigneFichier tmp = new DerniereLigneFichier();
            String derniereMarche = tmp.derniereLigne("programme_papy/donnee/marche.txt");//aller chercher la derniere marche
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
            JButton boutonAfficherAncienneMarche = new JButton();
            boutonAfficherAncienneMarche.setText("Afficher les anciennes marches");
            boutonAfficherAncienneMarche.addActionListener(this);
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



    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public JPanel getAncienneMarche(){
        return ancienneMarche;
    }
}
