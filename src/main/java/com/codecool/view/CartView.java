package com.codecool.view;

import com.codecool.model.Product;
import com.diogonunes.jcolor.AnsiFormat;


import static com.diogonunes.jcolor.Ansi.colorize;


import static com.diogonunes.jcolor.Attribute.BOLD;
import static com.diogonunes.jcolor.Attribute.BRIGHT_YELLOW_TEXT;


public class CartView {

    public final AnsiFormat HEADER_FORMAT = new AnsiFormat(BOLD(), BRIGHT_YELLOW_TEXT());

    public void CartMenu() {
        String[] options = {"Add product", "Delete product", "Clear cart", "Change quantity of product", "Back to Customer Menu"};
        for (int i = 0; i < options.length; i++) {
            System.out.format("%d. %s\n", i + 1, options[i]);
        }
        System.out.print("\nChoose one of the options: ");
    }

    public void printProduct(Product product, int quantity) {
        System.out.println(colorize(String.format("%d %s %d",product.getId(), product.getName(), quantity), HEADER_FORMAT));
    }

    public void printStartLine(){
        System.out.println("------------------------------");
        System.out.println("| ID | NAME/MODEL | QUANTITY |");
        System.out.println("------------------------------");
    }

    public void printEndLine(){
        System.out.println("------------------------------");
    }
}
