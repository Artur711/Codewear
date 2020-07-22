package com.codecool.datasource;

import org.postgresql.ds.PGSimpleDataSource;

import javax.sql.DataSource;

public class PostgresSQLDataSource implements SQLDataSource {
    private final String databaseName;
    private final String user;
    private final String password;
    PGSimpleDataSource dataSource = new PGSimpleDataSource();

    public PostgresSQLDataSource(String databaseName, String user, String password) {
        this.databaseName = databaseName;
        this.user = user;
        this.password = password;
    }

    public DataSource connect() {
        dataSource.setDatabaseName(this.databaseName);
        dataSource.setUser(this.user);
        dataSource.setPassword(this.password);

        return dataSource;
    }
}
