package com.codecool.select;

import com.codecool.dao.Product;

import java.util.List;

public class SelectIteratorPostgres implements SelectIteratorDAO {
    private List<Product> productsList;
    private int position = 0;

    public SelectIteratorPostgres(List<Product> productsList) {
        this.productsList = productsList;
    }

    @Override
    public Product getNext() {
        this.position++;

        if (position == this.productsList.size()) {
            this.position = 0;
        }

        return productsList.get(position);
    }

    @Override
    public Product getPrevious() {
        this.position--;

        if (this.position < 0) {
            this.position = this.productsList.size() - 1;
        }

        return productsList.get(position);
    }
}

