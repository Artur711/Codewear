package com.codecool.controllers;

import com.codecool.dao.CartDao;
import com.codecool.dao.TableProductsDAO;

import com.codecool.model.User;

import com.codecool.view.CartView;
import com.codecool.view.MainView;


import java.sql.SQLOutput;
import java.util.Map;


public class CartController {


    CartView cartView;
    MainView mainView;

    TableProductsDAO tableProductsDAO;
    CartDao cartDao;


    public CartController(CartDao cartDao, TableProductsDAO tableProductsDAO) {

        this.cartDao = cartDao;
        this.tableProductsDAO = tableProductsDAO;

        cartView = new CartView();
        mainView = new MainView();

    }

    public void run(User user) {
        mainView.clearScreen();
        boolean isRunning = true;

        while (isRunning) {

            mainView.clearScreen();
            Map<Integer, Integer> cartIdItems = cartDao.getCartOfItems(user.getId());
            for (int keyName : cartIdItems.keySet()) {
                cartView.printProduct(tableProductsDAO.getProductFromDatabase(keyName), cartIdItems.get(keyName));
            }

            int product_id = 0;
            int quantity = 0;
            cartView.CartMenu();
            int input = mainView.getIntegerInput();
            switch (input) {
                case 1:
                    System.out.println("Choose product id: ");
                    product_id = mainView.getIntegerInput();
                    if(tableProductsDAO.checkIfProductExist(product_id)) {
                        System.out.println("Choose quantity of product: ");
                        quantity = mainView.getIntegerInput();
                        if(cartDao.availableQuantityOnStock(getProductQuantityOnStock(product_id), quantity) && quantity > 0){
                            cartDao.addToUserCart(user.getId(), product_id, quantity);
                        }else{
                            System.out.println("Quantity available in stock: " + getProductQuantityOnStock(product_id));
                        }
                    }
                    break;
                case 2:
                    System.out.println("Type product id to delte: ");
                    product_id = mainView.getIntegerInput();
                    cartDao.deleteItemFromUserCart(user.getId(), product_id);
                    break;
                case 3:
                    cartDao.deleteAllFromUserCart(user.getId());
                    break;
                case 4:
                    System.out.println("Choose product id to change: ");
                    product_id = mainView.getIntegerInput();
                    System.out.println("Choose new quantity of product: ");
                    quantity = mainView.getIntegerInput();
                    if(cartDao.availableQuantityOnStock(getProductQuantityOnStock(product_id), quantity) && quantity > 0){
                        cartDao.addToUserCart(user.getId(), product_id, quantity);
                    }else{
                        System.out.println("Quantity available in stock: " + getProductQuantityOnStock(product_id));
                    }
                    cartDao.changeQuantityOfProduct(user.getId(), product_id, quantity);
                    break;
                case 5:
                    isRunning = false;
                    break;
            }
        }
    }

    public int getProductQuantityOnStock(int product_id){
        return (int)tableProductsDAO.getProductFromDatabase(product_id).getQuantity();
    }
}
