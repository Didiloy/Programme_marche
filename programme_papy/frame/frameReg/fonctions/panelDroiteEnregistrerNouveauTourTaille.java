package frame.frameReg.fonctions;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import static frame.frameReg.PanelCentreReg.cl;
import static frame.frameReg.PanelCentreReg.conteneurPanelCentre;

public class panelDroiteEnregistrerNouveauTourTaille implements ActionListener, MouseListener {


        JPanel enregistrerTourTaille = new JPanel(new GridLayout(1, 1));
        JLabel LabelEnregistrerTourTaille = new JLabel("Enregistrer un nouveau tour de taille");
        Color CouleurBleu = new Color(83, 122, 204);
        Color CouleurBleuClair = new Color(133, 156, 227);
        Color CouleurForegroundLabel = new Color(207, 211, 214);

        JPanel nouveauTourTaille = new JPanel();

        public panelDroiteEnregistrerNouveauTourTaille() {
            LabelEnregistrerTourTaille.setForeground(CouleurForegroundLabel);
            LabelEnregistrerTourTaille.setFont(new Font("Arial", Font.BOLD, 14));
            enregistrerTourTaille.setBackground(CouleurBleu);
            enregistrerTourTaille.addMouseListener(this);
            enregistrerTourTaille.add(LabelEnregistrerTourTaille);

            FonctionNouveauTourTaille tmp1 = new FonctionNouveauTourTaille();
            nouveauTourTaille = tmp1.getNouveauTourTaille();
        }
        @Override
        public void mouseClicked(MouseEvent e) {
            GridBagConstraints ctntMarche = new GridBagConstraints();
            ctntMarche.insets = new Insets(10, 10, 10, 10);//padding des éléments du panel
            ctntMarche.gridx = 0;
            ctntMarche.gridwidth = 1;
            ctntMarche.gridy = 2;
            JButton boutonRetour = new JButton();
            boutonRetour.setText("Annuler");
            nouveauTourTaille.add(boutonRetour, ctntMarche);
            boutonRetour.addActionListener(this);
            conteneurPanelCentre.add(nouveauTourTaille, "nouveauTourTaille");
            cl.show(conteneurPanelCentre,"nouveauTourTaille");
        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {
            enregistrerTourTaille.setBackground(CouleurBleuClair);
        }

        @Override
        public void mouseExited(MouseEvent e) {
            enregistrerTourTaille.setBackground(CouleurBleu);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            cl.show(conteneurPanelCentre, "panelCentre");
        }

        public JPanel getEnregistrerTourTaille(){return enregistrerTourTaille;}
}
