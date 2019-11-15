<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>도서 정보</title>
<style type="text/css">
h1, h4 {
	text-align: center;
}

#bookTable {
	margin: auto auto;
}

body, p {
	text-align: center;
}

#bookTable th{
	text-align: right;
}

#bookTable td {
	border: 1px solid black;
	padding: 10px 0px;
}

#bookTable tr:nth-child(2) {
	text-align: center;
	background-color: lightgray;
}

#bookTable td {
	width: 100px;
}
/* nth-child(2) 사용해서 td 사이즈 조절하기 */
#bookTable td:nth-child(1) {
	width: 150px;
}
#bookTable td:nth-child(2) {
	width: 200px;
}
#bookTable td:nth-child(3) {
	width: 150px;
}
#bookTable td:nth-child(4) {
	width: 150px;
}
</style>
<script type="text/javascript" src="http://code.jquery.com/jquery-1.10.2.js"></script>
<!-- 비동기 ajax 코드 추가 -->
<script>
	$(function() {
		$(".subject").mouseover(function(){
			var isbn = $(this).attr('id');
			//비동기 통신 시작
			$.ajax({
				type:"get",
				url:"book.do?command=desc2&&isbn=" + isbn,
						
				success:function(data){
					$('#resultView').html("<h4><font color=red>" +data+"</font></h4>");
				}//success
				
			});
		});	
	});
</script>
</head>
<body>
	<h1>도서 목록 화면</h1>
	<c:if test="${not empty user}">
<h4>${user} 님 로그인 되었습니다. <a href="member.do?command=logout">로그아웃</a></h4>
</c:if>
	<table id="bookTable">
		<tr>
			<th  colspan="4">
				<form action="book.do" method="get">
					<input type="hidden" name="command" value="search"> 
					<select name="searchField" id="searchField">
						<option value="LIST">전체</option>
						<option value="TITLE">도서명</option>
						<option value="PUBLISHER">출판사</option>
						<option value="PRICE">가격</option>
					</select> 
					<input type="text" id="searchText" name="searchText"> 
					<input type="submit" value="검색">
				</form>
			</th>
		</tr>
		<tr>
			<td>도서번호</td>
			<td>도서명</td>
			<td>도서분류</td>
			<td>저자</td>
		</tr>
		<!-- forEach 구문  -->
		<c:forEach items="${books}" var="item" varStatus="i">
			<tr>
				<td>${item.isbn}</td>
				<td><span id="${item.isbn}" class="subject">
					<c:if test="${not empty user }">
						<a href="book.do?command=view&isbn=${item.isbn}">${item.title}</a>
					</c:if>
					<c:if test="${empty user}">
						${item.title}
					</c:if>
				</span></td>
				<td>${item.catalogue}</td>
				<td>${item.author}</td>			
			</tr>
		</c:forEach>
	</table>
	<div id="resultView"></div>
	<p>
		<a href='book/book.jsp'>도서 등록</a> <a href='index.jsp'>메인페이지</a> 
	</p>
</body>
</html>
