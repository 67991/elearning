package com.myclass.elearning.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/target")
public class TargetController {

    @GetMapping
    public String index(){
        return "target/target-list";
    }

    @GetMapping("/add")
    public String add(){return "target/target-add";}
    
}
