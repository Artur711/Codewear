package com.codecool.dao;

import com.codecool.model.Order;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PSQLOrderDao implements OrderDao {

    private final Connection conn;

    public PSQLOrderDao(Connection conn) {
        this.conn = conn;
    }

    @Override
    public List<Order> showOrdersByCustomerID(int id) {

        String sql = "SELECT sales_order_id, status, user_id, first_name, last_name, order_date, due_date, total_due FROM orders " +
                     "JOIN users on users.id = orders.user_id " +
                     "WHERE id =  ?";

        List<Order> orders = new ArrayList<>();
        try(PreparedStatement st = conn.prepareStatement(sql)) {
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Order order = new Order();
                order.setId(rs.getInt(1));
                order.setStatus(rs.getString(2));
                order.setUserID(rs.getInt(3));
                order.setCustomerFirstName(rs.getString(4));
                order.setCustomerLastName(rs.getString(5));
                order.setOrderDate(rs.getString(6));
                order.setDueDate(rs.getString(7));
                order.setTotalDue(rs.getInt(8));
                orders.add(order);
            }
        } catch (SQLException e) {
            System.out.println("Error executing query: " + e.getMessage());
        }
        return orders;
    }

    @Override
    public List<Order> showPastDueDateOrders() {

        String sql = "SELECT sales_order_id, status, user_id, first_name, last_name, order_date, due_date, total_due FROM orders " +
                     "JOIN users on users.id = orders.user_id " +
                     "WHERE CURRENT_DATE > due_date and status = 'shipped'";

        List<Order> orders = new ArrayList<>();
        try(PreparedStatement st = conn.prepareStatement(sql)) {
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Order order = new Order();
                order.setId(rs.getInt(1));
                order.setStatus(rs.getString(2));
                order.setUserID(rs.getInt(3));
                order.setCustomerFirstName(rs.getString(4));
                order.setCustomerLastName(rs.getString(5));
                order.setOrderDate(rs.getString(6));
                order.setDueDate(rs.getString(7));
                order.setTotalDue(rs.getInt(8));
                orders.add(order);
            }
        } catch (SQLException e) {
            System.out.println("Error executing query: " + e.getMessage());
        }
        return orders;
    }
}
