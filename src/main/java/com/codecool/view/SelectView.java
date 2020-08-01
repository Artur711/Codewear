package com.codecool.view;

import com.codecool.model.Product;

import java.util.List;

import static com.diogonunes.jcolor.Ansi.colorize;

public class SelectView extends MainView {
    private final int NUMBER_SPACES = 46;

    /*public void printList (List<List<Object>> listToPrint) {
        for (List<Object> row : listToPrint) {
            for (Object element : row) {
                System.out.print(element);
                System.out.print(" ");
            }
            System.out.println();
        }
    }*/

    public void printSelectOption (List<Object> optionList) {
        clearScreen();
        printLineOfFrame();
        String str = "";
        StringBuilder sB = new StringBuilder(str);

        for (int index = 0; index < optionList.size(); index++) {
            sB.append(colorize("|| ", HEADER_FORMAT));
            String row = String.format("%d %s", index + 1, optionList.get(index).toString());
            sB.append(row);
            sB.append(getRestSpaces(NUMBER_SPACES - 2 - row.length()));
            sB.append(colorize(" ||\n", HEADER_FORMAT));
        }
        sB.append(getEmptyLine());
        System.out.print(sB.toString());
        printLineOfFrame();
    }

    public void printProductDetails(Product product, int numberOfAllSearch, int indexOfProduct, String userName) {
        clearScreen();
        int numberOfRestSpaces;
        int quantitySignsInRigidText;
        printLineOfFrame();
        String str = colorize("|| ", HEADER_FORMAT);

        StringBuilder sB = new StringBuilder(str);
        sB.append(String.format("Product id: %d",product.getId()));
        quantitySignsInRigidText = 32;
        numberOfRestSpaces = NUMBER_SPACES - quantitySignsInRigidText
                                           - String.valueOf(product.getId()).length()
                                           - String.valueOf(product.getQuantity()).length();
        sB.append(getRestSpaces(numberOfRestSpaces));
        sB.append(String.format("Pieces available: %d", product.getQuantity()));
        sB.append(colorize(" || \n", HEADER_FORMAT));

        sB.append(colorize("|| ", HEADER_FORMAT));
        quantitySignsInRigidText = 11;
        numberOfRestSpaces = NUMBER_SPACES - quantitySignsInRigidText - String.valueOf(product.getPrices()).length();
        sB.append(getRestSpaces(numberOfRestSpaces));
        sB.append(String.format("Price: %d $", product.getPrices()));
        sB.append(colorize(" || \n", HEADER_FORMAT));

        sB.append(getEmptyLine());

        sB.append(colorize("|| ", HEADER_FORMAT));
        sB.append(String.format("Product name: %s", product.getName()));
        quantitySignsInRigidText = 16;
        numberOfRestSpaces = NUMBER_SPACES - quantitySignsInRigidText - product.getName().length();
        sB.append(getRestSpaces(numberOfRestSpaces));
        sB.append(colorize(" || \n", HEADER_FORMAT));

        sB.append(colorize("|| ", HEADER_FORMAT));
        sB.append(String.format("Product type: %s", product.getType()));
        quantitySignsInRigidText = 22;
        numberOfRestSpaces = NUMBER_SPACES - quantitySignsInRigidText - product.getType().length() - product.getSizes().length();
        sB.append(getRestSpaces(numberOfRestSpaces));
        sB.append(String.format("SIZE: %s", product.getSizes()));
        sB.append(colorize(" || \n", HEADER_FORMAT));

        sB.append(colorize("|| ", HEADER_FORMAT));
        sB.append(String.format("Colour: %s", product.getColour()));
        quantitySignsInRigidText = 10;
        numberOfRestSpaces = NUMBER_SPACES - quantitySignsInRigidText - product.getColour().length();
        sB.append(getRestSpaces(numberOfRestSpaces));
        sB.append(colorize(" || \n", HEADER_FORMAT));

        sB.append(getEmptyLine());
        sB.append(colorize("|| ", HEADER_FORMAT));
        sB.append("Add to cart (A)");
        quantitySignsInRigidText = 36;
        sB.append(getRestSpaces(NUMBER_SPACES - quantitySignsInRigidText));
        sB.append("Product Preview (V)");
        sB.append(colorize(" || \n", HEADER_FORMAT));

        sB.append(colorize("|| ", HEADER_FORMAT));
        sB.append("Previous Product (P)");
        quantitySignsInRigidText = 38;
        sB.append(getRestSpaces(NUMBER_SPACES - quantitySignsInRigidText));
        sB.append("Next Product (N)");
        sB.append(colorize(" || \n", HEADER_FORMAT));
        sB.append(getEmptyLine());

        sB.append(colorize("|| ", HEADER_FORMAT));
        sB.append("Go back (Q)");
        quantitySignsInRigidText = 13;
        String strSearch = String.format("Number of results: %d/%d", indexOfProduct, numberOfAllSearch);
        sB.append(getRestSpaces(NUMBER_SPACES - quantitySignsInRigidText - strSearch.length()));
        sB.append(strSearch);
        sB.append(colorize(" || \n", HEADER_FORMAT));
        System.out.print(sB.toString());
        printLineOfFrame();
        displayPrompt(2, 3, userName);
    }


