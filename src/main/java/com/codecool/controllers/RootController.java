
package com.codecool.controllers;

import com.codecool.dao.CartDao;
import com.codecool.dao.OrderDao;
import com.codecool.dao.ProductDao;
import com.codecool.dao.UserDao;
import com.codecool.enums.Role;

import com.codecool.model.User;
import com.codecool.select.SelectDAO;
import com.codecool.view.MainView;


public class RootController {

    private final MainView mainView;
    private final UserDao userDao;
    private final CustomerController customerController;
    private final AdminController adminController;


    public RootController(UserDao userDao, SelectDAO selectDao, CartDao cartDao, ProductDao productDao, OrderDao orderDao) {
        this.userDao = userDao;
        mainView = new MainView();
        customerController = new CustomerController(cartDao, productDao, selectDao);
        adminController = new AdminController(mainView, userDao, productDao, orderDao);
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
                default:
            }
        }

    }

    public void createUserAccount() {
        User user = mainView.getUserData();
        if (userDao.addUser(user, Role.CUSTOMER.getRoleID()) == 1) {
            mainView.displayAccountCreationMessage();
        }
    }

    public void validateUser() {
        User user = userDao.validateUser(mainView.getUserCredentials());
        if (user != null && user.getRoleID() == Role.ADMIN.getRoleID()) {
            adminController.run();
        } else if (user != null && user.getRoleID() == Role.CUSTOMER.getRoleID()) {
            mainView.print("\nYou have successfully logged in");
            mainView.pressEnterToContinue("");
            customerController.run(user);

        } else {
            mainView.displayErrorWhileLoggingMessage();

        }
    }
}