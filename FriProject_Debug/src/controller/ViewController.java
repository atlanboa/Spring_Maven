package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Book;
import model.BookDAOImpl;
import model.MemberDAO;
//import model.MemberVO;
//LoginController, RegisterController, UpdateController
public class ViewController implements Controller{

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws Exception{
		//예전의 서블릿 기능...

		String path = "find_fail.jsp";
		String isbn = request.getParameter("isbn").trim();
		try {
			Book book=BookDAOImpl.getInstance().search(isbn);
			request.setAttribute("b",book );
			path="book/bookView.jsp";
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("msg","검색 중 오류가 발생했습니다." );
		}
		return new ModelAndView(path);
	}

}
