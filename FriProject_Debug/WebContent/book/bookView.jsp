<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	body, h1, h4,p{ text-align: center;}
	#bookTable{ margin: 0px auto;}
	#bookTable td{ border: 1px solid black;
			       padding: 10px 0px;
	}
	#bookTable td:first-child {
	text-align: center;
	background-color: lightgray;
}
	#bookTable td:nth-child(2) {
	width: 500px;
	}
</style>
</head>
<body>
<h1>입력된 도서 정보</h1>
		<c:if test="${not empty user}">
			<h4>${user} 님 로그인 되었습니다. <a href="member.do?command=logout">로그아웃</a></h4>
		</c:if>
	<table id="bookTable">
		<tr>
			<td colspan="2">도서 정보</td>
		</tr>
		<tr>
			<td>도서명</td>
			<td>${b.title}</td>
		</tr>
		<tr>
			<td>도서번호</td>
			<td>${b.isbn}</td>
		</tr>
		<tr>
			<td>도서분류</td>
			<td>${b.catalogue}</td>
		</tr>
		<tr>
			<td>도서국가</td>
			<td>${b.nation}</td>
		</tr>
		<tr>
			<td>출판일</td>
			<td>${b.publishDate}</td>
		</tr>
		<tr>
			<td>출판사</td>
			<td>${b.publisher}</td>
		</tr>
		<tr>
			<td>저자</td>
			<td>${b.author}</td>
		</tr>
		<tr>
			<td>도서가격</td>
			<td>${b.price}</td>
		</tr>
		<tr>
			<td>도서설명</td>
			<td>${b.description}</td>
		</tr>
	</table>
	<p>
		<a href='DispatcherServlet?command=search'>도서목록으로 돌아가기</a>	
		<!-- 로그인 한 사람만 삭제기능과 수정기능을 볼수 있도록 한다 -->
		<c:if test="${not empty user}">
			<a href='DispatcherServlet?command=delete&isbn=${b.isbn}'>도서삭제</a>
			<!--  수정하기는 수정하기 폼으로 먼저 간다. -->
			<a href='DispatcherServlet?command=updateForm&isbn=${b.isbn}'>도서수정</a>
		</c:if>
	</p>
</body>
</html>