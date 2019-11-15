package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Book;
import model.BookDAOImpl;
import model.MemberDAO;
//import model.MemberVO;
//LoginController, RegisterController, UpdateController
public class RegisterBookController implements Controller{

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws Exception{
		//예전의 서블릿 기능...

		String isbn1 = request.getParameter("isbn1").trim();
		String isbn2 = request.getParameter("isbn2").trim();
		String isbn3 = request.getParameter("isbn3").trim();
		String isbn = isbn1 + "-" + isbn2 + "-" + isbn3;
		String title = request.getParameter("title").trim();
		String catalogue = request.getParameter("catalogue").trim();
		String nation = request.getParameter("nation").trim();
		String publishDate = request.getParameter("publishDate").trim();
		String publisher = request.getParameter("publisher").trim();
		String author = request.getParameter("author").trim();
		String price = request.getParameter("price").trim();
		int p = Integer.parseInt(price);
		String currency = request.getParameter("currency").trim();
		String description = request.getParameter("description").trim();
		Book book = new Book(isbn, title, catalogue, nation, publishDate,
		publisher, author, p, currency, description);
		BookDAOImpl.getInstance().insertBook(book);
		String path = "find_fail.jsp";
		try {
			BookDAOImpl.getInstance().insertBook(book);
			request.setAttribute("bvo", book);
			request.setAttribute("msg","책 정보가 정상적으로 저장되었습니다");
			path = "result.jsp";
		}catch(Exception e) {
			System.out.println(e);
			request.setAttribute("msg", "책 정보 저장중 오류 발생...");
		}		
		
		//sendredirect할거면 modelandview 두번째 인자로 true를 넘겨줘야함.
		return new ModelAndView(path);
	}

}
