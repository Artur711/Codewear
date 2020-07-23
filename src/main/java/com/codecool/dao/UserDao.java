package com.codecool.dao;

import com.codecool.model.User;

public interface UserDao {

    int addCustomerUser(User user);

    User validateUser(User user);
}
