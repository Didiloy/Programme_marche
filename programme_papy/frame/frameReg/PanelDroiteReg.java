package frame.frameReg;
import frame.*;
import frame.frameReg.fonctions.*;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class PanelDroiteReg extends JPanel{
    Border borderNoir = BorderFactory.createLineBorder(Color.black);
    Color CouleurBleu = new Color(83, 122, 204);

    public PanelDroiteReg() {
        this.setPreferredSize(new Dimension(350, 100));
		this.setBackground(CouleurBleu);
        //this.setBorder(borderNoir); //Bordure
        this.setLayout(new BorderLayout());
//        this.setLayout(new GridLayout(3,1));

        //je crée le panel du haut
        JPanel panelHaut = new JPanel();
        panelHaut.setPreferredSize(new Dimension(100, 150));
        panelHaut.setBackground(CouleurBleu);
        this.add(panelHaut, BorderLayout.NORTH);

        //Je crée le panel du centre
        JPanel panelCentre = new JPanel(new GridLayout(3,1));
        //Je met les éléments que je veux dans le panel du centre
            panelDroiteEnregistrerNouvelleMarche panelEnregistrerMarche = new panelDroiteEnregistrerNouvelleMarche();
            panelCentre.add(panelEnregistrerMarche.getEnregistrerMarche());

            panelDroiteEnregistrerNouveauPoids panelEnregistrerPoids = new panelDroiteEnregistrerNouveauPoids();
            panelCentre.add(panelEnregistrerPoids.getEnregistrerPoids());

            panelDroiteEnregistrerNouveauTourTaille panelEnregistrerTourTaille = new panelDroiteEnregistrerNouveauTourTaille();
            panelCentre.add(panelEnregistrerTourTaille.getEnregistrerTourTaille());
        //J'ajoute le panel du centre au panel de droite
        this.add(panelCentre, BorderLayout.CENTER);
        panelCentre.setBackground(CouleurBleu);
        ///////////////////////////////////////////////

        //je crée le panel du bas
        JPanel panelBas = new JPanel();
        panelBas.setPreferredSize(new Dimension(100, 150));
        panelBas.setBackground(CouleurBleu);
        this.add(panelBas, BorderLayout.SOUTH);
    }

    public JPanel getPanelDroiteReg() {
        return new PanelDroiteReg();
    }


}
