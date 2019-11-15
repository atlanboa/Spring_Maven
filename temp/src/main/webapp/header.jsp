<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Header</title>
	<style type="text/css">
	@media ( min-width : 1000px) {
		.bd-placeholder-img-lg {
			font-size: 3.5rem;
		}
	}
	</style>
	<script>
	$(function() {
		$(".search-input-elm").hide();
		$(".search-btn").click(function () {
		  	$(".search-input-elm").animate({ width: 'toggle' });
		});
		// login toggle button
		
		
		
	});
	</script>
</head>
<body>
	<header>
		<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
			<div class="container">
				<ul class="navbar-nav ml-auto">
					<li class="nav-item">
					<div class="nav-link">
						${msg}
					</div>
					</li>
				<c:choose>
					<c:when test="${empty id}">
					<li class="nav-item">
						<a class="nav-link loginList" href="${pageContext.request.contextPath}/user/signUp.jsp"><i class="fas fa-user"></i> Sign Up</a>
					</li>
					<li class="nav-item loginList" style="position:relative">
						<a class="nav-link" data-toggle="collapse" href="#collapseExample" role="button" aria-expanded="false" aria-controls="collapseExample">
							<i class="fas fa-lock"></i>Login
						</a>
						<div class="collapse" id="collapseExample" style="position: absolute; z-index: 100; right: 0px; width: 250px;">
							<div class="card card-body bg-dark" id="loginWindow">
								<form method="post" action="${pageContext.request.contextPath}/UserServlet">
									<input type="hidden" name="command" value="login">
									<label class="text-white">아이디</label><br>
									<input type="text" class="form-control" name="id" id="identifier" required><br>
									<label class="text-white">비밀번호</label><br>
									<input type="password" class="form-control" name="pass" id="password" required><br> <br> 
									<input type="submit" class="btn btn-light" id="login" value="로 그 인" style="width:100%;">
								</form>
								<a class="btn btn-dark" href="${pageContext.request.contextPath}/user/passSearch.jsp">비밀번호 찾기</a>
							</div>
						</div>
					</li>
					</c:when>
					<c:otherwise>
					<li class="nav-item logoutList">
						<a class="nav-link" href="${pageContext.request.contextPath}/UserServlet?command=list"><i class="fas fa-users"></i>회원리스트</a>
					</li>
					<li class="nav-item logoutList">
						<a class="nav-link" href="${pageContext.request.contextPath}/UserServlet?command=logout"><i class="fas fa-lock-open"></i>LogOut</a>
					</li>
					<li class="nav-item logoutList">
						<a class="nav-link" href="${pageContext.request.contextPath}/UserServlet?command=view"><i class="fas fa-user"></i> 회원정보</a>
					</li>
					</c:otherwise>
				</c:choose>
				</ul>
			</div>
		</nav>
		<nav class="navbar navbar-expand-sm bg-light navbar-light">
			<div class="container">
				<a class="navbar-brand" href="${pageContext.request.contextPath}/index.jsp"> <img src="${pageContext.request.contextPath}/img/header-logo.jpg" alt="logo"></a>
				<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarCollapse" aria-controls="navbarCollapse" aria-expanded="true" aria-label="Toggle navigation">
			      <span class="navbar-toggler-icon"></span>
			    </button>
			    <div class="navbar-collapse collapse" id="navbarCollapse">
			    
					<ul class="navbar-nav ml-auto">
						<li class="nav-item"><a class="nav-link" href="#">사이트 소개</a></li>
						<li class="nav-item"><a class="nav-link" href="#">공지사항</a></li>
						<li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/infoPages/foodList.jsp">상품정보</a></li>
						<li class="nav-item"><a class="nav-link" href="#">베스트 섭취 정보</a></li>
						<c:if test="${not empty id}">
							<li class="nav-item"><a class="nav-link logoutList" href="${pageContext.request.contextPath}/FoodServlet?command=mydetail">내 섭취 정보</a></li>
							<li class="nav-item"><a class="nav-link logoutList" href="#">예상 섭취 정보</a></li>	
						</c:if>
						
						<li>
							<div class="search">
	                            <div class="search-wrap">
	                            	<span class="search-input-elm">
		                                <input class="search-input" type="text" placeholder="search.." />
		                                <button class="btn btn-secondary search-submit"><i class="fas fa-search"></i></button>
	                                </span>
	                                <span>
	                                	<button class="btn btn-secondary search-btn">검색</button>
	                                </span>
		                            </div>
	                            </div>
	                        </div>
						</li>
					</ul>
				</div>
			</div>
		</nav>
	</header>
</body>
</html>