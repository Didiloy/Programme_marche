package frame.frameReg.fonctions;

import frame.Personne;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class FonctionNouveauPoids implements ActionListener{
    JPanel nouveauPoids = new JPanel();
    JTextField textNouveauPoids = new JTextField(10);
    public FonctionNouveauPoids(){
        nouveauPoids.setBackground(Color.LIGHT_GRAY);
        nouveauPoids.setLayout(new GridBagLayout());
        GridBagConstraints ctntPoids = new GridBagConstraints();
        ctntPoids.insets = new Insets(10, 10, 10, 10);//padding des éléments du panel
        ctntPoids.gridx = 0;
        ctntPoids.gridwidth = 2;
        ctntPoids.gridy = 0;
        JLabel labelNouveauPoids = new JLabel("Veuillez entrer un nouveau poids:");
        nouveauPoids.add(labelNouveauPoids, ctntPoids);

        ctntPoids.gridx = 0;
        ctntPoids.gridwidth = 1;
        ctntPoids.gridy = 1;
        JLabel labelPoids = new JLabel("Poids");
        nouveauPoids.add(labelPoids, ctntPoids);

        ctntPoids.gridx = 1;
        ctntPoids.gridy = 1;
        nouveauPoids.add(textNouveauPoids, ctntPoids);

        ctntPoids.gridx = 1;
        ctntPoids.gridwidth =1;
        ctntPoids.gridy = 2;
        JButton boutonPoids = new JButton("Enregistrer");
        nouveauPoids.add(boutonPoids, ctntPoids);
        boutonPoids.addActionListener(this);
        //================================================
    }

    public JPanel getNouveauPoids() {
        return nouveauPoids;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
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
            bw.write(data[3] + ",");//On écrit
            bw.close(); //Je met l'ancien poids dans le fichier des anciens poids
            Personne p1 = new Personne(data[0], data[1], Integer.parseInt(data[2]), Integer.parseInt(textNouveauPoids.getText()));
            BufferedWriter bw1 = new BufferedWriter(new FileWriter("programme_papy/donnee/utilisateur.txt"));//On choisi le fichier dans lequel on écrit
            bw1.write(p1.toString());//On écrit
            bw1.close();
            JOptionPane.showMessageDialog(null, "Nouveau Poids enregistré !",
                    "Programme de Marche", JOptionPane.INFORMATION_MESSAGE);//Je met le popup qui indique que la marche est enregistrée

        }
        catch (IOException e)//Si il y a une erreur on la récupère.
        {
            //Print the error message
            System.out.print(e.getMessage());
        }
    }
}
