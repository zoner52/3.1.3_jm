package com.crud.springboot.dao;

import com.crud.springboot.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User getUserByUsername(String name);
    User getUserByEmail(String email);

}