package com.lagou.homework;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.lagou.homework.pojo.Article;
import com.lagou.homework.repository.ArticleRepository;

@SpringBootTest
class SpringbootHomeworkApplicationTests {

	@Test
	void contextLoads() {
	}

	@Autowired
	private ArticleRepository articleRepository;
	
	@Test
	public void selectArticle() {
		List<Article> li=articleRepository.findAll();
		for (Article article : li) {
			System.out.println(article.toString());
		}
		
	}
	
}
