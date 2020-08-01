package com.codecool.view;

import com.codecool.model.Product;
import com.diogonunes.jcolor.AnsiFormat;


import static com.diogonunes.jcolor.Ansi.colorize;
import static com.diogonunes.jcolor.Attribute.*;


public class CartView {

    MainView mainView = new MainView();
    public final AnsiFormat HEADER_FORMAT = new AnsiFormat(BOLD(), BRIGHT_YELLOW_TEXT());
    public final AnsiFormat PROMPT_FORMAT = new AnsiFormat(BOLD(), BLUE_TEXT());
    public final AnsiFormat MENU_FORMAT = new AnsiFormat(BOLD(), WHITE_TEXT());


    public void CartMenu() {
        String[] options = {"Show details", "Delete product", "Clear cart", "Change quantity of product", "Back to Customer Menu"};
        for (int i = 0; i < options.length; i++) {
            System.out.println(colorize("  " + (i + 1) + ". " + options[i], MENU_FORMAT));
        }
        System.out.println();
    }

    public void printProduct(Product product, int quantity) {
        System.out.println(colorize(String.format("   %d | %s | %d",product.getId(), product.getName(), quantity), HEADER_FORMAT));
    }

    public void printStartLine(){
        System.out.println();
        System.out.println(colorize("  ------------------------------", MENU_FORMAT));
        System.out.println(colorize("  | ID | TYPE/MODEL | QUANTITY |", PROMPT_FORMAT));
        System.out.println(colorize("  ------------------------------", MENU_FORMAT));
    }

    public void printEndLine(){

        System.out.println(colorize("  ------------------------------", MENU_FORMAT));
        System.out.println();
    }

    public int getProductIdFromCustomer(){
        System.out.println(colorize("  Choose product id to change: ", MENU_FORMAT));
        return mainView.getIntegerInput();
    }

    public int getQuantityFromCustomer(){
        System.out.println(colorize("Choose new quantity of product: ", MENU_FORMAT));
        return mainView.getIntegerInput();
    }
}
