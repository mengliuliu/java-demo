package com.mengliu.bigevent.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

import com.mengliu.bigevent.pojo.Result;
import com.mengliu.bigevent.service.ArticleService; 
import com.mengliu.bigevent.pojo.Article;

@RestController
@RequestMapping("/article")
public class ArticleController {
    @Autowired
    private ArticleService articleService;

    @PostMapping("/add")
    public Result<?> add(@RequestBody Article article) {
        if (articleService.add(article)) {
            return Result.success();
        }
        return Result.error("Add article failed");
    }

    @GetMapping()
    public String list() {

        return "article/list";
    }

}
