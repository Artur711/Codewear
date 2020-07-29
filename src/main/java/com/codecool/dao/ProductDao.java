package com.codecool.dao;

import com.codecool.model.Product;

import java.util.List;

public interface ProductDao {

    List<Product> getTableFromDatabase (String command);

    List<Object> getOptions(String command);

    Product getProductFromDatabase(int product_id);

    int getNumberOfRecords();

    void delete(Product product);

    int addProduct(Product product);

    void update(Product product);

    boolean checkIfProductExist(int productIdToCheck);

}
