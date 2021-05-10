package frame.frameReg.fonctions;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.security.cert.CertificateParsingException;

import frame.Marche;

import static frame.frameReg.FrameReg.frameReg;

public class FonctionNouvelleMarche implements ActionListener {
    JPanel nouvelleMarche = new JPanel();
    JTextField textDistance = new JTextField(10);
    JTextField textTemps = new JTextField(10);
    JTextField textDate = new JTextField(10);

    public FonctionNouvelleMarche() {
        nouvelleMarche.setBackground(Color.LIGHT_GRAY);
        nouvelleMarche.setLayout(new GridBagLayout());
        GridBagConstraints ctntMarche = new GridBagConstraints();
        ctntMarche.insets = new Insets(10, 10, 10, 10);//padding des éléments du panel
        ctntMarche.gridx = 0;
        ctntMarche.gridwidth = 2;
        ctntMarche.gridy = 0;
        JLabel enregistrer = new JLabel("Enregistrer une nouvelle marche");
        nouvelleMarche.add(enregistrer, ctntMarche);

        ctntMarche.gridx = 0;
        ctntMarche.gridy = 1;
        ctntMarche.gridwidth = 1;
        JLabel distance = new JLabel("Quelle distance avez-vous marché ? (m)");
        nouvelleMarche.add(distance, ctntMarche);

        ctntMarche.gridx = 1;
        ctntMarche.gridy = 1;
        nouvelleMarche.add(textDistance, ctntMarche);

        ctntMarche.gridx = 0;
        ctntMarche.gridy = 2;
        JLabel temps = new JLabel("En combien de temps ? (min)");
        nouvelleMarche.add(temps, ctntMarche);

        ctntMarche.gridx = 1;
        ctntMarche.gridy = 2;
        nouvelleMarche.add(textTemps, ctntMarche);

        ctntMarche.gridx = 0;
        ctntMarche.gridy = 3;
        JLabel date = new JLabel("Date du jour (format dd/mm/yyyy): ");
        nouvelleMarche.add(date, ctntMarche);

        ctntMarche.gridx = 1;
        ctntMarche.gridy = 3;
        nouvelleMarche.add(textDate, ctntMarche);


        ctntMarche.gridx = 1;
        ctntMarche.gridwidth = 2;
        ctntMarche.gridy = 4;
        JButton boutonMarche = new JButton("Enregistrer");
        nouvelleMarche.add(boutonMarche, ctntMarche);
        boutonMarche.addActionListener(this);
        //========================================
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int userDistance = Integer.parseInt(textDistance.getText());
        int userTemps = Integer.parseInt(textTemps.getText());
        String userDate = textDate.getText();
        Marche m1 = new Marche(userDistance, userTemps, userDate);
        ecrireMarche(m1);//J'écrit les infos de la marche dans le fichier
//        cl.show(conteneurPanelCentre, "panelCentre"); //On repasse au panelCentre
        JOptionPane.showMessageDialog(null, "Nouvelle marche enregistrée !",
                "Programme de Marche", JOptionPane.INFORMATION_MESSAGE);//Je met le popup qui indique que la marche est enregistrée
        SwingUtilities.updateComponentTreeUI(frameReg);
    }

    public JPanel getNouvelleMarche() {
        return nouvelleMarche;
    }

    public void ecrireMarche(Marche marche) {
        try {//Le true du filewriter c'est pour ouvrir le fichier en mode append
            BufferedWriter bw = new BufferedWriter(new FileWriter("programme_papy/donnee/marche.txt", true));//On choisi le fichier dans lequel on écrit
            bw.write(marche.toString(1) + "\n");//On écrit
            bw.close();
        }
        catch (IOException e)//Si il y a une erreur on la récupère.
        {
            System.out.print(e.getMessage());
        }
    }
}
