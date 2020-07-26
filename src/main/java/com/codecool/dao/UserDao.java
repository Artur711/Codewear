package com.codecool.dao;

import com.codecool.model.User;

public interface UserDao {

    int addCustomerUser(User user);

    int addOtherUser(User user);

    User validateUser(User user);

    void delete(User user);


}
