package com.codecool.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PSQLWriteImage {
    private Connection conn;

    public PSQLWriteImage(Connection conn) {
        this.conn = conn;
    }

    public void run (String fileName) {
        String query = "INSERT INTO products_images (product_name, image) VALUES(?, ?)";

        try (PreparedStatement pst = this.conn.prepareStatement(query)) {
            String str = String.format("src/main/resources/data/images/%s.jpg", fileName);
            File img = new File(str);

            try (FileInputStream fin = new FileInputStream(img)) {
                pst.setString(1, fileName);
                pst.setBinaryStream(2, fin, (int) img.length());
                pst.executeUpdate();
            } catch (IOException ex) {
                Logger.getLogger(PSQLWriteImage.class.getName()).log(
                        Level.SEVERE, ex.getMessage(), ex);
            }
        } catch (SQLException ex) {
            Logger lgr = Logger.getLogger(PSQLReadImage.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }

    }
}
