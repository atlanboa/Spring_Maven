<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비밀번호 찾기</title>
<c:import url="./import.jsp"></c:import>
</head>
<body>
<c:import url="../header.jsp"></c:import>
<section>
	<div class="container">
		<h1>pass</h1>
		<form action="../UserServlet" method="post" class="needs-validation">
		<input type="hidden" name="command" value="passSearch">
		<table class="table">
			<tr>
				<th>아이디</th>
				<td>
					<input type="text" class="form-control" name="id" id="userId" required>
				</td>
			<tr>
				<th>이름</th>
				<td><input type="text" class="form-control" name="name" id="userName" required></td>
			</tr>
			<tr>
				<th>주소</th>
				<td><input type="text" class="form-control" name="address" id="userAddress" required></td>
			</tr>
			</table>
		<input type="submit" class="btn btn-outline-primary" id="signUp" value="회원가입 ✓">
		</form>
	</div>
</section>
<c:import url="../footer.jsp"></c:import>
</body>
</html>