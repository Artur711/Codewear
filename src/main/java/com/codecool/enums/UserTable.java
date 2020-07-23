package com.codecool.enums;

public enum UserTable {

    ID(1,"id"),
    FIRST_NAME(2, "first_name"),
    LAST_NAME(3, "last_name"),
    EMAIL(4, "email"),
    PASSWORD(5, "password"),
    ADDRESS(6, "address"),
    USER_ROLE(7, "user_role");

    int index;
    String columnName;

    UserTable(int index, String columnName) {
        this.index = index;
        this.columnName = columnName;
    }

    public int getIndex() {
        return index;
    }

    public String getColumnName() {
        return columnName;
    }
}
