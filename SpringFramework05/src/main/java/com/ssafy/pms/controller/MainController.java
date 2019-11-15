package com.ssafy.pms.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ssafy.pms.dto.Phone;
import com.ssafy.pms.dto.UserInfo;
import com.ssafy.pms.service.IPhoneService;

@Controller
public class MainController {

	@Autowired
	private IPhoneService service;

	@GetMapping("regPhone.do")
	public String getRegPhone(Model model) {
		model.addAttribute("title", "핸드폰 관리 - 핸드폰 등록");
		return "PhoneReg";
	}

	@PostMapping("regPhone.do")
	public String doRegPhone(Phone phone, Model model) {

		try {
			service.insert(phone);
			model.addAttribute("title", "핸드폰 관리 - 핸드폰 등록 성공!!");
			return "Result";
		} catch (Exception e) {
			model.addAttribute("title", "핸드폰 관리 - 핸드폰 에러!!");
			model.addAttribute("message", "문제 내용 - 저장중 오류가 발생했습니다.!!");
			return "Error";
		}

	}

	@GetMapping("searchPhone.do")
	public String doSearch(Model model) {
		try {
			List<Phone> list = service.select();
			model.addAttribute("title", "핸드폰 관리 - 핸드폰 등록 성공!!");
			model.addAttribute("phones", list);
			return "PhoneList";
		} catch (Exception e) {
			model.addAttribute("title", "핸드폰 관리 - 에러!!");
			model.addAttribute("message", "핸드폰 관리 - 목록 조회중 오류가 발생했습니다.!!");
			return "Error";
		}
	}

	// 상세조회보기
	// 로그인

	@GetMapping("detail.do")
	public String doDetail(Phone phone, Model model) {

		try {
			Phone rvo = service.select(phone);
			model.addAttribute("title", "핸드폰 관리 - 핸드폰 조회 성공!!");
			model.addAttribute("phone", rvo);
			return "PhoneView";
		} catch (Exception e) {
			model.addAttribute("title", "핸드폰 관리 - 에러!!");
			model.addAttribute("message", "핸드폰 관리 - 조회에 실패하였습니다.!!");
			return "Error";
		}
	}
	
	@GetMapping("Login.do")
	public String getLogin(Model model) {
		model.addAttribute("title", "핸드폰 관리 - 로그인");
		return "Login";
	}
	
	@PostMapping("Login.do")
	public String doLogin(HttpServletRequest request, HttpServletResponse response,  UserInfo user, Model model) {
		try {
			UserInfo userinfo = service.select(user);
			model.addAttribute("title", "핸드폰 관리 - 로그인");
			request.getSession().setAttribute("loginUser", userinfo);
			
			return "PhoneReg";
		} catch (Exception e) {
			model.addAttribute("title", "핸드폰 관리 - 에러");
			model.addAttribute("message", "핸드폰 관리 - 로그인이 실패하였습니다.");
			return "Error";
		}
		

	}
	
	@GetMapping("logout.do")
	public String doLogout(HttpServletRequest request, HttpServletResponse response, Model model) {
		request.getSession().invalidate();
		return "index";
	}
	
	@GetMapping("delete.do")
	public String doDelete(@RequestParam List<String> num, Model model) {
		try {
			service.delete(num);
			return "redirect:searchPhone.do";
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("title", "핸드폰 관리 - 에러");
			model.addAttribute("message", "핸드폰 관리 - 삭제를 실패하였습니다.");
			return "Error";
		}
	}
	
	
	@GetMapping("rest.do")
	public String getRestClient() {
		return "rest";
	}

}
