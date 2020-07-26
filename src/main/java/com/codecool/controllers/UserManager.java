package com.codecool.controllers;

import com.codecool.dao.UserDao;
import com.codecool.enums.UserInfo;
import com.codecool.model.Manager;
import com.codecool.model.User;
import com.codecool.view.MainView;

import java.util.Random;

public class UserManager extends Manager {

    UserDao userDao;


    public UserManager(MainView mainView, UserDao userDao) {
        super(mainView);
        this.userDao = userDao;
    }

    @Override
    protected void run() {
        boolean isRunning = true;

        while (isRunning) {
            mainView.clearScreen();
            showAvailableOptions();

            switch(mainView.getIntegerInput()) {
                case 1:
                    add();
                    break;
                case 2:
                    //do something
                    break;
                case 3:
                    //do something
                    break;
                case 4:
                    isRunning = false;
                    break;

            }

        }


    }

    @Override
    protected void delete() {

    }

    @Override
    protected void add() {
        User user = enterUserData();
        if (user.getRoleID() == 3) {
            userDao.addCustomerUser(user);
        } else {
            userDao.addOtherUser(user);
        }

        user = userDao.validateUser(user);
        System.out.println("\nUser has been created:\n");
        System.out.println(user);
        mainView.pressEnterToContinue("\nPress enter to go back");
    }

    @Override
    protected void update() {

    }

    public User enterUserData() {
        String[] answers = new String[] {"", "", "", ""};
        String[] fields = {UserInfo.LAST_NAME.getDisplay(),
                UserInfo.EMAIL.getDisplay(),
                UserInfo.ROLE.getDisplay(),
                UserInfo.ROLE.getDisplay()};

        displayUserCreationScreen(UserInfo.FIRST_NAME.getDisplay(), answers);
        for (int i = 0; i < fields.length ; i++) {
            answers[i] = mainView.getStringInput();
            displayUserCreationScreen(fields[i], answers);

        }
        return new User(answers[0], answers[1], answers[2], autoGeneratePassword(), Integer.parseInt(answers[3]));
    }

    public void displayUserCreationScreen(String field, String[] answers) {
        mainView.clearScreen();
        System.out.println("Please enter user's " + field);
        for (int i = 0; i < UserInfo.values().length - 1; i++) {
            System.out.println(new String[] {"FIRST_NAME", "LAST_NAME", "EMAIL", "ROLEID" } [i] + ": " + answers[i]);
        }

    }

    private String autoGeneratePassword() {
        final String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        int passwordLength = 10;
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < passwordLength; i++) {
            int randomIndex = random.nextInt(chars.length());
            sb.append(chars.charAt(randomIndex));
        }
        return sb.toString();
    }

}
