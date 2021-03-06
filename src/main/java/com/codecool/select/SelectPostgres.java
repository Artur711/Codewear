package com.codecool.select;

import com.codecool.dao.TableProductsDAO;
import com.codecool.dao.TableProductsPostgres;
import com.codecool.view.SelectView;

import java.sql.*;
import java.util.*;

public class SelectPostgres implements SelectDAO {
    private SelectView view = new SelectView();
    private Connection conn;
    private List<List<Object>> objectList;
    private String command;
//    private List<String> optionToSelect = new ArrayList<>();
    private Map<String, String> mapOptionToSelect = new HashMap<>();
    private TableProductsDAO tableProd;
    private String [] selectOption = {"gender", "type", "colour", "sizes"};

    public SelectPostgres(Connection conn) {
        this.conn = conn;
        this.tableProd = new TableProductsPostgres(conn);
    }

    @Override
    public void run() {
        for (String option : selectOption) {
            getSelect(option);
        }

        command = generateSelectQuery("SELECT * FROM products", this.mapOptionToSelect);
        objectList = tableProd.getTableFromDatabase(command);
        view.printList(objectList);
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

        objectList = tableProd.getTableFromDatabase(command);
        List<Object> optionList= getOptions(objectList);
        view.printSelectOption(optionList);
        view.provideOption();

        while (isRun) {
            Scanner scan = new Scanner(System.in);
            try {
                int option = scan.nextInt();
                this.mapOptionToSelect.put(selectBY, String.valueOf(optionList.get(option - 1)));
//                this.optionToSelect.add(String.valueOf(optionList.get(option - 1)));
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
