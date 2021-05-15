package graph;

import frame.frameReg.fonctions.DerniereLigneFichier;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.xy.DefaultXYDataset;
import org.jfree.data.xy.XYDataset;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Date;

public class GraphTempsDate {
    ChartPanel cp;
    public GraphTempsDate() {

        JFreeChart chart = ChartFactory.createLineChart(
                "Évolution du temps de marche",
                "Date","Temps marché",
                createDataset(),
                PlotOrientation.VERTICAL,
                true,true,false);
        cp = new ChartPanel(chart);
    }

    public DefaultCategoryDataset createDataset() {
        DefaultCategoryDataset ds = new DefaultCategoryDataset();
        File f = new File("programme_papy/donnee/marche.txt");
        Double[] tempsMarche = new Double[GetLigneMarche()];
        String [] tmp;
        String[] date = new String[GetLigneMarche()];
        if (f.isFile()) {
            InputStreamReader streamReader = null;
            try {
                ArrayList<String> no_repeat = new ArrayList<>();
                streamReader = new InputStreamReader(new FileInputStream(f));
                BufferedReader br = new BufferedReader(streamReader);
                String line;
                int i = 0;
                while (br.ready()) {
                    line = br.readLine();
                    tmp = line.split(",");
                    int j=1;
                    for(String nr : no_repeat){
                        if(nr.equals(tmp[2])){
                            j++;
                        }
                    }
                    no_repeat.add(tmp[2]);
                    if(j!=1)tmp[2]=tmp[2]+" - "+j;
                    tempsMarche[i] = Double.parseDouble(tmp[1]);
                    date[i] = tmp[2];
                    i += 1;
                }
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        for (int i = 0; i< GetLigneMarche(); i++){
            ds.addValue(tempsMarche[i], "Temps marché", date[i]); //J'ajoute les valeurs à utilisé dans la courbe
        }
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
