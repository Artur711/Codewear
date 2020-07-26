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
    public int addToUserCart(int user_id, int product_id, int quantity) {
        String sql = "INSERT INTO cart (user_id, product_id, quantity) VALUES (?, ?, ?)";
        try(PreparedStatement st = conn.prepareStatement(sql)) {
            st.setInt(1, user_id);
            st.setInt(2, product_id);
            st.setInt(3, quantity);
            return st.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error executing query: " + e.getMessage());
        }
        return 0;
    }

    @Override
    public int deleteAllFromUserCart(int user_id) {
        String sql = "DELETE FROM cart WHERE user_id = ?";
        try (PreparedStatement st = conn.prepareStatement(sql)) {
            st.setInt(1, user_id);
            return st.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error executing query: " + e.getMessage());
        }
        return 0;
    }

    @Override
    public int deleteItemFromUserCart(int user_id, int product_id) {
        String sql = "DELETE FROM cart WHERE user_id = ? AND product_id = ?";
        try(PreparedStatement st = conn.prepareStatement(sql)) {
            st.setInt(1, user_id);
            st.setInt(2, product_id);
            return st.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error executing query: " + e.getMessage());
        }
        return 0;
    }

    @Override
    public Map<Integer, Integer> getCartOfItems(int user_id) {
        Map<Integer, Integer> cartOfItems = new HashMap<Integer, Integer>();
        String sql = "SELECT * FROM cart WHERE user_id = ?;";
        try(PreparedStatement st = conn.prepareStatement(sql)) {
            st.setInt(1, user_id);
            ResultSet rs = st.executeQuery();
            while(rs.next()) {
                int product_id = rs.getInt("product_id");
                int quantity = rs.getInt("quantity");
                cartOfItems.put(product_id, quantity);
            }
        } catch (SQLException e) {
            System.out.println("Error executing query: " + e.getMessage());
        }
        return cartOfItems;
    }

    @Override
    public int changeQuantityOfProduct(int user_id, int product_id, int quantity) {
        String sql = "UPDATE cart SET quantity = ? WHERE user_id = ? and product_id = ?;";
        try(PreparedStatement st = conn.prepareStatement(sql)) {
            st.setInt(1, quantity);
            st.setInt(2, user_id);
            st.setInt(3, product_id);
            return st.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error executing query: " + e.getMessage());
        }
        return 0;
    }
}