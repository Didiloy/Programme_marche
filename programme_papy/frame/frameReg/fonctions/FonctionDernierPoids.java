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
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;

import static frame.frameReg.FrameReg.panelReg;

public class FonctionDernierPoids implements ActionListener, MouseListener {
    JPanel ancienPoids = new JPanel();
    Color CouleurBleu = new Color(83, 122, 204);
    Color CouleurBleuClair = new Color(133, 156, 227);
    Color CouleurForegroundLabel = new Color(207, 211, 214);
    Color backgroundCentre = new Color(54, 57, 63);
    Font police = new Font("Arial", Font.PLAIN, 14);
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

            labelDernierPoids.setFont(new Font("Arial", Font.BOLD, 16));
            labelDernierPoids.setText("Votre poids actuel est " + dernierPoidsInt + "kg.");
            labelDernierPoids.addMouseListener(this);
            labelDernierPoids.setForeground(CouleurForegroundLabel);
            ancienPoids.setLayout(new GridLayout(1,1));
            ancienPoids.setBackground(CouleurBleu);
            ancienPoids.add(labelDernierPoids);
        }
        else {
            labelDernierPoids.setFont(new Font("Arial", Font.PLAIN, 16));
            labelDernierPoids.setText("Vous n'avez pas encore enregistrer de poids.");
            labelDernierPoids.addMouseListener(this);
            labelDernierPoids.setForeground(CouleurForegroundLabel);
            ancienPoids.setLayout(new GridLayout(1,1));
            ancienPoids.setBackground(CouleurBleu);
            ancienPoids.add(labelDernierPoids);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        FrameReg.setPanel(getGraphPoids());
    }

    public JPanel getGraphPoids(){
        JPanel panelAnciensPoids = new JPanel(new BorderLayout());
        panelAnciensPoids.setBackground(backgroundCentre);
        JPanel panelGraphAnciensPoids = new JPanel(new GridLayout(1, 1));
        JPanel panelSudAnciensPoids = new JPanel(new GridLayout(2, 1));
        panelSudAnciensPoids.setBackground(backgroundCentre);
            JPanel panelSudMoyennePoids = new JPanel(new FlowLayout());
            panelSudMoyennePoids.setBackground(backgroundCentre);

        GraphPoids graphPoids = new GraphPoids();
        panelGraphAnciensPoids.add(graphPoids.getCharPanel());
        panelAnciensPoids.add(panelGraphAnciensPoids, BorderLayout.CENTER); //J'ajoute le panel des graphs au panel

        FonctionMoyennePoids moyennePoids = new FonctionMoyennePoids();
        JLabel labelMoyennePoids =new JLabel("La moyenne de tout les poids entrés est "+ moyennePoids.getMoyenne() + "kg.");
        labelMoyennePoids.setForeground(Color.white);
        labelMoyennePoids.setFont(police);
        panelSudMoyennePoids.add(labelMoyennePoids);
        panelSudAnciensPoids.add(panelSudMoyennePoids);
        panelAnciensPoids.add(panelSudAnciensPoids, BorderLayout.SOUTH);

        return panelAnciensPoids;
    }
    public JPanel getAncienPoids() {
        return ancienPoids;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        FrameReg.setPanel(getGraphPoids());
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        ancienPoids.setBackground(CouleurBleuClair);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        ancienPoids.setBackground(CouleurBleu);
    }
}
