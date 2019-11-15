<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
form>label {
	display: inline-block;
	width: 100px;
}

form>:input {
	display: inline-block;
	width: 100px;
}
</style>
</head>

<body>
	<jsp:include page="/header.jsp"></jsp:include>
	<form method="post" action="regPhone.do">
		<label for="num">모델번호</label>
		<input type="text" name="num" id="num">
		<br>
		<label for="model">모델명</label>
		<input type="text" name="model" id="model">
		<br>
		<label for="price">가격</label>
		<input type="number" name="price" id="price">
		원 <br>
		<label for="vcode">제조사</label>
		<select id="vcode" name="vcode">
			<option value="10">삼성
			<option value="20">엘지
			<option value="30">애플
		</select>
		<br>
		<input type="submit" value="핸드폰등록">
		<input type="reset">
	</form>
</body>
</html>