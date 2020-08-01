package com.codecool.select;

import com.codecool.controllers.ApplicationController;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.util.Map;
import java.util.HashMap;


public class SelectPostgresTest {
    private final ApplicationController ac = new ApplicationController();
    private final Connection conn = ac.setup();
    private final SelectDAO selectObject = new SelectPostgres(conn, "TEST");
    private final String query = "SELECT * FROM products";
    private Map<String, String> optionToSelect;

    @Test
    void runTest() {
    }

    @Test
    void generateSelectQueryTest_Male() {
        optionToSelect = new HashMap<>();
        optionToSelect.put("gender", "Male");

        String command = selectObject.generateSelectQuery(query, optionToSelect);
        assertEquals("SELECT * FROM products where gender = 'Male'", command);
    }

    @Test
    void generateSelectQueryTest_Female_White() {
        optionToSelect = new HashMap<>();
        optionToSelect.put("gender", "Female");
        optionToSelect.put("colour", "white");

        String command = selectObject.generateSelectQuery(query, optionToSelect);
        assertEquals("SELECT * FROM products where gender = 'Female' and colour = 'white'", command);
    }

    @Test
    void generateSelectQueryTest_Female_TShirt_Red_XL() {
        optionToSelect = new HashMap<>();
        optionToSelect.put("gender", "Female");
        optionToSelect.put("type", "T-Shirt");
        optionToSelect.put("colour", "red");
        optionToSelect.put("sizes", "XL");

        String command = selectObject.generateSelectQuery(query, optionToSelect);
        String commandResult = "SELECT * FROM products where gender = 'Female' and type = 'T-Shirt' and colour = 'red' and sizes = 'XL'";
        assertEquals(commandResult, command);
    }

    @Test
    void generateSelectQueryTest_All_TShirt_All_XL() {
        optionToSelect = new HashMap<>();
        optionToSelect.put("gender", "All");
        optionToSelect.put("type", "T-Shirt");
        optionToSelect.put("colour", "All");
        optionToSelect.put("sizes", "XL");

        String command = selectObject.generateSelectQuery(query, optionToSelect);
        String commandResult = "SELECT * FROM products where type = 'T-Shirt' and sizes = 'XL'";
        assertEquals(commandResult, command);
    }

    @Test
    void generateSelectQueryTest_All() {
        optionToSelect = new HashMap<>();
        optionToSelect.put("gender", "All");
        optionToSelect.put("type", "All");
        optionToSelect.put("colour", "All");
        optionToSelect.put("sizes", "All");

        String command = selectObject.generateSelectQuery(query, optionToSelect);
        assertEquals("SELECT * FROM products", command);
    }
}