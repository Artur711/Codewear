package com.codecool.view;
import com.diogonunes.jcolor.AnsiFormat;
import com.diogonunes.jcolor.Attribute;
import java.util.Scanner;

import static com.diogonunes.jcolor.Ansi.colorize;
import static com.diogonunes.jcolor.Attribute.*;
import static com.diogonunes.jcolor.Attribute.RED_BACK;

public class View {

    private final Scanner scanner = new Scanner(System.in);
    private final String HEADER = "  W E L C O M E  T O  C O D E W E A R  ";

    private final AnsiFormat HEADER_FORMAT = new AnsiFormat(BOLD(), BRIGHT_YELLOW_TEXT(), RED_BACK());
    private final AnsiFormat MENU_FORMAT = new AnsiFormat(BOLD(), BLACK_TEXT(), RED_BACK());

    public void displayMenu(String[] options) {
        for (int i = 0; i < options.length; i++) {
            System.out.printf(colorize("  %d. %s", MENU_FORMAT ), i + 1, options[i]);
            System.out.print(colorize(" ".repeat(HEADER.length() - options[i].length() - 5), MENU_FORMAT));
            System.out.println();
        }
        drawLine(HEADER, RED_BACK());
    }

    public void displayMainMenu() {
        drawLine(HEADER, RED_BACK());
        System.out.println(colorize(HEADER, HEADER_FORMAT));
        drawLine(HEADER, RED_BACK());
        String[] options = {"Create an account", "Sign in", "Quit"};
        displayMenu(options);
    }

    public void displayAdminMenu() {
        String[] options = {"Add/Edit/Delete user", "Sign out"};
        print("Welcome to Admin dashboard\n");
        displayMenu(options);
    }

    public void drawLine(String text, Attribute color) {
        for (int i = 0; i < text.length(); i++) {
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

    public void pressEnterToContinue() {
        System.out.println("\nPress Enter key to go back to main menu...\n");
        scanner.nextLine();
    }


}
