package com.codecool.dao;

import com.codecool.enums.UserTable;
import com.codecool.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PSQLUserDao implements UserDao {

    private final Connection conn;

    public PSQLUserDao(Connection conn) {
        this.conn = conn;
    }

    @Override
    public int addUser(User user, int userRole) {
        String sql = "INSERT INTO users (first_name, last_name, email, password, user_role) VALUES (?, ?, ?, ?, ?)";
        try(PreparedStatement st = conn.prepareStatement(sql)) {
            st.setString(1, user.getFirstName());
            st.setString(2, user.getLastName());
            st.setString(3, user.getEmail());
            st.setString(4, user.getPassword());
            st.setInt(5, userRole);
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

    @Override
    public void delete(User user) {
        String sql = "DELETE FROM users WHERE id = ?";
        try(PreparedStatement st = conn.prepareStatement(sql)) {
            st.setInt(1, user.getId());

            st.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error executing query: " + e.getMessage());
        }
    }

    @Override
    public List<User> getUserWithUserID(int id) {
        String sql = "SELECT id, first_name, last_name, email, password, address, user_role FROM users WHERE id = ?";
        List<User> users = new ArrayList<>();
        try(PreparedStatement st = conn.prepareStatement(sql)) {
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                User user = new User(id);
                user.setFirstName(rs.getString(UserTable.FIRST_NAME.getIndex()));
                user.setLastName(rs.getString(UserTable.LAST_NAME.getIndex()));
                user.setEmail(rs.getString(UserTable.EMAIL.getIndex()));
                user.setPassword(rs.getString(UserTable.PASSWORD.getIndex()));
                user.setAddress(rs.getString(UserTable.ADDRESS.getIndex()));
                user.setRoleID(rs.getInt(UserTable.USER_ROLE.getIndex()));
                users.add(user);
            }
        } catch (SQLException e) {
            System.out.println("Error executing query: " + e.getMessage());
        }
        return users;
    }

    @Override
    public int getNumberOfRecords() {
        String sql = "SELECT count(*) FROM users";
        try(PreparedStatement st = conn.prepareStatement(sql)) {
            ResultSet rs = st.executeQuery();
            if (rs.next()) return rs.getInt(1);

        } catch (SQLException e) {
            System.out.println("Error executing query: " + e.getMessage());
        }
        return 0;
    }

    @Override
    public void update(User user) {
        String sql = "UPDATE users SET first_name = ?, last_name = ?, email = ?, password = ?, address = ?, user_role = ? WHERE id = ?";
        try(PreparedStatement st = conn.prepareStatement(sql)) {
            st.setString(1, user.getFirstName());
            st.setString(2, user.getLastName());
            st.setString(3, user.getEmail());
            st.setString(4, user.getPassword());
            st.setString(5, user.getAddress());
            st.setInt(6, user.getRoleID());
            st.setInt(7,user.getId());

            st.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error executing query: " + e.getMessage());
        }
    }

    @Override
    public int[] findMaxNumberOfCharsPerColumn() {
        int numberOfColumns = 6;
        int[] maxLengths = new int[numberOfColumns];
        String sql = "SELECT " +
                "max(length(cast(id as varchar(20)))), " +
                "max(length(first_name)), " +
                "max(length(last_name)), " +
                "max(length(email)), " +
                "max(length(password)), " +
                "max(length(cast(user_role as varchar(20)))) " +
                "FROM users";

        try(PreparedStatement st = conn.prepareStatement(sql)) {
            ResultSet rs = st.executeQuery();
            rs.next();
            for (int i = 0; i < maxLengths.length; i++) {
                maxLengths[i] = rs.getInt(i + 1);
            }

        } catch (SQLException e) {
            System.out.println("Error executing query: " + e.getMessage());
        }
        return maxLengths;
    }

}