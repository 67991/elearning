package com.myclass.elearning.service;

import com.myclass.elearning.enity.Role;
import com.myclass.elearning.repo.RoleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImp implements RoleService{
    @Autowired
    private RoleRepo roleRepo;

    @Override
    public List<Role> findAll() {
        List<Role> list = roleRepo.findAll();
        return list;
    }

    @Override
    public Role findById(int id) {

        return roleRepo.findById(id).get();
    }

    @Override
    public void save(Role role) {
        roleRepo.save(role);
    }

    @Override
    public void delete(int id) {
            Role role = roleRepo.findById(id).get();
            roleRepo.delete(role);
    }
}
