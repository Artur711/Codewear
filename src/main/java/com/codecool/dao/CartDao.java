package com.codecool.dao;

import com.codecool.model.Cart;
import com.codecool.model.Product;
import com.codecool.model.User;

import java.util.Map;

public interface CartDao {

    int addToUserCart(int user_id, int product_id, int quantity);

    int deleteItemFromUserCart(int user_id, int product_id);

    int deleteAllFromUserCart(int user_id);

    Map<Integer, Integer> getCartOfItems(int user_id);
}
