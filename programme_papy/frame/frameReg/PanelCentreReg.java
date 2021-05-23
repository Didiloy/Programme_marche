package frame.frameReg;


import frame.frameReg.fonctions.FonctionDerniereMarche;
import frame.frameReg.fonctions.FonctionNouveauPoids;
import frame.frameReg.fonctions.FonctionNouveauTourTaille;
import frame.frameReg.fonctions.FonctionNouvelleMarche;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class PanelCentreReg implements ActionListener, MouseListener {
    public static JPanel conteneurPanelCentre = new JPanel();
    public static JPanel panelCentre = new JPanel();
    public static CardLayout cl = new CardLayout();
    Color backgroundCentre = new Color(54, 57, 63);
    JButton boutonRetour = new JButton("Retour");
    JPanel nouvelleMarche;
    JPanel nouveauPoids;
    JPanel nouveauTourTaille;
    JPanel graphMarche;

    public PanelCentreReg(){
        conteneurPanelCentre.setLayout(cl);
		panelCentre.setBackground(backgroundCentre);
        panelCentre.setLayout(new BorderLayout());
//        panelCentre.setLayout(new GridLayout(10, 1, 5, 5));

       //Panel du haut
        PanelHautReg panelHaut = new PanelHautReg();
        panelCentre.add(panelHaut.getPanelHautReg(), BorderLayout.NORTH);
        /////////////
        FonctionDerniereMarche tmp4 = new FonctionDerniereMarche();
        graphMarche = tmp4.getGraphMarche();
        panelCentre.add(graphMarche, BorderLayout.CENTER);

        conteneurPanelCentre.add(panelCentre, "panelCentre");
        cl.show(conteneurPanelCentre, "panelCentre"); //Montrer ce panel de base au centre



        //////////////////////////////////////////////////
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {

    }


    ActionListener listenerBoutonRetour = new ActionListener() { // Afficher le panel pour enregistrer une nouvelle marche
        @Override
        public void actionPerformed(ActionEvent e) {
            cl.show(conteneurPanelCentre, "panelCentre");
        }
    };

    public JPanel getConteneurPanelCentre() {
        return conteneurPanelCentre;
    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {

    }

    @Override
    public void mousePressed(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseEntered(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseExited(MouseEvent mouseEvent) {

    }
}
