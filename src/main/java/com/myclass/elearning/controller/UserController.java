package com.myclass.elearning.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserController userController;

    @GetMapping
    public String index(){

        return "user/user-index";
    }

    @GetMapping("/add")
    public String add(){return "user/user-add";}
    
}
