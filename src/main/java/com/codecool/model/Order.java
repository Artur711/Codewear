package com.codecool.model;

import java.time.LocalDate;
import java.sql.Date;

public class Order {

    int orderID;
    String customerFirstName;
    String customerLastName;
    Date orderDate;
    Date dueDate;
    String status;
    String orderNumber;
    int userID;
    float totalDue;

    public Order(String customerFirstName, String customerLastName, Date orderDate, Date dueDate, String status, String orderNumber, int userID, float totalDue) {
        this.customerFirstName = customerFirstName;
        this.customerLastName = customerLastName;
        this.orderDate = orderDate;
        this.dueDate = dueDate;
        this.status = status;
        this.orderNumber = orderNumber;
        this.userID = userID;
        this.totalDue = totalDue;
    }

    public Order() {

    }

    public String getOrderNumber() { return orderNumber; }

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

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
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

    public float getTotalDue() {
        return totalDue;
    }

    public void setTotalDue(int totalDue) {
        this.totalDue = totalDue;
    }

    @Override
    public String toString() {
        return  "|       " + orderID + "        " +
                "| " + status.trim() +
                " | " + userID +
                " | " + customerFirstName +
                " | " + customerLastName +
                " | " + orderDate +
                " | " + dueDate +
                " | " + totalDue + " |";
    }

}
