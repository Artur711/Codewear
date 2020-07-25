package com.codecool.controllers;

import com.codecool.dao.UserDao;
import com.codecool.view.MainView;


public class AdminController {

    private final MainView mainView;
    private final UserDao userDao;

    public AdminController(MainView mainView, UserDao userDao) {
        this.mainView = mainView;
        this.userDao = userDao;
    }

    public void run() {
        mainView.clearScreen();
        boolean isRunning = true;

        while (isRunning) {

            mainView.clearScreen();
            mainView.displayAdminMenu();
            int input = mainView.getIntegerInput();

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
