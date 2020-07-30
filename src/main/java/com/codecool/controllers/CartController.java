package com.codecool.controllers;

import com.codecool.dao.CartDao;

import com.codecool.dao.ProductDao;
import com.codecool.model.User;
import com.codecool.view.CartView;
import com.codecool.view.MainView;

import java.util.Map;


public class CartController {


    CartView cartView;
    MainView mainView;
    ProductDao productDao;
    CartDao cartDao;


    public CartController(CartDao cartDao, ProductDao productDao) {
        this.cartDao = cartDao;
        this.productDao = productDao;
        cartView = new CartView();
        mainView = new MainView();

    }

    public void run(User user) {
        mainView.clearScreen();
        boolean isRunning = true;

        while (isRunning) {

            mainView.clearScreen();
            Map<Integer, Integer> cartIdItems = cartDao.getCartOfItems(user.getId());
            cartView.printStartLine();
            for (int keyName : cartIdItems.keySet()) {
                cartView.printProduct(productDao.getProductFromDatabase(keyName), cartIdItems.get(keyName));

            }
            cartView.printEndLinie();

            int product_id = 0;
            int quantity = 0;
            cartView.CartMenu();
            int input = mainView.getIntegerInput();
            switch (input) {
                case 1:
                    System.out.println("Choose product id: ");
                    product_id = mainView.getIntegerInput();
                    if(productDao.checkIfProductExist(product_id)) {
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
        return (int)productDao.getProductFromDatabase(product_id).getQuantity();
    }
}
