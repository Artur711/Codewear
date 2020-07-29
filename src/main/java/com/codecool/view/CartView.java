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
        System.out.println(String.format("%d %s %s",product.getId(), product.getName(), quantity));
    }

    public void printCartItems(Map<Integer, Integer> cartItems){
        if(cartItems.size() == 0) {
            System.out.println("Empty cart");
        }else {
            for (int keyName : cartItems.keySet()) {
                System.out.println(keyName + " " + cartItems.get(keyName));
            }

                //getProductFromDatabase(command);
                //SelectView.printProductDetails(new Product(id, name, gender, type, color, size, price, quantity));
        }
    }


}
