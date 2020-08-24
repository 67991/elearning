package com.myclass.elearning.controller;

import com.myclass.elearning.enity.Role;
import com.myclass.elearning.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/role")
public class RoleController {
    @Autowired
    private RoleService roleService;

    @GetMapping
    public String index(ModelMap modelMap)
    {
        modelMap.addAttribute("roles", roleService.findAll());
        return "role/role-index";
    }

    @GetMapping("/add")
    public String add(){return "role/role-add";}
    @PostMapping("/add")
    public String add(Role role){
        roleService.save(role);
        return "redirect:/role";
    }
    @GetMapping("/delete")
    public String delete(int id){
        roleService.delete(id);
        return "redirect:/role";
    }
    @GetMapping("/edit")
    public String edit(int id, ModelMap modelMap){
        modelMap.addAttribute("role",roleService.findById(id));
        return "role/role-edit";
    }
    @PostMapping("/edit")
    public String edit(Role role){
        roleService.save(role);
        return "redirect:/role";
    }
}
