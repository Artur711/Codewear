package com.codecool.model;

import java.util.Map;

public class Cart {

    String user_id;
    String product_id;
    int quantity;

    public Cart(String user_id, String product_id, int quantity){
        this.user_id = user_id;
        this.product_id = product_id;
        this.quantity = quantity;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getProduct_id() {
        return product_id;
    }

    public void setProduct_id(String product_id) {
        this.product_id = product_id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

}
