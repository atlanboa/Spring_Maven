<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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
	.signUpForm{
		width: 60%;
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
		<div>
		<h1>회원 정보 수정</h1>
		<form action="${pageContext.request.contextPath}/UserServlet" method="post" id="signUpForm">
		<input type="hidden" name="command" value="modification">
		<table class="signUpTable">
			<tr>
				<th>아이디</th>
				<td><input type="text" class="form-control" name="id" id="userId" readonly="readonly" value="${vo.id}"></td>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td><input type="password" class="form-control" name="pass" id="userPssword" value="${vo.pass}"></td>
			</tr>
			<tr>
				<th>이름</th>
				<td><input type="text" class="form-control" name="name" id="userName" value="${vo.name}"></td>
			</tr>
			<tr>
				<th>주소</th>
				<td><input type="text" class="form-control" name="address" id="userAddress" value="${vo.address}"></td>
			</tr>
			<tr>
				<th>전화번호</th>
				<td><input type="tel" class="form-control" name="phone" id="userPhone" value="${vo.phone}"></td>
			</tr>
			<tr>
				<th>알레르기</th>
				<td>
				<fieldset id="userAllergie"><legend>Check</legend>
				<c:forEach var="allergy" items="${allergies}" varStatus="status">
					<c:set var="comp" value="0"/>
					<c:forEach var="userAl" items="${fn:split(vo.allergy,' ')}">
						<c:if test="${allergy == userAl}">
							<c:set var="comp" value="1"/>			
						</c:if>
					</c:forEach>
					<c:choose>
						<c:when test="${comp==1}">
							<div class="form-check-inline">
								<label class="form-check-label">
									<input type="checkbox" class="form-check-input" name="allergy" value="${allergy}" checked="checked">${allergy}
								</label>
							</div>
						</c:when>
						<c:otherwise>
							<div class="form-check-inline">
								<label class="form-check-label">
									<input type="checkbox" class="form-check-input" name="allergy" value="${allergy}">${allergy}
								</label>
							</div>
						</c:otherwise>
					</c:choose>
					<c:if test="${status.count%4==0}">
						<br>
					</c:if>
				</c:forEach>
				</fieldset>
				</td>
			</tr>
		</table>
		<input type="submit" class="btn btn-outline-primary" id="modification" value="수정">
		</form>
		</div>
	</div>
</section>
<c:import url="../footer.jsp"></c:import>
</body>
</html>