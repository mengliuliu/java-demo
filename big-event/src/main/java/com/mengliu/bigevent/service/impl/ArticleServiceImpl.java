package com.mengliu.bigevent.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mengliu.bigevent.mapper.ArticleMapper;
import com.mengliu.bigevent.pojo.Article;
import com.mengliu.bigevent.service.ArticleService;
import com.mengliu.bigevent.utils.ThreadLocalUtil;

@Service
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    private ArticleMapper articleMapper;

    @Override
    public boolean add(Article article) {
        article.setCreateTime(LocalDateTime.now());
        article.setUpdateTime(LocalDateTime.now());
        Map<String, Object> claims = ThreadLocalUtil.get();
        article.setCreateUser((Integer) claims.get("id"));
        return articleMapper.insert(article) > 0;
    }

    @Override
    public List<Article> list(Integer categoryId) {
        return articleMapper.selectList(categoryId);
    }

}
