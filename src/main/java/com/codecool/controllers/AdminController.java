package com.codecool.controllers;

import com.codecool.dao.UserDao;
import com.codecool.view.View;


public class AdminController {

    private final View view;
    private final UserDao userDao;

    public AdminController(View view, UserDao userDao) {
        this.view = view;
        this.userDao = userDao;
    }

    public void run() {
        view.clearScreen();
        boolean isRunning = true;

        while (isRunning) {

            view.clearScreen();
            view.displayAdminMenu();
            int input = view.getIntegerInput();

            switch(input) {
                case 1:
                    //do something
                    break;
                case 2:
                    isRunning = false;
                    break;


            }

        }
    }
}
