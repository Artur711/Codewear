package com.codecool.model;

public class Order {

    int orderID;
    String customerFirstName;
    String customerLastName;
    String orderDate;
    String dueDate;
    String status;
    int userID;
    int totalDue;

    public int getId() {
        return orderID;
    }

    public void setId(int id) {
        this.orderID = id;
    }

    public String getCustomerFirstName() {
        return customerFirstName;
    }

    public void setCustomerFirstName(String customerFirstName) {
        this.customerFirstName = customerFirstName;
    }

    public String getCustomerLastName() {
        return customerLastName;
    }

    public void setCustomerLastName(String customerLastName) {
        this.customerLastName = customerLastName;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getTotalDue() {
        return totalDue;
    }

    public void setTotalDue(int totalDue) {
        this.totalDue = totalDue;
    }

    @Override
    public String toString() {
        return  "orderID=" + orderID +
                ", status='" + status.trim() + '\'' +
                ", userID=" + userID +
                ", customerFirstName='" + customerFirstName + '\'' +
                ", customerLastName='" + customerLastName + '\'' +
                ", orderDate='" + orderDate + '\'' +
                ", dueDate='" + dueDate + '\'' +
                ", totalDue=" + totalDue;
    }
}
