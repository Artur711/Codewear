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
        String[] options = {"Search", "My cart", "Confirm cart", "Personal details", "Update personal details", "Help", "Logout"};
        for (int i = 0; i < options.length; i++) {
            System.out.format(colorize("  %d. %s\n", MENU_FORMAT), i + 1, options[i]);
        }
        System.out.println(" ");
        mainView.displayPrompt(12, 2, " " + user.getFirstName());
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
        String[] options = {"If you need any help, don't hesitate and contact us codewear@codecool.com.", "Products overview is available after registration.", "For all orders payment policy is: Pay on Arrival", "Orders are execute in maximum 30 days. \n"};
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
        System.out.println(colorize("  ID: ", mainView.MENU_FORMAT) + colorize(String.valueOf(user.getId()), mainView.HEADER_FORMAT));
        System.out.println(colorize("  First name: ",mainView.MENU_FORMAT) + colorize(user.getFirstName(), mainView.HEADER_FORMAT));
        System.out.println(colorize("  Last name: ",mainView.MENU_FORMAT) + colorize(user.getLastName(),mainView.HEADER_FORMAT));
        System.out.println(colorize("  E-mail: ", mainView.MENU_FORMAT) + colorize(user.getEmail(), mainView.HEADER_FORMAT));
        System.out.println(colorize("  Address: " + user.getAddress(), mainView.MENU_FORMAT)); // Address can be null
        mainView.pressEnterToContinue("  Press enter to go back to customer menu...");
    }


    public void orderMenu() {
        String[] options = {" "};
        for (int i = 0; i < options.length; i++) {
            System.out.format("%d. %s\n", i + 1, options[i]);
        }
    }
}
