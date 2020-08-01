package com.codecool.controllers;


import com.codecool.dao.ProductDao;
import com.codecool.dao.CartDao;

import com.codecool.model.Product;
import com.codecool.model.User;
import com.codecool.view.CartView;
import com.codecool.view.MainView;
import com.codecool.view.SelectView;

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

            cartView.CartMenu();
            mainView.displayPrompt(13 + cartMap.size(), 3, user.getFirstName());
            int input = mainView.getIntegerInput();
            switch (input) {
                case 1:
                    showDetailsOption(user.getFirstName());
                    break;
                case 2:
                    deleteOption(user.getFirstName(), user.getId());
                    break;
                case 3:
                    clearOption(user.getId());
                    break;
                case 4:
                    changeQuantityOption(user.getFirstName(), user.getId());
                    break;
                case 5:
                    isRunning = false;
                    break;
            }
        }
    }


    public Product getProduct(int productId) {
        return productDao.getProductFromDatabase(productId);
    }


    public void showDetailsOption(String userName) {
        int productId = cartView.getProductIdFromCustomer(userName);
        if(productDao.checkIfProductExist(productId)){
            selectView.printProductDetails(getProduct(productId));
        }else {
            cartView.msgProductNotExist();
        }
        mainView.pressEnterToContinue("  Press enter to continue");
    }

    public void deleteOption(String userName, int userId){
        int productId = cartView.getProductIdFromCustomer(userName);
        if(productDao.checkIfProductExist(productId)){
            cartDao.delete(userId, productId);
            mainView.pressEnterToContinue("  Product removed. Press enter to continue");
        }else{
            cartView.msgProductNotExist();
        }
        mainView.pressEnterToContinue("  Press enter to continue");
    }

    public void clearOption(int userId){
        cartDao.clear(userId);
    }

    public void changeQuantityOption(String userName, int userId){
        int productId = cartView.getProductIdFromCustomer(userName);
        int quantity = cartView.getQuantityFromCustomer(userName);

        if(productDao.checkIfProductExist(productId)){
            if(cartDao.isAvailableOnStock(getProduct(productId).getQuantity(), quantity) && quantity > 0){
                cartDao.changeQuantityOfProduct(userId, productId, quantity);
                mainView.pressEnterToContinue("  Quantity changed. Press enter to continue");
            }else{
                mainView.pressEnterToContinue("  Quantity available in stock: " + getProduct(productId).getQuantity() + " Press enter to continue");
            }
        }else{
            cartView.msgProductNotExist();
            mainView.pressEnterToContinue("  Press enter to continue");
        }
    }
}
