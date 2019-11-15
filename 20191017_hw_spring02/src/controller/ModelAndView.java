package controller;
/*
 * 결과 페이지에 대한 이름과
 * 이동 경로에 대한 정보를 가지고 있는 클래스
 * 
 */

public class ModelAndView {
	private String path;
	private boolean isRedirect;
	public ModelAndView(String path, boolean isRedirect) {
		super();
		this.path = path;
		this.isRedirect = isRedirect;
	}
	public ModelAndView(String path) {
		super();
		this.path = path;
	}
	
	public ModelAndView() {
	
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public boolean isRedirect() {
		return isRedirect;
	}
	public void setRedirect(boolean isRedirect) {
		this.isRedirect = isRedirect;
	}
	@Override
	public String toString() {
		return "ModelAndView [path=" + path + ", isRedirect=" + isRedirect + "]";
	}
	
	
}
