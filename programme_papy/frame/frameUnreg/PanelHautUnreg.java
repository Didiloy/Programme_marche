package frame.frameUnreg;

import javax.swing.*;
import java.awt.*;

public class PanelHautUnreg {
    JPanel panelHaut = new JPanel();
    JLabel labelHaut = new JLabel();
    public PanelHautUnreg() {
        labelHaut.setText("Bienvenue dans ce programme de marche !");
        labelHaut.setFont(new Font("TimesRoman", Font.PLAIN, 20));
        panelHaut.setPreferredSize(new Dimension(100, 100));
        panelHaut.setBackground(Color.LIGHT_GRAY);
//        panelHaut.setLayout(new BorderLayout());
        panelHaut.setLayout(new GridBagLayout());
        GridBagConstraints contraintes = new GridBagConstraints();
        contraintes.gridx = 0;
        contraintes.gridy = 0;
        panelHaut.add(labelHaut, contraintes);
//        panelHaut.add(labelHaut, BorderLayout.CENTER);
    }
    public JPanel fonctionPanelHaut(){
        return this.panelHaut;
    }
}
