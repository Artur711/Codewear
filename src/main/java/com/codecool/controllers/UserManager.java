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
        User user = users.get(0);
        if (user != null && user.getRoleID() != Role.ADMIN.getRoleID()) {
            mainView.clearScreen();
            System.out.printf("\n" + colorize("  Are you sure you want to remove user: %s, %s? [Y/N]%n",mainView.MENU_FORMAT), user.getLastName(), user.getFirstName());
            System.out.printf("\n" + colorize("  Current number of records: %d%n", mainView.HEADER_FORMAT), userDao.getNumberOfRecords());
            mainView.displayPrompt(6, 3, currentUser.getFirstName());
            if (mainView.getStringInput().equalsIgnoreCase("y")) {
                userDao.delete(user);
                System.out.println("\n" + colorize("  User has been removed from database", mainView.MENU_FORMAT));
                System.out.printf("\n" + colorize("  Current number of records: %d%n", mainView.HEADER_FORMAT), userDao.getNumberOfRecords());
                mainView.pressEnterToContinue("\n" + colorize("  Press enter to go back", mainView.MENU_FORMAT));
            }
        } else {
            System.out.println("\n" + colorize("  You cannot delete this user or user doesn't exist\n", mainView.MENU_FORMAT));
        }

    }

    @Override
    protected void add() {
        User user = enterUserData();
        userDao.addUser(user, user.getRoleID());
        user = userDao.validateUser(user);
        List<User> users = userDao.getUserWithUserID(user.getId());
        System.out.println("\n" + colorize("  User has been created:\n", mainView.MENU_FORMAT));
        mainView.displayUsersTable(users, userDao.findMaxNumberOfCharsPerColumn());
        mainView.pressEnterToContinue("\n" + colorize("  Press enter to go back", mainView.MENU_FORMAT));
    }

    @Override
    protected void update() {
        System.out.println("Enter id of user to be updated:");
        List<User> users = userDao.getUserWithUserID(mainView.getIntegerInput());
        if (users.size() == 0) {
            System.out.println("\nUser not found in the database\n");
            return;
        }
        User user = users.get(0);
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
        return new User(answers[0], answers[1], answers[2], autoGeneratePassword(), Integer.parseInt(answers[3]));
    }

    public void displayUserCreationScreen(String field, String[] answers) {
        mainView.clearScreen();
        System.out.println(colorize("\n  Please enter user's " + field + "\n", mainView.HEADER_FORMAT));
        for (int i = 0; i < UserInfo.values().length - 1; i++) {
            System.out.println(new String[] {colorize("  FIRST_NAME (varchar)", mainView.MENU_FORMAT),
                                             colorize("  LAST_NAME (varchar)", mainView.MENU_FORMAT),
                                             colorize("  LOGIN/EMAIL (varchar)",mainView.MENU_FORMAT),
                                             colorize("  ROLE_ID (int) [2 - Employee, 3 - Customer]",mainView.MENU_FORMAT) }[i] + ": " + colorize(answers[i], mainView.HEADER_FORMAT));
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
