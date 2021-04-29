package frame.frameReg;

import javax.swing.*;
import java.awt.*;

public class FrameReg {
    JFrame frameReg = new JFrame();
    static CardLayout cl = new CardLayout();
    public static JPanel panelReg = new JPanel();
    static JPanel panelRegCard = new JPanel();
    public FrameReg(){
        frameReg.setTitle("Programme de marche");
        frameReg.setSize(1200, 700);
        frameReg.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameReg.setLocationRelativeTo(null);
        Image icon = new ImageIcon("programme_papy/image/marche.jpg").getImage(); // J'ajoute l'icone de l'app
        frameReg.setIconImage(icon);//Je met l'icone

        panelReg.setLayout(new BorderLayout());
        panelReg.setBackground(Color.LIGHT_GRAY);
        panelRegCard.setLayout(cl);


        //Panel du haut
        PanelHautReg panelHaut = new PanelHautReg();
        panelReg.add(panelHaut.getPanelHautReg(), BorderLayout.NORTH);
        ///////////////

        //Panel de droite
        PanelDroiteReg panelDroite = new PanelDroiteReg();
        panelReg.add(panelDroite.getPanelDroiteReg(), BorderLayout.EAST);
        /////////////

        //Panel du centre
        PanelCentreReg panelCentre = new PanelCentreReg();
        panelReg.add(panelCentre.getConteneurPanelCentre(), BorderLayout.CENTER);
        /////////////////

        panelRegCard.add(panelReg, "panelReg");
        cl.show(panelRegCard, "panelReg"); //Montrer ce panel de base au centre
        frameReg.add(panelRegCard);
        frameReg.setVisible(true);
    }

    public static void setPanel(JPanel panel){
        panelRegCard.add(panel, "panel");
        cl.show(panelRegCard, "panel");

    }
}
