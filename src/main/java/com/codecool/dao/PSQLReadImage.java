package com.codecool.dao;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PSQLReadImage {
    private Connection conn;

    public PSQLReadImage(Connection conn) {
        this.conn = conn;
    }

    public void run (String productName) {
        String query = String.format("SELECT image, LENGTH(image) FROM products_images where product_name = '%s'", productName);

        try (PreparedStatement pst = this.conn.prepareStatement(query);
             ResultSet rs = pst.executeQuery()) {

            rs.next();
            byte[] buf = rs.getBytes("image");

            ByteArrayInputStream bais = new ByteArrayInputStream(buf);

            BufferedImage img= ImageIO.read(bais);
            ImageIcon icon=new ImageIcon(img);
            JFrame frame=new JFrame();
            frame.setLayout(new FlowLayout());
            frame.setSize(500,500);
            JLabel lbl=new JLabel();
            lbl.setIcon(icon);
            frame.add(lbl);
            frame.setVisible(true);
//            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        } catch (SQLException | IOException ex) {

            Logger lgr = Logger.getLogger(PSQLReadImage.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }
    }
}
