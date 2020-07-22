package com.codecool.dao;

import com.codecool.datasource.SQLDataSource;
import com.codecool.model.Cart;


import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PSQLCartDao implements CartDao{

    SQLDataSource dataSource;

    public PSQLCartDao(SQLDataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public int addUserCart(Cart cart) {
        String sql = "INSERT INTO cart (user_id, product_id, quantity) VALUES (?, ?, ?)";
        try(PreparedStatement st = dataSource.connect().getConnection().prepareStatement(sql)) {
            st.setString(1, cart.getUser_id());
            st.setString(2, cart.getProduct_id());
            st.setInt(3, cart.getQuantity());
            return st.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error executing query: " + e.getMessage());
        }
        return 0;
    }
}
