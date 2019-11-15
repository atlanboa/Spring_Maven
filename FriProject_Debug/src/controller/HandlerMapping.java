package controller;
//component를 여러개 만들수 있다...여러 개의 공장이 필요한건 아니다.
public class HandlerMapping {
	private static HandlerMapping factory = new HandlerMapping();
	private HandlerMapping() {
		
	}
	public static HandlerMapping getInstance() {
		return factory;
	}
	
	public Controller createController(String command) {
		Controller controller = null;
		try {
			switch(command) {
			case "registerBook" :
				controller = new RegisterBookController();
				break;
			case "addTooBook" :
				controller = new AddTooBookController();
//				request.getRequestDispatcher("book/book.jsp").forward(request, response);
				break;
			case "search" :
				controller = new SearchController(); 
				break;
			case "view" :
				controller = new ViewController(); 
				break;
			case "desc" :
				controller = new DescController(); 
				break;
			case "desc2" :
				controller = new Desc2Controller(); 
				break;
			case "updateForm" :
				controller = new UpdateFormController(); 
				break;
			case "updateBook" :
				controller = new UpdateBookController(); 
				break;
			case "delete" :
				controller = new DeleteController(); 
				break;				
			}			
		}catch(Exception e) {
			System.out.println("doProcess : "+e.getMessage());
		}		
		return controller;
	}

}
