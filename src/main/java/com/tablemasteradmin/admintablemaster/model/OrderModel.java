package com.tablemasteradmin.admintablemaster.model;

import java.time.LocalDate;

public class OrderModel {
    long orderId;
    private String orderDescription;
    private String orderStatus;
    private LocalDate orderPlacedDate;
    private double orderAmount;
    private double orderExtraCharges;
    private long fkCustomerId;

    public OrderModel(long orderId, String orderDescription, String orderStatus, LocalDate orderPlacedDate, double orderAmount, double orderExtraCharges, long fkCustomerId) {
        this.orderId = orderId;
        this.orderDescription = orderDescription;
        this.orderStatus = orderStatus;
        this.orderPlacedDate = orderPlacedDate;
        this.orderAmount = orderAmount;
        this.orderExtraCharges = orderExtraCharges;
        this.fkCustomerId = fkCustomerId;
    }

    public OrderModel() {
    }

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public String getOrderDescription() {
        return orderDescription;
    }

    public void setOrderDescription(String orderDescription) {
        this.orderDescription = orderDescription;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public LocalDate getOrderPlacedDate() {
        return orderPlacedDate;
    }

    public void setOrderPlacedDate(LocalDate orderPlacedDate) {
        this.orderPlacedDate = orderPlacedDate;
    }

    public double getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(double orderAmount) {
        this.orderAmount = orderAmount;
    }

    public double getOrderExtraCharges() {
        return orderExtraCharges;
    }

    public void setOrderExtraCharges(double orderExtraCharges) {
        this.orderExtraCharges = orderExtraCharges;
    }

    public long getFkCustomerId() {
        return fkCustomerId;
    }

    public void setFkCustomerId(long fkCustomerId) {
        this.fkCustomerId = fkCustomerId;
    }
}
