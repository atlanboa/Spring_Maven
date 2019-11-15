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
	<table style="margin: 0 auto">
		<tr>
			<th>제목</th>
			<td>${result.title}</td>
		</tr>
		<tr>
			<th>분류</th>
			<td>${result.catalogue}</td>
		</tr>
		<tr>
			<th>국가</th>
			<td>${result.nation}</td>
		</tr>
		<tr>
			<th>날짜</th>
			<td>${result.publishDate}</td>
		</tr>
		<tr>
			<th>출판사</th>
			<td>${result.publisher}</td>
		</tr>
		<tr>
			<th>저자</th>
			<td>${result.author}</td>
		</tr>
		<tr>
			<th>가격</th>
			<td>${result.price}</td>
		</tr>
		<tr>
			<th>단위</th>
			<td>${result.currency}</td>
		</tr>
		<tr>
			<th>설명</th>
			<td>${result.description}</td>
		</tr>
	</table>
</body>