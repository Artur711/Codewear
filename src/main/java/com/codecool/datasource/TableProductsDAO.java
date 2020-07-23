package com.codecool.datasource;

import java.util.List;

public interface TableProductsDAO {

    public List<List<Object>> getTableFromDatabase (String command);
}
