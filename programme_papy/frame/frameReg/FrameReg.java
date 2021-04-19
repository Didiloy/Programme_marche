package frame.frameReg;

import javax.swing.*;
import java.awt.*;

public class FrameReg {
    JFrame frameReg = new JFrame();
    public FrameReg(){
        frameReg.setTitle("Programme de marche");
        frameReg.setSize(1200, 700);
        frameReg.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameReg.setLocationRelativeTo(null);
        Image icon = new ImageIcon("programme_papy/image/marche.jpg").getImage(); // J'ajoute l'icone de l'app
        frameReg.setIconImage(icon);//Je met l'icone
        frameReg.getContentPane().setBackground(Color.LIGHT_GRAY);
        frameReg.setLayout(new BorderLayout(5, 5));


        //Panel du haut
        PanelHautReg panelHaut = new PanelHautReg();
        frameReg.add(panelHaut.getPanelHautReg(), BorderLayout.NORTH);
        ///////////////

        //Panel de droite
        PanelDroiteReg panelDroite = new PanelDroiteReg();
        frameReg.add(panelDroite.getPanelDroiteReg(), BorderLayout.EAST);
        /////////////

        //Panel du centre
        PanelCentreReg panelCentre = new PanelCentreReg();
        frameReg.add(panelCentre.getConteneurPanelCentre(), BorderLayout.CENTER);
        /////////////////

        frameReg.setVisible(true);
    }
}
