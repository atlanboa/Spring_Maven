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

//Presentation Layer빈 
@Controller
public class MyProductController {
	
	@Autowired
	private MyProductService myProductService;
	
	@RequestMapping("myProduct.do")
	public ModelAndView insert(HttpServletRequest request, HttpServletResponse response,MyProductVO pvo)
																throws Exception{
		System.out.println("1. 폼으로 받은 데이타 : "+pvo.getId());//0
		myProductService.addProduct(pvo);
		System.out.println("2. 폼으로 받은 데이타 : "+pvo.getId());//5
		return new ModelAndView("insert_result","info", pvo);
	}
	
	@RequestMapping("myProduct2.do")
	public ModelAndView getProducts(HttpServletRequest request, HttpServletResponse response)
																throws Exception{
		String name=request.getParameter("word");
		List<MyProductVO> list=myProductService.getProducts(name);
		
		return new ModelAndView("find_result","list", list);
	}

}













