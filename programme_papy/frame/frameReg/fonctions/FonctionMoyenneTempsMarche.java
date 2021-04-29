package frame.frameReg.fonctions;

import javax.swing.*;
import java.awt.*;
import java.io.*;

public class FonctionMoyenneTempsMarche {
    float nbElement = 0, somme = 0;
    public FonctionMoyenneTempsMarche() throws IOException {
        File f = new File("programme_papy/donnee/marche.txt");
        if (f.isFile()) {
            String ligne[] = new String[3];
            try {
                InputStreamReader streamReader = new InputStreamReader(new FileInputStream(f));
                BufferedReader br = new BufferedReader(streamReader);
                String line = new String();
                while (br.ready()) {
                    line = br.readLine();
                    ligne = line.split(",");
                    somme += Integer.parseInt(ligne[1]);
                    nbElement++;
                }
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }

        } else {
            somme = -1;
            nbElement = 1;
        }
    }

    public float getMoyenne() {
        return somme/nbElement;
    }

    public int getHeure(){return (int) ((somme/nbElement)/60);}

    public int getMinute(){return (int) ((somme/nbElement)%60);}

    ///////TEST////////////////
//    public static void main(String[] args) throws IOException {
//        FonctionMoyenneTempsMarche test = new FonctionMoyenneTempsMarche();
//        System.out.println("Vous marchez en moyenne " + test.getMoyenne()+ " minutes");
//        FonctionMoyennePoids testPoids = new FonctionMoyennePoids();
//        System.out.println("Votre poids moyen est " + testPoids.getMoyenne()+ " Kilos");
//    }
}
