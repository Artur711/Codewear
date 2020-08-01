package com.codecool.select;

import com.codecool.dao.PSQLReadImage;

import com.codecool.model.Product;
import com.codecool.dao.ProductDao;
import com.codecool.dao.PSQLProductDao;
import com.codecool.view.SelectView;

import java.sql.Connection;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;
import java.util.InputMismatchException;


public class SelectPostgres implements SelectDAO {
    private final SelectView view = new SelectView();
    private final Connection conn;
    private String command;
    private final String userName;
    private final Map<String, String> mapOptionToSelect = new HashMap<>();
    private final ProductDao tableProd;
    private final String [] selectOption = {"gender", "type", "colour", "sizes"};

    public SelectPostgres(Connection conn, String userName) {
        this.conn = conn;
        this.tableProd = new PSQLProductDao(conn);
        this.userName = userName;
    }

    @Override
    public Product runSearch() {
        for (String option : selectOption) {
            getSelect(option);
        }

        command = generateSelectQuery("SELECT * FROM products", this.mapOptionToSelect);
        List<Product> productList = tableProd.getTableFromDatabase(command);
        mapOptionToSelect.clear();
//        view.printList(productList);
        return getSpecificProduct(productList);
    }

    @Override
    public String generateSelectQuery(String query, Map<String, String> mapOptionToSelect) {
        boolean isWhereStatement = false;
        StringBuilder sb = new StringBuilder(query);

        for (int index = 0; index < selectOption.length; index++) {
            String valueOfMap = mapOptionToSelect.get(selectOption[index]);

            if (!(valueOfMap == null)) {
                if (!valueOfMap.equals("All") && !isWhereStatement) {
                    sb.append(String.format(" where %s = '%s'", selectOption[index], valueOfMap));
                    isWhereStatement = true;
                }
                else if (!valueOfMap.equals("All")) {
                    sb.append(String.format(" and %s = '%s'", selectOption[index], valueOfMap));
                }
            }
        }

        return sb.toString();
    }

    private void getSelect(String selectBY) {
        command = generateSelectQuery(String.format("SELECT %s FROM products", selectBY), this.mapOptionToSelect);
        boolean isRun = true;

        List<Object> optionList = tableProd.getOptions(command);
        view.printSelectOption(optionList);
        view.provideOption(userName);

        while (isRun) {
            Scanner scan = new Scanner(System.in);
            try {
                int option = scan.nextInt();
                this.mapOptionToSelect.put(selectBY, String.valueOf(optionList.get(option - 1)));
                isRun = false;
            } catch (InputMismatchException | IndexOutOfBoundsException e) {
                scan.next();
            }
        }
    }

    private Product getSpecificProduct(List<Product> productList) {
        boolean isRun = true;
        Scanner scan = new Scanner(System.in);
        Product product = productList.get(0);

        SelectIteratorDAO selectIteratorDAO = new SelectIteratorPostgres(productList);

        while (isRun) {
            int searchNumber = productList.indexOf(product) + 1;
            view.printProductDetails(product, productList.size(), searchNumber, userName);
            String result = scan.nextLine().toLowerCase();

            switch (result) {
                case "n":
                    product = selectIteratorDAO.getNext();
                    break;
                case "p":
                    product = selectIteratorDAO.getPrevious();
                    break;
                case "v":
                    PSQLReadImage readImage = new PSQLReadImage(this.conn);
                    readImage.run(String.valueOf(product.getName()));
                    break;
                case "a":
                    isRun = false;
                    break;
                case "q":
                    return null;
            }
        }
        return product;
    }
}
