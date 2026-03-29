package com.mengliu.bigevent.service;

import java.util.List;

import com.mengliu.bigevent.pojo.Category;

public interface CategoryService {
    boolean add(Category category);

    List<Category> list();

}
