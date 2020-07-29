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
    private List<Product> productList;
    private String command;
    private Map<String, String> mapOptionToSelect = new HashMap<>();
    private ProductDao tableProd;
    private String [] selectOption = {"gender", "type", "colour", "sizes"};

    public SelectPostgres(Connection conn) {
        this.conn = conn;
        this.tableProd = new PSQLProductDao(conn);
    }

    @Override
    public Product runSearch() {
        for (String option : selectOption) {
            getSelect(option);
        }

        command = generateSelectQuery("SELECT * FROM products", this.mapOptionToSelect);
        productList = tableProd.getTableFromDatabase(command);
//        view.printList(productList);
        Product product = getSpecyficProduct(productList);
        return product;
    }

    @Override
    public String generateSelectQuery(String query, Map<String, String> mapOptionToSelect) {
        Boolean isWhereStatement = false;
        StringBuilder sb = new StringBuilder(query);

        for (int index = 0; index < selectOption.length; index++) {
            String vauleOfMap = mapOptionToSelect.get(selectOption[index]);

            if (!(vauleOfMap == null)) {
                if (!vauleOfMap.equals("All") && !isWhereStatement) {
                    sb.append(String.format(" where %s = '%s'", selectOption[index], vauleOfMap));
                    isWhereStatement = true;
                }
                else if (!vauleOfMap.equals("All")) {
                    sb.append(String.format(" and %s = '%s'", selectOption[index], vauleOfMap));
                }
            }
        }

        return sb.toString();
    }

    private void getSelect(String selectBY) {
        command = generateSelectQuery(String.format("SELECT %s FROM products", selectBY), this.mapOptionToSelect);
        Boolean isRun = true;

        List<Object> optionList = tableProd.getOptions(command);
        view.printSelectOption(optionList);
        view.provideOption();

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

    private Product getSpecyficProduct(List<Product> productList) {
        boolean isRun = true;
        Scanner scan = new Scanner(System.in);
        Product product = productList.get(0);

        SelectIteratorDAO selectIteratorDAO = new SelectIteratorPostgres(productList);

        while (isRun) {
            view.printProductDetails(product);
            String result = scan.nextLine().toLowerCase();

            if (result.equals("n")) {
                product = selectIteratorDAO.getNext();
            } else if (result.equals("p")) {
                product = selectIteratorDAO.getPrevious();
            } else if (result.equals("v")) {
                PSQLReadImage readImage = new PSQLReadImage(this.conn);
                readImage.run(String.valueOf(product.getName()));
            } else if (result.equals("a")) {
                isRun = false;
            } else if (result.equals("q")) {
                isRun = false;
                return null;
            }
        }
        return product;
    }
}
