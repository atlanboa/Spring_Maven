<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Main</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css" integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ" crossorigin="anonymous">
	<style type="text/css">
	@media ( min-width : 1000px) {
		.bd-placeholder-img-lg {
			font-size: 3.5rem;
		}
	}
	#indexPic{
		text-align: center;
		width: 100%;
		height: 400px;
	}
	.carousel-item>img{
		width:100%;
	}
	.carousel-control-next,
	.carousel-control-prev {
	    filter: invert(100%);
	}
	.carousel-caption {
    top: 0;
    bottom: auto;
	}
	</style>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
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
<c:import url="./header.jsp"></c:import>
<section>
	<div style="background: #959595;">
		<article class="container" style="background: white;">
		<div id="myCarousel" class="carousel slide" data-ride="carousel">
	        <ol class="carousel-indicators">
	          <li data-target="#myCarousel" data-slide-to="0" class=""></li>
	          <li data-target="#myCarousel" data-slide-to="1" class="active"></li>
	          <li data-target="#myCarousel" data-slide-to="2" class=""></li>
	        </ol>
	        <div class="carousel-inner" id="indexPic">
	          <div class="carousel-item">
	            <img class="first-slide" src="./img/introduction/fruit.jpg" alt="First slide">
	            <div class="container">
	              <div class="carousel-caption">
	                <h1>Safe Food</h1>
	              </div>
	            </div>
	          </div>
	          <div class="carousel-item active">
	            <img class="second-slide" src="./img/introduction/fruit2.jpg" alt="Second slide">
	            <div class="container">
	              <div class="carousel-caption">
	                <h1>Safe Food</h1>
	              </div>
	            </div>
	          </div>
	          <div class="carousel-item">
	            <img class="third-slide" src="./img/introduction/fruit3.jpg" alt="Third slide">
	            <div class="container">
	              <div class="carousel-caption">
	                <h1>Safe Food</h1>
	              </div>
	            </div>
	          </div>
	        </div>
	        <a class="carousel-control-prev" href="#myCarousel" role="button" data-slide="prev">
	          <span class="carousel-control-prev-icon" aria-hidden="true"></span>
	          <span class="sr-only">Previous</span>
	        </a>
	        <a class="carousel-control-next" href="#myCarousel" role="button" data-slide="next">
	          <span class="carousel-control-next-icon" aria-hidden="true"></span>
	          <span class="sr-only">Next</span>
	        </a>
	      </div>
		</article>
	</div>
	<br>
	<article>
		<div class="container">
			<form class="form-inline d-flex justify-content-center" id="foodSearch">
				<input type="hidden" name="command" value="search">
				<input type="hidden" name="location" value="index.jsp">
				<label for="cate" class="mb-2 mr-sm-2">검색조건:</label>
      			<select class="form-control mb-2 mr-sm-2" id="cate" name="cate">
        			<option>상품명</option>
        			<option>제조사</option>
        			<option>원재료</option>
      			</select>
				<label for="keyword" class="mb-2 mr-sm-2">검색단어:</label>
				<input type="text" class="form-control mb-2 mr-sm-2" id="keyword" placeholder="검색단어" name="keyword">
				<input type="submit" class="btn btn-primary mb-2" value="검색">
			</form>
		</div>
		<div class="container" style="margin-top: 30px">
			<div class="row">
				<c:forEach items="${list}" var="food" varStatus="i">
					<c:if test="${i.count % 3 == 1 }">
						<div class="col-sm-4 left">	
							<div class="info" onclick="forViewPage(${food.code})">
								<img src="${food.img}" style="width: 50%; height: 50%;">
								<p class="text">${food.name }<br>${food.maker }</p>
							</div>
						</div>
					</c:if>
					<c:if test="${i.count % 3 == 2 }">
						<div class="col-sm-4 mid">	
							<div class="info" onclick="forViewPage(${food.code})">
								<img src="${food.img}" style="width: 50%; height: 50%;">
								<p class="text">${food.name }<br>${food.maker }</p>
							</div>
						</div>
					</c:if>
					<c:if test="${i.count % 3 == 0 }">
						<div class="col-sm-4 right">
							<div class="info" onclick="forViewPage(${food.code})">
								<img src="${food.img}" style="width: 50%; height: 50%;">
								<p class="text">${food.name }<br>${food.maker }</p>
							</div>
						</div>
					</c:if>
				</c:forEach>
			</div>
		</div>
	</article>
</section>
<c:import url="./footer.jsp"></c:import>
</body>
<script type="text/javascript">
$("#foodSearch").submit(function(){
	let category = $("#cate").val();
	let keyword = $("#keyword").val();
	alert(category +" "+ keyword);
	$.ajax({
		url : test,
		type : "post",
		success : function(resData) {
			alert(category +" "+ keyword);
		},
		error : function() {
			alert("조회 실패(시스템 오류)")
		}
	});

});
</script>
</html>