package com.tablemasteradmin.admintablemaster;

import com.tablemasteradmin.admintablemaster.model.MenuItemModel;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

import java.io.FileNotFoundException;
import java.io.IOException;

public class MenuItemController {

    @FXML
    private Button editbutton;

    @FXML
    private ImageView menuItemImage;

    @FXML
    private Text menuItemPrice;

    @FXML
    private Text menuItemTitle;

    MenuItemModel selectedMenuItem;

    public void setData(String menuItemPrice, String menuItemTitle)  {
        this.menuItemPrice.setText(menuItemPrice);
        this.menuItemTitle.setText(menuItemTitle);
    }

    public ImageView getMenuItemImage() {
        return menuItemImage;
    }

    public void setMenuItemImage(ImageView menuItemImage) {
        this.menuItemImage = menuItemImage;
    }

    public Text getMenuItemPrice() {
        return menuItemPrice;
    }

    public void setMenuItemPrice(Text menuItemPrice) {
        this.menuItemPrice = menuItemPrice;
    }

    public Text getMenuItemTitle() {
        return menuItemTitle;
    }

    public void setMenuItemTitle(Text menuItemTitle) {
        this.menuItemTitle = menuItemTitle;
    }
    public void onclickeditbutton(Event e) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("addMenuItems.fxml"));
        AddMenuItemController menuItemController=fxmlLoader.getController();
        menuItemController.setmenuitems(selectedMenuItem);


    }

}
