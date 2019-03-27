package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class Controller {


    @FXML TextField txt_username;

    @FXML PasswordField pwd_password;

    @FXML TextField txt_fullName;

    @FXML TextField txt_email;

    @FXML Button btn_register;

    public void listeners()
    {
        btn_register.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("working");
                System.out.println(txt_username.getText());
                System.out.println(pwd_password.getText());
                System.out.println(txt_fullName.getText());
                System.out.println(txt_email.getText());
            }
        });
    }

    public void initialize(){

        listeners();


    }
}
