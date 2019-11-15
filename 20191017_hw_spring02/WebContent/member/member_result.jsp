<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	body{
		margin: 0 auto;
		width: 500px;
		background-color: #D5D5D5;
	}
	table{
	width: 400px;
	}
	th{
		text-align: center;
		width: 40%;
		padding: 5px;
	}
	td{
		text-align: center;
		width: 60%;
		padding: 5px;
	}
</style>
</head>
<body>
<h1>회원 등록 결과 화면</h1>
<p/>
<table>
	<tr><th>아이디</th><td>${mvo.id}</td></tr>
	<tr><th>비밀번호</th><td>${mvo.pw}</td></tr>
	<tr><th>이름</th><td>${mvo.name}</td></tr>
	<tr><th>닉네임</th><td>${mvo.nickName}</td></tr>
	<tr><th>이메일</th><td>${mvo.email}</td></tr>
	<tr><th>홈페이지</th><td>${mvo.homePage}</td></tr>
	<tr><th>주소</th><td>${mvo.address}</td></tr>
	<tr><th>취미</th><td>${mvo.hobby}</td></tr>	
</table>
<a href="index.jsp">메인 페이지</a>
</body>
</html>