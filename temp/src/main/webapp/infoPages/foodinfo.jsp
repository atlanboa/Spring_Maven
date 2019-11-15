<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css"
		integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ" crossorigin="anonymous">
	
<style>
	.table td {min-width : 100px; word-break: break-all; }
</style>
<script src="js/jquery-3.4.1.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>

<!-- 막대 그래프 사용 -->
<script src="https://code.highcharts.com/highcharts.js"></script>
<script src="https://code.highcharts.com/modules/exporting.js"></script>
<script src="https://code.highcharts.com/modules/export-data.js"></script>

<script>
	$(function() {
		
		var _tempArray=[
				<c:out value="${food.supportpereat}"></c:out>,
				<c:out value="${food.calory}"></c:out>,
				<c:out value="${food.carbo}"></c:out>,
				<c:out value="${food.protein}"></c:out>,
				<c:out value="${food.fat}"></c:out>,
				<c:out value="${food.sugar}"></c:out>,
				<c:out value="${food.natrium}"></c:out>,
				<c:out value="${food.chole}"></c:out>,
				<c:out value="${food.fattyacid}"></c:out>,
				<c:out value="${food.transfat}"></c:out>,
			];
		
		Highcharts.chart('graph', {
			chart: {
			    plotBackgroundColor: null,
			    plotBorderWidth: null,
			    plotShadow: false,
			    type: 'pie'
			},
			title: {
			    text: 'Nutrition Infomation'
			},
			tooltip: {
			    pointFormat: '{series.name}: <b>{point.percentage:.1f}%</b>'
			},
			plotOptions: {
			    pie: {
			    	allowPointSelect: true,
			      	cursor: 'pointer',
			      	dataLabels: {
			        	enabled: true,
			       	 	format: '<b>{point.name}</b>: {point.percentage:.1f} %'
			   		}
			   	}
			},
			series: [{
			    name: '양',
			    colorByPoint: true,
			    data: [{
			      	name: '칼로리',
			      	y:_tempArray[1]*1
			    }, {
			      	name: '탄수화물',
			      	y:_tempArray[2]*1
			    }, {
			      	name: '단백질',
			      	y:_tempArray[3]*1
			    }, {
			     	name: '지방',
			      	y:_tempArray[4]*1
			    }, {
			      	name: '당류',
			      	y:_tempArray[5]*1
			    }, {
			      	name: '나트륨',
			      	y:_tempArray[6]*1
			    }, {
			      	name: '콜레스테롤',
			      	y:_tempArray[7]*1
			    }, {
			      	name: '포화지방산',
			      	y:_tempArray[8]*1
			    }, {
			      	name: '트렌스지방',
			      	y:_tempArray[9]*1
			    }] //data
			}] //series
		}); //highchart

	}) //function
	
	
	function JJim() {
		if(quantity <= 0){
			alert("수량은 1이상 입력해 주세요");
			quantity.focus();
			return;
		}
		jjimform.submit();
	}
</script>

</head>
<body>
<!-- header -->
<c:import url="../header.jsp"></c:import>
<!-- header -->
	<section>
		<article>
				<div class="jumbotron jumbotron-fluid" style="text-align: center;">
			  	<h1>Product Information</h1>
			  	<hr>
			  	<p>제품 정보</p>
				</div>
				
				<div class="container">
					<div class="row">
						<div class="col-sm-4">
						<!-- 사진 들어가기  -->
							<img src="${pageContext.request.contextPath}/${food.img}" style="float:left; width:200px; height:200px;">
						</div>
						<div class="col-sm-8"  style="float: left;">
							<table class="table table-hover">
							<!-- 이름 제조사 재료 알러지 테이블 들어가기 -->	
							<tr><td>제품명</td><td>${food.name }</td></tr>
							<tr><td>제조사</td><td>${food.maker }</td></tr>
							<tr><td>원재료</td><td>${food.material }</td></tr>
							<tr><td>알레르기 성분</td><td>${food.allergy }</td></tr>
							</table>
						</div>
					</div>
				</div>
				<div class="container">
				<fieldset>
					<legend>Quantity</legend>
					<form name="jjimform" id="jjimform" action="FoodServlet" method="get">
						<input type="hidden" name="command" value="jjim">
						<input type="hidden" name="code" value="${food.code }">
						<input type="number" name="quantity" value="1" id="quantity">
						<!-- 추가 눌렀을때 ajax 통신으로 addItem 액션 취하는 걸로 합시다 -->
						<button type="button" class="btn btn-primary btn-lg addItem" onclick="JJim()">추가</button>
					</form>
				</fieldset>
				</div><br><br><br><br>
				
				<div class="container-fluid">
					<div class="row">
						<div class="col-sm-6" id="graph" style="min-width: 410px; height: 500px; max-width: 600px; margin-left: 100px; float:left">
						<!-- 원형 그래프 -->
						</div>
						<div class="col-sm-6" style="float:left">
							<table class="table nutri-table">
							<!-- 영양소 정보 테이블 -->
							<tr><td>일회제공량</td><td>${food.supportpereat }</td></tr>
							<tr><td>칼로리</td><td>${food.calory }</td></tr>
							<tr><td>탄수화물</td><td>${food.carbo }</td></tr>
							<tr><td>단백질</td><td>${food.protein }</td></tr>
							<tr><td>지방</td><td>${food.fat }</td></tr>
							<tr><td>당류</td><td>${food.sugar }</td></tr>
							<tr><td>나트륨</td><td>${food.natrium }</td></tr>
							<tr><td>콜레스테롤</td><td>${food.chole }</td></tr>
							<tr><td>포화 지방산</td><td>${food.fattyacid }</td></tr>
							<tr><td>트랜스지방</td><td>${food.transfat }</td></tr>
							</table>
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
