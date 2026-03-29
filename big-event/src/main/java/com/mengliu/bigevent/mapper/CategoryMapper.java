package com.mengliu.bigevent.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.mengliu.bigevent.pojo.Category;

@Mapper
public interface CategoryMapper {
    @Insert("INSERT INTO `category` (category_name, category_alias, create_user, create_time, update_time) VALUES (#{categoryName}, #{categoryAlias}, #{createUser}, #{createTime}, #{updateTime})")
    void insert(Category category);

    @Select("SELECT * FROM `category` WHERE create_user = #{userId}")
    List<Category> selectList(Integer userId);

    @Select("SELECT * FROM `category` WHERE id = #{id}")
    Category selectById(Integer id);

    @Update("UPDATE `category` SET category_name = #{categoryName}, category_alias = #{categoryAlias}, update_time = #{updateTime} WHERE id = #{id}")
    Integer updateById(Category category);

    @Delete("DELETE FROM `category` WHERE id = #{id}")
    Integer delete(Integer id);

}
