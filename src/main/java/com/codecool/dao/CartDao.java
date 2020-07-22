package com.codecool.dao;

import com.codecool.model.Product;

public interface CartDao {

    int addProductToCart(Product product);
}
