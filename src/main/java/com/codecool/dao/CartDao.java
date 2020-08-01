package com.codecool.dao;

import java.util.Map;

public interface CartDao {

    int add(int userId, int productId, int quantity);

    int delete(int userId, int productId);

    int clear(int userId);

    Map<Integer, Integer> getCartMap(int userId);

    int changeQuantityOfProduct(int userId, int productId, int quantity);

    boolean isAvailableOnStock(int quantityInOrder, int userQuantityOrder);
}
