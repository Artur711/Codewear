package com.codecool.model;

import com.codecool.view.MainView;

public abstract class Manager {

    protected MainView mainView;

    public Manager(MainView mainView) {
        this.mainView = mainView;
    }

    protected abstract void run();
    protected abstract void delete();
    protected abstract void add();
    protected abstract void update();

    protected void showAvailableOptions() {
        String[] options = {"Add", "Delete", "Update", "Go back"};
        mainView.println("Choose action to be performed:");
        mainView.displayMenuOptions(options);
    }
}
