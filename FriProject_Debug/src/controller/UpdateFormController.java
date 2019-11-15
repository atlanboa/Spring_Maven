package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Book;
import model.BookDAOImpl;
import model.MemberDAO;
//import model.MemberVO;
//LoginController, RegisterController, UpdateController
public class UpdateFormController implements Controller{

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws Exception{
		//예전의 서블릿 기능...

		String path = "find_fail.jsp";
		String isbn = request.getParameter("isbn");
		
		Book book;
		try {
			book = BookDAOImpl.getInstance().search(isbn);
			request.setAttribute("b", book);
			path = "book/update.jsp";
		}catch(Exception e) {
			System.out.println(e);
			
		}	
		return new ModelAndView(path);
	}

}
