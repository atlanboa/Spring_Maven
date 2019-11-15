package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Book;
import model.BookDAOImpl;
import model.MemberDAO;
//import model.MemberVO;
//LoginController, RegisterController, UpdateController
public class UpdateBookController implements Controller{

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws Exception{
		//예전의 서블릿 기능...

		String path = "find_fail.jsp";
		
		String isbn = request.getParameter("isbn").trim();
		String title = request.getParameter("title").trim();
		String catalogue = request.getParameter("catalogue").trim();
		String nation = request.getParameter("nation").trim();
		String publishDate = request.getParameter("publishDate").trim();
		String publisher = request.getParameter("publisher").trim();
		String author = request.getParameter("author").trim();
		String price = request.getParameter("price").trim();
		int p = Integer.parseInt(price);		
		String description = request.getParameter("description").trim();
		Book book = new Book(isbn, title, catalogue, nation, publishDate,
		publisher, author, p,  description);
		System.out.println("updateBook..."+book);
		try {
			BookDAOImpl.getInstance().update(book);
			
			HttpSession session=request.getSession();
			if(session.getAttribute("user")!=null)
				session.setAttribute("b", book);
			
			path="book/bookView.jsp";			
		}catch(Exception e) {
			System.out.println(e);
		}	
		return new ModelAndView(path);
	}

}
