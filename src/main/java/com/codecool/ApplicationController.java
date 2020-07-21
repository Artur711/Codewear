package com.codecool;

import com.codecool.file_handler.FileReaderApplication;
import com.codecool.file_handler.FileReaderDAO;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

public class ApplicationController {


    public void run() throws IOException {
        String path = "./src/main/resources/database.properties";
        FileReaderDAO fr = new FileReaderApplication(path);
        Map<String, String> mapSting = fr.readFile();

        String databaseName = mapSting.get("db.database");
        String user = mapSting.get("db.user");
        String password = mapSting.get("db.passwd");

        SQLDataSource datasource = new PostgresSQLDataSource(databaseName, user, password);
        String sql = "SELECT * FROM products";
        try(
                PreparedStatement st = datasource.connect().getConnection().prepareStatement(sql);
                ResultSet rs = st.executeQuery()) {
            while (rs.next()) {
                System.out.println(rs.getInt(1) + rs.getString(2));
            }

        } catch (
                SQLException e) {
            System.out.println("Error executing query");
        }
    }
}
