package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

import java.util.Random;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        primaryStage.setTitle("Hello World");


        /* Part 1
        Image[] images = new Image[2];
        images[0] = new Image("sample/x.gif");
        images[1] = new Image("sample/o.gif");
        GridPane grid = new GridPane();




        Random rnd = new Random();
        rnd.setSeed(System.currentTimeMillis());

        for(int i = 0; i < 3; i++){
            for( int j = 0; j < 3; j++){
                grid.add(new ImageView(images[rnd.nextInt(2)]),i,j);
            }
        }

        Scene scene = new Scene(grid, 1280, 720);
        primaryStage.setScene(scene);
        primaryStage.show();*/


        // Part 2
        /*
        AnchorPane anchorPane = new AnchorPane();
        Line line = new Line();
        line.setStartX(100);
        line.setStartY(500);
        line.setEndX(100);
        line.setEndY(150);

        Line line2 = new Line();
        line2.setStartX(100);
        line2.setStartY(150);
        line2.setEndX(400);
        line2.setEndY(150);

        Line line3 = new Line();
        line3.setStartX(400);
        line3.setEndX(400);
        line3.setStartY(150);
        line3.setEndY(200);


        Circle head = new Circle();
        head.setCenterX(400);
        head.setCenterY(250);
        head.setRadius(50);

        Line line4 = new Line();
        line4.setStartX(400);
        line4.setStartY(250);
        line4.setEndY(400);
        line4.setEndX(400);


        Line leg1 = new Line();
        leg1.setStartX(385);
        leg1.setEndX(335);
        leg1.setStartY(400);
        leg1.setEndY(500);
        leg1.setRotate(15);

        Line leg2 = new Line();
        leg2.setStartX(385);
        leg2.setEndX(435);
        leg2.setStartY(400);
        leg2.setEndY(500);


        anchorPane.getChildren().addAll(line,line2, head, line3, line4, leg1,leg2);





        Scene scene = new Scene(anchorPane, 1280, 720);
        primaryStage.setScene(scene);
        primaryStage.show();*/

        //Part 3





    }


    public static void main(String[] args) {
        launch(args);
    }
}
