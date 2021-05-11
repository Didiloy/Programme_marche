package frame.frameUnreg;

import frame.frameReg.FrameReg;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import static frame.frameUnreg.FrameUnreg.frameUnreg;

public class PanelCentreUnreg implements ActionListener {
    JLabel nom = new JLabel("Entrez votre nom: ");
    JTextField textFieldNom = new JTextField(20);
    JLabel prenom = new JLabel("Entrez votre prénom: ");
    JTextField textFieldPrenom = new JTextField(20);
    JLabel age = new JLabel("Entrez votre age: ");
    JTextField textFieldAge = new JTextField(3);
    JLabel poids = new JLabel("Entrez votre poids: ");
    JTextField textFieldPoids = new JTextField(3);
    JButton button = new JButton("OK");
    JPanel panelCentre = new JPanel();
    FrameUnreg frame;

    public PanelCentreUnreg(FrameUnreg fr){
        this.frame = fr;
        panelCentre.setLayout(new GridBagLayout());
        GridBagConstraints constraint = new GridBagConstraints();
        constraint.insets = new Insets(10, 10, 10, 10);

        constraint.gridx = 0;
        constraint.gridy = 0;
        panelCentre.add(nom, constraint);

        constraint.gridx = 1;
        panelCentre.add(textFieldNom, constraint);

        constraint.gridx = 0;
        constraint.gridy = 1;
        panelCentre.add(prenom, constraint);

        constraint.gridx = 1;
        constraint.gridy = 1;
        panelCentre.add(textFieldPrenom, constraint);

        constraint.gridx = 0;
        constraint.gridy = 2;
        panelCentre.add(age, constraint);

        constraint.gridx = 1;
        constraint.gridy = 2;
        panelCentre.add(textFieldAge, constraint);

        constraint.gridx = 0;
        constraint.gridy = 3;
        panelCentre.add(poids, constraint);

        constraint.gridx = 1;
        panelCentre.add(textFieldPoids, constraint);

        constraint.gridx = 1;
        constraint.gridwidth = 2;
        constraint.gridy = 4;
        panelCentre.add(button, constraint);
        button.addActionListener(this);

        panelCentre.setBackground(Color.LIGHT_GRAY);
    }

    public JPanel fonctionPanelCentreUnreg(){
        return panelCentre;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String userNom = textFieldNom.getText();
        String userPrenom = textFieldPrenom.getText();
        int userAge = Integer.parseInt(textFieldAge.getText());
        int userPoids = Integer.parseInt(textFieldPoids.getText());
        frame.Personne p1 = new frame.Personne(userNom, userPrenom, userAge, userPoids);
        ecrireFichier(p1);
        frameUnreg.dispose();
        FrameReg frameReg = new FrameReg();
    }
    public void ecrireFichier(frame.Personne p1) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("programme_papy/donnee/utilisateur.txt"));//On choisi le fichier dans lequel on écrit
            bw.write(p1.toString());//On écrit
            bw.close();
            BufferedWriter bw2 = new BufferedWriter(new FileWriter("programme_papy/donnee/ancienPoids.txt"));//On choisi le fichier dans lequel on écrit
            bw2.write(p1.getPoids() +"\n");//On écrit
            bw2.close();
        }
        catch (IOException e)//Si il y a une erreur on la récupère.
        {
            System.out.print(e.getMessage());
        }
    }
}
