package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.MemberDAO;
//import model.MemberVO;
//LoginController, RegisterController, UpdateController
public class AddTooBookController implements Controller{

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws Exception{
		//예전의 서블릿 기능...
		String path = "book/book.jsp";
		return new ModelAndView(path);
	}

}
