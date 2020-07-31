package com.codecool.model;

import com.codecool.view.MainView;

import static com.diogonunes.jcolor.Ansi.colorize;

public abstract class Manager {

    protected User currentUser;
    protected MainView mainView;

    public Manager(User currentUser, MainView mainView) {
        this.currentUser = currentUser;
        this.mainView = mainView;
    }

    protected abstract void run();

    protected abstract void delete();

    protected abstract void add();

    protected abstract void update();

    protected void showAvailableOptions() {
        String[] options = {"Add", "Delete", "Update", "Go back"};
        System.out.println(colorize("\n  Choose action to be performed\n", mainView.HEADER_FORMAT));
        mainView.displayMenuOptions(options);
        mainView.displayPrompt(9, 3, currentUser.getFirstName());
    }
}
