package com.codecool;

import org.postgresql.ds.PGSimpleDataSource;

import javax.sql.DataSource;

public class PostgresSQLDataSource implements SQLDataSource {
    private String databaseName;
    private String user;
    private String password;

    public PostgresSQLDataSource(String databaseName, String user, String password) {
        this.databaseName = databaseName;
        this.user = user;
        this.password = password;
    }

    public DataSource connect() {
        PGSimpleDataSource dataSource = new PGSimpleDataSource();
        dataSource.setDatabaseName(this.databaseName);
        dataSource.setUser(this.user);
        dataSource.setPassword(this.password);

        return dataSource;
    }
}
