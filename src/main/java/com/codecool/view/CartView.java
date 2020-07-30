package com.codecool.view;

import com.codecool.model.Product;

import java.util.Map;


public class CartView {

    public void CartMenu() {
        String[] options = {"Add product", "Delete product", "Clear cart", "Change quantity of product", "Back to Cusomer Menu"};
        for (int i = 0; i < options.length; i++) {
            System.out.format("%d. %s\n", i + 1, options[i]);
        }
        System.out.print("\nChoose one of the options: ");
    }

    public void printProduct(Product product, int quantity) {
        System.out.println(String.format("%d %s %d",product.getId(), product.getName(), quantity));
    }

    public void printStartLine(){
        System.out.println("------------------------------");
        System.out.println("| ID | NAME/MODEL | QUANTITY |");
        System.out.println("------------------------------");
    }

    public void printEndLinie(){
        System.out.println("------------------------------");
    }
}
