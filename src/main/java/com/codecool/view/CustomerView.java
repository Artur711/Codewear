package com.codecool.view;

import java.util.Scanner;

public class CustomerView {

    private Scanner scanner = new Scanner(System.in);

    public void CustomerMenu() {
        String[] options = {"My orders", "Manage account", "Help", "Back to Main Menu"};
        for (int i = 0; i < options.length; i++) {
            System.out.format("%d. %s\n", i + 1, options[i]);
        }
        System.out.print("\nChoose one of the options: ");
    }

    public int getIntegerInput() {
        int input = scanner.nextInt();
        scanner.nextLine();
        return input;
    }

    public void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public void CustomerHelp() {
        String[] options = {" "};
        for (int i = 0; i < options.length; i++) {
            System.out.format("%d. %s\n", i + 1, options[i]);
        }
    }

}
