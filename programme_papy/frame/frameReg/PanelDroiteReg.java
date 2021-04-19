package frame.frameReg;
import frame.*;
import frame.frameReg.fonctions.FonctionDernierPoids;
import frame.frameReg.fonctions.FonctionDernierTourTaille;
import frame.frameReg.fonctions.FonctionDerniereMarche;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class PanelDroiteReg {
    JPanel panelDroiteReg = new JPanel();
    Border borderNoir = BorderFactory.createLineBorder(Color.black);

    public PanelDroiteReg() {
        panelDroiteReg.setPreferredSize(new Dimension(350, 100));
		panelDroiteReg.setBackground(Color.LIGHT_GRAY);
        panelDroiteReg.setBorder(borderNoir); //Bordure
        panelDroiteReg.setLayout(new FlowLayout());
        FonctionDerniereMarche panelDerniereMarche = new FonctionDerniereMarche();
        panelDroiteReg.add(panelDerniereMarche.getAncienneMarche());
        FonctionDernierPoids panelDernierPoids = new FonctionDernierPoids();
        panelDroiteReg.add(panelDernierPoids.getAncienPoids());
        FonctionDernierTourTaille panelDernierTourTaille = new FonctionDernierTourTaille();
        panelDroiteReg.add(panelDernierTourTaille.getAncienTourTaille());

    }

    public JPanel getPanelDroiteReg() {
        return panelDroiteReg;
    }


}
