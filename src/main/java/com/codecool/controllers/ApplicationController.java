package com.codecool.controllers;

import com.codecool.datasource.PostgresSQLDataSource;
import com.codecool.datasource.SQLDataSource;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import java.util.Properties;

public class ApplicationController {

    public void run() {
        SQLDataSource datasource = setup();
        new RootController(datasource).run();

    }

    public SQLDataSource setup() {
        try (InputStream input = new FileInputStream("./src/main/resources/database.properties")) {
            Properties prop = new Properties();
            prop.load(input);
            String databaseName = prop.getProperty("db.database");
            String user = prop.getProperty("db.user");
            String password = prop.getProperty("db.passwd");
            return new PostgresSQLDataSource(databaseName, user, password);
        } catch (IOException e) {
            System.out.println("The file doesn't exist!!!");
        }
        return null;
    }
}
