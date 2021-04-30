package frame.frameUnreg;

import javax.swing.*;
import java.awt.*;

public class FrameUnreg extends JFrame {
    public static JFrame frameUnreg = new JFrame();
    public FrameUnreg(){
        frameUnreg.setTitle("Programme de marche");
        frameUnreg.setSize(1200, 700);
        frameUnreg.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameUnreg.setLocationRelativeTo(null);
        Image icon = new ImageIcon("programme_papy/image/marche.jpg").getImage(); // J'ajoute l'icone de l'app
        frameUnreg.setIconImage(icon);//Je met l'icone
        frameUnreg.getContentPane().setBackground(Color.LIGHT_GRAY);
        frameUnreg.setLayout(new BorderLayout());

        //Panel du haut
        PanelHautUnreg panelDuHaut = new PanelHautUnreg();
        frameUnreg.add(panelDuHaut.fonctionPanelHaut(), BorderLayout.NORTH);
        ///////////////

        //Panel du centre
        PanelCentreUnreg panelCentreUnreg = new PanelCentreUnreg(this);
        frameUnreg.add(panelCentreUnreg.fonctionPanelCentreUnreg(), BorderLayout.CENTER);
        //////////////
        frameUnreg.setVisible(true);
    }
}
