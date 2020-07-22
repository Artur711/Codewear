package com.codecool.datasource;

import org.postgresql.ds.PGSimpleDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class PostgresSQLDataSource {

    private final PGSimpleDataSource dataSource = new PGSimpleDataSource();

    public PostgresSQLDataSource(String databaseName, String user, String password) {
        dataSource.setDatabaseName(databaseName);
        dataSource.setUser(user);
        dataSource.setPassword(password);
    }

    public Connection connect() {
        try {
            return dataSource.getConnection();
        } catch (SQLException e) {
            System.out.println("Error during connecting: " + e.getMessage());
        }
        return null;
    }
}
