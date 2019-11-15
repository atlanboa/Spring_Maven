package controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Book;
import model.BookDAOImpl;
import model.MemberDAO;
//import model.MemberVO;
//LoginController, RegisterController, UpdateController
public class SearchController implements Controller{

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws Exception{
		//예전의 서블릿 기능...
		
		String field = request.getParameter("searchField");
		if(field == null) field="";
		String text = request.getParameter("searchText");
		if(text == null)  text="";
		field=field.trim();
		text=text.trim();
		System.out.println(field+":"+text);
		List<Book> result=null;
		String path = "find_fail.jsp";
		try {
			switch(field){
			case "TITLE":			
					result=BookDAOImpl.getInstance().searchByTitle(text);				
				break;
			case "PUBLISHER":
				result=BookDAOImpl.getInstance().searchByPublisher(text);
				break;
			case "PRICE":
				result=BookDAOImpl.getInstance().searchByPrice(Integer.parseInt(text));
				break;
			default :
				result=BookDAOImpl.getInstance().search();
			}
			request.setAttribute("books", result );
			request.setAttribute("field", field );
			request.setAttribute("text", text );
			path="book/bookList.jsp";
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("msg","검색 중 오류가 발생했습니다." );
		}	
		
		return new ModelAndView(path);
	}

}
