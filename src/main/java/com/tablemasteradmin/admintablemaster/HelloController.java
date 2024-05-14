package com.tablemasteradmin.admintablemaster;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.TilePane;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class HelloController {

    @FXML
    TilePane tiledpane;

    @FXML
    AnchorPane mainHomeArea;

    @FXML
    StackPane mainStackPane;

    ArrayList<MenuItemModel> menuItems = new ArrayList<>();

    MenuItemModel menuItem1 = new MenuItemModel("Pizza", 300);
    MenuItemModel menuItem2 = new MenuItemModel("Burger", 200);

    public void initialize() {
        menuItems.add(menuItem1);
        menuItems.add(menuItem2);
        try {
            getdata();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void getdata() throws IOException {
        for (MenuItemModel menuItem : menuItems) {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("menu-item-card.fxml"));
            AnchorPane anchorPane = fxmlLoader.load();
            MenuItemController menuItemController = fxmlLoader.getController();
            menuItemController.setData(menuItem.getMenuItemName(), String.valueOf(menuItem.getMenuItemPrice()));
            tiledpane.getChildren().add(anchorPane);
        }
    }
}