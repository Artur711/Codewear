package com.codecool.enums;

public enum UserInfo {

    FIRST_NAME("first name"),
    LAST_NAME("last name"),
    EMAIL("login/email"),
    PASSWORD("password"),
    ROLE("roleID");

    String display;

    UserInfo(String display) {
        this.display = display;
    }

    public String getDisplay() {
        return display;
    }
}
