package com.codecool.controllers;

import com.codecool.dao.PSQLUserDao;
import com.codecool.dao.UserDao;
import com.codecool.datasource.SQLDataSource;
import com.codecool.model.User;
import com.codecool.view.MainView;


public class RootController {

    SQLDataSource dataSource;
    MainView view;
    UserDao userDao;

    public RootController(SQLDataSource dataSource) {
        this.dataSource = dataSource;
        view = new MainView();
        userDao = new PSQLUserDao(dataSource);
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
                    isRegistered();
                    break;
                case 3:
                    isRunning = false;
            }
        }

    }

    public void createUserAccount() {
        User user = getUserData();
        if (userDao.addCustomerUser(user) == 1) {
            System.out.println("Your account has been created!");
        }
        view.pressEnterToContinue();
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

    public User getUserCredentials() {
        view.clearScreen();
        String[] fields = {"email", "password"};
        String[] answers = new String[fields.length];
        for (int i = 0; i < fields.length; i++) {
            System.out.printf("Please enter your %s: ", fields[i]);
            answers[i] = view.getStringInput();
        }
        return new User(answers[0], answers[1]);
     }

     public void isRegistered() {
        if (userDao.isRegistered(getUserCredentials())) {
            view.print("\nYou have successfully logged in");
        } else {
            view.print("\nIncorrect email or password");
        }

        view.pressEnterToContinue();
     }

}
