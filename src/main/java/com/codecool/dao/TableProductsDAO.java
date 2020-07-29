package com.codecool.dao;

import com.codecool.model.Product;

import java.util.List;

public interface TableProductsDAO {

    public List<Product> getTableFromDatabase (String command);

    public List<Object> getOptions(String command);

    public Product getProductFromDatabase(int product_id);

    public boolean checkIfProductExist(int productIdToCheck);
}
