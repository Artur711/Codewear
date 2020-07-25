package com.codecool.dao;

import com.codecool.model.Cart;
import com.codecool.model.Product;
import com.codecool.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Collections;
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
    public int deleteFromUserCart(int user_id, int product_id) {
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
    public Map<Product, Integer> getProductsFromCart() {
        return null;
    }
}
