package com.myclass.elearning.service;

import com.myclass.elearning.enity.Role;

import java.util.List;

public interface RoleService {
    List<Role> findAll();
    Role findById(int id);
    void save(Role role);
    void delete(int id);

}
