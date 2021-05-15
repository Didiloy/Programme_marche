package graph;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import java.io.*;
import java.util.ArrayList;

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
                        if(nr.equals(tmp[1])){
                            j++;
                        }
                    }
                    no_repeat.add(tmp[1]);
                    if(j!=1)tmp[1]=tmp[1]+" - "+j;
                    tourTaille[i] = Integer.parseInt(tmp[0]);
                    ds.addValue(tourTaille[i], "Tour de taille", ""+tmp[1]); //J'ajoute les valeurs à utilisé dans la courbe
                    i += 1;
                }
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
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
