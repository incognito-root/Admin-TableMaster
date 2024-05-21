package com.tablemasteradmin.admintablemaster.model;

public class Discount {
    private String Title;
    private double Percentage;

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public double getPercentage() {
        return Percentage;
    }

    public void setPercentage(double percentage) {
        Percentage = percentage;
    }

    public Discount(String title, double percentage) {
        setTitle(title);
        setPercentage(percentage);
    }


}
