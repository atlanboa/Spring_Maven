<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>회원가입</title>
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
<script type="text/javascript">
</script>

<body>

<c:import url="../header.jsp"></c:import>
<section>
	<article>
	<div class="container">
		<div>
		<h1>회원가입</h1>
		<form action="../UserServlet" method="post" class="needs-validation">
		<input type="hidden" name="command" value="signUp">
		<table class="table">
			<tr>
				<th>아이디</th>
				<td>
					<input type="text" class="form-control" name="id" id="userId" required>
				</td>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td><input type="password" class="form-control" name="pass" id="userPssword" required></td>
			</tr>
			<tr>
				<th>이름</th>
				<td><input type="text" class="form-control" name="name" id="userName" required></td>
			</tr>
			<tr>
				<th>주소</th>
				<td><input type="text" class="form-control" name="address" id="userAddress" required></td>
			</tr>
			<tr>
				<th>전화번호</th>
				<td><input type="tel" class="form-control" name="phone" id="userPhone" required></td>
			</tr>
			<tr>
				<th>알레르기</th>
				<td>
				<fieldset id="userAllergie"><legend>Check</legend>
				<div class="form-check-inline">
					<label class="form-check-label">
						<input type="checkbox" class="form-check-input" name="allergy" value="대두">대두
					</label>
				</div>
				<div class="form-check-inline">
					<label class="form-check-label">
						<input type="checkbox" class="form-check-input" name="allergy" value="땅콩">땅콩
					</label>
				</div>
				<div class="form-check-inline">
					<label class="form-check-label">
						<input type="checkbox" class="form-check-input" name="allergy" value="우유">우유
					</label>
				</div>
				<div class="form-check-inline">
					<label class="form-check-label">
						<input type="checkbox" class="form-check-input" name="allergy" value="게">게
					</label>
				</div><br>
				<div class="form-check-inline">
					<label class="form-check-label">
						<input type="checkbox" class="form-check-input" name="allergy" value="새우">새우
					</label>
				</div>
				<div class="form-check-inline">
					<label class="form-check-label">
						<input type="checkbox" class="form-check-input" name="allergy" value="참치">참치
					</label>
				</div>
				<div class="form-check-inline">
					<label class="form-check-label">
						<input type="checkbox" class="form-check-input" name="allergy" value="연어">연어
					</label>
				</div>
				<div class="form-check-inline">
					<label class="form-check-label">
						<input type="checkbox" class="form-check-input" name="allergy" value="쑥">쑥
					</label>
				</div><br>
				<!--  -->
				<div class="form-check-inline">
					<label class="form-check-label">
						<input type="checkbox" class="form-check-input" name="allergy" value="소고기">소고기
					</label>
				</div>
				<div class="form-check-inline">
					<label class="form-check-label">
						<input type="checkbox" class="form-check-input" name="allergy" value="닭고기">닭고기
					</label>
				</div>
				<div class="form-check-inline">
					<label class="form-check-label">
						<input type="checkbox" class="form-check-input" name="allergy" value="돼지고기">돼지고기
					</label>
				</div><br>
				<div class="form-check-inline">
					<label class="form-check-label">
						<input type="checkbox" class="form-check-input" name="allergy" value="복숭아">복숭아
					</label>
				</div>
				<div class="form-check-inline">
					<label class="form-check-label">
						<input type="checkbox" class="form-check-input" name="allergy" value="민들레">민들레
					</label>
				</div>
				<div class="form-check-inline">
					<label class="form-check-label">
						<input type="checkbox" class="form-check-input" name="allergy" value="계란흰자">계란흰자
					</label>
				</div><br>
				</fieldset>
				</td>
			</tr>
		</table>
		<input type="submit" class="btn btn-outline-primary" id="signUp" value="회원가입 ✓">
		</form>
		</div>
	</div>
	</article>
	</section>

<c:import url="../footer.jsp"></c:import>
</body>
</html>