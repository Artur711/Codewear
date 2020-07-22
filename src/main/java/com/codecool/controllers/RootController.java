package com.codecool.controllers;

import com.codecool.dao.PSQLUserDAO;
import com.codecool.dao.UserDAO;
import com.codecool.datasource.SQLDataSource;
import com.codecool.model.User;
import com.codecool.view.MainView;


public class RootController {

    SQLDataSource dataSource;
    MainView view;
    UserDAO userDao;

    public RootController(SQLDataSource dataSource) {
        this.dataSource = dataSource;
        view = new MainView();
        userDao = new PSQLUserDAO(dataSource);
    }

    public void run() {
        view.clearScreen();
        boolean isRunning = true;

        while (isRunning) {

            view.clearScreen();
            view.mainMenu();
            int input = view.getIntegerInput();

            switch(input) {
                case 1:
                    createUserAccount();
                    break;
                case 2:
                    //do something
                    break;
                case 3:
                    isRunning = false;
            }
        }

    }

    public void createUserAccount() {
        userDao.addCustomerUser(getUserData());
    }

    public User getUserData() {
        view.clearScreen();
        System.out.println("Please enter your details:");
        String[] fields = {"first name: ", "last name: ", "email: ", "password: ", "address: "};
        String[] answers = new String[fields.length];
        for (int i = 0; i < fields.length; i++) {
            view.print(fields[i]);
            answers[i] = view.getStringInput();
        }
        return new User(answers[0], answers[1], answers[2], answers[3], answers[4]);
    }

}
