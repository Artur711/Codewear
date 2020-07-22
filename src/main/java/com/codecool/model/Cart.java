package com.codecool.model;

import java.util.Map;

public class Cart {

    //private final Map<Product, User> products;
    String user_id;
    String product_id;
    int quantity;

    public Cart(String user_id, String product_id, int quantity){
        this.user_id = user_id;
        this.product_id = product_id;
        this.quantity = quantity;
    }

    public void add(Product product) {

    }

    public int size(){
        return 0;
    }

    public void remove(int i){

    }

    public void removeAll(int user_id) {
        String SQL = "DELETE FROM cart WHERE user_id = ?";
    }

    public void editProduct(String key, int i){

    }

    //public Map<String, Integer> getProductsFromCart(){
    //   return products;
    //}
}
