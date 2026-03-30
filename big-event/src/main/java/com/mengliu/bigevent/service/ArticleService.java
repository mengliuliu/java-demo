package com.mengliu.bigevent.service;

import com.mengliu.bigevent.pojo.Article;
import java.util.List;

public interface ArticleService {

    boolean add(Article article);

    List<Article> list(Integer categoryId);

}
