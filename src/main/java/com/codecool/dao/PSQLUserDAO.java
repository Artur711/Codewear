package com.codecool.dao;

import com.codecool.datasource.SQLDataSource;
import com.codecool.enums.Role;
import com.codecool.model.User;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PSQLUserDAO implements UserDAO {

    SQLDataSource dataSource;

    public PSQLUserDAO(SQLDataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public int addCustomerUser(User user) {
        String sql = "INSERT INTO users (first_name, last_name, email, password, address, user_role) VALUES (?, ?, ?, ?, ?, ?)";
        try(PreparedStatement st = dataSource.connect().getConnection().prepareStatement(sql)) {
            st.setString(1, user.getFirstName());
            st.setString(2, user.getLastName());
            st.setString(3, user.getEmail());
            st.setString(4, user.getPassword());
            st.setString(5, user.getAddress());
            st.setInt(6, Role.CUSTOMER.getRoleID());
            return st.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error executing query: " + e.getMessage());
        }
        return 0;

    }
}
