package com.codecool.dao;

import com.codecool.model.Product;

import java.util.List;

public interface TableProductsDAO {

    public List<Product> getTableFromDatabase (String command);

    public List<List<Object>> getTableAllDetails (String command);
}
