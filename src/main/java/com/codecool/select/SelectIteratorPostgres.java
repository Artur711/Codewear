package com.codecool.select;

import java.util.List;

public class SelectIteratorPostgres implements SelectIteratorDAO {
    private List<List<Object>> productsList;
    private int position = 0;

    public SelectIteratorPostgres(List<List<Object>> productsList) {
        this.productsList = productsList;
    }

    @Override
    public List<Object> getNext() {
        this.position++;

        if (position == this.productsList.size()) {
            this.position = 0;
        }

        return productsList.get(position);
    }

    @Override
    public List<Object> getPrevious() {
        this.position--;

        if (this.position < 0) {
            this.position = this.productsList.size() - 1;
        }

        return productsList.get(position);
    }
}

