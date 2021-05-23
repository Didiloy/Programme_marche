package frame.frameReg.fonctions;

import frame.frameReg.PanelHautReg;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import static frame.frameReg.FrameReg.frameReg;
import static frame.frameReg.FrameReg.panelReg;
import static frame.frameReg.PanelCentreReg.panelCentre;

public class LabelTaillePanelCentre implements MouseListener {
    Color backgroundCentre = new Color(54, 57, 63);
    Color backgroundCentreClair = new Color(77, 81, 89);
    Font police = new Font("Arial", Font.BOLD, 14);
    JLabel labelTaille = new JLabel("Tours de tailles",JLabel.CENTER);
    JPanel conteneur = new JPanel(new GridBagLayout());
    public LabelTaillePanelCentre() {
        labelTaille.setBackground(backgroundCentre);
        labelTaille.setForeground(Color.WHITE);
        labelTaille.setFont(police);
        labelTaille.addMouseListener(this);
        conteneur.setBackground(backgroundCentre);
        conteneur.addMouseListener(this);
        conteneur.add(labelTaille);
    }

    public JLabel getLabelTaille(){return labelTaille;}

    public JPanel getConteneur(){return conteneur;}

    @Override
    public void mouseClicked(MouseEvent e) {
        FonctionDernierTourTaille tmp = new FonctionDernierTourTaille();
        JPanel graphTourTaille = tmp.getGraphTourTaille();
        panelCentre.removeAll();
        PanelHautReg panelHaut = new PanelHautReg();
        panelCentre.add(panelHaut.getPanelHautReg(), BorderLayout.NORTH);
        panelCentre.add(graphTourTaille, BorderLayout.CENTER);
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
        labelTaille.setBackground(backgroundCentreClair);
        conteneur.setBackground(backgroundCentreClair);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        labelTaille.setBackground(backgroundCentre);
        conteneur.setBackground(backgroundCentre);
    }
}
