package com.codecool.view;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CustomerView {

    private Scanner scanner = new Scanner(System.in);

    public void CustomerMenu() {
        String[] options = {"Search", "My cart", "Confirm cart", "My personal details", "Help", "Logout"};
        for (int i = 0; i < options.length; i++) {
            System.out.format("%d. %s\n", i + 1, options[i]);
        }
        System.out.print("\nChoose one of the options: ");
    }

    public int getIntegerInput() {
        int input = 0;
        try {
            input = scanner.nextInt();
            scanner.nextLine();
        } catch (InputMismatchException e) { scanner.next(); }
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

    public void orderMenu() {
        String[] options = {" "};
        for (int i = 0; i < options.length; i++) {
            System.out.format("%d. %s\n", i + 1, options[i]);
        }
    }
}
