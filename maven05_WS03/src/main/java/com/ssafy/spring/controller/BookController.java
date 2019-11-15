package com.ssafy.spring.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ssafy.spring.service.BookService;
import com.ssafy.spring.vo.BookVO;

@Controller
public class BookController {
	
	@Autowired
	private BookService bookService;

	@RequestMapping("bookList.do")
	public ModelAndView getBooks(HttpServletRequest request, HttpServletResponse response) throws Exception {

		List<BookVO> list = bookService.getBooks();
		for(BookVO b : list) {
			System.out.println(b);
		}

		return new ModelAndView("book/bookList", "list", list);

	}

	@RequestMapping("bookSearch.do")
	public ModelAndView search(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String field = request.getParameter("searchField");
		if (field == null)
			field = "";
		String text = request.getParameter("searchText");
		if (text == null)
			text = "";
		field = field.trim();
		text = text.trim();
		System.out.println(field + ":" + text);
		List<BookVO> list = null;
		String path = "find_fail";
		try {
			switch (field) {
			case "TITLE":
				list = bookService.searchByTitle(text);
				break;
			case "PUBLISHER":
				list = bookService.searchByPublisher(text);
				break;
			case "PRICE":
				list = bookService.searchByPrice(Integer.parseInt(text));
				break;
			default:
				list = bookService.getBooks();
			}
			
			request.setAttribute("field", field);
			request.setAttribute("text", text);
			path = "book/bookList";
			
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("msg", "검색 중 오류가 발생했습니다.");
		}

		return new ModelAndView(path, "list", list);

	}
	
	@RequestMapping("bookView.do")
	public ModelAndView view(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String path = "find_fail";
		String isbn = request.getParameter("isbn").trim();
		BookVO book = null;
		try {
			book = bookService.searchByIsbn(isbn);
//			request.setAttribute("b",book );
			System.out.println("bookView : "+book);
			path="book/bookView";
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("msg","검색 중 오류가 발생했습니다." );
		}
		
		return new ModelAndView(path, "b", book);
	}
	
	@RequestMapping("bookDesc.do")
	public ModelAndView desc(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String path = "find_fail.jsp";
		String isbn = request.getParameter("isbn");
		System.out.println(isbn);
		
		BookVO b = null;
		try {
			b = bookService.searchByIsbn(isbn);
			System.out.println(b);
	        path="book/descResult";			
		
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("msg","오류 발생,  다시 시도해 주세요.");
		}	
		return new ModelAndView(path, "result", b);
	}
	
//	@RequestMapping("bookFormPage.do")
//	public ModelAndView form(HttpServletRequest request, HttpServletResponse response) throws Exception {
//		String path = "book/bookForm";
//		
//		return new ModelAndView(path);
//	}
	
	@RequestMapping("bookRegister.do")
	public ModelAndView register(HttpServletRequest request, HttpServletResponse response,HttpSession session) throws Exception {
		
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
		BookVO book = new BookVO(isbn, title, catalogue, nation, publishDate,
		publisher, author, p, currency, description);
		System.out.println("regiseter : "+book);
		
		
		String msg = "";
		String path = "Error.jsp";
		try {
			bookService.insertBook(book);
			msg = "책 정보가 정상적으로 저장되었습니다";

			path = "result.jsp";
		}catch(Exception e) {
			System.out.println(e);
			msg = "책 정보 저장중 오류 발생...";
			
		}		
		
		session.setAttribute("msg", msg);
		return new ModelAndView("redirect:"+path);
	}


}
