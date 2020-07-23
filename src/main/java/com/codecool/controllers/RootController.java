
package com.codecool.controllers;

import com.codecool.dao.UserDao;
import com.codecool.model.User;
import com.codecool.select.SelectDAO;
import com.codecool.view.View;


public class RootController {

    private final View view;
    private final UserDao userDao;
    private final SelectDAO selectDao;

    public RootController(UserDao userDao, SelectDAO selectDao) {
        this.userDao = userDao;
        this.selectDao = selectDao;
        view = new View();
    }

    public void run() {
        view.clearScreen();
        boolean isRunning = true;

        while (isRunning) {

            view.clearScreen();
            view.displayMainMenu();
            int input = view.getIntegerInput();

            switch(input) {
                case 1:
                    createUserAccount();
                    break;
                case 2:
                    validateUser();
                    break;
                case 3:
                    customer.run();
                case 4:
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
        String[] fields = {"first name: ", "last name: ", "email: ", "password: "};
        String[] answers = new String[fields.length];
        for (int i = 0; i < fields.length; i++) {
            view.print(fields[i]);
            answers[i] = view.getStringInput();
        }
        return new User(answers[0], answers[1], answers[2], answers[3]);
    }

    public User getUserCredentials() {
        view.clearScreen();
        String[] fields = {"email", "password"};
        String[] answers = new String[fields.length];
        for (int i = 0; i < fields.length; i++) {
            System.out.printf("Enter your %s: ", fields[i]);
            answers[i] = view.getStringInput();
        }
        return new User(answers[0], answers[1]);
    }

    public void validateUser() {
        User user = userDao.validateUser(getUserCredentials());
        if (user != null && user.getRoleID() == 1) {
            new AdminController(view, userDao).run();
        } else if (user != null && user.getRoleID() == 3) {
            view.print("\n You have succesfully logged in");
            view.pressEnterToContinue();
        } else {
            view.print("\nIncorrect email or password\n");
            view.pressEnterToContinue();

        }

    }

}