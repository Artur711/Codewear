package com.codecool.select;

import com.codecool.datasource.TableProductsDAO;
import com.codecool.datasource.TableProductsPostgres;
import com.codecool.view.SelectView;

import java.sql.*;
import java.util.*;

public class SelectPostgres implements SelectDAO {
    private SelectView view = new SelectView();
    private Connection conn;
    private List<List<Object>> objectList;
    private String command;
    private List<String> optionToSelect = new ArrayList<>();
    private TableProductsDAO tableProd = new TableProductsPostgres(conn);
    private String [] selectOption = {"gender", "type", "colour", "sizes"};

    public SelectPostgres(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void run() {
        for (String option : selectOption) {
            getSelect(option);
        }

        command = generatSelectQuery("SELECT * FROM products");
        objectList = tableProd.getTableFromDatabase(command);
        view.printList(objectList);
    }

    @Override
    public String generatSelectQuery(String query) {
        Boolean isWhereStatement = false;
        StringBuilder sb = new StringBuilder(query);

        for (int index = 0; index < optionToSelect.size(); index++) {
            if (!optionToSelect.get(index).equals("All") && !isWhereStatement) {
                sb.append(String.format(" where %s = '%s'", selectOption[index], optionToSelect.get(index)));
                isWhereStatement = true;
            }
            else if (!optionToSelect.get(index).equals("All")) {
                sb.append(String.format(" and %s = '%s'", selectOption[index], optionToSelect.get(index)));
            }
        }
        return sb.toString();
    }

    private void getSelect(String selectBY) {
        command = generatSelectQuery(String.format("SELECT %s FROM products", selectBY));
        Boolean isRun = true;

        objectList = tableProd.getTableFromDatabase(command);
        List<Object> optionList= getOptions(objectList);
        view.printSelectOption(optionList);
        view.provideOption();

        while (isRun) {
            Scanner scan = new Scanner(System.in);
            try {
                int option = scan.nextInt();
                this.optionToSelect.add(String.valueOf(optionList.get(option - 1)));
                isRun = false;
            } catch (InputMismatchException | IndexOutOfBoundsException e) {
                scan.next();
            }
        }
    }

    private List<Object> getOptions(List<List<Object>> objectList) {
        List<Object> optionList = new ArrayList<>();

        for (int i = 0; i < objectList.size(); i++) {
            if (!optionList.contains(objectList.get(i).get(0))) {
                optionList.add(objectList.get(i).get(0));
            }
        }
        optionList.add("All");
        return optionList;
    }
}
