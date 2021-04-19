package frame.frameReg.fonctions;

import java.io.*;

public class DerniereLigneFichier {
    public DerniereLigneFichier(){

    }
    public String derniereLigne(String chemin){
        try {
            File file = new File(chemin);
            InputStreamReader streamReader = new InputStreamReader(new FileInputStream(file));
            BufferedReader br = new BufferedReader(streamReader);
            String line = new String();
            while (br.ready()) {
                line = br.readLine();
            }
            br.close();
            return line;
        }
        catch (IOException e)//Si il y a une erreur on la récupère.
        {
            //Print the error message
            System.out.print(e.getMessage());
            return null;
        }
    }
}
