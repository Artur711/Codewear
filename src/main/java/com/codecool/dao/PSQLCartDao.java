package com.codecool.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class PSQLCartDao implements CartDao{

    Connection conn;

    public PSQLCartDao(Connection conn) {
        this.conn = conn;
    }

    @Override
    public int add(int userId, int productId, int quantity) {
        String sql = "INSERT INTO cart (user_id, product_id, quantity) VALUES (?, ?, ?)";
        try(PreparedStatement st = conn.prepareStatement(sql)) {
            st.setInt(1, userId);
            st.setInt(2, productId);
            st.setInt(3, quantity);
            return st.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error executing query: " + e.getMessage());
        }
        return 0;
    }

    @Override
    public int clear(int userId) {
        String sql = "DELETE FROM cart WHERE user_id = ?";
        try (PreparedStatement st = conn.prepareStatement(sql)) {
            st.setInt(1, userId);
            return st.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error executing query: " + e.getMessage());
        }
        return 0;
    }

    @Override
    public int delete(int userId, int productId) {
        String sql = "DELETE FROM cart WHERE user_id = ? AND product_id = ?";
        try(PreparedStatement st = conn.prepareStatement(sql)) {
            st.setInt(1, userId);
            st.setInt(2, productId);
            return st.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error executing query: " + e.getMessage());
        }
        return 0;
    }

    @Override
    public Map<Integer, Integer> getCartMap(int userId) {
        Map<Integer, Integer> cartOfItems = new HashMap<Integer, Integer>();
        String sql = "SELECT * FROM cart WHERE user_id = ?;";
        try(PreparedStatement st = conn.prepareStatement(sql)) {
            st.setInt(1, userId);
            ResultSet rs = st.executeQuery();
            while(rs.next()) {
                int productId = rs.getInt("product_id");
                int quantity = rs.getInt("quantity");
                cartOfItems.put(productId, quantity);
            }
        } catch (SQLException e) {
            System.out.println("Error executing query: " + e.getMessage());
        }
        return cartOfItems;
    }

    @Override
    public int changeQuantityOfProduct(int userId, int productId, int quantity) {
        String sql = "UPDATE cart SET quantity = ? WHERE user_id = ? and product_id = ?;";
        try(PreparedStatement st = conn.prepareStatement(sql)) {
            st.setInt(1, quantity);
            st.setInt(2, userId);
            st.setInt(3, productId);
            return st.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error executing query: " + e.getMessage());
        }
        return 0;
    }

    @Override
    public boolean isAvailableOnStock(int quantityInOrder, int userQuantityOrder){
        if(quantityInOrder >= userQuantityOrder){
            return true;
        }else{
            return false;
        }
    }
}