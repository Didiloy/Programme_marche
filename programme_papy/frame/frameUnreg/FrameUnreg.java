package frame.frameUnreg;

import javax.swing.*;
import java.awt.*;

public class FrameUnreg extends JFrame {
    public static JFrame frameUnreg = new JFrame();
    Color CouleurBleu = new Color(83, 122, 204);
    public FrameUnreg(){
        frameUnreg.setTitle("Programme de marche");
        frameUnreg.setSize(1200, 700);
        frameUnreg.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameUnreg.setLocationRelativeTo(null);
        Image icon = new ImageIcon("programme_papy/image/marche.jpg").getImage(); // J'ajoute l'icone de l'app
        frameUnreg.setIconImage(icon);//Je met l'icone
        frameUnreg.getContentPane().setBackground(CouleurBleu);
        frameUnreg.setLayout(new BorderLayout());

        //Panel du haut
        PanelCentreUnreg panelDuHaut = new PanelCentreUnreg();
        frameUnreg.add(panelDuHaut.fonctionPanelHaut(), BorderLayout.CENTER);
        ///////////////

        //Panel du centre
        PanelGaucheUnreg panelGaucheUnreg = new PanelGaucheUnreg(this);
        JPanel tmp = panelGaucheUnreg.fonctionPanelGaucheUnreg();
        tmp.setPreferredSize(new Dimension(300, 200));
        frameUnreg.add(tmp, BorderLayout.WEST);
        //////////////
        frameUnreg.setVisible(true);
    }
}
