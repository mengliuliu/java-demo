package com.mengliu.bigevent.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import com.mengliu.bigevent.service.CategoryService;    
import com.mengliu.bigevent.pojo.Result;
import com.mengliu.bigevent.pojo.Category;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;


    @PostMapping("/add")
    public Result<?> add(@RequestBody Category category) {
        if(categoryService.add(category)){
            return Result.success();
        }
        return Result.error("Add category failed");
    }

}

