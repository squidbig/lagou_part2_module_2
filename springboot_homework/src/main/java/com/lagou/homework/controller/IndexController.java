package com.lagou.homework.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import com.lagou.homework.pojo.Article;
import com.lagou.homework.repository.ArticleRepository;

@Controller
public class IndexController {
	
	@Autowired
	private ArticleRepository articleRepository;
	private final int eachPage=2;
	
	
	@RequestMapping("/index")
	public ModelAndView toIndex(Model mode) {
		Pageable pageable=PageRequest.of(0, eachPage);
		Page<Article> li=articleRepository.findAll(pageable);
		mode.addAttribute("ArticleList", li);
		mode.addAttribute("currentPage", 1);
		return new ModelAndView("client/index");
	}
	
	@RequestMapping(value = "/pageChange", method = RequestMethod.POST)
	public ModelAndView pageChange(HttpServletRequest request,Model mode) {
		
		int currentPange=Integer.parseInt(request.getParameter("currentPage"));
		currentPange=currentPange<1?0:currentPange-1;
		
		int type=Integer.parseInt(request.getParameter("pagetype"));
		if(type==1) {
			if(currentPange>0) {
				currentPange--;
			}
		} else {
			currentPange++;
		}
		
		Pageable pageable=PageRequest.of(currentPange, eachPage);
		Page<Article> li=articleRepository.findAll(pageable);
		mode.addAttribute("ArticleList", li);
		mode.addAttribute("currentPage", ++currentPange);
		return new ModelAndView("client/index");
	}
	
}
