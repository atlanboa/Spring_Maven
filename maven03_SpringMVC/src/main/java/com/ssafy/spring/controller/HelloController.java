package com.ssafy.spring.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;


public class HelloController implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();//결과 페이지 이름과 이동경로를 지정 + 여기에 데이터도 바인딩
		mv.setViewName("result");
		mv.addObject("message", "Hello First Spring MVC!!!");
		return mv;
	}

}
