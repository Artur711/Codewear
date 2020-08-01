package com.codecool.controllers;

import com.codecool.dao.UserDao;
import com.codecool.enums.Role;
import com.codecool.enums.UserInfo;
import com.codecool.model.Manager;
import com.codecool.model.User;
import com.codecool.view.MainView;

import java.util.List;
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
        mainView.clearScreen();
        System.out.println("\n" + colorize("  Enter id of user to be removed:", mainView.HEADER_FORMAT));
        mainView.displayPrompt(4, 3, currentUser.getFirstName());
        List<User> users = userDao.getUserWithUserID(mainView.getIntegerInput());
        if (users.size() == 0) {
            System.out.println("\n" + colorize("  You cannot delete this user or user doesn't exist", mainView.MENU_FORMAT));
            mainView.pressEnterToContinue("  Press enter to go back");
            return;
        }

        User user = users.get(0);
        if (user != null && user.getRoleID() != Role.ADMIN.getRoleID()) {
            mainView.clearScreen();
            mainView.displayConfirmationRequestMessage(user.getFirstName(), user.getLastName(), userDao.getNumberOfRecords());
            mainView.displayPrompt(6, 3, currentUser.getFirstName());
            if (mainView.getStringInput().equalsIgnoreCase("y")) {
                userDao.delete(user);
                mainView.displayRemovalMessage("User", userDao.getNumberOfRecords());
                mainView.pressEnterToContinue("  Press enter to go back");
            }
        }
    }

    @Override
    protected void add() {
        User user = enterUserData();
        if (user != null) {
            userDao.addUser(user, user.getRoleID());
            user = userDao.validateUser(user);
            List<User> users = userDao.getUserWithUserID(user.getId());
            System.out.println("\n" + colorize("  User has been created:\n", mainView.MENU_FORMAT));
            mainView.displayUsersTable(users, userDao.findMaxNumberOfCharsPerColumn());
            mainView.pressEnterToContinue("  Press enter to go back");
        }

    }

    @Override
    protected void update() {
        mainView.clearScreen();
        System.out.println("\n" + colorize("  Enter id of user to be updated:", mainView.HEADER_FORMAT));
        mainView.displayPrompt(4, 3, currentUser.getFirstName());
        List<User> users = userDao.getUserWithUserID(mainView.getIntegerInput());
        if (users.size() == 0) {
            System.out.println("\n" + colorize("  User not found in the database", mainView.MENU_FORMAT));
            mainView.pressEnterToContinue("  Press enter to go back");
            return;
        }
        User user = users.get(0);
        System.out.println();
        String firstName = mainView.readInput("FIRST_NAME (varchar(255), ", user.getFirstName(), currentUser);
        String lastName = mainView.readInput("LAST_NAME (varchar(255), ", user.getLastName(), currentUser);
        String email = mainView.readInput("EMAIL (varchar(255), ", user.getEmail(), currentUser);
        String password = mainView.readInput("PASSWORD (varchar(255), ", user.getPassword(), currentUser);
        String roleID = mainView.readInput("ROLE_ID (int) (2 - Employee, 3 - Customer, ", String.valueOf(user.getRoleID()), currentUser);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setEmail(email);
        user.setPassword(password);
        user.setRoleID(Integer.parseInt(roleID));
        userDao.update(user);
        System.out.println("\n" + colorize("  User has been updated", mainView.HEADER_FORMAT));
        mainView.displayUsersTable(users, userDao.findMaxNumberOfCharsPerColumn());
        mainView.pressEnterToContinue("  Press enter to go back");
    }

    private User enterUserData() {
        String[] answers = new String[] {"", "", "", ""};
        String[] fields = {
                UserInfo.FIRST_NAME.getDisplay(),
                UserInfo.LAST_NAME.getDisplay(),
                UserInfo.EMAIL.getDisplay(),
                UserInfo.ROLE.getDisplay(),
                };

        for (int i = 0; i < fields.length ; i++) {
            displayUserCreationScreen(fields[i], answers);
            answers[i] = mainView.getStringInput();
        }
        try {
            return new User(answers[0], answers[1], answers[2], autoGeneratePassword(), Integer.parseInt(answers[3]));
        } catch (NumberFormatException e) {
            System.out.println("\n" + colorize("  Wrong data type. " + e.getMessage(), mainView.MENU_FORMAT));
            mainView.pressEnterToContinue("  Press enter to go back");
        }
        return null;
    }

    private void displayUserCreationScreen(String field, String[] answers) {
        mainView.clearScreen();
        System.out.println(colorize("\n  Please enter user's " + field + "\n", mainView.HEADER_FORMAT));
        for (int i = 0; i < UserInfo.values().length - 1; i++) {
            System.out.println(new String[] {colorize("  FIRST_NAME varchar(255)", mainView.MENU_FORMAT),
                                             colorize("  LAST_NAME varchar(255)", mainView.MENU_FORMAT),
                                             colorize("  LOGIN/EMAIL varchar(255)", mainView.MENU_FORMAT),
                                             colorize("  ROLE_ID int (2 - Employee, 3 - Customer)", mainView.MENU_FORMAT) }[i] + ": " + colorize(answers[i], mainView.HEADER_FORMAT));
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
