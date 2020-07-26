package com.codecool.select;

import com.codecool.dao.Product;

import java.util.List;

public interface SelectIteratorDAO {

    public Product getNext();

    public Product getPrevious();
}
