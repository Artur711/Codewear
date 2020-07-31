
package com.codecool.controllers;

import com.codecool.dao.CartDao;
import com.codecool.dao.OrderDao;
import com.codecool.dao.ProductDao;
import com.codecool.dao.UserDao;
import com.codecool.enums.Role;

import com.codecool.model.User;
import com.codecool.select.SelectDAO;
import com.codecool.view.MainView;

import static com.diogonunes.jcolor.Ansi.colorize;


public class RootController {

    private final MainView mainView;
    private final UserDao userDao;
    private final ProductDao productDao;
    private final OrderDao orderDao;
    private final CustomerController customerController;

    public RootController(UserDao userDao, SelectDAO selectDao, CartDao cartDao, ProductDao productDao, OrderDao orderDao) {
        this.userDao = userDao;
        this.productDao = productDao;
        this.orderDao = orderDao;
        mainView = new MainView();
        customerController = new CustomerController(cartDao, productDao, selectDao, orderDao, mainView);

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

    public void createUserAccount() {
        User user = mainView.getUserData();
        if (userDao.addUser(user, Role.CUSTOMER.getRoleID()) == 1) {
            mainView.clearScreen();
            mainView.displayAccountCreationMessage();
        }
    }

    public void validateUser() {
        User user = userDao.validateUser(mainView.getUserCredentials());
        if (user != null && user.getRoleID() == Role.ADMIN.getRoleID()) {
            AdminController admin = new AdminController(user, mainView, userDao, productDao, orderDao);
            admin.run();
        } else if (user != null && user.getRoleID() == Role.CUSTOMER.getRoleID()) {
            System.out.print("\nYou have successfully logged in");
            mainView.pressEnterToContinue("");
            customerController.run(user);

        } else {
            mainView.displayErrorWhileLoggingMessage();

        }
    }
}