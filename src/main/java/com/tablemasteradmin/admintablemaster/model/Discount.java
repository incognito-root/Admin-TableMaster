package com.tablemasteradmin.admintablemaster.model;

public class Discount {
    private String discountTitle;
    private double discountPercentage;

    public Discount(String title, double percentage) {
        setDiscountTitle(title);
        setDiscountPercentage(percentage);
    }

    public String getDiscountTitle() {
        return discountTitle;
    }

    public void setDiscountTitle(String discountTitle) {
        this.discountTitle = discountTitle;
    }

    public double getDiscountPercentage() {
        return discountPercentage;
    }

    public void setDiscountPercentage(double discountPercentage) {
        this.discountPercentage = discountPercentage;
    }
}
