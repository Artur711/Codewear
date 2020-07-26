package com.codecool.controllers;

import com.codecool.model.Manager;
import com.codecool.view.MainView;

public class ProductManager extends Manager {

    public ProductManager(MainView mainView) {
        super(mainView);

    }

    @Override
    protected void run() {

    }

    @Override
    protected void delete() {

    }

    @Override
    protected void add() {

    }

    @Override
    protected void update() {

    }

    protected void showAvailableOptions() {
        String[] options = {"Add", "Delete", "Update"};
        mainView.println("Choose action to be performed:");
        mainView.displayMenuOptions(options);
    }
}
