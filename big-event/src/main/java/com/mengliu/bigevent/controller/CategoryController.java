package com.mengliu.bigevent.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;

import com.mengliu.bigevent.pojo.Category;
import com.mengliu.bigevent.pojo.Result;
import com.mengliu.bigevent.service.CategoryService;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping("/add")
    public Result<?> add(@RequestBody Category category) {
        if (categoryService.add(category)) {
            return Result.success();
        }
        return Result.error("Add category failed");
    }

    @GetMapping("/list")
    public Result<List<Category>> list() {
        List<Category> categories = categoryService.list();
        return Result.success(categories);

    }

    @GetMapping("/detail")
    public Result<Category> detail(@RequestParam Integer id) {
        Category category = categoryService.detail(id);
        return Result.success(category);
    }

    @PutMapping("/update")
    public Result<?> update(@RequestBody Category category) {
        if (categoryService.update(category)) {
            return Result.success();
        }
        return Result.error("Update category failed");
    }

    @DeleteMapping("/delete")
    public Result<?> delete(@RequestParam Integer id) {
        if (categoryService.delete(id)) {
            return Result.success();
        }
        return Result.error("Delete category failed");
    }

}
