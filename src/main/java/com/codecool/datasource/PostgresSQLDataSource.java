package com.codecool.datasource;

import org.postgresql.ds.PGSimpleDataSource;

import javax.sql.DataSource;

public class PostgresSQLDataSource implements SQLDataSource {

    private final PGSimpleDataSource dataSource = new PGSimpleDataSource();

    public PostgresSQLDataSource(String databaseName, String user, String password) {
        dataSource.setDatabaseName(databaseName);
        dataSource.setUser(user);
        dataSource.setPassword(password);
    }

    public DataSource connect() {
        return dataSource;
    }
}
