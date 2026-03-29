package com.mengliu.bigevent.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mengliu.bigevent.mapper.CategoryMapper;
import com.mengliu.bigevent.pojo.Category;
import com.mengliu.bigevent.service.CategoryService;
import com.mengliu.bigevent.utils.ThreadLocalUtil;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public boolean add(Category category) {
        category.setCreateTime(LocalDateTime.now());
        category.setUpdateTime(LocalDateTime.now());

        Map<String, Object> claims = ThreadLocalUtil.get();
        Integer userId = (Integer) claims.get("id");
        category.setCreateUser(userId);
        categoryMapper.insert(category);
        return true;
    }


    @Override
    public List<Category> list() {
        Map<String, Object> claims = ThreadLocalUtil.get();
        Integer userId = (Integer) claims.get("id");
        System.out.println("userId: " + userId);
        return categoryMapper.selectList(userId);
    }

    @Override
    public Category detail(Integer id) {
        return categoryMapper.selectById(id);
    }


    @Override
    public boolean update(Category category) {
        category.setUpdateTime(LocalDateTime.now());
        return categoryMapper.updateById(category) > 0;
    }

    @Override
    public boolean delete(Integer id) {
        return categoryMapper.delete(id) > 0;
    }
}
