package com.myclass.elearning.api;

import com.myclass.elearning.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RoleApiController {
    @Autowired
    private RoleService roleService;


    @GetMapping("/api/roles")
    public Object all(){
        return roleService.findAll();    }
}
