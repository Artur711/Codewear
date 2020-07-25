package com.codecool.model;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import com.codecool.model.Product;

public class Cart {

    private final Map<Integer, Integer> itemsInCart;

    public Cart(){
        this.itemsInCart = new HashMap<Integer, Integer>();
    }

    public void updateMap(Map<Integer, Integer> actualMap){
    }


    public void toString(Map<Integer, Integer> products){
        for (int product_id: products.keySet()){
            int key = product_id;
            int value = products.get(product_id);
            System.out.println(key + " " + value);
        }
    }
}
