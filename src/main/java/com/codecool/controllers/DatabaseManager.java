package com.codecool.controllers;

import com.codecool.dao.UserDao;
import com.codecool.view.MainView;

public class DatabaseManager {

    private final MainView mainView;
    private final UserDao userDao;
    private final ProductManager productManager;
    private final UserManager userManager;

    public DatabaseManager(MainView mainView, UserDao userDao) {
        this.mainView = mainView;
        this.userDao = userDao;
        this.productManager = new ProductManager(mainView);
        this.userManager = new UserManager(mainView, userDao);
    }

    protected void run() {
        boolean isRunning = true;

        while(isRunning) {
            mainView.clearScreen();
            listAvailableOptions();

            switch(mainView.getIntegerInput()) {
                case 1:
                    userManager.run();
                    break;
                case 2:
                    // do something
                    break;
                case 3:
                    isRunning = false;
                    break;


            }


        }

    }


    protected void listAvailableOptions() {
        String[] options = {"Users", "Products", "Go back"};
        mainView.println("Choose table to perform action or go back to previous menu");
        mainView.displayMenuOptions(options);
    }

    protected int chooseTable() {
        return mainView.getIntegerInput();
    }

    protected String chooseAction() {
        return mainView.getStringInput();
    }

}