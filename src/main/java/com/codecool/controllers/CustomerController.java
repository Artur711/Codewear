package com.codecool.controllers;

import com.codecool.view.CartView;
import com.codecool.view.CustomerView;

public class CustomerController {

    CustomerView view;
    CartController cartController;

    public CustomerController() {

        view = new CustomerView();
        cartController = new CartController(6);
    }

    public void run() {
        view.clearScreen();
        boolean isRunning = true;

        while (isRunning) {

            view.clearScreen();
            view.CustomerMenu();
            int input = view.getIntegerInput();

            switch (input) {
                case 1:
                    cartController.run();
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
