<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	h1, h4{ text-align: center;}
	a{ margin: 15px;}
</style>
</head>
<body>
<h1>메인 페이지</h1>
<h4>${msg}</h4>
<c:choose>
	<c:when test="${empty user}">
		<jsp:include page="login.html"></jsp:include>
		<h4><a href="member/member.jsp">회원 가입</a>
		<a href="book.do?command=search">도서 목록</a></h4>
	</c:when>
	<c:otherwise>
		<h4><a href="book/book.jsp">도서 등록</a>
		<a href="book.do?command=search">도서 목록</a></h4>
	</c:otherwise>
</c:choose>
</body>
</html>