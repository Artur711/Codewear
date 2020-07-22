package com.codecool.dao;

import com.codecool.model.User;

public interface UserDao {

    int addCustomerUser(User user);

    boolean isRegistered(User user);
}
