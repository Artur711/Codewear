package com.codecool.view;

import java.util.Scanner;

public class MainView {

    private final Scanner scanner = new Scanner(System.in);

    public void mainMenu() {
        String[] options = {"Create an account", "Sign in", "Quit"};
        for (int i = 0; i < options.length; i++) {
            System.out.format("%d. %s\n", i + 1, options[i]);
        }
        System.out.print("\nChoose one of the options: ");
    }

    public int getIntegerInput() {
        return scanner.nextInt();

    }

    public String getStringInput() {
        return scanner.next();
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

    public void handleNewLine() {
        scanner.nextLine();
    }
}
