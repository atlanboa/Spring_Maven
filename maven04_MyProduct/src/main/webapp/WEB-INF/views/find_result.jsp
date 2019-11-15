<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>++++++++++++++++++++++++상품 검색 결과++++++++++++++++++++++++</h2>
	<table border="2">
		<thead>
			<tr>
				<th>ID</th>
				<th>NAME</th>
				<th>MAKER</th>
				<th>PRICE</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${list}" var="vo">
				<tr>
					<th>${vo.id}</th>
					<th>${vo.name}</th>
					<th>${vo.maker}</th>
					<th>${vo.price}</th>
				</tr>
			</c:forEach>
		</tbody>
	</table>



</body>
</html>