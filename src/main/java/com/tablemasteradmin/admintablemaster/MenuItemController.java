package com.tablemasteradmin.admintablemaster;

import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

import java.io.FileNotFoundException;

public class MenuItemController {

    @FXML
    private ImageView menuItemImage;

    @FXML
    private Text menuItemPrice;

    @FXML
    private Text menuItemTitle;

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
}
