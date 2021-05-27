package frame.frameReg.fonctions;

import frame.Personne;
import frame.TextPrompt;
import frame.frameReg.PanelDroiteReg;

import javax.swing.*;
import javax.swing.border.MatteBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.*;
import java.time.LocalDate;

import static frame.frameReg.FrameReg.frameReg;
import static frame.frameReg.FrameReg.panelReg;
import static frame.frameReg.PanelCentreReg.cl;
import static frame.frameReg.PanelCentreReg.conteneurPanelCentre;

public class FonctionNouveauPoids implements MouseListener {
    JPanel conteneur = new JPanel( new BorderLayout());
    JPanel panelHaut = new JPanel( new BorderLayout());
    JPanel nouveauPoids = new JPanel();
    JTextField textNouveauPoids = new JTextField(10);
    Color backgroundCentre = new Color(54, 57, 63);
    Color backgroundCentreClair = new Color(77, 81, 89);
    MatteBorder bordureTextfield = new MatteBorder(0,0,2,0, Color.white);
    Font police = new Font("Arial", Font.BOLD, 14);
    JPanel panelEnregistrer = new JPanel(new FlowLayout());
    public FonctionNouveauPoids(){
        nouveauPoids.setBackground(backgroundCentre);
        nouveauPoids.setLayout(new GridBagLayout());
        GridBagConstraints ctntPoids = new GridBagConstraints();
        ctntPoids.insets = new Insets(10, 10, 10, 10);//padding des éléments du panel
        ctntPoids.gridx = 0;
        ctntPoids.gridy = 0;
        textNouveauPoids.setOpaque(false);
        textNouveauPoids.setBorder(bordureTextfield);
        textNouveauPoids.setForeground(Color.white);
        textNouveauPoids.setFont(police);
        TextPrompt TpDate = new TextPrompt("Poids", textNouveauPoids); //Le textPrompt c'est pour ne mettre le texte que quand le jtextfield n'as pas le focus ou est vide
        TpDate.setFont(police);
        TpDate.setShow(TextPrompt.Show.ALWAYS);
        nouveauPoids.add(textNouveauPoids, ctntPoids);

        ctntPoids.gridx = 0;
        ctntPoids.gridy = 1;
        panelEnregistrer.setBackground(backgroundCentre);
        JLabel enregistrer = new JLabel("Enregistrer");
        enregistrer.setForeground(Color.white);
        enregistrer.setFont(new Font("Arial", Font.BOLD, 16));
        panelEnregistrer.add(enregistrer);
        nouveauPoids.add(panelEnregistrer, ctntPoids);
        panelEnregistrer.addMouseListener(this);
        //================================================

        conteneur.add(nouveauPoids, BorderLayout.CENTER);

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

    public JPanel getNouveauPoids() {
        return conteneur;
    }

    @Override
    public void mouseClicked(MouseEvent ev) {
        try {//Le true du filewriter c'est pour ouvrir le fichier en mode append
            BufferedReader br = new BufferedReader(new FileReader("programme_papy/donnee/utilisateur.txt"));
            String s="";
            String data[] = new String[4];
            while((s=br.readLine())!=null) {
                data = s.split(",");
//					System.out.println(data[3]);
            }
//				System.out.println(data[3]);
            br.close();//Avec le buffered reader j'obtiens l'ancien poids
            BufferedWriter bw = new BufferedWriter(new FileWriter("programme_papy/donnee/ancienPoids.txt", true));//On choisi le fichier dans lequel on écrit
            LocalDate date = null;
            bw.write(textNouveauPoids.getText() + "," + date.now() + "\n");//On écrit
            bw.close(); //Je met l'ancien poids dans le fichier des anciens poids
            Personne p1 = new Personne(data[0], data[1], Integer.parseInt(data[2]), Integer.parseInt(textNouveauPoids.getText()));
            BufferedWriter bw1 = new BufferedWriter(new FileWriter("programme_papy/donnee/utilisateur.txt"));//On choisi le fichier dans lequel on écrit
            bw1.write(p1.toString());//On écrit
            bw1.close();
            cl.show(conteneurPanelCentre, "panelCentre"); //On repasse au panelCentre
            JOptionPane.showMessageDialog(null, "Nouveau Poids enregistré !",
                    "Programme de Marche", JOptionPane.INFORMATION_MESSAGE);//Je met le popup qui indique que la marche est enregistrée

            textNouveauPoids.setText("");
            BorderLayout layout = (BorderLayout)panelReg.getLayout();
            panelReg.remove(layout.getLayoutComponent(BorderLayout.EAST));
            panelReg.add(new PanelDroiteReg(), BorderLayout.EAST);
            panelReg.updateUI();
            SwingUtilities.updateComponentTreeUI(frameReg);

        }
        catch (IOException e)//Si il y a une erreur on la récupère.
        {
            //Print the error message
            System.out.print(e.getMessage());
        }
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
