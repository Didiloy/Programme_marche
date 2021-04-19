package frame.frameReg.fonctions;

import javax.swing.*;
import java.io.*;

public class FonctionMoyennePoids {
    float somme = 0, nbElement = 0;
    public FonctionMoyennePoids() {
        File f = new File("programme_papy/donnee/ancienPoids.txt");
        if (f.isFile()) {
            String ligne[] = new String[1];
            try {
                InputStreamReader streamReader = new InputStreamReader(new FileInputStream(f));
                BufferedReader br = new BufferedReader(streamReader);
                String line = new String();
                while (br.ready()) {
                    line = br.readLine();
                    ligne = line.split(",");
                    somme += Integer.parseInt(ligne[0]);
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
}
