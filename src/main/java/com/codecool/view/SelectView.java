package com.codecool.view;

import java.util.List;

public class SelectView {

    public void printList (List<List<Object>> listToPrint) {
        for (List<Object> row : listToPrint) {
            for (Object element : row) {
                System.out.print(element);
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    public void printSelectOption (List<Object> optionList) {
        for (int index = 0; index < optionList.size(); index++) {
            System.out.println(String.format("%d %s", index + 1, optionList.get(index).toString()));
        }
    }

    public void provideOption() {
        System.out.println("Provide your option number:");
    }
}
