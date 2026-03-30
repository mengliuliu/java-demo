package com.mengliu.bigevent.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.mengliu.bigevent.pojo.Result;
import com.mengliu.bigevent.service.ArticleService;
import com.mengliu.bigevent.pojo.Article;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import java.util.List;
import com.mengliu.bigevent.pojo.PageBean;

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
    public Result<PageBean> list(@RequestParam Integer pageNum, @RequestParam Integer pageSize,
            @RequestParam Integer categoryId) {

        PageHelper.startPage(pageNum, pageSize);

        List<Article> articles = articleService.list(categoryId);
        System.out.println("articles: " + articles.size());
        PageInfo<Article> pageInfo = new PageInfo<>(articles);

        // 1.创建PageBean对象
        PageBean<Article> pb = new PageBean<>();
        pb.setTotal(pageInfo.getTotal());
        pb.setItems(pageInfo.getList());

        return Result.success(pb);
    }

}
