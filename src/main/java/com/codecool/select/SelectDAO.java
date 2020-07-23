package com.codecool.select;

import java.util.Map;

public interface SelectDAO {

    public void run();

    public String generateSelectQuery(String query, Map<String, String> mapOptionToSelect);
}
