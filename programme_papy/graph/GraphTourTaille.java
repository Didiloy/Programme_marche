package graph;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import java.io.*;

public class GraphTourTaille {
    ChartPanel cp;
    public GraphTourTaille() {

        JFreeChart chart = ChartFactory.createLineChart(
                "Évolution du tour de taille",
                "tour de taille enregistré numéro:","Tour de taille",
                createDataset(),
                PlotOrientation.VERTICAL,
                true,true,false);
        cp = new ChartPanel(chart);
    }

    public DefaultCategoryDataset createDataset() {
        DefaultCategoryDataset ds = new DefaultCategoryDataset();
        File f = new File("programme_papy/donnee/tourTaille.txt");
        int[] tourTaille = new int[GetLigneTourTaille()];
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
                    tmp = line.split("\n");
                    tourTaille[i] = Integer.parseInt(tmp[0]);
                    i += 1;
                }
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        for (int i = 0; i< GetLigneTourTaille(); i++){
            ds.addValue(tourTaille[i], "Distance marché", ""+i); //J'ajoute les valeurs à utilisé dans la courbe
        }
        return ds;
    }

    public int GetLigneTourTaille(){
        try {
            int i = 0;
            File file = new File("programme_papy/donnee/tourTaille.txt");
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
