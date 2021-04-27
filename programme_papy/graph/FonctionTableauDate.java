package graph;

import java.io.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FonctionTableauDate {
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    Date tableauDate[] = new Date[GetLigneMarche()];
    String[] DateString = new String[GetLigneMarche()];
    public FonctionTableauDate(){
        File f = new File("programme_papy/donnee/marche.txt");
        String tmp[];
        if (f.isFile()) {
            InputStreamReader streamReader = null;
            try {
                streamReader = new InputStreamReader(new FileInputStream(f));
                BufferedReader br = new BufferedReader(streamReader);
                String line;
                int i = 0;
                while (br.ready()) {
                    line = br.readLine();
                    tmp = line.split(",");
                    DateString[i] = tmp[2];
                    i += 1;
                }
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        for (int i = 0; i < GetLigneMarche(); i++){
            try {
                tableauDate[i] = sdf.parse(DateString[i]);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
    }

//    public Date[] getTableauDate{
//        return tableauDate;
//    }

    public int GetLigneMarche(){
        try {
            int i = 0;
            File file = new File("programme_papy/donnee/marche.txt");
            InputStreamReader streamReader = new InputStreamReader(new FileInputStream(file));
            BufferedReader br = new BufferedReader(streamReader);
            String line = new String();
            while (br.ready()) {
                line = br.readLine();
                i += 1;
            }
            br.close();
            return i;
        }
        catch (IOException e)//Si il y a une erreur on la récupère.
        {
            //Print the error message
            System.out.print(e.getMessage());
            return 0;
        }
    }

//    public static void main(String[] args) {
//        FonctionTableauDate date = new FonctionTableauDate();
//        for (int i = 0; i < date.GetLigneMarche(); i++) {
//            System.out.println(date.DateString[i]);
//            System.out.println(date.tableauDate[i]);
//        }
//    }
}
