package com.tablemasteradmin.admintablemaster;

import com.tablemasteradmin.admintablemaster.model.MenuItemModel;
import com.tablemasteradmin.admintablemaster.services.MenuService;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.TilePane;

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

    ArrayList<MenuItemModel> menuItems = new ArrayList<>();

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
            menuItemController.setData(menuItem.getMenuItemName(), String.valueOf(menuItem.getMenuItemPrice()));
            tiledpane.getChildren().add(anchorPane);
        }
    }
}