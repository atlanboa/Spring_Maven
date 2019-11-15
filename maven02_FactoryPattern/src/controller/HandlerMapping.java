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
		if(command.equals("find")) {
			controller = new FindController();
		}else if(command.equals("find")) {
			
		}
		return controller;
	}

}
