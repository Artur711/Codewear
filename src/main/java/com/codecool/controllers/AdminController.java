package com.codecool.controllers;

import com.codecool.dao.OrderDao;
import com.codecool.dao.ProductDao;
import com.codecool.dao.UserDao;
import com.codecool.model.Order;
import com.codecool.model.User;
import com.codecool.view.MainView;

import java.util.List;


public class AdminController {

    private final User currentUser;
    private final MainView mainView;
    private final DatabaseManager dbmanager;
    private final OrderDao orderDao;


    public AdminController(User currentUser, MainView mainView, UserDao userDao, ProductDao productDAO, OrderDao orderDao) {
        this.currentUser = currentUser;
        this.mainView = mainView;
        this.orderDao = orderDao;
        this.dbmanager = new DatabaseManager(currentUser, mainView, userDao, productDAO);
    }

    public void run() {
        mainView.clearScreen();
        boolean isRunning = true;

        while (isRunning) {

            mainView.clearScreen();
            mainView.displayAdminMenu(currentUser);

            switch(mainView.getIntegerInput()) {
                case 1:
                    mainView.clearScreen();
                    dbmanager.run();
                    break;
                case 2:
                    showOrdersBYCustomerID();
                    break;
                case 3:
                    showPastDueDateOrders();
                    break;
                case 4:
                    isRunning = false;
                    break;

            }
        }
    }

    public void showOrdersBYCustomerID() {
        mainView.clearScreen();
        mainView.println("Enter customerID:");
        List<Order> orders = orderDao.showOrdersByCustomerID(mainView.getIntegerInput());
        mainView.displayOrders(orders);
        mainView.pressEnterToContinue("\nPress enter to go back");
    }

    public void showPastDueDateOrders() {
        mainView.clearScreen();
        List<Order> orders = orderDao.showPastDueDateOrders();
        mainView.displayOrders(orders);
        mainView.pressEnterToContinue("\nPress enter to go back");
    }
}
