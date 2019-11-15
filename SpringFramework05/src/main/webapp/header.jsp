<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%-- <c:url value="/css/basic.css" var="css" /> --%>
<link rel="stylesheet" href="${css }" />
<c:if test="${!empty loginUser }">
	<div>
		${loginUser.id }님 로그인되었습니다. <a href="logout.do">로그아웃</a>
	</div>
</c:if>
<h1 id="head">${title }</h1>
<c:url value="/js/jquery-3.3.1.js" var="jquery" />
<script src="${jquery }"></script>