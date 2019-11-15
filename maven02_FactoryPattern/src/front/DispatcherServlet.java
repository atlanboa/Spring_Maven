package front;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import controller.HandlerMapping;
import controller.ModelAndView;

/**
 * Servlet implementation class DispatcherServlet
 */
@WebServlet("/DispatcherServlet")
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	
	private void doProcess(HttpServletRequest request, HttpServletResponse response) {
		String command = request.getParameter("command");
		String path = "index.jsp";
		
		//CBD 방법 개발론
		/*
		 * 1. 공장을 하나 받아온다.
		 * 2. 공장의 createController() 호출.. 이때 command 값 넣어준다
		 * 3. Controller를 리턴 받는다.. execute() 호출
		 * 4. 컴포넌트가 실행... ModelAndView 리턴
		 * 5. ModelAndView를 열어서 네비게이터
		 */
		
		Controller controller = HandlerMapping.getInstance().createController(command);
		try {
			ModelAndView mv = controller.execute(request, response);
			if(mv.isRedirect()) response.sendRedirect(mv.getPath());
			else request.getRequestDispatcher(mv.getPath()).forward(request, response);	
		}catch (Exception e) {
			
		}
		
		
		
	}

}
