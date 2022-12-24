import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.block.BlockBorder;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RectangleInsets;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

import static org.jfree.chart.block.BlockBorder.*;

class Graphics  {
    private static  CategoryDataset createDataset(ArrayList<Manager> managers) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        managers.forEach(x->dataset.addValue(x.getSubordinates().size(), x.name+x.surname, "Managers"));
        return dataset;
    }
    private static  JFreeChart createChart(CategoryDataset dataset)
    {
        JFreeChart chart = ChartFactory.createBarChart(
                "Распределение работников по менеджерам",
                null,                   // x-axis label
                "Кол-во",                // y-axis label
                dataset);
        chart.setBackgroundPaint(Color.white);

        CategoryPlot plot = (CategoryPlot) chart.getPlot();

        NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
        rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
        BarRenderer renderer = (BarRenderer) plot.getRenderer();
        renderer.setDrawBarOutline(false);
        chart.getLegend().setFrame(NONE);

        return chart;
    }
    public static JPanel createDemoPanel(ArrayList<Manager> managers)
    {
        JFreeChart chart = createChart(createDataset(managers));
        chart.setPadding(new RectangleInsets(4, 8, 2, 2));
        ChartPanel panel = new ChartPanel(chart);
        panel.setFillZoomRectangle(true);
        panel.setMouseWheelEnabled(true);
        panel.setPreferredSize(new Dimension(600, 300));
        return panel;
    }
    public static void Show(JPanel panel){
        JFrame jFrame = new JFrame();
        jFrame.add(panel);
        jFrame.setSize(1280, 1024);
        jFrame.setVisible(true);
    }
}