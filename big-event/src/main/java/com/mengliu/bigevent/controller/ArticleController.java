package com.mengliu.bigevent.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/article")
public class ArticleController {
    // @Autowired
    // private ArticleService articleService;

    @GetMapping()
    public String list() {

        return "article/list";
    }

}
