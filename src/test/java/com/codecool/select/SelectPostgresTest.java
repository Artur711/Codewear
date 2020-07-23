package com.codecool.select;

import com.codecool.controllers.ApplicationController;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SelectPostgresTest {
    private List<String> optionToSelect;
    private String [] selectOption = {"gender", "type", "colour", "sizes"};
    private ApplicationController ac = new ApplicationController();
    private Connection conn = ac.setup();
    private SelectDAO selectObject = new SelectPostgres(conn);
    private String query = "SELECT * FROM products";

    @Test
    void runTest() {
    }

    @Test
    void generatSelectQueryTest_Male() {
        optionToSelect = new ArrayList<>(Arrays.asList("Male"));
        String command = selectObject.generatSelectQuery(query, optionToSelect);
        assertEquals("SELECT * FROM products where gender = 'Male'", command);
    }

    @Test
    void generatSelectQueryTest_Female_White() {
        optionToSelect = new ArrayList<>(Arrays.asList("Female", "white"));
        String command = selectObject.generatSelectQuery(query, optionToSelect);
        assertEquals("SELECT * FROM products where gender = 'Female' and colour = 'white'", command);
    }

    @Test
    void generatSelectQueryTest_Female_TShirt_Red_XL() {
        optionToSelect = new ArrayList<>(Arrays.asList("Female", "T-Shirt", "red", "XL"));
        String command = selectObject.generatSelectQuery(query, optionToSelect);
        String commandResult = "SELECT * FROM products where gender = 'Female' and type = 'T-Shirt' and colour = 'red' and sizes = 'XL'";
        assertEquals(commandResult, command);
    }

    @Test
    void generatSelectQueryTest_All() {
        optionToSelect = new ArrayList<>(Arrays.asList("All", "All", "All", "All"));
        String command = selectObject.generatSelectQuery(query, optionToSelect);
        assertEquals("SELECT * FROM products", command);
    }
}