package com.crud.springboot.dao;

import com.crud.springboot.model.User;

import java.util.List;

public interface UserDao {
    void addUser(User user);

    void updateUser(User user, long id);

    void deleteUser(long id);

    User getUserById(long id);

    List<User> getUsers();

    User getUserByName(String name);
}