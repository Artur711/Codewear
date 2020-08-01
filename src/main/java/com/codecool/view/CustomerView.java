package com.codecool.view;

import com.diogonunes.jcolor.AnsiFormat;

import java.util.InputMismatchException;
import java.util.Scanner;

import static com.diogonunes.jcolor.Ansi.colorize;
import static com.diogonunes.jcolor.Attribute.*;

public class CustomerView {

    private Scanner scanner = new Scanner(System.in);

    public final AnsiFormat HEADER_FORMAT = new AnsiFormat(BOLD(), BRIGHT_YELLOW_TEXT());
    public final AnsiFormat MENU_FORMAT = new AnsiFormat(BOLD(), WHITE_TEXT());
    public final AnsiFormat PROMPT_FORMAT = new AnsiFormat(BOLD(), BLUE_TEXT());

    public void CustomerMenu() {
        String[] options = {"Search", "My cart", "Confirm cart", "My personal details", "Help", "Logout"};
        for (int i = 0; i < options.length; i++) {
            System.out.format(colorize("%d. %s\n", MENU_FORMAT), i + 1, options[i]);
        }
        System.out.print(colorize("\nChoose one of the options: ", PROMPT_FORMAT));
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
        String[] options = {"If you need any help, don't hesitate and contact us codewear@codecool.com.", "Products overview is available after registration.", "Orders are execute in maximum 30 days. \n"};
        System.out.println(colorize("Help", HEADER_FORMAT));
        for (int i = 0; i < options.length; i++) {
            System.out.format(colorize("%d. %s\n", MENU_FORMAT), i + 1, options[i]);
        }
    }

    public void orderMenu() {
        String[] options = {" "};
        for (int i = 0; i < options.length; i++) {
            System.out.format("%d. %s\n", i + 1, options[i]);
        }
    }
}
