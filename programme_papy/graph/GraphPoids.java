package graph;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class GraphPoids {
    ChartPanel cp;
    public GraphPoids() {

        JFreeChart chart = ChartFactory.createLineChart(
                "Évolution du poids",
                "poids enregistré numéro:","Poids",
                createDataset(),
                PlotOrientation.VERTICAL,
                true,true,false);
        cp = new ChartPanel(chart);
    }

    public DefaultCategoryDataset createDataset() { //créer le dataset
        DefaultCategoryDataset ds = new DefaultCategoryDataset();
        File f = new File("programme_papy/donnee/ancienPoids.txt");
        int[] poids = new int[GetLignePoids()];
        String [] ligne;
        if (f.isFile()) {
            InputStreamReader streamReader = null;
            try {
                streamReader = new InputStreamReader(new FileInputStream(f));
                BufferedReader br = new BufferedReader(streamReader);
                String line;
                int i = 0;
                while (br.ready()) {
                    line = br.readLine();
                    ligne = line.split(",");
                    poids[i] = Integer.parseInt(ligne[0]);
                    System.out.println(ligne[1]);
                    ds.addValue(poids[i], "Distance marché", ""+ligne[1]); //J'ajoute les valeurs au dataset
                    i += 1;
                }
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return ds;
    }

    public int GetLignePoids(){
        try {
            int i = 0;
            File file = new File("programme_papy/donnee/ancienPoids.txt");
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
    public ChartPanel getCharPanel(){
        return cp;
    }


}
