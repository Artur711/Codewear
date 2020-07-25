package com.codecool.select;

import java.util.List;

public interface SelectIteratorDAO {

    public List<Object> getNext();

    public List<Object> getPrevious();
}
