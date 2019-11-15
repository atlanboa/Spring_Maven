package com.ssafy.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ssafy.service.MyProductService;
import com.ssafy.vo.MyProductVO;

//Presentation Layer Bean

@Controller
public class MyProductController {

	@Autowired
	private MyProductService myProductService;
	
	/*
	 * form의 입력된 값, 이름이 setter로 들어가서 vo를 만들어줌.
	 */
	
	@RequestMapping("myProduct.do")
	public ModelAndView insert(HttpServletRequest request, HttpServletResponse response, MyProductVO pvo) throws Exception{
		
		System.out.println("1. 폼으로 받은 데이터 : "+pvo.getId());
		myProductService.addProduct(pvo);
		System.out.println("2. 폼으로 받은 데이터 : "+pvo.getId());
		return new ModelAndView("insert_result", "info", pvo);
		
	}
	
	@RequestMapping("myProduct2.do")
	public ModelAndView getProduct(HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		String word = request.getParameter("word");
		
		List<MyProductVO> list =  myProductService.getProduct(word);
		
		return new ModelAndView("find_result", "list", list);
		
	}
}
