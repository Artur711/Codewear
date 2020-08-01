
package com.codecool.view;

import com.codecool.enums.UserInfo;
import com.codecool.model.Order;
import com.codecool.model.Product;
import com.codecool.model.User;
import com.diogonunes.jcolor.AnsiFormat;

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
        String[] options = {"Database management", "Show all orders of a customer", "Show past due orders", "Sign out"};
        System.out.println(colorize("\n  W E L C O M E  T O  A D M I N  D A S H B O A R D\n", HEADER_FORMAT));
        displayMenuOptions(options);
        displayPrompt(9, 3, user.getFirstName());
    }

    public void displayPrompt(int verticalOffset, int horizontalOffset, String owner) {
        System.out.print(colorize("\033["+verticalOffset+";" + horizontalOffset + "H" + owner + ":$ ", PROMPT_FORMAT));
    }

    public int getIntegerInput() {
        while(!scanner.hasNextInt()){
            scanner.next();
            System.out.println("\n" + colorize("  Enter integer", MENU_FORMAT));
            System.out.print("\033[2C");
        }
        int input = scanner.nextInt();
        scanner.nextLine();

        return input;
    }

    public String getStringInput() {
        String input = scanner.nextLine();
        while (input.isEmpty()) {
            input = scanner.nextLine();
            System.out.println(colorize("  Enter text", MENU_FORMAT));
        }
        return input;
    }

    public void displayUsersTable(List<User> users, int[] maxLengths) {
        String[] headers = {"id", "first_name", "last_name", "email", "password", "user_role"};
        int[] maxLengthsIncludingHeaders = findLongestCharacterPerColumn(maxLengths, getHeadersLengths(headers));
        StringBuilder sb;
        System.out.println();

        displayHeaders(maxLengthsIncludingHeaders, headers);
        sb = new StringBuilder();
        for (User user : users) {

            String[] fields = {String.valueOf(user.getId()), user.getFirstName(), user.getLastName(),
                               user.getEmail(), user.getPassword(), String.valueOf(user.getRoleID())};

            sb.append("  ");
            for (int i = 0; i < maxLengthsIncludingHeaders.length; i++) {
                sb.append("| ")
                  .append(findHowManySpacesToAppend(maxLengthsIncludingHeaders[i], fields[i].trim()))
                  .append(" ");
            }
            sb.append("|\n");
        }
        System.out.println(sb.toString());
    }

    public void displayOrdersTable(List<Order> orders, int[] maxLengths) {
        String[] headers = {"sales_order_id", "status", "user_id", "first_name", "last_name", "order_date", "due_date", "total_due"};
        int[] maxLengthsIncludingHeaders = findLongestCharacterPerColumn(maxLengths, getHeadersLengths(headers));
        StringBuilder sb;
        System.out.println();


        displayHeaders(maxLengthsIncludingHeaders, headers);
        sb = new StringBuilder();

        for (Order order : orders) {

            String[] fields = {String.valueOf(order.getId()), order.getStatus(), String.valueOf(order.getUserID()),
                               order.getCustomerFirstName(), order.getCustomerLastName(), order.getOrderDate().toString(),
                               order.getDueDate().toString(), String.valueOf(order.getTotalDue())};

            sb.append("  ");
            for (int i = 0; i < maxLengthsIncludingHeaders.length; i++) {
                sb.append("| ")
                  .append(findHowManySpacesToAppend(maxLengthsIncludingHeaders[i], fields[i].trim()))
                  .append(" ");
            }
            sb.append("|\n");
        }
        System.out.println(sb.toString());
    }

    public void displayProductsTable(List<Product> products, int[] maxLengths) {
        String[] headers = {"id", "product_name", "gender", "type", "colour", "sizes", "prices", "quantity_on_stock"};
        int[] maxLengthsIncludingHeaders = findLongestCharacterPerColumn(maxLengths, getHeadersLengths(headers));
        StringBuilder sb;
        System.out.println();

        displayHeaders(maxLengthsIncludingHeaders, headers);
        sb = new StringBuilder();

        for (Product product : products) {

            String[] fields = {String.valueOf(product.getId()), product.getName(), product.getGender(),
                    product.getType(), product.getColour(), product.getSizes(), String.valueOf(product.getPrices()),
                    String.valueOf(product.getQuantity())};

            sb.append("  ");
            for (int i = 0; i < maxLengthsIncludingHeaders.length; i++) {
                sb.append("| ")
                        .append(findHowManySpacesToAppend(maxLengthsIncludingHeaders[i], fields[i].trim()))
                        .append(" ");
            }
            sb.append("|\n");
        }
        System.out.println(sb.toString());
    }

    private void displayHeaders(int[] maxLengthsIncludingHeaders, String[] headers) {
        StringBuilder sb = new StringBuilder();
        sb.append("  ");

        for (int i = 0; i < headers.length; i++) {
            sb.append("| ")
              .append(findHowManySpacesToAppend(maxLengthsIncludingHeaders[i], headers[i].trim()))
              .append(" ");
        }
        sb.append("|\n");

        drawHorizontalLine(calculateSum(maxLengthsIncludingHeaders) + (maxLengthsIncludingHeaders.length * 2) + maxLengthsIncludingHeaders.length);
        System.out.print(colorize(sb.toString(), MENU_FORMAT));
        drawHorizontalLine(calculateSum(maxLengthsIncludingHeaders) + (maxLengthsIncludingHeaders.length * 2) + maxLengthsIncludingHeaders.length);
    }

    private int[] findLongestCharacterPerColumn(int[] maxLengths, int[] headers) {
        for (int i = 0; i < headers.length; i++) {
            maxLengths[i] = Math.max(maxLengths[i], headers[i]);
        }
        return maxLengths;
    }

    public String findHowManySpacesToAppend(int longestWordLength, String field) {
        int numChars = longestWordLength - field.length();
        if (numChars % 2 == 0) {
            return " ".repeat(numChars / 2) + field + " ".repeat(numChars / 2);
        } else {
            return " ".repeat(numChars / 2) + field + " ".repeat((numChars / 2) + 1);
        }
    }

    public void drawHorizontalLine(int length) {
        System.out.print("  ");
        System.out.println("-".repeat(length));
    }


    public int[] getHeadersLengths(String[] headers) {
        int[] headersLengths = new int[headers.length];
        for (int i = 0; i < headers.length; i++) {
            headersLengths[i] = headers[i].length();
        }
        return headersLengths;
    }


    public void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public void pressEnterToContinue(String prompt) {
        System.out.print("\n" + colorize(prompt, MENU_FORMAT));
        scanner.nextLine();
    }

    public User getUserData() {
        String[] answers = new String[] {"", "", "", ""};

        for (int i = 0; i < fields.length ; i++) {
            displayRegistrationScreen(fields[i], answers);
            answers[i] = getStringInput();
        }
        return new User(answers[0], answers[1], answers[2], answers[3]);
    }

    public void displayRegistrationScreen(String field, String[] answers) {
        clearScreen();
        System.out.println("\n" + colorize("  Please enter your " + field, HEADER_FORMAT));
        System.out.println();
        for (int i = 0; i < fields.length; i++) {
            System.out.println(colorize("  " + fields[i].toUpperCase() + ": ", MENU_FORMAT) + colorize(answers[i], HEADER_FORMAT));
        }
        displayPrompt(9, 3, "Guest");
    }

    public User getUserCredentials() {
        String[] credentials = {UserInfo.EMAIL.getDisplay(), UserInfo.PASSWORD.getDisplay()};
        String[] answers = new String[] {"", ""};

        for (int i = 0; i < credentials.length ; i++) {
            displayLoginScreen(credentials[i], answers);
            answers[i] = getStringInput();

        }
        return new User(answers[0], answers[1]);
    }

    public void displayLoginScreen(String field, String[] answers) {
        clearScreen();
        String[] credentials = {UserInfo.EMAIL.getDisplay(), UserInfo.PASSWORD.getDisplay()};
        System.out.println("\n" + colorize("  Please enter your " + field, HEADER_FORMAT));
        System.out.println();
        for (int i = 0; i < answers.length; i++) {
            System.out.println(colorize("  " + credentials[i].toUpperCase() + ": ", MENU_FORMAT) + colorize(answers[i], HEADER_FORMAT));
        }
        displayPrompt(7, 3, "Guest");
    }

    public void displayAccountCreationMessage() {
        System.out.println("\n" + colorize("  Your account has been created!", HEADER_FORMAT));
        pressEnterToContinue("  Press enter to return to main menu");

    }

    public void displayErrorWhileLoggingMessage() {
        System.out.println("\n" + colorize("  Incorrect email or password", HEADER_FORMAT));
        pressEnterToContinue("  Press enter to return to main menu");
    }

    public String readInput(String prompt, String defaultValue, User currentUser) {
        askToUpdateRecords(prompt, defaultValue, currentUser);
        String input = scanner.nextLine();
        return input.isEmpty() ? defaultValue : input;
    }

    private void askToUpdateRecords(String prompt, String defaultValue, User currentUser) {
        clearScreen();
        System.out.print("\n" + colorize("  " + prompt + "current value -> " + "'"+ defaultValue + "'" + "): ", MENU_FORMAT));
        displayPrompt(4, 3, currentUser.getFirstName());
    }

    private int calculateSum(int[] array) {
        int sum = 0;
        for (int number : array) {
            sum += number;
        }
        return sum;
    }

    public void displayConfirmationRequestMessage(String firstName, String lastName, int records) {
        System.out.printf("\n" + colorize("  Are you sure you want to remove user: %s, %s? [Y/N]%n",MENU_FORMAT), firstName, lastName);
        System.out.printf("\n" + colorize("  Current number of records: %d%n", HEADER_FORMAT), records);
    }

    public void displayConfirmationRequestMessage(String name, int records) {
        System.out.printf("\n" + colorize("  Are you sure you want to remove product: %s? [Y/N]%n",MENU_FORMAT), name);
        System.out.printf("\n" + colorize("  Current number of records: %d%n", HEADER_FORMAT), records);
    }

    public void displayRemovalMessage(String type, int records) {
        System.out.println("\n" + colorize("  " + type + " has been removed from database", MENU_FORMAT));
        System.out.printf("\n" + colorize("  Current number of records: %d%n", HEADER_FORMAT), records);
    }

}