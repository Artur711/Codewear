package com.codecool.controllers;

import com.codecool.datasource.PostgresSQLDataSource;
import com.codecool.select.SelectDAO;
import com.codecool.select.SelectPostgres;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import java.sql.Connection;
import java.util.Properties;

public class ApplicationController {

    public void run() {
        Connection conn = setup();
//        SelectDAO select = new SelectPostgres(conn);
//        select.run();
        new RootController(conn).run();
    }

    public Connection setup() {
        try (InputStream input = new FileInputStream("./src/main/resources/database.properties")) {
            Properties prop = new Properties();
            prop.load(input);
            String databaseName = prop.getProperty("db.database");
            String user = prop.getProperty("db.user");
            String password = prop.getProperty("db.passwd");
            return new PostgresSQLDataSource(databaseName, user, password).connect();
        } catch (IOException e) {
            System.out.println("The file doesn't exist!!!");
        }
        return null;
    }
}
