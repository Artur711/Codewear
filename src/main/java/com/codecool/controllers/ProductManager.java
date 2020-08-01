package com.codecool.controllers;

import com.codecool.dao.ProductDao;
import com.codecool.model.Manager;
import com.codecool.model.Product;
import com.codecool.model.User;
import com.codecool.view.MainView;

import java.util.List;

import static com.diogonunes.jcolor.Ansi.colorize;

public class ProductManager extends Manager {

    private final ProductDao productDAO;

    public ProductManager(User currentUser, MainView mainView, ProductDao productDAO) {
        super(currentUser, mainView);
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
        mainView.clearScreen();
        System.out.println("\n" + colorize("  Enter id of product to be removed:", mainView.HEADER_FORMAT));
        mainView.displayPrompt(4, 3, currentUser.getFirstName());
        Product product = productDAO.getProductFromDatabase(mainView.getIntegerInput());
        if (product != null) {
            mainView.clearScreen();
            mainView.displayConfirmationRequestMessage(product.getName(), productDAO.getNumberOfRecords());
            mainView.displayPrompt(6, 3, currentUser.getFirstName());
            if (mainView.getStringInput().equalsIgnoreCase("y")) {
                productDAO.delete(product);
                mainView.displayRemovalMessage("Product", productDAO.getNumberOfRecords());
                mainView.pressEnterToContinue("  Press enter to go back");
            }
        } else {
            System.out.println("\n" + colorize("  This product doesn't exist\n",mainView.HEADER_FORMAT));
            mainView.pressEnterToContinue("  Press enter to go back");
        }
    }

    @Override
    protected void add() {
        Product product = enterProductData();
        productDAO.addProduct(product);
        List<Product> products = productDAO.getProductWithProductName(product.getName());
        System.out.println(colorize("  Product has been added", mainView.MENU_FORMAT));
        mainView.displayProductsTable(products, productDAO.findMaxNumberOfCharsPerColumn());
        mainView.pressEnterToContinue("  Press enter to go back");
    }

    @Override
    protected void update() {
        mainView.clearScreen();
        System.out.println("\n" + colorize("  Enter id of the product to be updated:", mainView.HEADER_FORMAT));
        mainView.displayPrompt(4, 3, currentUser.getFirstName());
        Product product = productDAO.getProductFromDatabase(mainView.getIntegerInput());
        if (product == null) {
            System.out.println("\n" + colorize("  Product not found in the database\n", mainView.MENU_FORMAT));
            mainView.pressEnterToContinue("  Press enter to go back");
            return;
        }
        String name = mainView.readInput("PRODUCT_NAME (varchar(30), ", product.getName(), currentUser);
        String gender = mainView.readInput("GENDER (varchar(6), ", product.getGender(), currentUser);
        String type = mainView.readInput("TYPE (varchar(15), ", product.getType(), currentUser);
        String colour = mainView.readInput("COLOUR (varchar(25), ", product.getColour(), currentUser);
        String size = mainView.readInput("SIZE (varchar(3), ", product.getSizes(), currentUser);
        String price = mainView.readInput("PRICE (int, ", String.valueOf(product.getPrices()), currentUser);
        String quantity = mainView.readInput("QUANTITY_ON_STOCK (int, ", String.valueOf(product.getQuantity()), currentUser);
        product.setName(name);
        product.setGender(gender);
        product.setType(type);
        product.setColour(colour);
        product.setSizes(size);
        product.setPrices(Integer.parseInt(price));
        product.setQuantity(Integer.parseInt(quantity));
        productDAO.update(product);
        List<Product> products = productDAO.getProductWithProductName(product.getName());
        System.out.println("\n" + colorize("  Product has been updated", mainView.HEADER_FORMAT));
        mainView.displayProductsTable(products, productDAO.findMaxNumberOfCharsPerColumn());
        mainView.pressEnterToContinue("  Press enter to go back");
    }

    private Product enterProductData() {
        String[] answers = new String[] {"", "", "", "", "", "", ""};
        String[] fields = {"product_name", "gender", "type", "colour", "size", "price", "quantity on stock"};

        for (int i = 0; i < fields.length ; i++) {
            displayProductCreationScreen(fields[i], answers);
            answers[i] = mainView.getStringInput();
        }
        return new Product(answers[0], answers[1], answers[2], answers[3], answers[4], Integer.parseInt(answers[5]), Integer.parseInt(answers[6]));
    }

    private void displayProductCreationScreen(String field, String[] answers) {
        mainView.clearScreen();
        System.out.println(colorize("\n  Please enter product " + field + "\n", mainView.HEADER_FORMAT));
        for (int i = 0; i < answers.length; i++) {
            System.out.println(new String[] {colorize("  PRODUCT_NAME varchar(30)", mainView.MENU_FORMAT),
                    colorize("  GENDER varchar(6)", mainView.MENU_FORMAT),
                    colorize("  TYPE varchar(15)", mainView.MENU_FORMAT),
                    colorize("  COLOUR varchar(25)", mainView.MENU_FORMAT),
                    colorize("  SIZE varchar(3)", mainView.MENU_FORMAT),
                    colorize("  PRICE int", mainView.MENU_FORMAT),
                    colorize("  QUANTITY_ON_STOCK int", mainView.MENU_FORMAT)}[i] + ": " + colorize(answers[i], mainView.HEADER_FORMAT));
        }
        mainView.displayPrompt(12,3, currentUser.getFirstName());

    }
}
