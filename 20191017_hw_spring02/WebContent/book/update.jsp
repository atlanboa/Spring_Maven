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
<h1>도서 정보 수정하기</h1>	
<form method="post" action="${pageContext.request.contextPath}/book.do">
<input type="hidden" name="command" value="updateBook">
	<table id="bookTable">
		<tr>
			<td colspan="2">도서 정보</td>
		</tr>
		<tr>
			<td>도서명</td>
			<td><input type="text" name="title" value="${b.title}"></td>
		</tr>
		<tr>
			<td>도서번호</td>
			<td><input type="text" name="isbn" value="${b.isbn}" readonly="readonly"></td>
		</tr>
		<tr>
			<td>도서분류</td>
			<td><input type="text" name="catalogue" value="${b.catalogue}" readonly="readonly"></td>
		</tr>
		<tr>
			<td>도서국가</td>
			<td><input type="text" name="nation" value="${b.nation}" readonly="readonly"></td>
		</tr>
		<tr>
			<td>출판일</td>
			<td><input type="text" name="publishDate" value="${b.publishDate}" readonly="readonly"></td>
		</tr>
		<tr>
			<td>출판사</td>
			<td><input type="text" name="publisher" value="${b.publisher}" readonly="readonly"></td>
		</tr>
		<tr>
			<td>저자</td>
			<td><input type="text" name="author" value="${b.author}"></td>
		</tr>
		<tr>
			<td>도서가격</td>
			<td><input type="text" name="price" value="${b.price}" readonly="readonly"></td>
		</tr>
		<tr>
			<td>도서설명</td>
			<td><input type="text" name="description" value="${b.description}"></td>
		</tr>
	</table>
	<p/>
	<input type="submit" value="수정하기">
	</form>
</body>
</html>