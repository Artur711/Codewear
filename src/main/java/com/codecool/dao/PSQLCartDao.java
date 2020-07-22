package com.codecool.dao;

import com.codecool.datasource.SQLDataSource;
import com.codecool.enums.Role;
import com.codecool.model.Product;
import com.codecool.model.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PSQLCartDao implements CartDao{

    @Override
    public int addProductToCart(Product product) {

        return 0;
    }
}
