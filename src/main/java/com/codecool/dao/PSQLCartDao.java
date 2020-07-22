package com.codecool.dao;

import com.codecool.model.Cart;
import com.codecool.model.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Collections;
import java.util.Map;

public class PSQLCartDao implements CartDao{

    Connection conn;

    private final Map<Product, Integer> products= Collections.<Product, Integer>emptyMap();

    public PSQLCartDao(Connection conn) {
        this.conn = conn;
    }

    @Override
    public int addToUserCart(Cart cart) {
        String sql = "INSERT INTO cart (user_id, product_id, quantity) VALUES (?, ?, ?)";
        try(PreparedStatement st = conn.prepareStatement(sql)) {
            st.setString(1, cart.getUser_id());
            st.setString(2, cart.getProduct_id());
            st.setInt(3, cart.getQuantity());
            return st.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error executing query: " + e.getMessage());
        }
        return 0;
    }

    @Override
    public int deleteFromUserCart(Cart cart, Product product) {
        String sql = "DELETE FROM cart WHERE user_id = ? AND product_id = ?";
        try(PreparedStatement st = conn.prepareStatement(sql)) {
            st.setString(1, cart.getUser_id());
            st.setString(2, cart.getProduct_id());
            st.setInt(3, cart.getQuantity());
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
