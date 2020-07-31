package com.codecool.dao;

import com.codecool.model.Order;

import java.util.List;

public interface OrderDao {

    List<Order> getOrdersByCustomerID(int id);

    List<Order> getPastDueDateOrders();

    void add(Order order);

    int[] findMaxNumberOfCharsPerColumn();
}
