package frame.frameReg;

import frame.frameReg.fonctions.LabelMarchePanelCentre;
import frame.frameReg.fonctions.LabelPoidsPanelCentre;
import frame.frameReg.fonctions.LabelTaillePanelCentre;

import javax.swing.*;
import java.awt.*;


public class PanelHautReg {
    Color backgroundCentre = new Color(54, 57, 63);
    JPanel panelHautReg = new JPanel();
    public PanelHautReg(){
        panelHautReg.setPreferredSize(new Dimension(10, 50));
        panelHautReg.setBackground(backgroundCentre);
        panelHautReg.setLayout(new GridLayout(1,3));

        LabelMarchePanelCentre labelMarche = new LabelMarchePanelCentre();
        panelHautReg.add(labelMarche.getConteneur());

        LabelPoidsPanelCentre labelPoids = new LabelPoidsPanelCentre();
        panelHautReg.add(labelPoids.getConteneur());

        LabelTaillePanelCentre labelTaille = new LabelTaillePanelCentre();
        panelHautReg.add(labelTaille.getConteneur());

    }
    public JPanel getPanelHautReg(){
        return panelHautReg;
    }

}
