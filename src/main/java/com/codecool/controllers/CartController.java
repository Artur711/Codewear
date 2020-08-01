package com.codecool.controllers;


import com.codecool.dao.ProductDao;
import com.codecool.dao.CartDao;

import com.codecool.model.User;
import com.codecool.view.CartView;
import com.codecool.view.MainView;
import com.codecool.view.SelectView;

import java.sql.SQLOutput;
import java.util.Map;

public class CartController {

    CartView cartView;
    MainView mainView;

    ProductDao productDao;
    CartDao cartDao;
    SelectView selectView;


    public CartController(CartDao cartDao, ProductDao productDao, SelectView selectView) {
        this.cartDao = cartDao;
        this.productDao = productDao;
        this.selectView = selectView;

        cartView = new CartView();
        mainView = new MainView();
    }

    public void run(User user) {
        mainView.clearScreen();
        boolean isRunning = true;

        while (isRunning) {

            mainView.clearScreen();
            Map<Integer, Integer> cartMap = cartDao.getCartMap(user.getId());
            cartView.printStartLine();

            for (int keyName : cartMap.keySet()) {
                cartView.printProduct(productDao.getProductFromDatabase(keyName), cartMap.get(keyName));
            }

            cartView.printEndLine();

            int productId = 0;
            int quantity = 0;
            cartView.CartMenu();
            mainView.displayPrompt(13 + cartMap.size(), 3, user.getFirstName());
            int input = mainView.getIntegerInput();
            switch (input) {
                case 1:
                    //System.out.println("Choose product id: ");
                    productId = mainView.getIntegerInput();
                    selectView.printProductDetails(productDao.getProductFromDatabase(productId));
                    mainView.pressEnterToContinue("Press enter to continue");
                    break;
                case 2:
                    System.out.println("Type product id to delete: ");
                    productId = mainView.getIntegerInput();
                    cartDao.delete(user.getId(), productId);
                    break;
                case 3:
                    cartDao.clear(user.getId());
                    break;
                case 4:
                    productId = cartView.getProductIdFromCustomer();
                    quantity = cartView.getQuantityFromCustomer();
                    if(cartDao.isAvailableOnStock(getProductQuantityOnStock(productId), quantity) && quantity > 0){
                        cartDao.add(user.getId(), productId, quantity);
                    }else{
                        System.out.println("Quantity available in stock: " + getProductQuantityOnStock(productId));
                    }
                    cartDao.changeQuantityOfProduct(user.getId(), productId, quantity);
                    break;
                case 5:
                    isRunning = false;
                    break;
            }
        }
    }

    public int getProductQuantityOnStock(int productId){
        return productDao.getProductFromDatabase(productId).getQuantity();
    }
}
