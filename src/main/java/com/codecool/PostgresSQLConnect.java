package com.codecool;

import org.postgresql.ds.PGSimpleDataSource;
import javax.sql.DataSource;

public class PostgresSQLConnect {

    public DataSource connect() {
        PGSimpleDataSource dataSource = new PGSimpleDataSource();
        dataSource.setDatabaseName("codewear");
        dataSource.setUser("postgres");
        dataSource.setPassword("postgres");

        return dataSource;
    }
}
