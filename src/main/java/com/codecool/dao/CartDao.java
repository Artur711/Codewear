package com.codecool.dao;

import com.codecool.model.Cart;
import com.codecool.model.Product;

import java.util.Map;

public interface CartDao {

    int addToUserCart(Cart cart);

    int deleteFromUserCart(Cart cart, Product product);

    Map<Product, Integer> getProductsFromCart();
}
