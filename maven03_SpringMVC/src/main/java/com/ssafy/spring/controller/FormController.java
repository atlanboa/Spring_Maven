package com.ssafy.spring.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class FormController implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//폼값 받아서
		//vo 생성
		//dao호출
		//리턴된 값 바인딩
		//네이게이터
		
		String name = request.getParameter("name");
		String addr = request.getParameter("addr");
		
		
				
		
		 
		return new ModelAndView("form_result", "info", name+","+addr);
	}

}
