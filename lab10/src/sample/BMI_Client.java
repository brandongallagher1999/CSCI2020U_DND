package sample;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class BMI_Client extends Stage {
    Socket socket;
    Button sendMessage;
    TextField username;
    TextField message;



    public void create() {
        Label user_label = new Label("Username:");
        user_label.setLayoutX(40);
        user_label.setLayoutY(100);
        Label message_label = new Label("Message:");
        message_label.setLayoutX(40);
        message_label.setLayoutY(150);
        message = new TextField();
        message.setLayoutY(150);
        message.setLayoutX(100);
        username = new TextField();
        username.setLayoutX(100);
        username.setLayoutY(100);
        sendMessage = new Button("Send");
        sendMessage.setLayoutX(100);
        sendMessage.setLayoutY(200);

        Thread thread = new Thread(() -> {
            try {
                socket = new Socket("localhost", 6666);
                sendMessage.setOnAction(e ->
                {
                    System.out.println("pressed");
                    try {
                        PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
                        writer.println(username.getText() + ": " + message.getText());



                    } catch (Throwable t) {
                        t.printStackTrace();
                    }
                });
            } catch (Throwable e) {
                e.printStackTrace();
            }
        });
        thread.start();

        AnchorPane pane = new AnchorPane();
        pane.getChildren().addAll(sendMessage, username, message, message_label, user_label);

        this.setTitle("Client Side");
        this.setScene(new Scene(pane, 700, 700));
        this.show();


    }

}
