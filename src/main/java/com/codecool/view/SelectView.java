package com.codecool.view;

import com.codecool.model.Product;

import java.util.List;

import static com.diogonunes.jcolor.Ansi.colorize;

public class SelectView extends MainView {
    private final int NUMBER_SPACES = 46;
    private int numberOfRestSpaces;
    private int quantitySignsInRigidText;
    private StringBuilder sB;
    private final String str = colorize("|| ", HEADER_FORMAT);

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

        for (int index = 0; index < optionList.size(); index++) {
            StringBuilder sB = new StringBuilder(str);
            sB.append(colorize("|| ", HEADER_FORMAT));
            String row = String.format("%d %s", index + 1, optionList.get(index).toString());
            sB.append(colorize(row, MENU_FORMAT));
            sB.append(getRestSpaces(NUMBER_SPACES - 2 - row.length()));
            sB.append(colorize(" ||", HEADER_FORMAT));
            System.out.println(sB.toString());
        }

        System.out.print(getEmptyLine());
        printLineOfFrame();
    }

    public void printProductDetails(Product product) {
        clearScreen();
        printLineOfFrame();

        printLineWithProductIDAndQuntity(product);
        printLineWithPrice(product);
        System.out.print(getEmptyLine());

        printLineWithNameOfProduct(product);
        printLineWithTypeAndSize(product);
        printLineWithColour(product);
        System.out.print(getEmptyLine());

        printLineOfFrame();
    }

    public void printProductDetails(Product product, int numberOfAllSearch, int indexOfProduct, String userName) {
        clearScreen();
        printLineOfFrame();

        printLineWithProductIDAndQuntity(product);
        printLineWithPrice(product);

        System.out.print(getEmptyLine());

        printLineWithNameOfProduct(product);
        printLineWithTypeAndSize(product);
        printLineWithColour(product);

        System.out.print(getEmptyLine());
        printLineWithOptionAddAndView();
        printLineWithOptionNextAndPrevious();
        System.out.print(getEmptyLine());
        printLineWithOptionQuitAndNumberOfSearch(indexOfProduct, numberOfAllSearch);

        printLineOfFrame();
        displayPrompt(14, 1, userName);
    }

    private void printLineWithProductIDAndQuntity(Product product) {
        sB = new StringBuilder(str);
        sB.append(colorize(String.format("Product id: %d",product.getId()), MENU_FORMAT));
        quantitySignsInRigidText = 32;
        numberOfRestSpaces = NUMBER_SPACES - quantitySignsInRigidText
                - String.valueOf(product.getId()).length()
                - String.valueOf(product.getQuantity()).length();
        sB.append(getRestSpaces(numberOfRestSpaces));
        sB.append(colorize(String.format("Pieces available: %d", product.getQuantity()), MENU_FORMAT));
        sB.append(colorize(" ||", HEADER_FORMAT));
        System.out.println(sB.toString());
    }

    private void printLineWithPrice(Product product) {
        sB = new StringBuilder(str);
        quantitySignsInRigidText = 11;
        numberOfRestSpaces = NUMBER_SPACES - quantitySignsInRigidText - String.valueOf(product.getPrices()).length();
        sB.append(getRestSpaces(numberOfRestSpaces));
        sB.append(colorize(String.format("Price: %d $", product.getPrices()), MENU_FORMAT));
        sB.append(colorize(" ||", HEADER_FORMAT));
        System.out.println(sB.toString());
    }

    private void printLineWithNameOfProduct(Product product) {
        sB = new StringBuilder(str);
        sB.append(colorize(String.format("Product name: %s", product.getName()), MENU_FORMAT));
        quantitySignsInRigidText = 16;
        numberOfRestSpaces = NUMBER_SPACES - quantitySignsInRigidText - product.getName().length();
        sB.append(getRestSpaces(numberOfRestSpaces));
        sB.append(colorize(" ||", HEADER_FORMAT));
        System.out.println(sB.toString());
    }

    private void printLineWithTypeAndSize(Product product) {
        sB = new StringBuilder(str);
        sB.append(colorize(String.format("Product type: %s", product.getType()), MENU_FORMAT));
        quantitySignsInRigidText = 22;
        numberOfRestSpaces = NUMBER_SPACES - quantitySignsInRigidText - product.getType().length() - product.getSizes().length();
        sB.append(getRestSpaces(numberOfRestSpaces));
        sB.append(colorize(String.format("SIZE: %s", product.getSizes()), MENU_FORMAT));
        sB.append(colorize(" ||", HEADER_FORMAT));
        System.out.println(sB.toString());
    }

    private void printLineWithColour(Product product) {
        sB = new StringBuilder(str);
        sB.append(colorize(String.format("Colour: %s", product.getColour()), MENU_FORMAT));
        quantitySignsInRigidText = 10;
        numberOfRestSpaces = NUMBER_SPACES - quantitySignsInRigidText - product.getColour().length();
        sB.append(getRestSpaces(numberOfRestSpaces));
        sB.append(colorize(" ||", HEADER_FORMAT));
        System.out.println(sB.toString());
    }

    private void printLineWithOptionAddAndView() {
        sB = new StringBuilder(str);
        sB.append(colorize("Add to cart (A)", PROMPT_FORMAT));
        quantitySignsInRigidText = 36;
        sB.append(getRestSpaces(NUMBER_SPACES - quantitySignsInRigidText));
        sB.append(colorize("Product Preview (V)", PROMPT_FORMAT));
        sB.append(colorize(" ||", HEADER_FORMAT));
        System.out.println(sB);
    }

    private void printLineWithOptionNextAndPrevious() {
        sB = new StringBuilder(str);
        sB.append(colorize("Previous Product (P)", PROMPT_FORMAT));
        quantitySignsInRigidText = 38;
        sB.append(getRestSpaces(NUMBER_SPACES - quantitySignsInRigidText));
        sB.append(colorize("Next Product (N)", PROMPT_FORMAT));
        sB.append(colorize(" ||", HEADER_FORMAT));
        System.out.println(sB.toString());
    }

    private void printLineWithOptionQuitAndNumberOfSearch(int indexOfProduct, int numberOfAllSearch) {
        sB = new StringBuilder(str);
        sB.append(colorize("Go back (Q)", PROMPT_FORMAT));
        quantitySignsInRigidText = 13;
        String strSearch = String.format("Number of results: %d/%d", indexOfProduct, numberOfAllSearch);
        sB.append(getRestSpaces(NUMBER_SPACES - quantitySignsInRigidText - strSearch.length()));
        sB.append(colorize(strSearch, MENU_FORMAT));
        sB.append(colorize(" ||", HEADER_FORMAT));
        System.out.println(sB.toString());
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
        System.out.print(colorize(String.format("%s:$ ", userName), PROMPT_FORMAT));
//        System.out.print(colorize("Provide your option number: ", PROMPT_FORMAT));
    }
}
