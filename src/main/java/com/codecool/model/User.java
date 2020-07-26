package com.codecool.model;

import com.codecool.enums.Role;

public class User {

    int id;
    String firstName;
    String lastName;
    String email;
    String password;
    String address;
    int roleID;

    public User(int id, String firstName, String lastName, String email, String password, String address, int roleID) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.address = address;
        this.roleID = roleID;
    }

    public User(String firstName, String lastName, String email, String password) {
        this(9999, firstName, lastName, email, password, null, Role.CUSTOMER.getRoleID());
    }

    public User(String firstName, String lastName, String email, String password, int roleID) {
        this(9999, firstName, lastName, email, password, null, roleID);
    }

    public User(String email, String password) {
        this(9999, null, null, email, password, null, Role.CUSTOMER.getRoleID());
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getRoleID() {
        return roleID;
    }

    public void setRoleID(int roleID) {
        this.roleID = roleID;
    }

    @Override
    public String toString() {
        return "id: " + id + "\n" +
                "firstName: " + firstName + '\n' +
                "lastName: '" + lastName + '\n' +
                "email: " + email + '\n' +
                "password: " + password + '\n' +
                "address: " + address + '\n' +
                "roleID: " + roleID;
    }
}
