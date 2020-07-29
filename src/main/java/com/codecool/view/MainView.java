package com.codecool.view;
import com.codecool.enums.UserInfo;
import com.codecool.model.User;
import com.diogonunes.jcolor.AnsiFormat;
import com.diogonunes.jcolor.Attribute;

import java.lang.reflect.Member;
import java.util.Scanner;

import static com.diogonunes.jcolor.Ansi.colorize;
import static com.diogonunes.jcolor.Attribute.*;

public class MainView {

    private final Scanner scanner = new Scanner(System.in);
    private final String[] fields = {UserInfo.FIRST_NAME.getDisplay(),
                                     UserInfo.LAST_NAME.getDisplay(),
                                     UserInfo.EMAIL.getDisplay(),
                                     UserInfo.PASSWORD.getDisplay()};

    public void displayMenuOptions(String[] options) {
        for (int i = 0; i < options.length; i++) {
            System.out.format("%d. %s%n", (i + 1), options[i]);
        }
    }

    public void displayMainMenu() {
        System.out.println("W E L C O M E  T O  C O D E W E A R  \n");
        String[] options = {"Create an account", "Sign in", "Quit"};
        displayMenuOptions(options);
    }

    public void displayAdminMenu() {
        String[] options = {"Database management", "Sign out"};
        print("Welcome to Admin dashboard\n");
        displayMenuOptions(options);
    }

    public int getIntegerInput() {
        int input = scanner.nextInt();
        scanner.nextLine();
        return input;
    }

    public String getStringInput() {
        return scanner.nextLine();
    }

    public void print(String message) {
        System.out.print(message);
    }

    public void println(String message) {
        System.out.println(message);
    }


    public void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public void pressEnterToContinue(String prompt) {
        System.out.println(prompt);
        scanner.nextLine();
    }

    public User getUserData() {
        String[] answers = new String[] {"", "", "", ""};
        String[] fields = {"last name", "email", "password", "password"};

        displayRegistrationScreen(UserInfo.FIRST_NAME.getDisplay(), answers);
        for (int i = 0; i < fields.length ; i++) {
            answers[i] = getStringInput();
            displayRegistrationScreen(fields[i], answers);

        }
        return new User(answers[0], answers[1], answers[2], answers[3]);
    }

    public void displayRegistrationScreen(String field, String[] answers) {
        clearScreen();
        System.out.println("Please enter your " + field);
        for (int i = 0; i < fields.length; i++) {
            System.out.println(fields[i].toUpperCase() + ": " + answers[i]);
        }

    }

    public void displayLoginScreen(String field, String[] answers) {
        clearScreen();
        String[] credentials = {UserInfo.EMAIL.getDisplay(), UserInfo.PASSWORD.getDisplay()};
        System.out.println("Please enter your " + field);
        for (int i = 0; i < answers.length; i++) {
            System.out.println(credentials[i] + ": " + answers[i]);
        }
    }

    public User getUserCredentials() {
        String[] credentials = {UserInfo.PASSWORD.getDisplay(), UserInfo.PASSWORD.getDisplay()};
        String[] answers = new String[] {"", ""};
        displayLoginScreen(UserInfo.EMAIL.getDisplay(), answers);
        for (int i = 0; i < credentials.length ; i++) {
            answers[i] = getStringInput();
            displayLoginScreen(credentials[i], answers);

        }
        return new User(answers[0], answers[1]);
    }

    public void displayAccountCreationMessage() {
        System.out.print("\nYour account has been created!\n");
        pressEnterToContinue("\nPress enter to return to main menu");

    }

    public void displayErrorWhileLoggingMessage() {
        System.out.print("\nIncorrect email or password\n");
        pressEnterToContinue("\nPress enter to return to main menu");
    }

    public String readInput(String prompt, String defaultValue) {
        showPrompt(prompt, defaultValue);
        String input = scanner.nextLine();
        return input.isEmpty() ? defaultValue : input;
    }

    private void showPrompt(String prompt, Object defaultValue) {
        System.out.print(prompt + " (current value -> " + defaultValue + "): ");
    }
}
