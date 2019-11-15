<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Footer</title>
	<style type="text/css">
	@media ( min-width : 1000px) {
		.bd-placeholder-img-lg {
			font-size: 3.5rem;
		}
	}
	</style>
</head>
<body>
	<footer class="page-footer font-small teal pt-4">
		<!-- Footer Links -->
		<div class="container text-center text-md-left">

			<!-- Grid row -->
			<div class="row">

				<!-- Grid column -->
				<div class="col-md-4 mx-auto">

					<!-- Content -->
					<h5 class="font-weight-bold text-uppercase mt-3 mb-4">사이트맵</h5>
					<p> 이용자님들의 건강한 삶을 위해 항상 노력하겠습니다. </p>

				</div>
				<!-- Grid column -->

				<hr class="clearfix w-100 d-md-none">

				<!-- Grid column -->
				<div class="col-md-2 mx-auto">

					<!-- Links -->
					<h5 class="font-weight-bold text-uppercase mt-3 mb-4">회사소개</h5>

					<ul class="list-unstyled">
						<li><a href="#">인사말</a></li>
						<li><a href="#">연혁</a></li>
						<li><a href="#">사이트소개</a></li>
						<li><a href="#">오시는길</a></li>
					</ul>

				</div>
				<!-- Grid column -->
				<hr class="clearfix w-100 d-md-none">
				<!-- Grid column -->
				<div class="col-md-2 mx-auto">
					<!-- Links -->
					<h5 class="font-weight-bold text-uppercase mt-3 mb-4">정보</h5>
					<ul class="list-unstyled">
						<li><a href="#!">공지사항</a></li>
						<li><a href="#!">자유게시판</a></li>
						<li><a href="#!">정보게시판</a></li>
					</ul>
				</div>
				<!-- Grid column -->
				<hr class="clearfix w-100 d-md-none">
				<!-- Grid column -->
				<div class="col-md-2 mx-auto">
					<!-- Links -->
					<h5 class="font-weight-bold text-uppercase mt-3 mb-4">고객지원</h5>
					<ul class="list-unstyled">
						<li><a href="#">공지사항</a></li>
						<li><a href="#">자료실</a></li>
						<li><a href="#">QnA</a></li>
						<li><a class='logoutList' href="${pageContext.request.contextPath}/UserServlet?command=view">회원정보</a></li>
					</ul>
				</div>
				<!-- Grid column -->
			</div>
			<!-- Grid row -->
		</div>
		<!-- Social buttons -->
		<ul class="list-unstyled list-inline text-center">
			<li class="list-inline-item"><a class="btn-floating btn-fb mx-1">
					<i class="fab fa-facebook-f"> </i>
			</a></li>
			<li class="list-inline-item"><a class="btn-floating btn-tw mx-1">
					<i class="fab fa-twitter"> </i>
			</a></li>
			<li class="list-inline-item"><a
				class="btn-floating btn-gplus mx-1"> <i
					class="fab fa-google-plus-g"> </i>
			</a></li>
			<li class="list-inline-item"><a class="btn-floating btn-li mx-1">
					<i class="fab fa-linkedin-in"> </i>
			</a></li>
			<li class="list-inline-item"><a
				class="btn-floating btn-dribbble mx-1"> <i
					class="fab fa-dribbble"> </i>
			</a></li>
		</ul>
		<!-- Social buttons -->

		<div class="container">
			<!-- Footer Text -->
			<div class="container-fluid text-center text-md-left">
				<!-- Grid row -->
				<div class="row">
					<!-- Grid column -->
					<div class="col-md-6 mt-md-0 mt-3">
						<!-- Content -->
						<h5 class="text-uppercase font-weight-bold">Find Us</h5>
						<hr>
						<p>
							<i class="fas fa-map-marker-alt"></i> 서울시 강남구 테헤란로 멀티스퀘어
						</p>
						<p>
							<i class="fas fa-phone"></i> 1544-9001
						</p>
						<p>
							<i class="far fa-envelope"></i> admin@ssafy.com
						</p>
					</div>
					<!-- Grid row -->
				</div>
			</div>
			<!-- Footer Text -->
			<!-- Copyright -->
			<div class="footer-copyright text-center py-3">
				© 2018 Copyright: <a href="https://mdbootstrap.com/education/bootstrap/">
					www.ssafy.com</a>
			</div>
			<!-- Copyright -->
		</div>
	</footer>

</body>
</html>