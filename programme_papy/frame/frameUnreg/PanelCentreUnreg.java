package frame.frameUnreg;

import javax.swing.*;
import java.awt.*;

public class PanelCentreUnreg {
    JPanel panelCentre = new JPanel();
    JLabel labelHaut = new JLabel();
    Color couleurRose = new Color(194, 148, 178);
    public PanelCentreUnreg() {
        panelCentre.setBackground(couleurRose);
        panelCentre.setLayout(new BorderLayout());

        //Panel du haut
        JPanel panelCentreHaut = new JPanel(new BorderLayout());
        panelCentreHaut.setBackground(couleurRose);
        panelCentreHaut.setPreferredSize(new Dimension(100, 150));
        JPanel panelCentreHautBas = new JPanel(new FlowLayout());
        panelCentreHautBas.setBackground(couleurRose);
        labelHaut.setText("Bienvenue dans ce programme de marche !");
        labelHaut.setFont(new Font("TimesRoman", Font.PLAIN, 20));
        panelCentreHautBas.add(labelHaut);
        panelCentreHaut.add(panelCentreHautBas, BorderLayout.SOUTH);
        panelCentre.add(panelCentreHaut, BorderLayout.NORTH);
        //////////////////////////////

        //Panel du centre
        JLabel labelCentre = new JLabel("trouver un truc à mettre");
        labelCentre.setFont(new Font("TimesRoman", Font.PLAIN, 14));
        JPanel panelCentreCentre = new JPanel(new GridBagLayout());
        panelCentreCentre.setBackground(couleurRose);
        GridBagConstraints contraintes = new GridBagConstraints();
        contraintes.gridx = 0;
        contraintes.gridy = 0;
        panelCentreCentre.add(labelCentre, contraintes);
        panelCentre.add(panelCentreCentre, BorderLayout.CENTER);
        //////////////////////////////
    }
    public JPanel fonctionPanelHaut(){
        return this.panelCentre;
    }
}
