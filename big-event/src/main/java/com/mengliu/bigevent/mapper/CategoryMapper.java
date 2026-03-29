package com.mengliu.bigevent.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.mengliu.bigevent.pojo.Category;

@Mapper
public interface CategoryMapper {
    @Insert("INSERT INTO `category` (category_name, category_alias, create_user, create_time, update_time) VALUES (#{categoryName}, #{categoryAlias}, #{createUser}, #{createTime}, #{updateTime})")
    void insert(Category category);

    @Select("SELECT * FROM `category` WHERE create_user = #{userId}")
    List<Category> selectList(Integer userId);

}
