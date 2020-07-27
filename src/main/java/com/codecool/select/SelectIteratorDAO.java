package com.codecool.select;

import com.codecool.model.Product;

import java.util.List;

public interface SelectIteratorDAO {

    public Product getNext();

    public Product getPrevious();
}
