package com.ssafy.spring.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ssafy.spring.service.MemberService;
import com.ssafy.spring.vo.MemberVO;

@Controller
public class MemberController {
	@Autowired
	private MemberService memberService;
	
	
	@RequestMapping("memberLogin.do")
	public ModelAndView login(HttpServletRequest request, HttpServletResponse response, HttpSession session, MemberVO vo) throws SQLException {
		
		System.out.println(vo);
		MemberVO rvo = memberService.loginCheck(vo);
		System.out.println(rvo);
		String msg ="아이디 또는 패스워드가 틀립니다.";
		String path ="index.jsp";
		if(rvo != null) {
			session.setAttribute("user", rvo);
			
			msg = "정상적으로 로그인 되었습니다";
		}
		session.setAttribute("msg", msg);
		
		return new ModelAndView("redirect:"+path);
	}
	
	@RequestMapping("memberLogout.do")
	public ModelAndView logout(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws SQLException {
		

		String path ="index.jsp";
		session.invalidate();
		
		return new ModelAndView("redirect:"+path);
	}
	
}
