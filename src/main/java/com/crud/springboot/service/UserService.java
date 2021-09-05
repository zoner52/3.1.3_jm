package com.crud.springboot.service;

import com.crud.springboot.model.Role;
import org.springframework.security.core.userdetails.UserDetailsService;
import com.crud.springboot.model.User;

import java.util.List;

public interface UserService {

    User getUserByName(String username);

    List<User> getAllUsers();

    void saveUser(User user);

    User getUser(long id);

    void deleteUser(long id);

    List<Role> getAllRoles();

    Role getRoleById(long id);
}