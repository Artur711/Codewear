package com.codecool.view;

import java.util.Scanner;

public class View {

    private final Scanner scanner = new Scanner(System.in);

    public void displayMenu(String[] options) {
        for (int i = 0; i < options.length; i++) {
            System.out.format("%d. %s\n", i + 1, options[i]);
        }
        System.out.print("\nChoose one of the options: ");
    }

    public void displayMainMenu() {
        String[] options = {"Create an account", "Sign in", "Quit"};
        displayMenu(options);
    }

    public void displayAdminMenu() {
        String[] options = {"Add/Edit/Delete user", "Sign out"};
        print("Welcome to Admin dashboard\n");
        displayMenu(options);
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

    public void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public void pressEnterToContinue() {
        System.out.println("\nPress Enter key to go back to main menu...\n");
        scanner.nextLine();
    }


}
