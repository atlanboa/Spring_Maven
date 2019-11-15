<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>
	<title>notice</title>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">

	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css"
		integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ" crossorigin="anonymous">
	<link rel="stylesheet" href="../css/main.css">
	<style type="text/css">
	section:after {
	
  		content: "";
  		display: table;
  		clear: both;
  		
	}
	
	div.info :HOVER{ 
		background: pink;
	}
	</style>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
		<script type="text/javascript">
		function forViewPage(code) {
			//alert(code);
			var path ="FoodServlet?command=view&code="+code;
			//alert(path);
			location.href=path;
		}
	
	</script>
	
</head>
<body>
<!-- header -->
<c:import url="../header.jsp"></c:import>
<!-- header -->
	<section>
		<article>
			<div class="container">
					<div class="jumbotron jumbotron-fluid" style="text-align: center;">
  	<h1>What We Provide</h1>
  	<hr>
  	<p>건강한 삶을 위한 먹거리 프로젝트</p>
	</div>
	
	<div class="container">
		<!-- <form class="form-inline" action="/action_page.php"> -->
		<form class="form-inline" action="${pageContext.request.contextPath}/FoodServlet" method="get">
		<input type="hidden" name="command" value="search">
		<input type="hidden" name="location" value="infoPages/productInfo.jsp">
		<label for="cate" class="mb-2 mr-sm-2">검색조건:</label>
		<!-- <label for="sel1">Select list (select one):</label> -->
      	<select class="form-control mb-2 mr-sm-2" id="cate" name="cate">
        <option>상품명</option>
        <option>제조사</option>
        <option>원재료</option>
      </select>
	<!-- <input type="" class="form-control mb-2 mr-sm-2" id="email2" placeholder="Enter email" name="email"> -->
		<label for="keyword" class="mb-2 mr-sm-2">검색단어:</label>
		<input type="text" class="form-control mb-2 mr-sm-2" id="keyword" placeholder="검색단어" name="keyword">
		<input type="submit" class="btn btn-primary mb-2" value="검색">
		<!-- <button type="button" class="btn btn-primary mb-2" id="searchbutton">검색</button> -->
	</form>
	</div>
	
		<!-- <button type="button" class="btn">Basic</button> -->
	<div class="container-fuild" style="margin-top: 30px">
		<div class="row">
		<c:forEach items="${list }" var="item" varStatus="i">
			
				
				<c:if test="${i.count % 2 == 1}">
					<div class="col-sm-6 left">
					<div class="info" onclick="forViewPage(${item.code})">
						<img src="${pageContext.request.contextPath}/${item.img }" style="float:left; width:30%; height: 30%">
						<article class="content" style="float: left; width: 70%">
							${item.name }<br>
							${item.maker }<br>
							${item.material }		
						</article>
					</div>
					</div>
				</c:if>
				
				
				<c:if test="${i.count % 2 == 0}">
					<div class="col-sm-6 right">
					<div class="info" onclick="forViewPage(${item.code})">
						<img src="${pageContext.request.contextPath}/${item.img }" style="float:left; width:30%; height: 30%">
						<article class="content" style="float: left; width: 70%">
							${item.name }<br>
							${item.maker }<br>
							${item.material }		
						</article>
					</div>
					</div>
				</c:if> 
				
			
		</c:forEach>
		</div>
	</div>
			</div>
		</article>
	</section>
	<!-- Footer -->
<c:import url="../footer.jsp"></c:import>
	<!-- Footer -->
</body>

</html>