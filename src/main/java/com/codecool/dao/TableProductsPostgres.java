package com.codecool.dao;

import com.codecool.model.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TableProductsPostgres implements TableProductsDAO {
    private Connection conn;

    public TableProductsPostgres(Connection conn) {
        this.conn = conn;
    }

    @Override
    public List<Product> getTableFromDatabase(String command) {
        List<Product> productsList = new ArrayList<>();

        try (PreparedStatement st = this.conn.prepareStatement(command);
             ResultSet rs = st.executeQuery()) {

            while (rs.next()) {
                Object id = rs.getObject(1);
                Object name = rs.getObject(2);
                Object gender = rs.getObject(3);
                Object type = rs.getObject(4);
                Object color = rs.getObject(5);
                Object size = rs.getObject(6);
                Object price = rs.getObject(7);
                Object quantity = rs.getObject(8);
                productsList.add(new Product(id, name, gender, type, color, size, price, quantity));
            }

        } catch (SQLException e) {
            System.out.println("Error executing query");
        }
        return productsList;
    }

    @Override
    public List<Object> getOptions(String command) {
        List<Object> objectList = new ArrayList<>();

        try (PreparedStatement st = this.conn.prepareStatement(command);
             ResultSet rs = st.executeQuery()) {

            while (rs.next()) {
                if (!objectList.contains(rs.getObject(1))) {
                    objectList.add(rs.getObject(1));
                }
            }

        } catch (SQLException e) {
            System.out.println("Error executing query");
        }
        objectList.add("All");
        return objectList;
    }

    public Product getProductFromDatabase(int product_id) {

        String sql = "select * from products where id = ?";
        try(PreparedStatement st = conn.prepareStatement(sql)) {
            st.setInt(1, product_id);
            ResultSet rs = st.executeQuery();
            while(rs.next()) {
                Object id = rs.getObject(1);
                Object name = rs.getObject(2);
                Object gender = rs.getObject(3);
                Object type = rs.getObject(4);
                Object color = rs.getObject(5);
                Object size = rs.getObject(6);
                Object price = rs.getObject(7);
                Object quantity = rs.getObject(8);
                Product product = new Product(id, name, gender, type, color, size, price, quantity);

                return product;
            }

        } catch (SQLException e) {
            System.out.println("Error executing query: " + e.getMessage());
        }
        return null;
    }
}
