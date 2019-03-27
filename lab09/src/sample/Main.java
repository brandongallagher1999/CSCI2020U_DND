package sample;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

import java.io.*;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Map;

public class Main extends Application {

    public static AnchorPane pane = new AnchorPane();
    public static ArrayList<Float> data1 =  new ArrayList<>();
    public static ArrayList<Float> data2 =  new ArrayList<>();



    @Override
    public void start(Stage primaryStage) throws Exception{


        //Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Aron Sethryl Cohen is a bastard");
        primaryStage.setScene(new Scene(pane, 1280, 720));
        primaryStage.show();
    }


    private static String getKey(String stockSymbol, String key)
    {
        return "https://www.alphavantage.co/query?function=TIME_SERIES_MONTHLY&symbol="
                + stockSymbol + "&apikey=" + key;
    }

    public static String readAll(Reader reader) throws IOException
    {
        StringBuilder sb = new StringBuilder();
        int cp;
        while ((cp = reader.read()) != -1){
            sb.append((char) cp);
        }
        return sb.toString();

    }

    public static JsonObject readJsonFromURL(String url) throws IOException
    {

        InputStream is = new URL(url).openStream();

        try{
            BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
            String jsonText = readAll(rd);
            JsonParser parser = new JsonParser();
            JsonObject json = parser.parse(jsonText).getAsJsonObject();
            is.close();
            return json;
        }catch(Exception e)
        {
            is.close();
            e.printStackTrace();
        }
        return null;
    }

    public static void drawLine()
    {
        int j = 0;
        for(int i = data1.size()-1; i > 1; i--){
            Line line = new Line();
            line.setStroke(Color.BLUE);
            line.setStartX(j);
            line.setStartY(data1.get(i));
            j += 4;
            line.setEndX(j);
            line.setEndY(data1.get(i-1));
            pane.getChildren().add(line);

        }
        int k = 0;
        for(int i = data2.size()-1; i > 1; i--){
            Line line = new Line();
            line.setStroke(Color.RED);
            line.setStartX(k);
            line.setStartY(data2.get(i));
            k += 4;
            line.setEndX(k);
            line.setEndY(data2.get(i-1));
            pane.getChildren().add(line);

        }


    }

    //public int intersect()

    public static void main(String[] args) throws Exception {

        JsonObject json1 = readJsonFromURL(getKey("AAPL", "IISNDZRDIAHCUV5P"));
        System.out.println(json1);
        JsonObject values1 = json1.get("Monthly Time Series").getAsJsonObject();

        JsonObject json2 = readJsonFromURL(getKey("GOOGL", "IISNDZRDIAHCUV5P"));
        System.out.println(json2);
        JsonObject values2 = json2.get("Monthly Time Series").getAsJsonObject();

        for (Map.Entry<String, JsonElement> entry : values1.entrySet()) {
            String date = entry.getKey();
            Float value = entry.getValue().getAsJsonObject().get("4. close").getAsFloat();
            data1.add(value / 1.5f);
            System.out.println(data1.size());
            System.out.printf("%s: $%.2f\r\n", date, value);
        }

        for (Map.Entry<String, JsonElement> entry : values2.entrySet()) {
            String date = entry.getKey();
            Float value = entry.getValue().getAsJsonObject().get("4. close").getAsFloat();
            data2.add(value / 1.5f);
            System.out.println(data2.size());
            System.out.printf("%s: $%.2f\r\n", date, value);
        }

        drawLine();
        launch(args);

    }
}
