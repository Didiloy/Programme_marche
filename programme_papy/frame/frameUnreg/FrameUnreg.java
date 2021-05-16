package frame.frameUnreg;

import javax.swing.*;
import java.awt.*;

public class FrameUnreg extends JFrame {
    public static JFrame frameUnreg = new JFrame();
    Color CouleurBleu = new Color(83, 122, 204);
    Color CouleurBleuClaire = new Color(133, 156, 227);
    public FrameUnreg(){
        frameUnreg.setTitle("Programme de marche");
        frameUnreg.setSize(1200, 700);
        frameUnreg.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameUnreg.setLocationRelativeTo(null);
        Image icon = new ImageIcon("programme_papy/image/marche.jpg").getImage(); // J'ajoute l'icone de l'app
        frameUnreg.setIconImage(icon);//Je met l'icone
        frameUnreg.getContentPane().setBackground(CouleurBleu);
        frameUnreg.setLayout(new BorderLayout());


        //Panel gauche
        JPanel gauche = new JPanel();
        gauche.setBackground(CouleurBleuClaire);
        gauche.setPreferredSize(new Dimension(frameUnreg.getWidth()/3,1));
        frameUnreg.add(gauche,BorderLayout.WEST);

        //Panel droite
        JPanel droite = new JPanel();
        droite.setBackground(CouleurBleuClaire);
        droite.setPreferredSize(new Dimension(frameUnreg.getWidth()/3,1));
        frameUnreg.add(droite,BorderLayout.EAST);

        //Panel du centre
        PanelCentreUnreg panelCentreUnreg = new PanelCentreUnreg(this);
        JPanel tmp = panelCentreUnreg.fonctionPanelCentreUnreg();
        tmp.setPreferredSize(new Dimension(300, 200));
        frameUnreg.add(tmp, BorderLayout.CENTER);
        //////////////
        frameUnreg.setVisible(true);
    }
}
