
package com.codecool.view;

import com.codecool.enums.UserInfo;
import com.codecool.model.Order;
import com.codecool.model.User;
import com.diogonunes.jcolor.AnsiFormat;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import static com.diogonunes.jcolor.Ansi.colorize;
import static com.diogonunes.jcolor.Attribute.*;

public class MainView {

    private final Scanner scanner = new Scanner(System.in);
    private final String[] fields = {UserInfo.FIRST_NAME.getDisplay(),
            UserInfo.LAST_NAME.getDisplay(),
            UserInfo.EMAIL.getDisplay(),
            UserInfo.PASSWORD.getDisplay()};

    public final AnsiFormat HEADER_FORMAT = new AnsiFormat(BOLD(), BRIGHT_YELLOW_TEXT());
    public final AnsiFormat MENU_FORMAT = new AnsiFormat(BOLD(), WHITE_TEXT());
    public final AnsiFormat PROMPT_FORMAT = new AnsiFormat(BOLD(), BLUE_TEXT());

    public void displayMenuOptions(String[] options) {
        for (int i = 0; i < options.length; i++) {
            System.out.printf(colorize("  %d. %s", MENU_FORMAT ), i + 1, options[i]);
            System.out.println();
        }
    }

    public void displayMainMenu() {
        System.out.println(colorize("\n  W E L C O M E  T O  C O D E W E A R  \n", HEADER_FORMAT));
        String[] options = {"Create an account", "Sign in", "Quit"};
        displayMenuOptions(options);
        displayPrompt(8, 3, "Guest");
    }

    public void displayAdminMenu(User user) {
        String[] options = {"Database management", "Show all orders by customer", "Show past due orders", "Sign out"};
        System.out.println(colorize("\n  W E L C O M E  T O  A D M I N  D A S H B O A R D\n", HEADER_FORMAT));
        displayMenuOptions(options);
        displayPrompt(9, 3, user.getFirstName());
    }

    public void displayPrompt(int verticalOffset, int horizontalOffset, String owner) {
        System.out.print(colorize("\033["+verticalOffset+";" + horizontalOffset + "H" + owner + ":$ ", PROMPT_FORMAT));
    }


    public int getIntegerInput() {
        int input = 0;

        try {
            input = scanner.nextInt();
            scanner.nextLine();
        } catch (InputMismatchException e) {
            scanner.next();
        }
        return input;
    }

    public String getStringInput() {
        return scanner.nextLine();
    }

    public void displayOrders(List<Order> orders) {
        for (Order order : orders) {
            System.out.println(order);
        }
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
        System.out.println("\n  Please enter your " + field);
        for (int i = 0; i < fields.length; i++) {
            System.out.println(fields[i].toUpperCase() + ": " + answers[i]);
        }

    }

    public void displayLoginScreen(String field, String[] answers) {
        clearScreen();
        String[] credentials = {UserInfo.EMAIL.getDisplay(), UserInfo.PASSWORD.getDisplay()};
        System.out.println();
        System.out.println(colorize("  Please enter your " + field, HEADER_FORMAT));
        System.out.println();
        for (int i = 0; i < answers.length; i++) {
            System.out.println(colorize("  " + credentials[i].toUpperCase() + ": ", MENU_FORMAT) + colorize(answers[i], HEADER_FORMAT));
        }
        displayPrompt(7, 3, "Guest");
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
        System.out.println("\nIncorrect email or password\n");
        pressEnterToContinue("\nPress enter to return to main menu");
    }

    public String readInput(String prompt, String defaultValue) {
        showPrompt(prompt, defaultValue);
        String input = scanner.nextLine();
        return input.isEmpty() ? defaultValue : input;
    }

    private void showPrompt(String prompt, String defaultValue) {
        System.out.print(prompt + "current value -> " + defaultValue + "): ");
    }
}