package com.tablemasteradmin.admintablemaster;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.IOException;

public class HelloController {

    @FXML
    private TextField password;
    @FXML
    Button retry;
    @FXML
    private TextField username;

    private Stage stage;

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    @FXML
    public void onclickLogin(ActionEvent event) throws NullPointerException, IOException {
        String uname = username.getText();
        String pass = password.getText();
        if (uname.equals("admin") && pass.equals("admin123")) {
            FXMLLoader loader1 = new FXMLLoader(getClass().getResource("Afterlogin.fxml"));
            Scene scene = new Scene(loader1.load(), 1200, 720);
            stage.setScene(scene);
            stage.show();
        } else {
            FXMLLoader loader2 = new FXMLLoader(getClass().getResource("Incorrect-Password.fxml"));
            Scene scene = new Scene(loader2.load(), 1200, 720);
            stage.setScene(scene);
            stage.show();

        }
    }
    @FXML
    public void onclickretry(ActionEvent event) throws NullPointerException, IOException {
        String uname = username.getText();
        String pass = password.getText();
        if (uname.equals("admin") && pass.equals("admin123")) {
            FXMLLoader loader1 = new FXMLLoader(getClass().getResource("Afterlogin.fxml"));
            Scene scene = new Scene(loader1.load(), 1200, 720);
            stage.setScene(scene);
            stage.show();
        }

    }
}
