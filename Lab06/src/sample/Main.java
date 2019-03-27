package sample;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.chart.PieChart;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Drawing Operations Test");
        Group root = new Group();
        Canvas canvas = new Canvas(1280, 720);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        //Part 1
        /*
        double[] avgHousingPricesByYear = {
                247381.0, 264171.4, 287715.3, 294736.1,
                308431.4, 322635.9, 340253.0, 363153.7
        };
        double highest = 0;
        for (int i = 0; i < avgHousingPricesByYear.length; i++) {
            if (avgHousingPricesByYear[i] > highest) {
                highest = avgHousingPricesByYear[i];
            }
        }
        double highest2 = 0;
        double[] avgCommercialPricesByYear = {
                1121585.3, 1219479.5, 1246354.2, 1295364.8,
                1335932.6, 1472362.0, 1583521.9, 1613246.3
        };

        for (int i = 0; i < avgCommercialPricesByYear.length; i++) {
            if (avgCommercialPricesByYear[i] > highest2) {
                highest2 = avgCommercialPricesByYear[i];
            }
        }
        String[] ageGroups = {
                "18-25", "26-35", "36-45", "46-55", "56-65", "65+"
        };
        int[] purchasesByAgeGroup = {
                648, 1021, 2453, 3173, 1868, 2247
        };
        Color[] pieColours = {
                Color.AQUA, Color.GOLD, Color.DARKORANGE,
                Color.DARKSALMON, Color.LAWNGREEN, Color.PLUM
        };

        ObservableList<PieChart.Data> pcData =
                FXCollections.observableArrayList(
                        new PieChart.Data(ageGroups[0], purchasesByAgeGroup[0]),
                        new PieChart.Data(ageGroups[1], purchasesByAgeGroup[1]),
                        new PieChart.Data(ageGroups[2], purchasesByAgeGroup[2]),
                        new PieChart.Data(ageGroups[3], purchasesByAgeGroup[3]),
                        new PieChart.Data(ageGroups[4], purchasesByAgeGroup[4]),
                        new PieChart.Data(ageGroups[5], purchasesByAgeGroup[5])
                );
        PieChart chart = new PieChart(pcData);
        chart.setLayoutX(500);
        chart.setLayoutY(200);

        int c = 0;
        for (PieChart.Data data : pcData) {
            data.getNode().setStyle(
                    "-fx-pie-color: " + pieColours[c] + ";"
            );
            c++;
        }


        BarChart2 barChart = new BarChart2(highest);
        BarChart2 barChart2 = new BarChart2(highest2);

        for (int i = 0; i < avgHousingPricesByYear.length; i++) {
            Bar bar = new Bar(avgHousingPricesByYear[i], Color.BLUE);
            barChart.add(bar);

        }

        for (int i = 0; i < avgHousingPricesByYear.length; i++) {
            Bar bar = new Bar(avgCommercialPricesByYear[i], Color.RED);
            barChart2.add(bar);

        }

        barChart.draw(gc, 50);
        barChart2.draw(gc, 60);

        chart.setTitle("");
        root.getChildren().addAll(canvas, chart);
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
        */

        //part 2

        csvreader reader = new csvreader();
        reader.setValues();

        ObservableList<PieChart.Data> pcData =
                FXCollections.observableArrayList(
                        new PieChart.Data("Flash Flood", reader.getFlashFlood()),
                        new PieChart.Data("Severe Thunderstorm", reader.getSevere_thunderstorm()),
                        new PieChart.Data("Special Marine", reader.getSpecial_marine()),
                        new PieChart.Data("Tornado", reader.getTornado())
                );
        PieChart chart = new PieChart(pcData);
        chart.setLayoutX(500);
        chart.setLayoutY(200);


        root.getChildren().addAll(canvas, chart);
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }
}
