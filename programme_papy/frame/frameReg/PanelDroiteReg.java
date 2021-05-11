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

public class PanelDroiteReg extends JPanel{
    Border borderNoir = BorderFactory.createLineBorder(Color.black);

    public PanelDroiteReg() {
        this.setPreferredSize(new Dimension(350, 100));
		this.setBackground(Color.LIGHT_GRAY);
        this.setBorder(borderNoir); //Bordure
        this.setLayout(new GridLayout(3,1));
        //Je met les éléments que je veux dans le panel
            FonctionDerniereMarche panelDerniereMarche = new FonctionDerniereMarche();
            this.add(panelDerniereMarche.getAncienneMarche());
            FonctionDernierPoids panelDernierPoids = new FonctionDernierPoids();
            this.add(panelDernierPoids.getAncienPoids());
            FonctionDernierTourTaille panelDernierTourTaille = new FonctionDernierTourTaille();
            this.add(panelDernierTourTaille.getAncienTourTaille());
        ///////////////////////////////////////////////
    }

    public JPanel getPanelDroiteReg() {
        return new PanelDroiteReg();
    }


}
