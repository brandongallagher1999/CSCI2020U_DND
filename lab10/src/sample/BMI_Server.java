package sample;

import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class BMI_Server extends Stage {


    AnchorPane pane;
    Socket socket;

    TextArea area = new TextArea();

    public void create() {
        pane = new AnchorPane();

        Thread thread = new Thread(() -> {
            try {
                ServerSocket ss = new ServerSocket(6666);
                socket = ss.accept();
                while (true) {
                    Scanner input = new Scanner(socket.getInputStream());
                    if(input.hasNext()){
                        area.appendText(input.nextLine());
                        area.appendText("\n");
                    }


                }
            } catch (Throwable e) {
                e.printStackTrace();
            }

        });
        thread.start();


        pane.getChildren().addAll(area);
        this.setTitle("Server Side");
        this.setScene(new Scene(pane, 700, 700));
        this.show();
    }
}
