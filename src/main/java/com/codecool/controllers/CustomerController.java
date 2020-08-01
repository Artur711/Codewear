package com.codecool.controllers;

import com.codecool.dao.CartDao;
import com.codecool.dao.OrderDao;
import com.codecool.dao.PSQLSaveOrderDetails;
import com.codecool.dao.ProductDao;
import com.codecool.model.Order;
import com.codecool.model.Product;
import com.codecool.model.User;
import com.codecool.select.SelectDAO;
import com.codecool.view.CustomerView;
import com.codecool.view.MainView;
import com.codecool.view.SelectView;

import static com.diogonunes.jcolor.Ansi.colorize;


import java.sql.Connection;
import java.sql.Date;
import java.time.LocalDate;
import java.util.Map;
import java.util.Random;

public class CustomerController {
    private SelectDAO selectDAO;
    private CartDao cartDao;
    private ProductDao productDao;
    private OrderDao orderDao;
    private Connection conn;

    CustomerView view;
    SelectView selectView;
    MainView mainView;

    CartController cartController;


    public CustomerController(CartDao cartDao, ProductDao productDao, SelectDAO selectDAO, OrderDao orderDao, MainView mainView, SelectView selectView, Connection conn) {
        this.selectDAO = selectDAO;
        this.cartDao = cartDao;
        this.productDao = productDao;
        this.orderDao = orderDao;
        this.mainView = mainView;
        this.conn = conn;

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
                    Product product = selectDAO.runSearch();
                    if (product != null) {
                        if(productDao.checkIfProductExist(product.getId())) {
                            System.out.println(colorize("  Choose quantity of product: ", mainView.HEADER_FORMAT));
                            int quantity = mainView.getIntegerInput();
                            //Scanner scanner = new Scanner(System.in);
                            //int quantity = scanner.nextInt();
                            if(cartDao.isAvailableOnStock(product.getQuantity(), quantity) && quantity > 0){
                                cartDao.add(user.getId(), product.getId(), quantity);
                            }else{
                                System.out.println(colorize("  Quantity available in stock: " + product.getQuantity(), mainView.PROMPT_FORMAT));
                            }
                        }
                    }
                    break;
                case 2:
                    cartController.run(user);
                    break;
                case 3:
                    Map<Integer, Integer> mapOrders = cartDao.getCartMap(user.getId());
                    if (mapOrders.size() > 0) {
                        cartDao.clear(user.getId());
                        float totalPrice = getTotalPrice(mapOrders);
                        Order order = new Order(user.getFirstName(), user.getLastName(), Date.valueOf(LocalDate.now()), Date.valueOf(LocalDate.now().plusDays(30)), "submitted", generateOrderNumber(), user.getId(), totalPrice);
                        orderDao.add(order);
                        new PSQLSaveOrderDetails(conn, productDao, mapOrders, user.getId()).run();
                        System.out.println(colorize("  Order submitted.\n", mainView.PROMPT_FORMAT));
                    }
                    System.out.println(colorize("  Your cart is empty.", mainView.HEADER_FORMAT));
                    mainView.pressEnterToContinue("  Press enter to go back to customer menu...");
                    break;
                case 4:
                    view.clearScreen();
                    view.userDetails(user, mainView);
                    break;
                case 5:
                    view.clearScreen();
                    view.CustomerHelp();
                    mainView.pressEnterToContinue("  Press enter to go back to customer menu...");
                    break;
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
}
