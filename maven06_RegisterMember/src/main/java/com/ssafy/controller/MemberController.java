package com.ssafy.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ssafy.model.MemberVO;
import com.ssafy.service.MemberService;

@Controller
public class MemberController {
	@Autowired
	private MemberService memberService;

	@RequestMapping("idcheck.do")
	public ModelAndView idcheck(HttpServletRequest request, HttpServletResponse response, String id) throws Exception {

		String result = (String) memberService.idcheck(id);
		boolean flag = false;
		if (result != null)
			flag = true;
		return new ModelAndView("idcheck", "flag", flag);

	}

	@RequestMapping("register.do")
	public ModelAndView register(HttpServletRequest request, HttpServletResponse response, MemberVO pvo)
			throws Exception {

		memberService.registerMember(pvo);
		return new ModelAndView("redirect:allMember.do");

	}

	@RequestMapping("login.do") // 세션에 바인딩해야하는 로직 ; login, update
	public ModelAndView login(HttpServletRequest request, HttpServletResponse response, HttpSession session,
			MemberVO pvo) throws Exception {

		MemberVO rvo = memberService.login(pvo);

		String path = "login_fail";
		if (rvo != null) {
			path = "login_ok";
			session.setAttribute("vo", rvo);
		}

		return new ModelAndView(path);

	}

	@RequestMapping("logout.do")
	public ModelAndView logout(HttpServletRequest request, HttpServletResponse response, HttpSession session)
			throws Exception {

		if (session.getAttribute("vo") != null)
			session.invalidate();
		return new ModelAndView("redirect:index.jsp");

	}

	@RequestMapping("update.do")
	public ModelAndView update(HttpServletRequest request, HttpServletResponse response,HttpSession session , MemberVO vo) throws Exception {

		memberService.updateMember(vo);
		session.setAttribute("vo", vo);

		return new ModelAndView("update_result");

	}

	@RequestMapping("getAddressKind.do")
	public ModelAndView getAddress(HttpServletRequest request, HttpServletResponse response) throws Exception {

		List<String> list = memberService.getAddressKind();

		return new ModelAndView("findByAddress", "list", list);

	}
	

	@RequestMapping("findByAddress.do")
	public ModelAndView findByAddress(HttpServletRequest request, HttpServletResponse response, String address) throws Exception {

		List<MemberVO> list = memberService.findByAddress(address);

		return new ModelAndView("findByAddress_result", "memList", list);

	}
	
	@RequestMapping("allMember.do")
	public ModelAndView allMember(HttpServletRequest request, HttpServletResponse response) throws Exception {

		List<MemberVO> list = memberService.getAllMember();

		return new ModelAndView("allMember_result", "allList", list);

	}
}
