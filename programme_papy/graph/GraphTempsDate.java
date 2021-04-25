package graph;

import frame.frameReg.fonctions.DerniereLigneFichier;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.DefaultXYDataset;
import org.jfree.data.xy.XYDataset;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;

public class GraphTempsDate {
    ChartPanel cp;
    public GraphTempsDate() {
        JFreeChart chart =
                ChartFactory.createXYLineChart("Temps Marché",
                        "Date", "Temps Marché", createDataset(), PlotOrientation.VERTICAL, true, true,
                        false);
        cp = new ChartPanel(chart);
    }
    private XYDataset createDataset() {

        DefaultXYDataset ds = new DefaultXYDataset();
        File f = new File("programme_papy/donnee/marche.txt");
        Double[] tempsMarche = new Double[GetLigneMarche()];
        String[] Date = new String[GetLigneMarche()];
        String [] tmp;
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
                    tempsMarche[i] = Double.parseDouble(tmp[1]);
                    Date[i] = tmp[2];
                    i += 1;
                }
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //LA j'ai rempli tempsMarché avec le temps en format double et Date avec la date en format String.
        //Faut trouver un moyen de mettre ça dans le DefaultXYDataset.
        //https://www.jfree.org/jfreechart/javadoc/org/jfree/data/xy/DefaultXYDataset.html#addSeries(java.lang.Comparable,double%5B%5D%5B%5D)



        return ds;
    }
    public ChartPanel getCharPanel(){
        return cp;
    }

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
}
