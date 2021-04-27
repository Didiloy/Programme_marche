package graph;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.DefaultXYDataset;
import org.jfree.data.xy.XYDataset;

import javax.swing.*;
import java.awt.*;

public class graphExemple extends JFrame {
    ChartPanel cp;
    public graphExemple() {
        JFreeChart chart =
                ChartFactory.createXYLineChart("Test Chart",
                        "x", "y", createDataset(), PlotOrientation.VERTICAL, true, true,
                        false);
         cp = new ChartPanel(chart);
    }
        private XYDataset createDataset() {

            DefaultXYDataset ds = new DefaultXYDataset();

            double[][] data = { {0.1, 0.2, 0.3}, {1, 2, 3} };
            double[][] data2 = { {0.5, 0.6, 0.7}, {2, 2, 3} };

            ds.addSeries("series1", data);
            ds.addSeries("series2", data2);

            return ds;
        }
        public ChartPanel getCharPanel(){
            return cp;
        }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setTitle("Programme de marche");
        frame.setSize(1200, 700);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.getContentPane().setBackground(Color.LIGHT_GRAY);
        frame.setLayout(new BorderLayout());
        graphExemple graph = new graphExemple();
        GraphTempsDate graphTempsDate = new GraphTempsDate();
//        frame.add(graph.getCharPanel(), BorderLayout.CENTER);
        frame.add(graphTempsDate.getCharPanel(), BorderLayout.CENTER); // je test le  graph fait dans GraphTempsDate

        frame.setVisible(true);
    }
}
