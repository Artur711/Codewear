package com.codecool.view;
import com.codecool.model.User;
import com.diogonunes.jcolor.AnsiFormat;
import com.diogonunes.jcolor.Attribute;

import java.lang.reflect.Member;
import java.util.Scanner;

import static com.diogonunes.jcolor.Ansi.colorize;
import static com.diogonunes.jcolor.Attribute.*;

public class MainView {

    private final Scanner scanner = new Scanner(System.in);
    private final int MENU_WIDTH = 39;
    private final AnsiFormat HEADER_FORMAT = new AnsiFormat(BOLD(), BRIGHT_YELLOW_TEXT(), RED_BACK());
    private final AnsiFormat MENU_FORMAT = new AnsiFormat(BOLD(), BLACK_TEXT(), RED_BACK());

    public void displayMenuOptions(String[] options) {
        for (int i = 0; i < options.length; i++) {
            System.out.printf(colorize("  %d. %s", MENU_FORMAT ), i + 1, options[i]);
            System.out.print(colorize(" ".repeat(MENU_WIDTH - options[i].length() - 5), MENU_FORMAT));
            System.out.println();
        }
        drawLine(MENU_WIDTH, RED_BACK());
    }

    public void displayMainMenu() {
        drawLine(MENU_WIDTH, RED_BACK());
        System.out.println(colorize("  W E L C O M E  T O  C O D E W E A R  ", HEADER_FORMAT));
        drawLine(MENU_WIDTH, RED_BACK());
        String[] options = {"Create an account", "Sign in", "Quit"};
        displayMenuOptions(options);
    }

    public void displayAdminMenu() {
        String[] options = {"Add/Edit/Delete user", "Sign out"};
        print("Welcome to Admin dashboard\n");
        displayMenuOptions(options);
    }

    public void drawLine(int width, Attribute color) {
        for (int i = 0; i < width; i++) {
            System.out.print(colorize(" ", color));
        }
        System.out.println();
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
        System.out.print(colorize(prompt, HEADER_FORMAT));
        System.out.println(colorize(" ".repeat(MENU_WIDTH - prompt.length()), MENU_FORMAT));
        scanner.nextLine();
    }

    public User getUserData() {

        String[] fields = {"first name: ", "last name: ", "email: ", "password: "};
        String[] answers = new String[fields.length];
        displayRegistrationScreen(fields[0], "", "", "", "");
        for (int i = 0; i < fields.length; i++) {
            answers[i] = getStringInput();

            switch(i) {
                case 0:
                    displayRegistrationScreen(fields[i + 1], answers[i], "", "", "");
                    break;
                case 1:
                    displayRegistrationScreen(fields[i + 1], answers[i - 1], answers[i], "", "");
                    break;
                case 2:
                    displayRegistrationScreen(fields[i + 1], answers[i - 2], answers[i - 1], answers[i], "");
                    break;
                case 3:
                    displayRegistrationScreen(fields[i], answers[i - 3], answers[i - 2], answers[i - 1], answers[i]);
            }

        }
        return new User(answers[0], answers[1], answers[2], answers[3]);
    }

    public void displayRegistrationScreen(String field, String firstName, String lastName, String email, String password) {
        clearScreen();
        drawLine(MENU_WIDTH, RED_BACK());
        String prompt = "  Please enter your " + field;
        System.out.print(colorize(prompt, HEADER_FORMAT));
        System.out.println(colorize(" ".repeat(MENU_WIDTH - prompt.length()), MENU_FORMAT));
        prompt = "  first name: " + firstName;
        System.out.print(colorize(prompt, MENU_FORMAT));
        System.out.println(colorize(" ".repeat(MENU_WIDTH - prompt.length()), MENU_FORMAT));
        prompt = "  last Name: " + lastName;
        System.out.print(colorize(prompt, MENU_FORMAT));
        System.out.println(colorize(" ".repeat(MENU_WIDTH - prompt.length()), MENU_FORMAT));
        prompt = "  email: " + email;
        System.out.print(colorize(prompt, MENU_FORMAT));
        System.out.println(colorize(" ".repeat(MENU_WIDTH - prompt.length()), MENU_FORMAT));
        prompt = "  password: " + maskPassword((password));
        System.out.print(colorize(prompt, MENU_FORMAT));
        System.out.println(colorize(" ".repeat(MENU_WIDTH - prompt.length()), MENU_FORMAT));
        drawLine(MENU_WIDTH, RED_BACK());
    }

    public String maskPassword(String password) {
        return "*".repeat(password.length());
    }

    public User getUserCredentials() {
        clearScreen();
        String[] fields = {"email", "password"};
        String[] answers = new String[fields.length];
        for (int i = 0; i < fields.length; i++) {
            System.out.printf("Enter your %s: ", fields[i]);
            answers[i] = getStringInput();
        }
        return new User(answers[0], answers[1]);
    }

    public void displayAccountCreationMessage() {
        String text = "  Your account has been created!";
        System.out.print(colorize(text, HEADER_FORMAT));
        System.out.println(colorize(" ".repeat(MENU_WIDTH - text.length()), MENU_FORMAT));
        drawLine(MENU_WIDTH, RED_BACK());
        pressEnterToContinue("  Press enter to return to main menu");

    }

}
