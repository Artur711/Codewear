package com.codecool;

import javax.sql.DataSource;

public interface SQLDataSource {

    DataSource connect();
}
