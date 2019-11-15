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
		<h1>비밀번호는</h1>
		<h1>${password}</h1>
	</div>
</section>
<c:import url="../footer.jsp"></c:import>
</body>
</html>