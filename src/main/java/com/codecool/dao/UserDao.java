package com.codecool.dao;

import com.codecool.model.User;

public interface UserDao {

    int addUser(User user, int userRole);

    User validateUser(User user);

    void delete(User user);

    User getUserWithUserID(int userID);

    int getNumberOfRecords();

    void update(User user);

}
