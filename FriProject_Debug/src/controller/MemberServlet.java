package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Member;
import model.MemberDAOImpl;


@WebServlet("/member.do")
public class MemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String command = request.getParameter("command");
		if(command.equalsIgnoreCase("login")) {
			login(request, response);//addMember
		}else if(command.equalsIgnoreCase("addMember")) {
			addMember(request, response);
		}else if(command.equalsIgnoreCase("logout")) {
			logout(request, response);
		}
	}

	
	

	private void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String user = request.getParameter("user");
		String pass = request.getParameter("pass");
		String path = "Error.jsp";
		try {
			if(MemberDAOImpl.getInstance().loginCheck(user, pass)) {
				//세션에 바인딩...중요
				HttpSession session=request.getSession();
				session.setAttribute("user", user);
				session.setAttribute("msg", "정상적으로 로그인 되었습니다");
			}else {
				System.out.println("아이디 혹은 패스워드가 잘못되었습니다.");
				String msg ="아이디 또는 패스워드가 틀립니다.";
				request.setAttribute("msg", msg);
			}
			path = "index.jsp";
		}catch(SQLException e) {
			request.setAttribute("msg", "로그인 실패~~~!!");
		}
		
		request.getRequestDispatcher(path).forward(request, response);	
	}//
	
	private void addMember(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String id = request.getParameter("ID");
		String pw = request.getParameter("PW");
		String name = request.getParameter("NAME");
		String nickName = request.getParameter("NICKNAME");
		String email = request.getParameter("EMAIL");
		String homePage = request.getParameter("HOMEPAGE");
		String [] hobby = request.getParameterValues("HOBBY");
		String address = request.getParameter("ADDRESS");
		
		String path  = "Error.jsp";
		
		Member mvo = new Member(id, pw, name, nickName, email, homePage, address, hobby);
		try {
			MemberDAOImpl.getInstance().add(mvo);
			request.setAttribute("mvo", mvo);			
			path = "/member/member_result.jsp";
		}catch(Exception e) {
			System.out.println(e);
			request.setAttribute("msg", "회원 저장에 실패했습니다.");
		}
		request.getRequestDispatcher(path).forward(request, response);	
	}
	
	private void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		HttpSession session = request.getSession();
		
		if(session.getAttribute("user")!=null) {
			session.invalidate();
		}
		response.sendRedirect("index.jsp");
		
	}

}
















