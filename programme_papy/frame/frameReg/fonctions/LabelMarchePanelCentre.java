package frame.frameReg.fonctions;

import frame.frameReg.PanelHautReg;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import static frame.frameReg.FrameReg.frameReg;
import static frame.frameReg.FrameReg.panelReg;
import static frame.frameReg.PanelCentreReg.panelCentre;

public class LabelMarchePanelCentre implements MouseListener {
    Color backgroundCentre = new Color(54, 57, 63);
    Color backgroundCentreClair = new Color(77, 81, 89);
    Font police = new Font("Arial", Font.BOLD, 14);
    JLabel labelMarche = new JLabel("Marches",JLabel.CENTER);
    JPanel conteneur = new JPanel(new GridBagLayout());
    public LabelMarchePanelCentre() {
        labelMarche.setBackground(backgroundCentre);
        labelMarche.setForeground(Color.WHITE.darker());
        labelMarche.setFont(police);
        labelMarche.addMouseListener(this);
        conteneur.setBackground(backgroundCentre);
        conteneur.addMouseListener(this);
        conteneur.add(labelMarche);
    }

    public JLabel getLabelMarche(){return labelMarche;}

    public JPanel getConteneur(){return conteneur;}

    @Override
    public void mouseClicked(MouseEvent e) {
        FonctionDerniereMarche tmp = new FonctionDerniereMarche();
        JPanel graphMarche = tmp.getGraphMarche();
        panelCentre.removeAll();
        PanelHautReg panelHaut = new PanelHautReg();
        panelCentre.add(panelHaut.getPanelHautReg(), BorderLayout.NORTH);
        panelCentre.add(graphMarche, BorderLayout.CENTER);
        panelReg.updateUI();
        SwingUtilities.updateComponentTreeUI(frameReg);
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        labelMarche.setBackground(backgroundCentreClair);
        conteneur.setBackground(backgroundCentreClair);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        labelMarche.setBackground(backgroundCentre);
        conteneur.setBackground(backgroundCentre);
    }
}
