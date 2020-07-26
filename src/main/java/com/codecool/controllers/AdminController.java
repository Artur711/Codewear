package com.codecool.controllers;

import com.codecool.dao.UserDao;
import com.codecool.view.MainView;


public class AdminController {

    private final MainView mainView;
    private final UserDao userDao;
    private final DatabaseManager dbmanager;

    public AdminController(MainView mainView, UserDao userDao) {
        this.mainView = mainView;
        this.userDao = userDao;
        this.dbmanager = new DatabaseManager(mainView, userDao);
    }

    public void run() {
        mainView.clearScreen();
        boolean isRunning = true;

        while (isRunning) {

            mainView.clearScreen();
            mainView.displayAdminMenu();

            switch(mainView.getIntegerInput()) {
                case 1:
                    mainView.clearScreen();
                    dbmanager.run();
                    break;
                case 2:
                    isRunning = false;
                    break;


            }

        }
    }
}
