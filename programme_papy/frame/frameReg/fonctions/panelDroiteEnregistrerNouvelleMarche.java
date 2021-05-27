package frame.frameReg.fonctions;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import static frame.frameReg.PanelCentreReg.cl;
import static frame.frameReg.PanelCentreReg.conteneurPanelCentre;

public class panelDroiteEnregistrerNouvelleMarche implements MouseListener, ActionListener {
    JPanel enregistrerMarche = new JPanel(new GridLayout(1, 1));
    JLabel LabelEnregistrermMarche = new JLabel("    Nouvelle marche");
    Color CouleurBleu = new Color(83, 122, 204);
    Color CouleurBleuClair = new Color(133, 156, 227);
    Color CouleurForegroundLabel = new Color(255, 255, 255);

    JPanel nouvelleMarche = new JPanel();

    public panelDroiteEnregistrerNouvelleMarche() {
        LabelEnregistrermMarche.setForeground(CouleurForegroundLabel);
        LabelEnregistrermMarche.setFont(new Font("Arial", Font.BOLD, 14));
        enregistrerMarche.setBackground(CouleurBleu);
        enregistrerMarche.addMouseListener(this);
        enregistrerMarche.add(LabelEnregistrermMarche);

        FonctionNouvelleMarche tmp1 = new FonctionNouvelleMarche();
        nouvelleMarche = tmp1.getNouvelleMarche();
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        conteneurPanelCentre.add(nouvelleMarche, "nouvelleMarche");
        cl.show(conteneurPanelCentre,"nouvelleMarche");
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        enregistrerMarche.setBackground(CouleurBleuClair);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        enregistrerMarche.setBackground(CouleurBleu);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        cl.show(conteneurPanelCentre, "panelCentre");
    }

    public JPanel getEnregistrerMarche(){return enregistrerMarche;}
}
