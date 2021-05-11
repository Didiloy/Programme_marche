package frame.frameReg;

import javax.swing.*;
import java.awt.*;

public class PanelHautReg {
    JPanel panelHautReg = new JPanel();
    JLabel titre = new JLabel("Programme de Marche");
    public PanelHautReg(){
        titre.setFont(new Font("Arial",Font.BOLD,24));
        panelHautReg.setPreferredSize(new Dimension(100, 100));
        panelHautReg.setBackground(Color.LIGHT_GRAY);
        panelHautReg.setLayout(new GridBagLayout());
        GridBagConstraints ctntHaut = new GridBagConstraints();
        ctntHaut.gridx = 0;
        ctntHaut.gridy = 0;
        panelHautReg.add(titre, ctntHaut);
    }
    public JPanel getPanelHautReg(){
        return panelHautReg;
    }
}
