package com.codecool.enums;

public enum Role {

    ADMIN(1),
    EMPLOYEE(2),
    CUSTOMER(3);

    int roleID;

    Role(int roleID) {
        this.roleID = roleID;
    }

    public int getRoleID() {
        return roleID;
    }
}
