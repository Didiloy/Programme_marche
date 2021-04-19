package frame.frameReg.fonctions;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class FonctionDernierTourTaille implements ActionListener {
    JPanel ancienTourTaille = new JPanel();
    public FonctionDernierTourTaille() {
        File f = new File("programme_papy/donnee/tourTaille.txt");
        JLabel labelDernierTourTaille = new JLabel();
        JLabel labelTitreDernierTourTaille = new JLabel("Dernier tour de taille:");
        if (f.isFile()) {
            DerniereLigneFichier tmp = new DerniereLigneFichier();
            String dernierTourTaille = tmp.derniereLigne("programme_papy/donnee/tourTaille.txt");//aller chercher le dernier poids
            int dernierTourTailleInt = Integer.parseInt(dernierTourTaille);//Convertir le poids en int

            labelDernierTourTaille.setText("Votre tour de taille actuel est " + dernierTourTailleInt + "cm.");
            ancienTourTaille.setLayout(new GridBagLayout());
            GridBagConstraints ctntAncienTourTaille = new GridBagConstraints();
            ctntAncienTourTaille.insets = new Insets(10, 10, 10, 10);//padding des éléments du panel
            ctntAncienTourTaille.gridx = 0;
            ctntAncienTourTaille.gridwidth = 2;
            ctntAncienTourTaille.gridy = 0;
            ancienTourTaille.add(labelTitreDernierTourTaille, ctntAncienTourTaille);
            ctntAncienTourTaille.gridx = 0;
            ctntAncienTourTaille.gridy = 1;
            ancienTourTaille.add(labelDernierTourTaille, ctntAncienTourTaille);
            ctntAncienTourTaille.gridx = 0;
            ctntAncienTourTaille.gridy = 2;
            JButton boutonAfficherAncienTourTaille = new JButton();
            boutonAfficherAncienTourTaille.setText("Afficher les anciens tour de taille");
            boutonAfficherAncienTourTaille.addActionListener(this);
            ancienTourTaille.add(boutonAfficherAncienTourTaille, ctntAncienTourTaille);
        }
        else {
            labelDernierTourTaille.setText("Vous n'avez pas encore enregistrer de tour de taille.");
            ancienTourTaille.setLayout(new GridBagLayout());
            GridBagConstraints ctntAncienTourTaille = new GridBagConstraints();
            ctntAncienTourTaille.insets = new Insets(10, 10, 10, 10);//padding des éléments du panel
            ctntAncienTourTaille.gridx = 0;
            ctntAncienTourTaille.gridwidth = 2;
            ctntAncienTourTaille.gridy = 0;
            ancienTourTaille.add(labelTitreDernierTourTaille, ctntAncienTourTaille);
            ctntAncienTourTaille.gridx = 0;
            ctntAncienTourTaille.gridy = 1;
            ancienTourTaille.add(labelDernierTourTaille, ctntAncienTourTaille);
        }
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {

    }

    public JPanel getAncienTourTaille() {
        return ancienTourTaille;
    }
}
