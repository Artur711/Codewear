package com.codecool.dao;

import com.codecool.dao.TableProductsDAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TableProductsPostgres implements TableProductsDAO {
    private Connection conn;

    public TableProductsPostgres(Connection conn) {
        this.conn = conn;
    }

    @Override
    public List<List<Object>> getTableFromDatabase(String command) {
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
