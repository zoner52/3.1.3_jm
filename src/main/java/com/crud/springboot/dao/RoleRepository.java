package com.crud.springboot.dao;

import com.crud.springboot.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoleRepository extends JpaRepository<Role,Long> {

    Role getRoleById(long id);
    List<Role> getRolesById(long id);
}