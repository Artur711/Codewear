package com.codecool.select;

import com.codecool.model.Product;

import java.util.List;

public interface SelectIteratorDAO {

    Product getNext();

    Product getPrevious();
}
