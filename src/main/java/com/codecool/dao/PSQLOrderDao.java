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
    public List<Order> getOrdersByCustomerID(int id) {

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
                order.setOrderDate(rs.getDate(6));
                order.setDueDate(rs.getDate(7));
                order.setTotalDue(rs.getInt(8));
                orders.add(order);
            }
        } catch (SQLException e) {
            System.out.println("Error executing query: " + e.getMessage());
        }
        return orders;
    }

    @Override
    public List<Order> getPastDueDateOrders() {

        String sql = "SELECT sales_order_id, status, user_id, first_name, last_name, order_date, due_date, total_due " +
                     "FROM orders " +
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
                order.setOrderDate(rs.getDate(6));
                order.setDueDate(rs.getDate(7));
                order.setTotalDue(rs.getInt(8));
                orders.add(order);
            }
        } catch (SQLException e) {
            System.out.println("Error executing query: " + e.getMessage());
        }
        return orders;
    }

    @Override
    public void add(Order order) {
        String sql = "INSERT INTO orders (order_date, due_date, status, sales_order_number, user_id, total_due) " +
                     "VALUES (?, ?, ?, ?, ?, ?)";
        try(PreparedStatement st = conn.prepareStatement(sql)) {
            st.setDate(1, order.getOrderDate());
            st.setDate(2, order.getDueDate());
            st.setString(3, order.getStatus());
            st.setString(4, order.getOrderNumber());
            st.setInt(5, order.getUserID());
            st.setFloat(6, order.getTotalDue());
            st.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error executing query: " + e.getMessage());
        }
    }

    @Override
    public int[] findMaxNumberOfCharsPerColumn() {
        int numberOfColumns = 8;
        int[] maxLengths = new int[numberOfColumns];
        String sql = "SELECT " +
                        "max(length(cast(sales_order_id as varchar(20)))) ," +
                        "max(length(status)) ," +
                        "max(length(cast(user_id as varchar(20)))) ," +
                        "max(length(first_name)), " +
                        "max(length(last_name)), " +
                        "max(length(cast(order_date as varchar(20)))), " +
                        "max(length(cast(due_date as varchar(20)))), " +
                        "max(length(cast(total_due as varchar(10)))) " +
                     "FROM orders " +
                     "JOIN users on users.id = orders.user_id";
        try(PreparedStatement st = conn.prepareStatement(sql)) {
            ResultSet rs = st.executeQuery();
            rs.next();
            for (int i = 0; i < maxLengths.length; i++) {
                maxLengths[i] = rs.getInt(i + 1);
            }

        } catch (SQLException e) {
            System.out.println("Error executing query: " + e.getMessage());
        }
        return maxLengths;
    }
}