    public void printProductDetails(Product product, int numberOfAllSearch, int indexOfProduct) {
        clearScreen();
        int numberOfRestSpaces;
        int quantitySignsInRigidText;
        printLineOfFrame();
        String str = colorize("|| ", HEADER_FORMAT);

        StringBuilder sB = new StringBuilder(str);
        sB.append(String.format("Product id: %d",product.getId()));
        quantitySignsInRigidText = 32;
        numberOfRestSpaces = NUMBER_SPACES - quantitySignsInRigidText
                - String.valueOf(product.getId()).length()
                - String.valueOf(product.getQuantity()).length();
        sB.append(getRestSpaces(numberOfRestSpaces));
        sB.append(String.format("Pieces available: %d", product.getQuantity()));
        sB.append(colorize(" || \n", HEADER_FORMAT));

        sB.append(colorize("|| ", HEADER_FORMAT));
        quantitySignsInRigidText = 11;
        numberOfRestSpaces = NUMBER_SPACES - quantitySignsInRigidText - String.valueOf(product.getPrices()).length();
        sB.append(getRestSpaces(numberOfRestSpaces));
        sB.append(String.format("Price: %d $", product.getPrices()));
        sB.append(colorize(" || \n", HEADER_FORMAT));

        sB.append(getEmptyLine());

        sB.append(colorize("|| ", HEADER_FORMAT));
        sB.append(String.format("Product name: %s", product.getName()));
        quantitySignsInRigidText = 16;
        numberOfRestSpaces = NUMBER_SPACES - quantitySignsInRigidText - product.getName().length();
        sB.append(getRestSpaces(numberOfRestSpaces));
        sB.append(colorize(" || \n", HEADER_FORMAT));

        sB.append(colorize("|| ", HEADER_FORMAT));
        sB.append(String.format("Product type: %s", product.getType()));
        quantitySignsInRigidText = 22;
        numberOfRestSpaces = NUMBER_SPACES - quantitySignsInRigidText - product.getType().length() - product.getSizes().length();
        sB.append(getRestSpaces(numberOfRestSpaces));
        sB.append(String.format("SIZE: %s", product.getSizes()));
        sB.append(colorize(" || \n", HEADER_FORMAT));

        sB.append(colorize("|| ", HEADER_FORMAT));
        sB.append(String.format("Colour: %s", product.getColour()));
        quantitySignsInRigidText = 10;
        numberOfRestSpaces = NUMBER_SPACES - quantitySignsInRigidText - product.getColour().length();
        sB.append(getRestSpaces(numberOfRestSpaces));
        sB.append(colorize(" || \n", HEADER_FORMAT));

        sB.append(getEmptyLine());

        System.out.print(sB.toString());
        printLineOfFrame();

    }


    private void printLineOfFrame() {
        System.out.print(colorize("##", HEADER_FORMAT));

        for (int i = 0; i < NUMBER_SPACES; i++) {
            System.out.print(colorize("=", HEADER_FORMAT));
        }
        System.out.println(colorize("##", HEADER_FORMAT));
    }

    private String getRestSpaces(int numberOfRestSpaces) {
        String str = "";
        StringBuilder sB = new StringBuilder(str);

        for (int i = 0; i < numberOfRestSpaces; i++) {
            sB.append(" ");
        }
        return sB.toString();
    }

    private String getEmptyLine() {
        String str = "";

        StringBuilder sB = new StringBuilder(str);
        sB.append(colorize("||", HEADER_FORMAT));
        sB.append(getRestSpaces(NUMBER_SPACES));
        sB.append(colorize("||\n", HEADER_FORMAT));
        return  sB.toString();
    }

    public void provideOption(String userName) {
        displayPrompt(2, 3, userName);
//        System.out.print(colorize("Provide your option number: ", PROMPT_FORMAT));
    }
}
