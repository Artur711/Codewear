package com.codecool.controllers;

import com.codecool.dao.*;
import com.codecool.model.Order;
import com.codecool.model.Product;
import com.codecool.model.User;
import com.codecool.select.SelectDAO;
import com.codecool.view.CustomerView;
import com.codecool.view.MainView;
import com.codecool.view.SelectView;
import com.codecool.dao.UserDao;

import static com.diogonunes.jcolor.Ansi.colorize;


import java.sql.Connection;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class CustomerController {
    private SelectDAO selectDAO;
    private CartDao cartDao;
    private ProductDao productDao;
    private OrderDao orderDao;
    private Connection conn;
    private UserDao userDao;

    CustomerView view;
    SelectView selectView;
    MainView mainView;

    CartController cartController;


    public CustomerController(CartDao cartDao, ProductDao productDao, SelectDAO selectDAO, OrderDao orderDao, MainView mainView, SelectView selectView, Connection conn, UserDao userDao) {
        this.selectDAO = selectDAO;
        this.cartDao = cartDao;
        this.productDao = productDao;
        this.orderDao = orderDao;
        this.mainView = mainView;
        this.conn = conn;
        this.userDao = userDao;

        this.selectView = selectView;


        view = new CustomerView();
        cartController = new CartController(cartDao, productDao, selectView);
    }

    public void run(User user) {
        view.clearScreen();
        boolean isRunning = true;

        while (isRunning) {

            view.clearScreen();
            view.CustomerMenu(user, mainView);
            int input = view.getIntegerInput();

            switch (input) {
                case 1:
                    customerCart(user);
                    break;
                case 2:
                    cartController.run(user);
                    break;
                case 3:
                    customerOrder(user);
                    break;
                case 4:
                    view.clearScreen();
                    view.userDetails(user, mainView);
                    break;
                case 5:
                    updateCustomerDetails(userDao, user);
                    break;
                case 6:
                    showCustomerOrders(user);
                    break;
                case 7:
                    view.clearScreen();
                    view.CustomerHelp(mainView);
                    break;
                case 8:
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

    private String generateOrderNumber() {
        int numberOfDigits = 5;
        int numberOfChars = 7;
        StringBuilder sb = new StringBuilder(numberOfChars);
        Random random = new Random();
        sb.append("SO");
        for (int i = 0; i < numberOfDigits; i++) {
            sb.append(random.nextInt(10));
        }
        return sb.toString();
    }

    private void customerCart(User user) {
        Product product = selectDAO.runSearch();
        if (product != null) {
            if(productDao.checkIfProductExist(product.getId())) {
                System.out.println("\n" + colorize("Choose quantity of product: ", mainView.HEADER_FORMAT));
                int quantity = mainView.getIntegerInput();
                if(cartDao.isAvailableOnStock(product.getQuantity(), quantity) && quantity > 0){
                    cartDao.add(user.getId(), product.getId(), quantity);
                    System.out.println("\n" + colorize("Added to cart!", mainView.PROMPT_FORMAT));
                }else{
                    System.out.println("\n" + colorize("Quantity available in stock: " + product.getQuantity(), mainView.PROMPT_FORMAT));
                }
            }
            mainView.pressEnterToContinue("Press enter to continue");
        }
    }

    private void customerOrder(User user) {
        Map<Integer, Integer> mapOrders = cartDao.getCartMap(user.getId());
        if (mapOrders.size() > 0) {
            cartDao.clear(user.getId());
            float totalPrice = getTotalPrice(mapOrders);
            Order order = new Order(user.getFirstName(), user.getLastName(), Date.valueOf(LocalDate.now()), Date.valueOf(LocalDate.now().plusDays(30)), "submitted", generateOrderNumber(), user.getId(), totalPrice);
            orderDao.add(order);
            new PSQLSaveOrderDetails(conn, productDao, mapOrders, user.getId()).run();
            view.clearScreen();
            System.out.println("\n" + colorize("  Order submitted. Your order number is " + order.getOrderNumber(), mainView.PROMPT_FORMAT));
        }
        System.out.println("\n" + colorize("  Your cart is empty.", mainView.PROMPT_FORMAT));
        mainView.pressEnterToContinue("  Press enter to go back to customer menu");
    }

    private void updateCustomerDetails(UserDao userDao, User user) {
        System.out.println();
        String firstName = mainView.readInput("FIRST_NAME (varchar(255), ", user.getFirstName(), user);
        String lastName = mainView.readInput("LAST_NAME (varchar(255), ", user.getLastName(), user);
        String email = mainView.readInput("EMAIL (varchar(255), ", user.getEmail(), user);
        String password = mainView.readInput("PASSWORD (varchar(255), ", user.getPassword(), user);
        String address = mainView.readInput("ADDRESS character varying(255), ", user.getAddress(), user);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setEmail(email);
        user.setPassword(password);
        user.setAddress(address);
        userDao.update(user);
        System.out.println("\n" + "  " + colorize(user.getFirstName() + ", your details has been updated", mainView.HEADER_FORMAT));
        mainView.pressEnterToContinue("  Press enter to go back to customer menu");


    }
    private void showCustomerOrders(User user) {
        mainView.clearScreen();
        List<Order> orders = orderDao.getOrdersByCustomerID(user.getId());
        mainView.displayOrdersTable(orders,orderDao.findMaxNumberOfCharsPerColumn());
        mainView.pressEnterToContinue("  Press enter to go back to customer menu");
    }
}
