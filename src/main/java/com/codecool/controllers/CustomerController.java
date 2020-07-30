package com.codecool.controllers;

import com.codecool.dao.CartDao;
import com.codecool.dao.OrderDao;
import com.codecool.dao.ProductDao;
import com.codecool.model.Order;
import com.codecool.model.Product;
import com.codecool.model.User;
import com.codecool.select.SelectDAO;
import com.codecool.view.CustomerView;
import com.codecool.view.MainView;


import java.sql.Date;
import java.time.LocalDate;
import java.util.Map;
import java.util.Scanner;

public class CustomerController {
    private SelectDAO selectDAO;
    CustomerView view;
    MainView mainView;
    CartController cartController;
    private CartDao cartDao;
    private ProductDao productDao;
    private OrderDao orderDao;



    public CustomerController(CartDao cartDao, ProductDao productDao, SelectDAO selectDAO, OrderDao orderDao, MainView mainView) {
        this.selectDAO = selectDAO;
        this.cartDao = cartDao;
        this.productDao = productDao;
        this.orderDao = orderDao;
        this.mainView = mainView;

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
                    Product product = selectDAO.runSearch();
                    if (product != null) {
                        if(productDao.checkIfProductExist(product.getId())) {
                            System.out.println("Choose quantity of product: ");
                            int quantity = mainView.getIntegerInput();
                            //Scanner scanner = new Scanner(System.in);
                            //int quantity = scanner.nextInt();
                            if(cartDao.availableQuantityOnStock(product.getQuantity(), quantity) && quantity > 0){
                                cartDao.addToUserCart(user.getId(), product.getId(), quantity);
                            }else{
                                System.out.println("Quantity available in stock: " + product.getQuantity());
                            }
                        }
                    }
                    break;
                case 2:
                    cartController.run(user);
                    break;
                case 3:
                    Map<Integer, Integer> mapOrders = cartDao.getCartOfItems(user.getId());
                    if (mapOrders.size() > 0) {
                        cartDao.deleteAllFromUserCart(user.getId());
                        float totalPrice = getTotalPrice(mapOrders);
                        Order order = new Order(user.getFirstName(), user.getLastName(), Date.valueOf(LocalDate.now()), Date.valueOf(LocalDate.now().plusDays(30)), "submitted", "", user.getId(), totalPrice);
                        orderDao.add(order);
                        System.out.println("Order submitted.");
                    }
                    System.out.println("Your cart is empty.");
                    break;
                case 4:
                    System.out.println(user.toString());
                case 5:
                    view.clearScreen();
                    view.CustomerHelp();
                case 6:
                    isRunning = false;
                    break;
            }
        }
    }

    private float getTotalPrice(Map<Integer, Integer> mapOrders) {
        float totalPrice = 0;
        for(Integer product_id: mapOrders.keySet()){
            totalPrice = totalPrice + productDao.getProductFromDatabase(product_id).getPrices() * mapOrders.get(product_id);

        }
        return totalPrice;
    }
}
