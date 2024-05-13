package com.tablemasteradmin.admintablemaster;

import com.tablemasteradmin.admintablemaster.model.Admin;
import com.tablemasteradmin.admintablemaster.services.AdminService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.*;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {

    @FXML
    private PasswordField password;
    @FXML
    private TextField username;
    @FXML
    private Button login;
    @FXML
    private Label loginFailedLabel;
    @FXML
    private CheckBox stayLoggedIn;

    private Stage stage;

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    @FXML
    public void onclickLogin(ActionEvent event) throws NullPointerException, IOException {
        String uname = username.getText();
        String pass = password.getText();

        Admin admin = new Admin(uname, pass);

        AdminService adminService = new AdminService();
        boolean isLoggedId = adminService.adminLogin(admin);

        if (isLoggedId) {

            if (stayLoggedIn.isSelected()) {
                saveCookie(admin.getUsername());
            }

            FXMLLoader loader1 = new FXMLLoader(getClass().getResource("Afterlogin.fxml"));
            Scene scene = new Scene(loader1.load(), 1200, 720);
            stage.setScene(scene);
            stage.show();
        } else {
            login.setText("Retry");
            loginFailedLabel.setVisible(true);
        }
    }

    private void saveCookie(String username) throws IOException {
        BufferedWriter writer = null;

        try {
            writer = new BufferedWriter(new FileWriter("cookie.txt"));
            writer.write(username);
        } catch (IOException e) {
            System.out.println("Error in writing to file: " + e.getMessage());
        } finally {
            if (writer != null) {
                writer.close();
            }
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
