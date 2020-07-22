package com.codecool.model;

import java.util.Collections;
import java.util.Map;

public class Cart {

    private final Map<Product, Integer> products = Collections.<Product, Integer>emptyMap();
    int user_id;
    int product_id;
    int quantity;

    public Cart(int user_id, int product_id, int quantity){
        this.user_id = user_id;
        this.product_id = product_id;
        this.quantity = quantity;
    }

    public int getUser_id() {
        return user_id;
    }

    public int getProduct_id() {
        return product_id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void getCartItems(User user){

    }
}
