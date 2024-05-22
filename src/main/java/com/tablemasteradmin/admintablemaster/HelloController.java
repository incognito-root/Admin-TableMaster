package com.tablemasteradmin.admintablemaster;

import com.tablemasteradmin.admintablemaster.model.MenuItemModel;
import com.tablemasteradmin.admintablemaster.services.MenuService;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class HelloController implements Initializable {

    @FXML
    TilePane tiledpane;

    @FXML
    AnchorPane mainHomeArea;

    @FXML
    StackPane mainStackPane;

    @FXML
    Button addbutton;

    @FXML
    Button searchbutton;

    @FXML
    TextField searchtextfield;

    ArrayList<MenuItemModel> menuItems = new ArrayList<>();
    Scene scene=null;
    Stage stage;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            MenuService menuService = new MenuService();
            menuService.setAllMenuItems();
            menuItems  = menuService.getAllMenuItems();

            this.getdata();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void getdata() throws IOException {
        for (MenuItemModel menuItem : menuItems) {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("menu-item-card.fxml"));
            AnchorPane anchorPane = fxmlLoader.load();
            MenuItemController menuItemController = fxmlLoader.getController();
            menuItemController.setData(String.valueOf(menuItem.getMenuItemPrice()), menuItem.getMenuItemName(), menuItem.getMenuItemDescription());
            tiledpane.getChildren().add(anchorPane);
        }
    }
    public void onclickaddbutton(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("addMenuItems.fxml"));
        scene = new Scene(fxmlLoader.load(), 1200, 720);
        stage = (Stage) addbutton.getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
    public void onclicksearchbutton(Event actionEvent) throws IOException {
        String source = searchtextfield.getText();

        tiledpane.getChildren().clear();

        for(MenuItemModel menuItem : menuItems) {
            if(menuItem.getMenuItemName().contains(source)) {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("menu-item-card.fxml"));
                AnchorPane anchorPane = fxmlLoader.load();
                MenuItemController menuItemController = fxmlLoader.getController();
                menuItemController.setData( String.valueOf(menuItem.getMenuItemPrice()),menuItem.getMenuItemName(), menuItem.getMenuItemDescription());
                tiledpane.getChildren().add(anchorPane);
            }
        }
    }

    public void navigateToDashboard() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("dashboard.fxml"));
        scene = new Scene(fxmlLoader.load(), 1200, 720);
        stage = (Stage) addbutton.getScene().getWindow();
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }

    public void navigateToDiscount() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Discount.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1200, 720);
        Stage stage;
        stage = (Stage) addbutton.getScene().getWindow();
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }
}