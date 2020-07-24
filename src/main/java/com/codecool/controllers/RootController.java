
package com.codecool.controllers;

import com.codecool.dao.UserDao;
import com.codecool.enums.Role;
import com.codecool.model.User;
import com.codecool.select.SelectDAO;
import com.codecool.view.MainView;


public class RootController {

    private final MainView mainView;
    private final UserDao userDao;
    private final SelectDAO selectDao;
    private final CustomerController customerController;

    public RootController(UserDao userDao, SelectDAO selectDao) {
        this.userDao = userDao;
        this.selectDao = selectDao;
        mainView = new MainView();
        customerController = new CustomerController();
    }

    public void run() {
        mainView.clearScreen();
        boolean isRunning = true;

        while (isRunning) {

            mainView.clearScreen();
            mainView.displayMainMenu();
            int input = mainView.getIntegerInput();

            switch(input) {
                case 1:
                    createUserAccount();
                    break;
                case 2:
                    validateUser();
                    break;
                case 3:
                    customerController.run();
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
        mainView.pressEnterToContinue();
    }

    public User getUserData() {
        mainView.clearScreen();
        System.out.println("Please enter your details:");
        String[] fields = {"first name: ", "last name: ", "email: ", "password: "};
        String[] answers = new String[fields.length];
        for (int i = 0; i < fields.length; i++) {
            mainView.print(fields[i]);
            answers[i] = mainView.getStringInput();
        }
        return new User(answers[0], answers[1], answers[2], answers[3]);
    }

    public User getUserCredentials() {
        mainView.clearScreen();
        String[] fields = {"email", "password"};
        String[] answers = new String[fields.length];
        for (int i = 0; i < fields.length; i++) {
            System.out.printf("Enter your %s: ", fields[i]);
            answers[i] = mainView.getStringInput();
        }
        return new User(answers[0], answers[1]);
    }

    public void validateUser() {
        User user = userDao.validateUser(getUserCredentials());
        if (user != null && user.getRoleID() == Role.ADMIN.getRoleID()) {
            new AdminController(mainView, userDao).run();
        } else if (user != null && user.getRoleID() == Role.CUSTOMER.getRoleID()) {
            mainView.print("\n You have succesfully logged in");
            mainView.pressEnterToContinue();
        } else {
            mainView.print("\nIncorrect email or password\n");
            mainView.pressEnterToContinue();

        }

    }

}