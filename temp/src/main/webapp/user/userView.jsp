<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>회원 정보</title>
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
	<script type="text/javascript">
	$(function() {
		$("#delete").click(function() {
			var choose = confirm("정말로 계정을 삭제하시겠습니까?");
			if(!choose){
				$(location).attr("href","#");
			}else{
				$(location).attr("href","UserServlet?command=delete");
			}
		});
	})
	</script>
</head>
<body>
<c:import url="../header.jsp"></c:import>
<section>
	<div class="container">
		<div>
		<h1>회원 정보</h1>
		<input type="hidden" name="command" value="signUp">
		<table class="table">
			<tr>
				<th>아이디</th>
				<td>${vo.id}</td>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td>******</td>
			</tr>
			<tr>
				<th>이름</th>
				<td>${vo.name}</td>
			</tr>
			<tr>
				<th>주소</th>
				<td>${vo.address}</td>
			</tr>
			<tr>
				<th>전화번호</th>
				<td>${vo.phone}</td>
			</tr>
			<tr>
				<th>알레르기</th>
				<td>${vo.allergy}</td>
			</tr>
		</table>
		<a class="btn btn-outline-primary" href="${pageContext.request.contextPath}/UserServlet?command=info">회원정보 수정</a><!-- ${pageContext.request.contextPath}/UserServlet?command=delete -->
		<a class="btn btn-outline-primary" id="delete" href="#">회원탈퇴</a>
		</div>
	</div>
</section>
<c:import url="../footer.jsp"></c:import>
</body>
</html>