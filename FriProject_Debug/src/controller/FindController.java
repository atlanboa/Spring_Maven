package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.MemberDAO;
//import model.MemberVO;
//LoginController, RegisterController, UpdateController
public class FindController implements Controller{

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws Exception{
		//예전의 서블릿 기능...
//		String id = request.getParameter("id");
//		MemberVO rvo = MemberDAO.getInstance().findMemberById(id);
		String path = "find_fail.jsp";
//		if(rvo!=null) {
//			request.setAttribute("vo", rvo);
//			path = "find_ok_jsp";
//		}
//		
//		
//		
		return new ModelAndView(path);
	}

}
