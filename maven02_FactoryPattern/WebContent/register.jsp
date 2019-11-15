<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="DispatcherServlet" name="registerForm" method="post">
	<input type="hidden" name="command" value="register">
		아이디 : <input type="text" name="id" required="required">		
		패스워드 : <input type="password" name="password" required="required"><br>
		이름 : <input type="text" name="name" required="required"><br>
		주소 : <input type="text" name="address" required="required"><br>			
		<input type="submit" value="회원가입">
	</form>
</body>
</html>