package com.codecool.controllers;

import com.codecool.dao.CartDao;
import com.codecool.dao.TableProductsDAO;
import com.codecool.model.User;
import com.codecool.view.CustomerView;

public class CustomerController {

    CustomerView view;
    CartController cartController;


    public CustomerController(CartDao cartDao, TableProductsDAO tableProductsDAO) {

        view = new CustomerView();
        cartController = new CartController(cartDao, tableProductsDAO);
    }

    public void run(User user) {
        view.clearScreen();
        boolean isRunning = true;

        while (isRunning) {

            view.clearScreen();
            view.CustomerMenu();
            int input = view.getIntegerInput();

            switch (input) {
                case 1:
                    cartController.run(user);
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    view.clearScreen();
                    view.CustomerHelp();
                case 5:
                    break;
            }
        }
    }
}
