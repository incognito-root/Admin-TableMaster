package com.tablemasteradmin.admintablemaster;

import java.time.LocalDateTime;

public class MenuItemModel {
        private String menuItemName;
        private double menuItemPrice;
        private String menuItemImageUrl;

        public MenuItemModel(String menuItemName, double menuItemPrice) {
            this.menuItemName = menuItemName;
            this.menuItemPrice = menuItemPrice;

        }

        public MenuItemModel() {
        }

    public String getMenuItemName() {
        return menuItemName;
    }

    public void setMenuItemName(String menuItemName) {
        this.menuItemName = menuItemName;
    }

    public double getMenuItemPrice() {
        return menuItemPrice;
    }

    public void setMenuItemPrice(double menuItemPrice) {
        this.menuItemPrice = menuItemPrice;
    }


}


