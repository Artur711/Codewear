package com.codecool.select;

import com.codecool.model.Product;

import java.util.List;
import java.util.Map;

public interface SelectDAO {

    public List<Product> run();

    public String generateSelectQuery(String query, Map<String, String> mapOptionToSelect);
}
