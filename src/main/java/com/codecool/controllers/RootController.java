
package com.codecool.controllers;

import com.codecool.dao.CartDao;
import com.codecool.dao.OrderDao;
import com.codecool.dao.ProductDao;
import com.codecool.dao.UserDao;
import com.codecool.enums.Role;

import com.codecool.model.User;
import com.codecool.select.SelectDAO;
import com.codecool.select.SelectPostgres;
import com.codecool.view.MainView;
import com.codecool.view.SelectView;

import java.sql.Connection;


import static com.diogonunes.jcolor.Ansi.colorize;


public class RootController {

    private final MainView mainView;
    private final SelectView selectView;
    private final UserDao userDao;
    private final ProductDao productDao;
    private final OrderDao orderDao;
    private final CartDao cartDao;
    private final Connection conn;


    public RootController(UserDao userDao, CartDao cartDao, ProductDao productDao, OrderDao orderDao, Connection conn) {
        this.userDao = userDao;
        this.productDao = productDao;
        this.orderDao = orderDao;
        this.cartDao = cartDao;
        this.conn = conn;
        mainView = new MainView();
        selectView = new SelectView();


    }

    public void run() {
        mainView.clearScreen();
        boolean isRunning = true;

        while (isRunning) {

            mainView.clearScreen();
            mainView.displayMainMenu();

            int input = mainView.getIntegerInput();

            switch(input) {
                case 1:
                    createUserAccount();
                    break;
                case 2:
                    validateUser();
                    break;
                case 3:
                    isRunning = false;
                    System.out.println("\n" + colorize("  Bye!", mainView.HEADER_FORMAT));
                default:
            }
        }

    }

    private void createUserAccount() {
        User user = mainView.getUserData();
        if (userDao.addUser(user, Role.CUSTOMER.getRoleID()) == 1) {
            mainView.clearScreen();
            mainView.displayAccountCreationMessage();
        }
    }

    private void validateUser() {
        User user = userDao.validateUser(mainView.getUserCredentials());
        if (user != null && user.getRoleID() == Role.ADMIN.getRoleID()) {
            AdminController admin = new AdminController(user, mainView, userDao, productDao, orderDao);
            admin.run();
        } else if (user != null && user.getRoleID() == Role.CUSTOMER.getRoleID()) {
            SelectDAO selectDao = new SelectPostgres(conn, user.getFirstName());
            CustomerController customerController = new CustomerController(cartDao, productDao, selectDao, orderDao, mainView, selectView, conn);
            customerController.run(user);
        } else {
            mainView.displayErrorWhileLoggingMessage();
        }
    }
}