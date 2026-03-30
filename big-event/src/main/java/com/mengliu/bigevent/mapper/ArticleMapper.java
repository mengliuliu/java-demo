package com.mengliu.bigevent.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import java.util.List;
import com.mengliu.bigevent.pojo.Article;

@Mapper
public interface ArticleMapper {

    @Insert("INSERT INTO `article` (title, content, cover_img, state, category_id, create_user, create_time, update_time) VALUES (#{title}, #{content}, #{coverImg}, #{state}, #{categoryId}, #{createUser}, #{createTime}, #{updateTime})")
    int insert(Article article);


    @Select("SELECT * FROM `article` WHERE category_id = #{categoryId}")
    List<Article> selectList(Integer categoryId);
}
