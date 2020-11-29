package com.lagou.homework.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lagou.homework.pojo.Article;

public interface ArticleRepository extends JpaRepository<Article,Integer> {

}
