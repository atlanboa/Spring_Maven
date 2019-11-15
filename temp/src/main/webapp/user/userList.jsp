<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>유저 리스트</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css" integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ" crossorigin="anonymous">
	<link rel="stylesheet" href="./css/main.css">
	<style type="text/css">
	@media ( min-width : 1000px) {
		.bd-placeholder-img-lg {
			font-size: 3.5rem;
		}
	}
	</style>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</head>
<body>
<c:import url="../header.jsp"></c:import>
<section>
	<div class="container">
		<table class="table">
		<tr>
			<td>아이디</td>
			<td>이름</td>
			<td>알레르기 정보</td>
		</tr>
		<c:forEach var="user" items="${vo}">
		<tr>
			<td>${user.id}</td>
			<td>${user.name}</td>
			<td>${user.allergy}</td>
		</tr>
		</c:forEach>
		</table>
	</div>
</section>

<c:import url="../footer.jsp"></c:import>
</body>
</html>