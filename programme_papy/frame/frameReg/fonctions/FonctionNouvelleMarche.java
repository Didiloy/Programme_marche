package frame.frameReg.fonctions;

import javax.swing.*;
import javax.swing.border.MatteBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;


import frame.Marche;
import frame.TextPrompt;
import frame.frameReg.PanelDroiteReg;

import static frame.frameReg.FrameReg.frameReg;
import static frame.frameReg.FrameReg.panelReg;
import static frame.frameReg.PanelCentreReg.cl;
import static frame.frameReg.PanelCentreReg.conteneurPanelCentre;

public class FonctionNouvelleMarche implements MouseListener {
    JPanel conteneur = new JPanel( new BorderLayout());
    JPanel panelHaut = new JPanel( new BorderLayout());
    JPanel nouvelleMarche = new JPanel();
    JTextField textDistance = new JTextField(20);
    JTextField textTemps = new JTextField(20);
    JTextField textDate = new JTextField(20);
    Color backgroundCentre = new Color(54, 57, 63);
    Color backgroundCentreClair = new Color(77, 81, 89);
    MatteBorder bordureTextfield = new MatteBorder(0,0,2,0, Color.white);
    Font police = new Font("Arial", Font.BOLD, 14);
    JPanel panelEnregistrer = new JPanel(new FlowLayout());

    public FonctionNouvelleMarche() {
        nouvelleMarche.setBackground(backgroundCentre);
        nouvelleMarche.setLayout(new GridBagLayout());
        GridBagConstraints ctntMarche = new GridBagConstraints();
        ctntMarche.insets = new Insets(10, 10, 10, 10);//padding des éléments du panel
        ctntMarche.gridx = 0;
        ctntMarche.gridy = 0;
        textDistance.setOpaque(false);
        textDistance.setBorder(bordureTextfield);
        textDistance.setForeground(Color.white);
        textDistance.setFont(police);
        TextPrompt TpDistance = new TextPrompt("Distance (m)", textDistance); //Le textPrompt c'est pour ne mettre le texte que quand le jtextfield n'as pas le focus ou est vide
        TpDistance.setFont(police);
        TpDistance.setShow(TextPrompt.Show.ALWAYS);
        nouvelleMarche.add(textDistance, ctntMarche);

        ctntMarche.gridx = 0;
        ctntMarche.gridy = 1;
        textTemps.setOpaque(false);
        textTemps.setBorder(bordureTextfield);
        textTemps.setForeground(Color.white);
        textTemps.setFont(police);
        TextPrompt TpTemps = new TextPrompt("Durée (min)", textTemps); //Le textPrompt c'est pour ne mettre le texte que quand le jtextfield n'as pas le focus ou est vide
        TpTemps.setFont(police);
        TpTemps.setShow(TextPrompt.Show.ALWAYS);
        nouvelleMarche.add(textTemps, ctntMarche);


        ctntMarche.gridx = 0;
        ctntMarche.gridy = 2;
        textDate.setOpaque(false);
        textDate.setBorder(bordureTextfield);
        textDate.setForeground(Color.white);
        textDate.setFont(police);
        TextPrompt TpDate = new TextPrompt("Date (format dd/mm/yyyy)", textDate); //Le textPrompt c'est pour ne mettre le texte que quand le jtextfield n'as pas le focus ou est vide
        TpDate.setFont(police);
        TpDate.setShow(TextPrompt.Show.ALWAYS);
        nouvelleMarche.add(textDate, ctntMarche);


        ctntMarche.gridx = 0;
        ctntMarche.gridy = 3;
        JLabel enregistrer = new JLabel("Enregistrer");
        enregistrer.setForeground(Color.white);
        enregistrer.setFont(new Font("Arial", Font.BOLD, 16));
        panelEnregistrer.add(enregistrer);
        panelEnregistrer.setBackground(backgroundCentre);
        panelEnregistrer.addMouseListener(this);
        nouvelleMarche.add(panelEnregistrer, ctntMarche);
        //========================================

        conteneur.add(nouvelleMarche, BorderLayout.CENTER);

        panelHaut.setPreferredSize(new Dimension(100, 30));
        panelHaut.setBackground(backgroundCentre);
        JPanel panelRetour = new JPanel(new FlowLayout());
        panelRetour.setBackground(backgroundCentre);
        JLabel labelRetour = new JLabel("Retour");
        labelRetour.setFont(police);
        labelRetour.setForeground(Color.white);
        panelRetour.add(labelRetour);
        panelRetour.addMouseListener(new MouseListener() { //Mouse listener pour le bouton retour
            @Override
            public void mouseClicked(MouseEvent e) {
                cl.show(conteneurPanelCentre, "panelCentre");
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                panelRetour.setBackground(backgroundCentreClair);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                panelRetour.setBackground(backgroundCentre);
            }
        });
        panelHaut.add(panelRetour, BorderLayout.WEST);
        conteneur.add(panelHaut, BorderLayout.NORTH);

    }


    public JPanel getNouvelleMarche() {
        return conteneur;
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

    @Override
    public void mouseClicked(MouseEvent e) {
        int userDistance = Integer.parseInt(textDistance.getText());
        int userTemps = Integer.parseInt(textTemps.getText());
        String userDate = textDate.getText();
        Marche m1 = new Marche(userDistance, userTemps, userDate);
        ecrireMarche(m1);//J'écrit les infos de la marche dans le fichier
        cl.show(conteneurPanelCentre, "panelCentre"); //On repasse au panelCentre
        JOptionPane.showMessageDialog(null, "Nouvelle marche enregistrée !",
                "Programme de Marche", JOptionPane.INFORMATION_MESSAGE);//Je met le popup qui indique que la marche est enregistrée
        textDate.setText("");
        textTemps.setText("");
        textDistance.setText("");
        BorderLayout layout = (BorderLayout)panelReg.getLayout();

        panelReg.remove(layout.getLayoutComponent(BorderLayout.EAST));
        panelReg.add(new PanelDroiteReg(), BorderLayout.EAST);
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
        panelEnregistrer.setBackground(backgroundCentreClair);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        panelEnregistrer.setBackground(backgroundCentre);
    }
}
