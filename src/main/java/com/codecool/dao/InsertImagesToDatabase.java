package com.codecool.dao;

import com.codecool.datasource.PostgresSQLDataSource;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class InsertImagesToDatabase {
    private Connection conn = setup();

    public static void main(String[] args) {
        new InsertImagesToDatabase().run();
    }

    private void run() {
        String[] fileNames = {"Woman T-Shirt model 1", "Woman T-Shirt model 2", "Woman T-Shirt model 3",
                "Men T-Shirt model 1", "Men T-Shirt model 2", "Men T-Shirt model 3", "Men T-Shirt model 4",
                "Men T-Shirt model 5", "Men T-Shirt model 6", "Men T-Shirt model 7", "Men T-Shirt model 8",
                "Woman Leggins model 1", "Woman Leggins model 2", "Men Sweatshirt model 1", "Men Sweatshirt model 2",
                "Men Pants model 1", "Men Pants model 2", "Men Pants model 3", "Men Jacket model 1",
                "Men Jacket model 2", "Woman Jacket model 1", "Woman Jacket model 2", "Woman Jacket model 3",
                "Men Sweatshirt model 3", "Woman Sweatshirt model 1", "Woman Sweatshirt model 2",
                "Woman Sweatshirt model 3", "Woman Sweatshirt model 4", "Woman Pants model 1", "Woman Pants model 2"};

        changeInDatabase("DROP TABLE IF EXISTS products_images;");
        changeInDatabase("CREATE TABLE products_images (product_name character varying(255) UNIQUE NOT NULL, image bytea);");

        for (String fileName : fileNames) {
            new PSQLWriteImage(this.conn).run(fileName);
        }
    }

    private Connection setup() {
        try (InputStream input = new FileInputStream("./src/main/resources/database.properties")) {
            Properties prop = new Properties();
            prop.load(input);
            String databaseName = prop.getProperty("db.database");
            String user = prop.getProperty("db.user");
            String password = prop.getProperty("db.passwd");
            return new PostgresSQLDataSource(databaseName, user, password).connect();
        } catch (IOException e) {
            System.out.println("The file doesn't exist!!!");
        }
        return null;
    }

    private void changeInDatabase(String query) {
        try (PreparedStatement pst = this.conn.prepareStatement(query)) {
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger lgr = Logger.getLogger(InsertImagesToDatabase.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }
    }
}
