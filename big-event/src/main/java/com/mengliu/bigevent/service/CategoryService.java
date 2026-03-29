package com.mengliu.bigevent.service;

import java.util.List;

import com.mengliu.bigevent.pojo.Category;

public interface CategoryService {
    boolean add(Category category);

    List<Category> list();

    Category detail(Integer id);

    boolean update(Category category);

    boolean delete(Integer id);

}
