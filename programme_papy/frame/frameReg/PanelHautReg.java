package frame.frameReg;

import frame.frameReg.fonctions.LabelMarchePanelCentre;
import frame.frameReg.fonctions.LabelPoidsPanelCentre;
import frame.frameReg.fonctions.LabelTaillePanelCentre;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class PanelHautReg {
    Color backgroundCentre = new Color(54, 57, 63);
    JPanel panelHautReg = new JPanel();
    public PanelHautReg(){
        panelHautReg.setPreferredSize(new Dimension(50, 50));
        panelHautReg.setBackground(backgroundCentre);
        panelHautReg.setLayout(new GridLayout(1,5));

        LabelMarchePanelCentre labelMarche = new LabelMarchePanelCentre();
        panelHautReg.add(labelMarche.getConteneur());

        JPanel panelvide = new JPanel();
        panelvide.setBackground(backgroundCentre);
        panelHautReg.add(panelvide);


        LabelPoidsPanelCentre labelPoids = new LabelPoidsPanelCentre();
        panelHautReg.add(labelPoids.getConteneur());

        JPanel panelVide2 = new JPanel();
        panelVide2.setBackground(backgroundCentre);
        panelHautReg.add(panelVide2);

        LabelTaillePanelCentre labelTaille = new LabelTaillePanelCentre();
        panelHautReg.add(labelTaille.getConteneur());

    }
    public JPanel getPanelHautReg(){
        return panelHautReg;
    }

}
