package com.codecool.controllers;

import com.codecool.view.CustomerView;


public class CustomerController {

    CustomerView view;

    public CustomerController() {
        view = new CustomerView();
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
                    break;
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
