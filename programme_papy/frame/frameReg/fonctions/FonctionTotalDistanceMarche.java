package frame.frameReg.fonctions;

import java.io.*;

public class FonctionTotalDistanceMarche {
    float somme = 0;
    public FonctionTotalDistanceMarche() {
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
                    somme += Integer.parseInt(ligne[0]);
                }
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }

        } else {
            somme = -1;
        }
    }

    public float getSomme() {
        return somme/1000;
    }

    ///TEST///////////:
//    public static void main(String[] args) {
//        FonctionTotalDistanceMarche test = new FonctionTotalDistanceMarche();
//        System.out.println("La distance totale marchée est "+ test.getSomme()+ " kilomètres");
//    }
}
