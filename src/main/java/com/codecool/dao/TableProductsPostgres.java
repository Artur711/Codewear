package com.codecool.dao;

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
    public List<List<Object>> getTableAllDetails(String command) {
        List<List<Object>> objectList = new ArrayList<>();

        try (PreparedStatement st = this.conn.prepareStatement(command);
             ResultSet rs = st.executeQuery()) {

            ResultSetMetaData meta = rs.getMetaData();
            int columnCount = meta.getColumnCount();

            while (rs.next()) {
                List<Object> oList = new ArrayList<>();

                for (int index = 0; index < columnCount; index++) {
                    oList.add(rs.getObject(index + 1));
                }
                objectList.add(oList);
            }

        } catch (SQLException e) {
            System.out.println("Error executing query");
        }
        return objectList;
    }
}
