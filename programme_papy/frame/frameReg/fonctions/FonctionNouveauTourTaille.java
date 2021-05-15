package frame.frameReg.fonctions;

import frame.frameReg.PanelDroiteReg;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;

import static frame.frameReg.FrameReg.frameReg;
import static frame.frameReg.FrameReg.panelReg;
import static frame.frameReg.PanelCentreReg.cl;
import static frame.frameReg.PanelCentreReg.conteneurPanelCentre;

public class FonctionNouveauTourTaille implements ActionListener {
    JPanel nouveauTourTaille = new JPanel();
    JTextField textNouveauTourTaille = new JTextField(10);
    public FonctionNouveauTourTaille(){
        nouveauTourTaille.setBackground(Color.LIGHT_GRAY);
        nouveauTourTaille.setLayout(new GridBagLayout());
        GridBagConstraints ctntTourTaille = new GridBagConstraints();
        ctntTourTaille.insets = new Insets(10, 10, 10, 10);//padding des éléments du panel
        ctntTourTaille.gridx = 0;
        ctntTourTaille.gridwidth = 2;
        ctntTourTaille.gridy = 0;
        JLabel labelNouveauTourTaille = new JLabel("Quel est votre tour de taille actuel ?");
        nouveauTourTaille.add(labelNouveauTourTaille, ctntTourTaille);

        ctntTourTaille.gridx = 0;
        ctntTourTaille.gridwidth = 1;
        ctntTourTaille.gridy = 1;
        JLabel tourTaille = new JLabel("Entrez votre tour de taille");
        nouveauTourTaille.add(tourTaille, ctntTourTaille);

        ctntTourTaille.gridx = 1;
        ctntTourTaille.gridy = 1;
        nouveauTourTaille.add(textNouveauTourTaille, ctntTourTaille);

        ctntTourTaille.gridx = 1;
        ctntTourTaille.gridwidth =1;
        ctntTourTaille.gridy = 2;
        JButton boutonTourTaille = new JButton();
        boutonTourTaille.setText("Enregistrer");
        nouveauTourTaille.add(boutonTourTaille, ctntTourTaille);
        boutonTourTaille.addActionListener(this);
    }

    public JPanel getNouveauTourTaille() {
        return nouveauTourTaille;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        int userTourTaille = Integer.parseInt(textNouveauTourTaille.getText());
        ecrireTourTaille(userTourTaille);
        cl.show(conteneurPanelCentre, "panelCentre"); //On repasse au panelCentre
        JOptionPane.showMessageDialog(null, "Nouveau tour de taille enregistré !",
                "Programme de Marche", JOptionPane.INFORMATION_MESSAGE);//Je met le popup qui indique que la marche est enregistrée

        BorderLayout layout = (BorderLayout)panelReg.getLayout();
        panelReg.remove(layout.getLayoutComponent(BorderLayout.EAST));
        panelReg.add(new PanelDroiteReg(), BorderLayout.EAST);
        panelReg.updateUI();
        SwingUtilities.updateComponentTreeUI(frameReg);
    }

    public void ecrireTourTaille(int tourTaille) {//Change le poids dans le fichier utilisateur.txt et met l'ancien dans ancienPoids.txt
        try {//Le true du filewriter c'est pour ouvrir le fichier en mode append
            BufferedWriter bw = new BufferedWriter(new FileWriter("programme_papy/donnee/tourTaille.txt", true));//On choisi le fichier dans lequel on écrit
            LocalDate date = null;
            bw.write(tourTaille +","+ date.now()+ "\n");//On écrit
            bw.close();
        }
        catch (IOException e)//Si il y a une erreur on la récupère.
        {
            //Print the error message
            System.out.print(e.getMessage());
        }
    }

}
