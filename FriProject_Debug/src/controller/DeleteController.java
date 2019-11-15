package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.BookDAOImpl;
import model.MemberDAO;
//import model.MemberVO;
//LoginController, RegisterController, UpdateController
public class DeleteController implements Controller{

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws Exception{
		//예전의 서블릿 기능...
;
		String path = "find_fail.jsp";
		String isbn = request.getParameter("isbn");
		
		try {
			request.setAttribute("msg", "삭제가 정상적으로 진행되었습니다.");
			BookDAOImpl.getInstance().delete(isbn);
			path = "result.jsp";
		}catch(Exception e) {
			System.out.println(e);
			request.setAttribute("msg", "삭제시 문제가 발생했습니다.");
		}
		
		
		return new ModelAndView(path);
	}

}
