package com.codecool.view;

import com.codecool.model.Product;

import java.util.List;

import static com.diogonunes.jcolor.Ansi.colorize;

public class SelectView extends MainView {
    private final int NUMBER_SPACES = 45;
    private int numberOfRestSpaces;
    private StringBuilder sB;
    private final String str = colorize("|| ", HEADER_FORMAT);
    private String leftString;
    private String rightString;


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

        leftString = String.format("Product id: %d",product.getId());
        rightString = String.format("Pieces available: %d", product.getQuantity());
        printLineWithWhiteText(leftString, rightString);

        rightString = String.format("Price: %d $", product.getPrices());
        printLineWithWhiteText("", rightString);
        System.out.print(getEmptyLine());

        leftString = String.format("Product name: %s", product.getName());
        printLineWithWhiteText(leftString, "");

        leftString = String.format("Product type: %s", product.getType());
        rightString = String.format("SIZE: %s", product.getSizes());
        printLineWithWhiteText(leftString, rightString);

        leftString = String.format("Colour: %s", product.getColour());
        printLineWithWhiteText(leftString, "");
        System.out.print(getEmptyLine());

        printLineOfFrame();
    }

    public void printProductDetails(Product product, int numberOfAllSearch, int indexOfProduct, String userName) {
        clearScreen();
        printLineOfFrame();

        leftString = String.format("Product id: %d",product.getId());
        rightString = String.format("Pieces available: %d", product.getQuantity());
        printLineWithWhiteText(leftString, rightString);

        rightString = String.format("Price: %d $", product.getPrices());
        printLineWithWhiteText("", rightString);
        System.out.print(getEmptyLine());

        leftString = String.format("Product name: %s", product.getName());
        printLineWithWhiteText(leftString, "");

        leftString = String.format("Product type: %s", product.getType());
        rightString = String.format("SIZE: %s", product.getSizes());
        printLineWithWhiteText(leftString, rightString);

        leftString = String.format("Colour: %s", product.getColour());
        printLineWithWhiteText(leftString, "");
        System.out.print(getEmptyLine());

        printLineWithBlueText("Add to cart (A)", "Product Preview (V)");
        printLineWithBlueText("Previous Product (P)", "Next Product (N)");
        System.out.print(getEmptyLine());

        rightString = String.format("Number of results: %d/%d", indexOfProduct, numberOfAllSearch);
        printLineWithBlueAndWhiteText("Go back (Q)", rightString);

        printLineOfFrame();
        displayPrompt(14, 1, userName);
    }

    private void printLineWithWhiteText(String leftString, String rightString) {
        sB = new StringBuilder(str);
        sB.append(colorize(leftString, MENU_FORMAT));
        numberOfRestSpaces = NUMBER_SPACES - leftString.length() - rightString.length() - 2;
        sB.append(getRestSpaces(numberOfRestSpaces));
        sB.append(colorize(rightString, MENU_FORMAT));
        sB.append(colorize(" ||", HEADER_FORMAT));
        System.out.println(sB.toString());
    }

    private void printLineWithBlueText(String leftString, String rightString) {
        sB = new StringBuilder(str);
        sB.append(colorize(leftString, PROMPT_FORMAT));
        numberOfRestSpaces = NUMBER_SPACES - leftString.length() - rightString.length() - 2;
        sB.append(getRestSpaces(numberOfRestSpaces));
        sB.append(colorize(rightString, PROMPT_FORMAT));
        sB.append(colorize(" ||", HEADER_FORMAT));
        System.out.println(sB.toString());
    }

    private void printLineWithBlueAndWhiteText(String leftString, String rightString) {
        sB = new StringBuilder(str);
        sB.append(colorize(leftString, PROMPT_FORMAT));
        numberOfRestSpaces = NUMBER_SPACES - leftString.length() - rightString.length() - 2;
        sB.append(getRestSpaces(numberOfRestSpaces));
        sB.append(colorize(rightString, MENU_FORMAT));
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
    }
}
