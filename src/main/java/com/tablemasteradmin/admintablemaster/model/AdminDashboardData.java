package com.tablemasteradmin.admintablemaster.model;

import java.util.List;

public class AdminDashboardData {
    private long totalOrders;
    private List<OrderModel> orders;
    private double revenue;
    private long totalCustomers;

    public AdminDashboardData(long totalOrders, List<OrderModel> orders, double revenue, long totalCustomers) {
        this.totalOrders = totalOrders;
        this.orders = orders;
        this.revenue = revenue;
        this.totalCustomers = totalCustomers;
    }

    public AdminDashboardData() {
    }

    public long getTotalOrders() {
        return totalOrders;
    }

    public void setTotalOrders(long totalOrders) {
        this.totalOrders = totalOrders;
    }

    public List<OrderModel> getOrders() {
        return orders;
    }

    public void setOrders(List<OrderModel> orders) {
        this.orders = orders;
    }

    public double getRevenue() {
        return revenue;
    }

    public void setRevenue(double revenue) {
        this.revenue = revenue;
    }

    public long getTotalCustomers() {
        return totalCustomers;
    }

    public void setTotalCustomers(long totalCustomers) {
        this.totalCustomers = totalCustomers;
    }
}
