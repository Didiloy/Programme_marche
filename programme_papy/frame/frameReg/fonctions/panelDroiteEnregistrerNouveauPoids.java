package frame.frameReg.fonctions;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import static frame.frameReg.PanelCentreReg.cl;
import static frame.frameReg.PanelCentreReg.conteneurPanelCentre;

public class panelDroiteEnregistrerNouveauPoids implements ActionListener, MouseListener {

        JPanel enregistrerPoids = new JPanel(new GridLayout(1, 1));
        JLabel LabelEnregistrerPoids = new JLabel("Enregistrer un nouveau poids");
        Color CouleurBleu = new Color(83, 122, 204);
        Color CouleurBleuClair = new Color(133, 156, 227);
        Color CouleurForegroundLabel = new Color(207, 211, 214);

        JPanel nouveauPoids = new JPanel();

        public panelDroiteEnregistrerNouveauPoids() {
            LabelEnregistrerPoids.setForeground(CouleurForegroundLabel);
            LabelEnregistrerPoids.setFont(new Font("Arial", Font.BOLD, 14));
            enregistrerPoids.setBackground(CouleurBleu);
            enregistrerPoids.addMouseListener(this);
            enregistrerPoids.add(LabelEnregistrerPoids);

            FonctionNouveauPoids tmp1 = new FonctionNouveauPoids();
            nouveauPoids = tmp1.getNouveauPoids();
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
            nouveauPoids.add(boutonRetour, ctntMarche);
            boutonRetour.addActionListener(this);
            conteneurPanelCentre.add(nouveauPoids, "nouveauPoids");
            cl.show(conteneurPanelCentre,"nouveauPoids");
        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {
            enregistrerPoids.setBackground(CouleurBleuClair);
        }

        @Override
        public void mouseExited(MouseEvent e) {
            enregistrerPoids.setBackground(CouleurBleu);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            cl.show(conteneurPanelCentre, "panelCentre");
        }

        public JPanel getEnregistrerPoids(){return enregistrerPoids;}
}
