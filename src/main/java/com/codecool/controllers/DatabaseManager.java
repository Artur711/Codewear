package com.codecool.controllers;

import com.codecool.dao.ProductDao;
import com.codecool.dao.UserDao;
import com.codecool.model.User;
import com.codecool.view.MainView;

import static com.diogonunes.jcolor.Ansi.colorize;

public class DatabaseManager {

    private final User currentUser;
    private final MainView mainView;
    private final ProductManager productManager;
    private final UserManager userManager;

    public DatabaseManager(User currentUser, MainView mainView, UserDao userDao, ProductDao productDAO) {
        this.currentUser = currentUser;
        this.mainView = mainView;
        this.productManager = new ProductManager(currentUser, mainView, productDAO);
        this.userManager = new UserManager(currentUser, mainView, userDao);
    }

    protected void run() {
        boolean isRunning = true;

        while(isRunning) {
            mainView.clearScreen();
            listAvailableOptions(currentUser);

            switch(mainView.getIntegerInput()) {
                case 1:
                    userManager.run();
                    break;
                case 2:
                    productManager.run();
                    break;
                case 3:
                    isRunning = false;
                    break;
                default:
                    System.out.println("There is no such option");
            }
        }
    }

    protected void listAvailableOptions(User user) {
        String[] options = {"Users", "Products", "Go back"};
        System.out.println(colorize("\n  Choose table to perform action or go back to previous menu\n", mainView.HEADER_FORMAT));
        mainView.displayMenuOptions(options);
        mainView.displayPrompt(8, 3, user.getFirstName());
    }
}
