package com.codecool.select;

import java.util.List;

public interface SelectDAO {

    public void run();

    public String generatSelectQuery(String query, List<String> optionToSelect);
}
