package frame.frameReg.fonctions;

import frame.frameReg.FrameReg;
import graph.GraphPoids;
import graph.GraphTourTaille;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;

import static frame.frameReg.FrameReg.panelReg;

public class FonctionDernierTourTaille implements ActionListener, MouseListener {
    JPanel ancienTourTaille = new JPanel();
    Color CouleurBleu = new Color(83, 122, 204);
    Color CouleurBleuClair = new Color(133, 156, 227);
    Color CouleurForegroundLabel = new Color(207, 211, 214);
    public FonctionDernierTourTaille() {
        File f = new File("programme_papy/donnee/tourTaille.txt");
        JLabel labelDernierTourTaille = new JLabel();
        if (f.isFile()) {
            DerniereLigneFichier tmp = new DerniereLigneFichier();
            String[] dernierTourTaille = tmp.derniereLigne("programme_papy/donnee/tourTaille.txt").split(",");//aller chercher le dernier poids
            int dernierTourTailleInt = Integer.parseInt(dernierTourTaille[0]);//Convertir le poids en int

            labelDernierTourTaille.setFont(new Font("Arial", Font.BOLD, 16));
            labelDernierTourTaille.setText("Votre tour de taille actuel est " + dernierTourTailleInt + "cm.");
            labelDernierTourTaille.addMouseListener(this);
            labelDernierTourTaille.setForeground(CouleurForegroundLabel);
            ancienTourTaille.setLayout(new GridLayout(1,1));
            ancienTourTaille.setBackground(CouleurBleu);
            ancienTourTaille.add(labelDernierTourTaille);

            //bouton pour afficher les graphiques
//            JButton boutonAfficherAncienTourTaille = new JButton();
//            boutonAfficherAncienTourTaille.setBackground(Color.WHITE);
//            boutonAfficherAncienTourTaille.setText("Afficher les anciens tour de taille");
//            boutonAfficherAncienTourTaille.addActionListener(this);
//            ancienTourTaille.add(boutonAfficherAncienTourTaille, ctntAncienTourTaille);
        }
        else {
            labelDernierTourTaille.setFont(new Font("Arial", Font.BOLD, 16));
            labelDernierTourTaille.setText("Vous n'avez pas encore enregistrer de tour de taille.");
            labelDernierTourTaille.addMouseListener(this);
            labelDernierTourTaille.setForeground(CouleurForegroundLabel);
            ancienTourTaille.setLayout(new GridLayout(1,1));
            ancienTourTaille.setBackground(CouleurBleu);
            ancienTourTaille.add(labelDernierTourTaille);
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

    @Override
    public void mouseClicked(MouseEvent e) {
        FrameReg.setPanel(getGraphTourTaille());
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        ancienTourTaille.setBackground(CouleurBleuClair);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        ancienTourTaille.setBackground(CouleurBleu);
    }
}
