package frame.frameReg.fonctions;

import frame.frameReg.PanelHautReg;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import static frame.frameReg.FrameReg.frameReg;
import static frame.frameReg.FrameReg.panelReg;
import static frame.frameReg.PanelCentreReg.panelCentre;

public class LabelPoidsPanelCentre implements MouseListener {
    Color backgroundCentre = new Color(54, 57, 63);
    Color backgroundCentreClair = new Color(77, 81, 89);
    Font police = new Font("Arial", Font.BOLD, 14);
    JLabel labelPoids = new JLabel("Poids");
    JPanel conteneur = new JPanel(new GridBagLayout());
    public LabelPoidsPanelCentre() {
        labelPoids.setBackground(backgroundCentre);
        labelPoids.setForeground(Color.WHITE.darker());
        labelPoids.setFont(police);
        labelPoids.addMouseListener(this);
        conteneur.setBackground(backgroundCentre);
        conteneur.addMouseListener(this);
        conteneur.add(labelPoids);
    }

    public JLabel getLabelPoids(){return labelPoids;}

    public JPanel getConteneur(){return conteneur;}

    @Override
    public void mouseClicked(MouseEvent e) {
        FonctionDernierPoids tmp = new FonctionDernierPoids();
        JPanel graphPoids = tmp.getGraphPoids();
        panelCentre.removeAll();
        PanelHautReg panelHaut = new PanelHautReg();
        panelCentre.add(panelHaut.getPanelHautReg(), BorderLayout.NORTH);
        panelCentre.add(graphPoids, BorderLayout.CENTER);
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
        labelPoids.setBackground(backgroundCentreClair);
        conteneur.setBackground(backgroundCentreClair);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        labelPoids.setBackground(backgroundCentre);
        conteneur.setBackground(backgroundCentre);
    }
}
