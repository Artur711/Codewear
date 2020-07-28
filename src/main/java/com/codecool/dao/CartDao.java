package com.codecool.dao;

import java.util.Map;

public interface CartDao {

    int addToUserCart(int user_id, int product_id, int quantity);

    int deleteItemFromUserCart(int user_id, int product_id);

    int deleteAllFromUserCart(int user_id);

    Map<Integer, Integer> getCartOfItems(int user_id);

    int changeQuantityOfProduct(int user_id, int product_id, int quantity);

    boolean checkQuantityOnStock(int quantityInOrder);
}
