package frame.frameUnreg;

import frame.TextPrompt;
import frame.frameReg.FrameReg;
import javax.swing.*;
import javax.swing.border.MatteBorder;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;

import static frame.frameUnreg.FrameUnreg.frameUnreg;

public class PanelGaucheUnreg implements MouseListener {
    JTextField textFieldNom = new JTextField(20);
    JTextField textFieldPrenom = new JTextField(20);
    JTextField textFieldAge = new JTextField(5);
    JTextField textFieldPoids = new JTextField(5);
    JPanel panelCentre = new JPanel();
    FrameUnreg frame;
    Color CouleurBleu = new Color(83, 122, 204);
    Color CouleurBleuClair = new Color(133, 156, 227);
    MatteBorder bordureTextfield = new MatteBorder(0,0,2,0, Color.white);
    Font police = new Font("Arial", Font.BOLD, 14);
    JLabel enregistrer = new JLabel("Enregistrer");
    JPanel panelEnregistrer = new JPanel(new FlowLayout());

    JPanel panelGauche = new JPanel(new BorderLayout());
    JPanel panelHaut = new JPanel();


    public PanelGaucheUnreg(FrameUnreg fr){
        this.frame = fr;
        //=====Panel Centre============================
        panelCentre.setLayout(new GridBagLayout());
        GridBagConstraints constraint = new GridBagConstraints();
        constraint.insets = new Insets(10, 10, 10, 10);

        constraint.gridx = 0;
        constraint.gridy = 0;
        textFieldNom.setOpaque(false);
        textFieldNom.setBorder(bordureTextfield);
        textFieldNom.setForeground(Color.white);
        textFieldNom.setFont(police);
        TextPrompt TpNom = new TextPrompt("Nom", textFieldNom); //Le textPrompt c'est pour ne mettre le texte que quand le jtextfield n'as pas le focus ou est vide
        TpNom.setFont(police);
        TpNom.setShow(TextPrompt.Show.ALWAYS);
        panelCentre.add(textFieldNom, constraint);

        constraint.gridx = 0;
        constraint.gridy = 1;
        textFieldPrenom.setOpaque(false);
        textFieldPrenom.setBorder(bordureTextfield);
        textFieldPrenom.setForeground(Color.white);
        textFieldPrenom.setFont(police);
        TextPrompt TpPrenom = new TextPrompt("Prénom", textFieldPrenom);
        TpPrenom.setFont(police);
        TpPrenom.setShow(TextPrompt.Show.ALWAYS);
        panelCentre.add(textFieldPrenom, constraint);

        constraint.gridx = 0;
        constraint.gridy = 2;
        textFieldAge.setOpaque(false);
        textFieldAge.setBorder(bordureTextfield);
        textFieldAge.setForeground(Color.white);
        textFieldAge.setFont(police);
        TextPrompt TpAge = new TextPrompt("    Age", textFieldAge);
        TpAge.setFont(police);
        TpAge.setShow(TextPrompt.Show.ALWAYS);
        panelCentre.add(textFieldAge, constraint);

        constraint.gridx = 0;
        constraint.gridy = 4;
        textFieldPoids.setOpaque(false);
        textFieldPoids.setBorder(bordureTextfield);
        textFieldPoids.setForeground(Color.white);
        textFieldPoids.setFont(police);
        TextPrompt TpPoids = new TextPrompt("   Poids", textFieldPoids);
        TpPoids.setFont(police);
        TpPoids.setShow(TextPrompt.Show.ALWAYS);
        panelCentre.add(textFieldPoids, constraint);

        constraint.gridx = 0;
        constraint.gridy = 5;

        enregistrer.setForeground(Color.white);
        enregistrer.setFont(new Font("Arial", Font.BOLD, 16));
        panelEnregistrer.setBackground(CouleurBleu);
        panelEnregistrer.add(enregistrer);
        panelEnregistrer.addMouseListener(this);
        panelCentre.add(panelEnregistrer, constraint);

        panelCentre.setBackground(CouleurBleu);
        panelGauche.add(panelCentre, BorderLayout.CENTER);
        //========================================================
        //=======Panel du Haut======================
        panelHaut.setLayout(new BorderLayout());
        panelHaut.setPreferredSize(new Dimension(300, 250));
        panelHaut.setBackground(CouleurBleu);

        //J'ajoute l'image tout en haut du panel pour s'enregistrer
        JLabel LabelImage = new JLabel();
        Image iconePersonne = new ImageIcon("programme_papy/image/iconePersonne.png").getImage();
        ImageIcon img2 = new ImageIcon(new ImageIcon(iconePersonne).getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH));
        LabelImage.setIcon(img2);
        JPanel panelHautCentre = new JPanel(new FlowLayout());
        panelHautCentre.setBackground(CouleurBleu);
        panelHautCentre.add(LabelImage);
        panelHaut.add(panelHautCentre, BorderLayout.CENTER);
        //////////////////////////////////////////////////////////

        //J'ajoute le label "enregistrement
        JLabel labelEnregistrer = new JLabel("Enregistrement");
        labelEnregistrer.setFont(new Font("Arial", Font.ITALIC, 24));
        labelEnregistrer.setForeground(Color.white);
        JPanel panelHautBas = new JPanel(new FlowLayout());
        panelHautBas.setBackground(CouleurBleu);
        panelHautBas.add(labelEnregistrer);
        panelHaut.add(panelHautBas, BorderLayout.SOUTH);
        //////////////////////////////////////////////////////////

        //J'ajoute un peu d'espace en haut
        JPanel panelHautHaut = new JPanel(new FlowLayout());
        panelHautHaut.setPreferredSize(new Dimension(100, 50));
        panelHautHaut.setBackground(CouleurBleu);
        panelHaut.add(panelHautHaut, BorderLayout.NORTH);
        //////////////////////////////////////
        panelGauche.add(panelHaut, BorderLayout.NORTH);
        //=========================================================

        //========Panel du bas======================
        JPanel panelSud = new JPanel(new FlowLayout());
        panelSud.setBackground(CouleurBleu);
        panelSud.setPreferredSize(new Dimension(100, 100));
        panelGauche.add(panelSud, BorderLayout.SOUTH);
        //==========================================
    }

    public JPanel fonctionPanelGaucheUnreg(){
        return panelGauche;
    }


    public void ecrireFichier(frame.Personne p1) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("programme_papy/donnee/utilisateur.txt"));//On choisi le fichier dans lequel on écrit
            bw.write(p1.toString());//On écrit
            bw.close();
            LocalDate date = null;
            BufferedWriter bw2 = new BufferedWriter(new FileWriter("programme_papy/donnee/ancienPoids.txt"));//On choisi le fichier dans lequel on écrit
            bw2.write(p1.getPoids() +"," + date.now() + "\n");//On écrit
            bw2.close();
        }
        catch (IOException e)//Si il y a une erreur on la récupère.
        {
            System.out.print(e.getMessage());
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        String userNom = textFieldNom.getText();
        String userPrenom = textFieldPrenom.getText();
        int userAge = Integer.parseInt(textFieldAge.getText());
        int userPoids = Integer.parseInt(textFieldPoids.getText());
        frame.Personne p1 = new frame.Personne(userNom, userPrenom, userAge, userPoids);
        ecrireFichier(p1);
        frameUnreg.dispose();
        FrameReg frameReg = new FrameReg();
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        panelEnregistrer.setBackground(CouleurBleuClair);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        panelEnregistrer.setBackground(CouleurBleu);
    }
}
