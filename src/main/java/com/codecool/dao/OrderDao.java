package com.codecool.dao;

import com.codecool.model.Order;

import java.util.List;

public interface OrderDao {

    List<Order> showOrdersByCustomerID(int id);

    List<Order> showPastDueDateOrders();
}
