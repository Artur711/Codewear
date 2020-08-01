package com.codecool.view;

import com.codecool.model.User;

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

    public void CustomerMenu(User user, MainView mainView) {
        System.out.println("\n" + colorize("  Welcome, " + user.getFirstName() + "!", mainView.HEADER_FORMAT));
        System.out.println(" ");
        String[] options = {"Search", "My cart", "Confirm cart", "Personal details", "Update personal details", "My orders", "Help", "Logout"};
        for (int i = 0; i < options.length; i++) {
            System.out.format(colorize("  %d. %s\n", MENU_FORMAT), i + 1, options[i]);
        }
        System.out.println(" ");
        mainView.displayPrompt(13, 3, user.getFirstName());
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

    public void CustomerHelp(MainView mainView) {
        String[] options = {"If you need any help, don't hesitate and contact us codewear@codecool.com.", "Products overview is available after registration.", "You can add your address in |Update personal details|", "For all orders payment policy is: Pay on Arrival", "Orders are execute in maximum 30 days. \n"};
        System.out.println("\n" + colorize("  Help:", HEADER_FORMAT));
        System.out.println(" ");
        for (int i = 0; i < options.length; i++) {
            System.out.format(colorize("  %d. %s\n", MENU_FORMAT), i + 1, options[i]);
        }
        mainView.pressEnterToContinue("  Press enter to go back to customer menu...");
    }

    public void userDetails(User user, MainView mainView) {
        System.out.println("\n" + colorize("  My personal details: ", mainView.HEADER_FORMAT));
        System.out.println(" ");
        System.out.println(colorize("  ID: " + user.getId(), mainView.MENU_FORMAT));
        System.out.println(colorize("  First name: " + user.getFirstName(), mainView.MENU_FORMAT));
        System.out.println(colorize("  Last name: " + user.getLastName(), mainView.MENU_FORMAT));
        System.out.println(colorize("  E-mail: " + user.getEmail(), mainView.MENU_FORMAT));
        System.out.println(colorize("  Password: " + user.getPassword(), mainView.MENU_FORMAT));
        System.out.println(colorize("  Address: " + user.getAddress(), mainView.MENU_FORMAT));
        mainView.pressEnterToContinue("  Press enter to go back to customer menu");
    }


    public void orderMenu() {
        String[] options = {" "};
        for (int i = 0; i < options.length; i++) {
            System.out.format("%d. %s\n", i + 1, options[i]);
        }
    }
}
