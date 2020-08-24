package com.myclass.elearning.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/category")
public class CategoryController {

    @GetMapping
    public String index(){
        return "category/category-index";
    }

    @GetMapping("/add")
    public String add(){return "category/category-add";}
    
}
