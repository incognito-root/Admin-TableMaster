package com.tablemasteradmin.admintablemaster.model;

public class UpdateMenuItem {
    String menuItemTitle;
    double menuItemPrice;
    String menuItemDescription;

    public UpdateMenuItem(String menuItemTitle, double menuItemPrice, String menuItemDescription) {
        this.menuItemTitle = menuItemTitle;
        this.menuItemPrice = menuItemPrice;
        this.menuItemDescription = menuItemDescription;
    }

    public UpdateMenuItem() {
    }

    public String getMenuItemTitle() {
        return menuItemTitle;
    }

    public void setMenuItemTitle(String menuItemTitle) {
        this.menuItemTitle = menuItemTitle;
    }

    public double getMenuItemPrice() {
        return menuItemPrice;
    }

    public void setMenuItemPrice(double menuItemPrice) {
        this.menuItemPrice = menuItemPrice;
    }

    public String getMenuItemDescription() {
        return menuItemDescription;
    }

    public void setMenuItemDescription(String menuItemDescription) {
        this.menuItemDescription = menuItemDescription;
    }
}
