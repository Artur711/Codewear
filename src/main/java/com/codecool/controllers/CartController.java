package com.codecool.controllers;

import com.codecool.dao.CartDao;
import com.codecool.datasource.PostgresSQLDataSource;
import com.codecool.view.CartView;
import com.codecool.view.MainView;
import com.codecool.dao.PSQLCartDao;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Map;
import java.util.Properties;

import com.codecool.dao.TableProductsPostgres;

public class CartController {

    Connection conn = setup();

    CartView cartView;
    MainView mainView;

    TableProductsPostgres tableProductsPostgres;
    PSQLCartDao psqlCartDao;

    final int user_id;


    public CartController(int user_id) {

        this.user_id = user_id;

        cartView = new CartView();
        mainView = new MainView();

        tableProductsPostgres = new TableProductsPostgres(conn);
        psqlCartDao = new PSQLCartDao(conn);
    }

    public void run() {
        mainView.clearScreen();
        boolean isRunning = true;

        while (isRunning) {

            mainView.clearScreen();
            Map<Integer, Integer> cartIdItems = psqlCartDao.getCartOfItems(6);
            for (int keyName : cartIdItems.keySet()) {
                cartView.printProduct(tableProductsPostgres.getProductFromDatabase(keyName), cartIdItems.get(keyName));
            }

            cartView.CartMenu();
            int input = mainView.getIntegerInput();
            switch (input) {
                case 1:
                    psqlCartDao.addToUserCart(6, 8323, 2);
                    break;
                case 2:
                    System.out.println("Type product id to delte: ");
                    int propduct_id = mainView.getIntegerInput();
                    psqlCartDao.deleteItemFromUserCart(getUser_id(), propduct_id);
                    break;
                case 3:
                    psqlCartDao.deleteAllFromUserCart(getUser_id());
                    break;
                case 4:
                    System.out.println("Choose product id to change: ");
                    int product_idd = mainView.getIntegerInput();
                    System.out.println("Choose new quantity of product: ");
                    int new_quantity = mainView.getIntegerInput();
                    psqlCartDao.changeQuantityOfProduct(getUser_id(), product_idd, new_quantity);
                    break;
                case 5:
                    isRunning = false;
                    break;
            }
        }
    }

    public Connection setup() {
        try (InputStream input = new FileInputStream("./src/main/resources/database.properties")) {
            Properties prop = new Properties();
            prop.load(input);
            String databaseName = prop.getProperty("db.database");
            String user = prop.getProperty("db.user");
            String password = prop.getProperty("db.passwd");
            return new PostgresSQLDataSource(databaseName, user, password).connect();
        } catch (IOException e) {
            System.out.println("The file doesn't exist!!!");
        }
        return null;
    }

    public int getUser_id() {
        return user_id;
    }
}
