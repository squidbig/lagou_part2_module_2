package com.lagou.homework.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
@RequestMapping("login")
public class LoginController {
	@RequestMapping("toLogin")
	public ModelAndView toLogin() {
		System.out.println("================++++++++++++++跳转登录页面");
		return new ModelAndView("client/login");
	}

	@RequestMapping("loginSystem")
	public String loginSystem(String username, String password, HttpSession session) {
		// 合法用户，信息写入session，同时跳转到系统主页面
		if ("admin".equals(username) && "admin".equals(password)) {
			System.out.println("合法用户");
			session.setAttribute("username", username);
			return "redirect:/resume/resumeList";
		} else {
			// 非法用户返回登录页面
			System.out.println("非法，跳转");
			return "redirect:/login/toLogin";
		}
	}
}
