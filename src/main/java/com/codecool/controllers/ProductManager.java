package com.codecool.controllers;

import com.codecool.dao.ProductDao;
import com.codecool.model.Manager;
import com.codecool.model.Product;
import com.codecool.view.MainView;

public class ProductManager extends Manager {

    private final ProductDao productDAO;

    public ProductManager(MainView mainView, ProductDao productDAO) {
        super(mainView);
        this.productDAO = productDAO;
    }

    @Override
    protected void run() {
        boolean isRunning = true;

        while (isRunning) {
            mainView.clearScreen();
            showAvailableOptions();

            switch(mainView.getIntegerInput()) {
                case 1:
                    add();
                    break;
                case 2:
                    delete();
                    break;
                case 3:
                    update();
                    break;
                case 4:
                    isRunning = false;
                    break;
                default:
                    System.out.println("There is no such choice");
            }

        }
    }

    @Override
    protected void delete() {
        mainView.println("Enter id of product to be removed:");
        Product product = productDAO.getProductFromDatabase(mainView.getIntegerInput());
        if (product != null) {
            System.out.printf("Current number of records: %d%n", productDAO.getNumberOfRecords());
            System.out.printf("Are you sure you want to remove product: %s? [Y/N]%n", product.getName());
            if (mainView.getStringInput().equalsIgnoreCase("y")) {
                productDAO.delete(product);
                mainView.println("\nProduct has been removed from database");
                System.out.printf("%nCurrent number of records: %d%n", productDAO.getNumberOfRecords());
                mainView.pressEnterToContinue("\nPress enter to go back");
            }
        } else {
            System.out.println("\nThis product doesn't exist\n");
        }

    }

    @Override
    protected void add() {
        Product product = enterProductData();
        productDAO.addProduct(product);
        System.out.println("\nProduct has been added");
        mainView.pressEnterToContinue("\nPress enter to go back");
    }

    @Override
    protected void update() {
        mainView.println("Enter id of the product to be updated:");
        Product product = productDAO.getProductFromDatabase(mainView.getIntegerInput());
        if (product == null) {
            System.out.println("\nProduct not found in the database\n");
            return;
        }
        String name = mainView.readInput("PRODUCT_NAME", product.getName());
        String gender = mainView.readInput("GENDER", product.getGender());
        String type = mainView.readInput("TYPE", product.getType());
        String colour = mainView.readInput("COLOUR", product.getColour());
        String size = mainView.readInput("SIZE", product.getSizes());
        String price = mainView.readInput("PRICE", String.valueOf(product.getPrices()));
        String quantity = mainView.readInput("QUANTITY_ON_STOCK", String.valueOf(product.getQuantity()));
        product.setName(name);
        product.setGender(gender);
        product.setType(type);
        product.setColour(colour);
        product.setSizes(size);
        product.setPrices(Integer.parseInt(price));
        product.setQuantity(Integer.parseInt(quantity));

        productDAO.update(product);
        System.out.println("\nProduct has been updated\n");
        System.out.println(productDAO.getProductFromDatabase(product.getId()));
        mainView.pressEnterToContinue("\nPress enter to go back");
    }

    public Product enterProductData() {
        String[] answers = new String[] {"", "", "", "", "", "", "", ""};
        String[] fields = {"gender", "type", "colour", "size", "price", "quantity on stock", "quantity on stock"};

        displayProductCreationScreen("name", answers);
        for (int i = 0; i < fields.length ; i++) {
            answers[i] = mainView.getStringInput();
            displayProductCreationScreen(fields[i], answers);

        }
        return new Product(answers[0], answers[1], answers[2], answers[3], answers[4], Integer.parseInt(answers[5]), Integer.parseInt(answers[6]));
    }

    public void displayProductCreationScreen(String field, String[] answers) {
        mainView.clearScreen();
        System.out.println("Please enter product " + field + "\n");
        for (int i = 0; i < answers.length - 1; i++) {
            System.out.println(new String[] {"PRODUCT_NAME", "GENDER", "TYPE", "COLOUR", "SIZE", "PRICE", "QUANTITY_ON_STOCK"}[i] + ": " + answers[i]);
        }

    }
}
