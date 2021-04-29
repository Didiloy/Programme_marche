package frame.frameReg.fonctions;

import java.io.*;

public class FonctionTotalTempsMarche {
    float somme = 0;
    public FonctionTotalTempsMarche() {
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

    public int getHeures() {
        return (int) (somme/60);
    }
    public int getMinutes(){
        return (int) (somme%60);
    }

//    ///TEST///////////:
//    public static void main(String[] args) {
//        FonctionTotalTempsMarche test = new FonctionTotalTempsMarche();
//        System.out.println("Le temps total marché est "+ test.getHeures()+ " heures "+ test.getMinutes()+" minutes");
//    }

}
