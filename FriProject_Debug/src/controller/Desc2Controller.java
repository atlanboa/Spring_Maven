package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Book;
import model.BookDAOImpl;
import model.MemberDAO;
//import model.MemberVO;
//LoginController, RegisterController, UpdateController
public class Desc2Controller implements Controller{

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws Exception{
		//예전의 서블릿 기능...

		String path = "find_fail.jsp";
		String isbn = request.getParameter("isbn");
		System.out.println(isbn);
		
		Book b;
		try {
			b = BookDAOImpl.getInstance().search(isbn);
			System.out.println(b);
			request.setAttribute("result", b);
	        path="book/descResult.jsp";			
		
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("msg","오류 발생,  다시 시도해 주세요.");
		}	
		return new ModelAndView(path);
	}

}
