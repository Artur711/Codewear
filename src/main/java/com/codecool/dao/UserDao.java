package com.codecool.dao;

import com.codecool.model.User;

import java.util.List;

public interface UserDao {

    int addUser(User user, int userRole);

    User validateUser(User user);

    void delete(User user);

    List<User> getUserWithUserID(int userID);

    int getNumberOfRecords();

    void update(User user);

    int[] findMaxNumberOfCharsPerColumn();

}
