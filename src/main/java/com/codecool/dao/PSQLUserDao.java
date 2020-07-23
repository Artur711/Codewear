package com.codecool.dao;

import com.codecool.enums.Role;
import com.codecool.enums.UserTable;
import com.codecool.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PSQLUserDao implements UserDao {

    private final Connection conn;

    public PSQLUserDao(Connection conn) {
        this.conn = conn;
    }

    @Override
    public int addCustomerUser(User user) {
        String sql = "INSERT INTO users (first_name, last_name, email, password, user_role) VALUES (?, ?, ?, ?, ?)";
        try(PreparedStatement st = conn.prepareStatement(sql)) {
            st.setString(1, user.getFirstName());
            st.setString(2, user.getLastName());
            st.setString(3, user.getEmail());
            st.setString(4, user.getPassword());
            st.setInt(5, Role.CUSTOMER.getRoleID());
            return st.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error executing query: " + e.getMessage());
        }
        return 0;

    }

    @Override
    public User validateUser(User user) {
        String sql = "SELECT id, first_name, last_name, email, password, address, user_role FROM users WHERE email = ? and password = ?";
        try(PreparedStatement st = conn.prepareStatement(sql)) {
            st.setString(1, user.getEmail());
            st.setString(2, user.getPassword());
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                user.setId(rs.getInt(UserTable.ID.getIndex()));
                user.setFirstName(rs.getString(UserTable.FIRST_NAME.getIndex()));
                user.setLastName(rs.getString(UserTable.LAST_NAME.getIndex()));
                user.setAddress(rs.getString(UserTable.ADDRESS.getIndex()));
                user.setRoleID(rs.getInt(UserTable.USER_ROLE.getIndex()));
                return user;
            }
        } catch (SQLException e) {
            System.out.println("Error executing query: " + e.getMessage());
        }
        return null;
    }
}