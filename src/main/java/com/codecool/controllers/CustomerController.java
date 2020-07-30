package com.codecool.controllers;

import com.codecool.dao.CartDao;
import com.codecool.dao.ProductDao;
import com.codecool.model.User;
import com.codecool.select.SelectDAO;
import com.codecool.view.CustomerView;

public class CustomerController {
    private SelectDAO selectDAO;
    CustomerView view;
    CartController cartController;


    public CustomerController(CartDao cartDao, ProductDao productDao, SelectDAO selectDAO) {
        this.selectDAO = selectDAO;

        view = new CustomerView();
        cartController = new CartController(cartDao, productDao);
    }

    public void run(User user) {
        view.clearScreen();
        boolean isRunning = true;

        while (isRunning) {

            view.clearScreen();
            view.CustomerMenu();
            int input = view.getIntegerInput();

            switch (input) {
                case 1:
                    cartController.run(user);
                    break;
                case 2:
                    break;
                case 3:
                    System.out.println(user.toString());
                case 4:
                    view.clearScreen();
                    view.CustomerHelp();
                case 5:
                    break;
            }
        }
    }
}
