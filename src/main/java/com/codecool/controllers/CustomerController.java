package com.codecool.controllers;

import com.codecool.view.CustomerView;

import java.sql.Connection;

public class CustomerController {

    CustomerView view;
    RootController root;


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
                    view.clearScreen();
                    view.CustomerHelp();
                case 4:
                    break;
            }
        }
    }
}
