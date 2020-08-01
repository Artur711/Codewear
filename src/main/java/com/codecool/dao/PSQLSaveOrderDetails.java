package com.codecool.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class PSQLSaveOrderDetails {
    private final Connection conn;
    private final ProductDao productDao;
    private final Map<Integer, Integer> mapOrders;
    private final int userID;

    public PSQLSaveOrderDetails(Connection conn, ProductDao productDao, Map<Integer, Integer> mapOrders, int userID) {
        this.conn = conn;
        this.productDao = productDao;
        this.mapOrders = mapOrders;
        this.userID = userID;
    }

    public void run() {
        String command = "INSERT INTO orderdetails (sales_order_detail_id, sales_order_id, qty, product_id, unit_price) VALUES (?, ?, ?, ?, ?);";
        int idNumber = getSalesID();

        for (Integer productID : mapOrders.keySet()) {
            try (PreparedStatement st = this.conn.prepareStatement(command)) {
                int price = productDao.getProductFromDatabase(productID).getPrices();
                st.setInt(1, idNumber);
                 st.setInt(2, this.userID);
                 st.setInt(3, mapOrders.get(productID));
                 st.setInt(4, productID);
                 st.setInt(5, price);

                 st.executeUpdate();

            } catch (SQLException e) {
                System.out.println("Error executing query");
            }
        }
    }

    private int getSalesID() {
        List<Object> objectList = productDao.getOptions("SELECT sales_order_detail_id FROM orderdetails;");
        List<Integer> listID = new ArrayList<>();

        for (int i = 0; i < objectList.size() - 1; i++) {
            listID.add((Integer) objectList.get(i));
        }
        int nextID = 1;

        while (listID.contains(nextID)) {
            nextID++;
        }

        return nextID;
    }
}
