package frame.frameReg.fonctions;
import frame.frameReg.fonctions.*;
import frame.frameReg.FrameReg;
import graph.GraphDistanceDate;
import graph.GraphTempsDate;
import frame.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.*;

import static frame.frameReg.FrameReg.panelReg;

public class FonctionDerniereMarche implements ActionListener, MouseListener {
    JPanel ancienneMarche = new JPanel();
    Color CouleurBleu = new Color(83, 122, 204);
    Color CouleurBleuClair = new Color(133, 156, 227);
    Color CouleurForegroundLabel = new Color(207, 211, 214);
    public FonctionDerniereMarche() {
        File f = new File("programme_papy/donnee/marche.txt");
        JLabel labelDerniereMarche = new JLabel();
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
            labelDerniereMarche.setFont(new Font("Arial", Font.BOLD, 14));
            labelDerniereMarche.setForeground(CouleurForegroundLabel);
            ancienneMarche.setLayout(new GridLayout(1, 1));
            ancienneMarche.setBackground(CouleurBleu);
            ancienneMarche.addMouseListener(this);
            ancienneMarche.add(labelDerniereMarche);
            //Bouton pour afficher les anciennes marches
//            JButton boutonAfficherAncienneMarche = new JButton();
//            boutonAfficherAncienneMarche.setBackground(Color.WHITE);
//            boutonAfficherAncienneMarche.setText("Afficher les anciennes marches");
//            boutonAfficherAncienneMarche.addActionListener(this);
//            ancienneMarche.add(boutonAfficherAncienneMarche, ctntAncienneMarche);
        } else {//Si il n'y a pas d'ancienne marche
            labelDerniereMarche.setFont(new Font("Arial", Font.BOLD, 14));
            labelDerniereMarche.setForeground(CouleurForegroundLabel);
            ancienneMarche.setLayout(new GridLayout(1, 1));
            ancienneMarche.setBackground(CouleurBleu);
            ancienneMarche.addMouseListener(this);
            labelDerniereMarche.setText("Il n'y a pas encore de marche enregistrée");
            ancienneMarche.add(labelDerniereMarche);
        }

    }



    @Override
    public void actionPerformed(ActionEvent e) {
        FrameReg.setPanel(getGraphMarche());
    }

    public JPanel getGraphMarche(){
        JPanel panelAnciennesMarches = new JPanel(new BorderLayout());
        JPanel panelCentreAnciennesMarches = new JPanel(new GridLayout(1, 2, 2, 2));
        JPanel panelSudAnciennesMarches = new JPanel();

        GraphDistanceDate graphDistanceDate = new GraphDistanceDate();
        GraphTempsDate graphTempsDate = new GraphTempsDate();//J'ajoute le premier graph au panel.
        panelCentreAnciennesMarches.add(graphDistanceDate.getCharPanel());
        panelCentreAnciennesMarches.add(graphTempsDate.getCharPanel());//J'ajoute le 2eme graph au panel
        panelAnciennesMarches.add(panelCentreAnciennesMarches, BorderLayout.CENTER); //J'ajoute le panel des graphs au panel

        panelSudAnciennesMarches.setPreferredSize(new Dimension(100, 150));
        panelSudAnciennesMarches.setBackground(Color.LIGHT_GRAY);
        panelSudAnciennesMarches.setLayout(new GridLayout(4, 1));
        try {
            FonctionMoyenneTempsMarche tempsMoyen = new FonctionMoyenneTempsMarche();
            JLabel labelTempsMoyen = new JLabel("En moyenne vous marchez "+  tempsMoyen.getHeure() + " heures " + tempsMoyen.getMinute()+ " minutes.");
            FonctionTotalDistanceMarche totaleDistance = new FonctionTotalDistanceMarche();
            JLabel labelTotaleDistance = new JLabel("Vous avez marché sur une distance totale de "+ totaleDistance.getSomme() + "kms.");
            FonctionTotalTempsMarche totalTempsMarche = new FonctionTotalTempsMarche();
            JLabel labelTotalTemps = new JLabel("Vous avez marchés un temps total de "+ totalTempsMarche.getHeures() + " heures "+ totalTempsMarche.getMinutes() + " minutes.");
            JButton boutonRetour = new JButton("retour à l'acceuil");
            boutonRetour.addActionListener(listenerBoutonRetour);
            panelSudAnciennesMarches.add(labelTotaleDistance);
            panelSudAnciennesMarches.add(labelTempsMoyen);
            panelSudAnciennesMarches.add(labelTotalTemps);
            panelSudAnciennesMarches.add(boutonRetour);

            panelAnciennesMarches.add(panelSudAnciennesMarches, BorderLayout.SOUTH);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return panelAnciennesMarches;
    }

    public JPanel getAncienneMarche(){
        return ancienneMarche;
    }

    ActionListener listenerBoutonRetour = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            FrameReg.setPanel(panelReg);
        }
    };

    @Override
    public void mouseClicked(MouseEvent e) {
        FrameReg.setPanel(getGraphMarche());
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        ancienneMarche.setBackground(CouleurBleuClair);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        ancienneMarche.setBackground(CouleurBleu);
    }
}
