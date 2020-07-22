package com.codecool.controllers;

import com.codecool.datasource.SQLDataSource;


public class RootController {

    SQLDataSource dataSource;

    public RootController(SQLDataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void run() {
        mainMenu();

    }

    public void mainMenu() {
        String[] options = {"Sign in", "Create account", "Quit"};
        for (int i = 0; i < options.length; i++) {
            System.out.format("%d. %s\n", i + 1, options[i]);
        }
    }
}
