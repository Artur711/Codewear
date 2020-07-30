package com.codecool.controllers;

import com.codecool.dao.UserDao;
import com.codecool.enums.Role;
import com.codecool.enums.UserInfo;
import com.codecool.model.Manager;
import com.codecool.model.User;
import com.codecool.view.MainView;

import java.util.Random;

import static com.diogonunes.jcolor.Ansi.colorize;

public class UserManager extends Manager {

    private final UserDao userDao;

    public UserManager(User currentUser, MainView mainView, UserDao userDao) {
        super(currentUser, mainView);
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
                    delete();
                    break;
                case 3:
                    update();
                    break;
                case 4:
                    isRunning = false;
                    break;
                default:
                    System.out.println("There is no such choice");
            }

        }

    }

    @Override
    protected void delete() {
        mainView.println("Enter id of user to be removed:");
        User user = userDao.getUserWithUserID(mainView.getIntegerInput());
        if (user != null && user.getRoleID() != Role.ADMIN.getRoleID()) {
            System.out.printf("Current number of records: %d%n", userDao.getNumberOfRecords());
            System.out.printf("Are you sure you want to remove user: %s, %s? [Y/N]%n", user.getLastName(), user.getFirstName());
            if (mainView.getStringInput().equalsIgnoreCase("y")) {
                userDao.delete(user);
                mainView.println("\nUser has been removed from database");
                System.out.printf("%nCurrent number of records: %d%n", userDao.getNumberOfRecords());
                mainView.pressEnterToContinue("\nPress enter to go back");
            }
        } else {
            System.out.println("\nYou cannot delete this user or user doesn't exist\n");
        }

    }

    @Override
    protected void add() {
        User user = enterUserData();
        userDao.addUser(user, user.getRoleID());
        user = userDao.validateUser(user);
        System.out.println(colorize("\nUser has been created:\n", mainView.MENU_FORMAT));
        System.out.println(user);
        mainView.pressEnterToContinue(colorize("\nPress enter to go back", mainView.MENU_FORMAT));
    }

    @Override
    protected void update() {
        mainView.println("Enter id of user to be updated:");
        User user = userDao.getUserWithUserID(mainView.getIntegerInput());
        if (user == null) {
            System.out.println("\nUser not found in the database\n");
            return;
        }
        String firstName = mainView.readInput("FIRST_NAME (varchar, ", user.getFirstName());
        String lastName = mainView.readInput("LAST_NAME (varchar, ", user.getLastName());
        String email = mainView.readInput("EMAIL (varchar, ", user.getEmail());
        String password = mainView.readInput("PASSWORD (varchar, ", user.getPassword());
        String address = mainView.readInput("ADDRESS (varchar, ", user.getAddress());
        String roleID = mainView.readInput("ROLE_ID (2 - Employee, 3 - Customer, ", String.valueOf(user.getRoleID()));
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setEmail(email);
        user.setPassword(password);
        user.setAddress(address);
        user.setRoleID(Integer.parseInt(roleID));
        userDao.update(user);
        System.out.println("\nUser has been updated\n");
        System.out.println(userDao.getUserWithUserID(user.getId()));
        mainView.pressEnterToContinue("\nPress enter to go back");
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
        System.out.println(colorize("\n  Please enter user's " + field + "\n", mainView.HEADER_FORMAT));
        for (int i = 0; i < UserInfo.values().length - 1; i++) {
            System.out.println(new String[] {colorize("  FIRST_NAME (varchar)", mainView.MENU_FORMAT),
                                             colorize("  LAST_NAME (varchar)", mainView.MENU_FORMAT),
                                             colorize("  EMAIL (varchar)",mainView.MENU_FORMAT),
                                             colorize("  ROLE_ID (2 - Employee, 3 - Customer)",mainView.MENU_FORMAT) }[i] + ": " + answers[i]);
        }
        mainView.displayPrompt(9,3, currentUser.getFirstName());
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
