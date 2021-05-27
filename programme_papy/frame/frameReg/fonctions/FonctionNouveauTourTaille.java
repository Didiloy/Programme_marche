package frame.frameReg.fonctions;

import frame.TextPrompt;
import frame.frameReg.PanelDroiteReg;

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
import java.time.LocalDate;

import static frame.frameReg.FrameReg.frameReg;
import static frame.frameReg.FrameReg.panelReg;
import static frame.frameReg.PanelCentreReg.cl;
import static frame.frameReg.PanelCentreReg.conteneurPanelCentre;

public class FonctionNouveauTourTaille implements MouseListener {
    JPanel conteneur = new JPanel( new BorderLayout());
    JPanel panelHaut = new JPanel( new BorderLayout());
    JPanel nouveauTourTaille = new JPanel();
    JTextField textNouveauTourTaille = new JTextField(20);
    Color backgroundCentre = new Color(54, 57, 63);
    Color backgroundCentreClair = new Color(77, 81, 89);
    MatteBorder bordureTextfield = new MatteBorder(0,0,2,0, Color.white);
    Font police = new Font("Arial", Font.BOLD, 14);
    JPanel panelEnregistrer = new JPanel(new FlowLayout());
    public FonctionNouveauTourTaille(){
        nouveauTourTaille.setBackground(backgroundCentre);
        nouveauTourTaille.setLayout(new GridBagLayout());
        GridBagConstraints ctntTourTaille = new GridBagConstraints();
        ctntTourTaille.insets = new Insets(10, 10, 10, 10);//padding des éléments du panel
        ctntTourTaille.gridx = 0;
        ctntTourTaille.gridy = 0;
        textNouveauTourTaille.setOpaque(false);
        textNouveauTourTaille.setBorder(bordureTextfield);
        textNouveauTourTaille.setForeground(Color.white);
        textNouveauTourTaille.setFont(police);
        TextPrompt TpDate = new TextPrompt("Tour de taille (cm)", textNouveauTourTaille); //Le textPrompt c'est pour ne mettre le texte que quand le jtextfield n'as pas le focus ou est vide
        TpDate.setFont(police);
        TpDate.setShow(TextPrompt.Show.ALWAYS);
        nouveauTourTaille.add(textNouveauTourTaille, ctntTourTaille);

        ctntTourTaille.gridx = 0;
        ctntTourTaille.gridy = 1;
        panelEnregistrer.setBackground(backgroundCentre);
        JLabel enregistrer = new JLabel("Enregistrer");
        enregistrer.setForeground(Color.white);
        enregistrer.setFont(new Font("Arial", Font.BOLD, 16));
        panelEnregistrer.add(enregistrer);
        nouveauTourTaille.add(panelEnregistrer, ctntTourTaille);
        panelEnregistrer.addMouseListener(this);

        conteneur.add(nouveauTourTaille, BorderLayout.CENTER);

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

    public JPanel getNouveauTourTaille() {
        return conteneur;
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

    @Override
    public void mouseClicked(MouseEvent e) {
        int userTourTaille = Integer.parseInt(textNouveauTourTaille.getText());
        ecrireTourTaille(userTourTaille);
        cl.show(conteneurPanelCentre, "panelCentre"); //On repasse au panelCentre
        JOptionPane.showMessageDialog(null, "Nouveau tour de taille enregistré !",
                "Programme de Marche", JOptionPane.INFORMATION_MESSAGE);//Je met le popup qui indique que la marche est enregistrée
        textNouveauTourTaille.setText("");
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
