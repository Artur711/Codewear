package com.codecool.controllers;

import com.codecool.dao.ProductDao;
import com.codecool.dao.UserDao;
import com.codecool.view.MainView;


public class AdminController {

    private final MainView mainView;
    private final DatabaseManager dbmanager;

    public AdminController(MainView mainView, UserDao userDao, ProductDao productDAO) {
        this.mainView = mainView;
        this.dbmanager = new DatabaseManager(mainView, userDao, productDAO);
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
