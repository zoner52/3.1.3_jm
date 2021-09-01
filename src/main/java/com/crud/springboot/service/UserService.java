package com.crud.springboot.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import com.crud.springboot.model.User;

import java.util.List;

public interface UserService extends UserDetailsService {

    void addUser(User user);

    void updateUser(User user, long id);

    void deleteUser(long id);

    User getUserById(long id);

    List<User> getUsers();

    User getUserByName(String name);
}