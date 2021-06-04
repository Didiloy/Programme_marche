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
    Color backgroundCentre = new Color(54, 57, 63);
    Font police = new Font("Arial", Font.PLAIN, 14);
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
        panelAnciensTourTaille.setBackground(backgroundCentre);
        JPanel panelGraphAnciensTourTaille = new JPanel(new GridLayout(1, 1));
        panelGraphAnciensTourTaille.setBackground(backgroundCentre);
        JPanel panelSudAnciensTourTaille = new JPanel(new FlowLayout());
        panelSudAnciensTourTaille.setPreferredSize(new Dimension(100, 54));
        panelSudAnciensTourTaille.setBackground(backgroundCentre);

        GraphTourTaille graphTourTaille = new GraphTourTaille(); //ajout du graph et du scrollpane
        panelGraphAnciensTourTaille = graphTourTaille.getCharPanel();
        JScrollPane scrollPane = new JScrollPane(panelGraphAnciensTourTaille);
        panelGraphAnciensTourTaille.setPreferredSize(new Dimension(graphTourTaille.GetLigneTourTaille()*100,1));
        scrollPane.setBackground(backgroundCentre);
        panelAnciensTourTaille.add(scrollPane, BorderLayout.CENTER); //J'ajoute le panel des graphs au panel

        FonctionMoyenneTourTaille mtt = new FonctionMoyenneTourTaille();
        JLabel moyenneTaille = new JLabel("La moyenne des tours de taille entrés est: " + mtt.getMoyenne() + "cm");
        moyenneTaille.setForeground(Color.white);
        moyenneTaille.setFont(police);
        panelSudAnciensTourTaille.add(moyenneTaille);

        panelAnciensTourTaille.add(panelSudAnciensTourTaille, BorderLayout.SOUTH);

        return panelAnciensTourTaille;
    }
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
