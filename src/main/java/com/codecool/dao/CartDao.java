package com.codecool.dao;

import java.util.Map;

public interface CartDao {

    int add(int user_id, int product_id, int quantity);

    int delete(int user_id, int product_id);

    int clear(int user_id);

    Map<Integer, Integer> getCartMap(int user_id);

    int changeQuantityOfProduct(int user_id, int product_id, int quantity);

    boolean isAvailableOnStock(int quantityInOrder, int userQuantityOrder);
}
