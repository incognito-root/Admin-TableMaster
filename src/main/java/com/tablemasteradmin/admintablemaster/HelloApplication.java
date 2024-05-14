package com.tablemasteradmin.admintablemaster;

import com.tablemasteradmin.admintablemaster.HelperFunction.Auth;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        boolean loggedInStatus = Auth.checkSignedInStatus();

        FXMLLoader fxmlLoader;

        if (loggedInStatus) {
            fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Afterlogin.fxml"));
        } else {
            fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("login-screen.fxml"));
        }

        Scene scene = new Scene(fxmlLoader.load(), 1200, 720);
        LoginController controller = fxmlLoader.getController();
        controller.setStage(stage);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}