package com.codecool.dao;

import com.codecool.enums.UserTable;
import com.codecool.model.Product;
import com.codecool.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PSQLProductDao implements ProductDAO {
    private Connection conn;

    public PSQLProductDao(Connection conn) {
        this.conn = conn;
    }

    @Override
    public List<Product> getTableFromDatabase(String command) {
        List<Product> productsList = new ArrayList<>();

        try (PreparedStatement st = this.conn.prepareStatement(command);
             ResultSet rs = st.executeQuery()) {

            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                String gender = rs.getString(3);
                String type = rs.getString(4);
                String color = rs.getString(5);
                String size = rs.getString(6);
                int price = rs.getInt(7);
                int quantity = rs.getInt(8);
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
                int id = rs.getInt(1);
                String name = rs.getString(2);
                String gender = rs.getString(3);
                String type = rs.getString(4);
                String color = rs.getString(5);
                String size = rs.getString(6);
                int price = rs.getInt(7);
                int quantity = rs.getInt(8);
                Product product = new Product(id, name, gender, type, color, size, price, quantity);

                return product;
            }

        } catch (SQLException e) {
            System.out.println("Error executing query: " + e.getMessage());
        }
        return null;
    }

    @Override
    public int getNumberOfRecords() {
        String sql = "SELECT count(*) FROM products";
        try(PreparedStatement st = conn.prepareStatement(sql)) {
            ResultSet rs = st.executeQuery();
            if (rs.next()) return rs.getInt(1);

        } catch (SQLException e) {
            System.out.println("Error executing query: " + e.getMessage());
        }
        return 0;
    }

    @Override
    public void delete(Product product) {
        String sql = "DELETE FROM products WHERE id = ?";
        try(PreparedStatement st = conn.prepareStatement(sql)) {
            st.setInt(1, product.getId());

            st.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error executing query: " + e.getMessage());
        }
    }

    @Override
    public int addProduct(Product product) {
        String sql = "INSERT INTO products (product_name, gender, type, colour, sizes, prices, quantity_on_stock) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try(PreparedStatement st = conn.prepareStatement(sql)) {
            st.setString(1, product.getName());
            st.setString(2, product.getGender());
            st.setString(3, product.getType());
            st.setString(4, product.getColour());
            st.setString(5, product.getSizes());
            st.setInt(6, product.getPrices());
            st.setInt(7, product.getQuantity());
            return st.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error executing query: " + e.getMessage());
        }
        return 0;

    }

    @Override
    public void update(Product product) {
        String sql = "UPDATE products SET product_name = ?, gender = ?, type = ?, colour = ?, sizes = ?, prices = ?, quantity_on_stock = ? WHERE id = ?";
        try(PreparedStatement st = conn.prepareStatement(sql)) {
            st.setString(1, product.getName());
            st.setString(2, product.getGender());
            st.setString(3, product.getType());
            st.setString(4, product.getColour());
            st.setString(5, product.getSizes());
            st.setInt(6, product.getPrices());
            st.setInt(7,product.getQuantity());
            st.setInt(8,product.getId());

            st.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error executing query: " + e.getMessage());
        }
    }

}
