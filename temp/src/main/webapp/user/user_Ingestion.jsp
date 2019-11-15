<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>내 섭취 정보</title>
<c:set var="totalCalory" value="0"/>
<c:set var="totalCarbo" value="0"/>
<c:set var="totalProtein" value="0"/>
<c:set var="totalFat" value="0"/>
<c:forEach items="${list}" var="item" varStatus="i">
	<c:forEach items="${info}" var="information" varStatus="i">
		<c:if test="${item.code==information.code}">
			<c:set var="totalCalory" value="${totalCalory+information.quantity*item.calory}"/>
			<c:set var="totalCarbo" value="${totalCarbo+information.quantity*item.carbo}"/>
			<c:set var="totalProtein" value="${totalProtein+information.quantity*item.protein}"/>
			<c:set var="totalFat" value="${totalFat+information.quantity*item.fat}"/>
		</c:if>
	</c:forEach>
</c:forEach>
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
	<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
	<script src="https://code.highcharts.com/highcharts.js"></script>
	<script src="https://code.highcharts.com/modules/exporting.js"></script>
	<script src="https://code.highcharts.com/modules/export-data.js"></script>
	<script type="text/javascript">
		/* 
		탄수화물 55-65%
		단백질 7-20%
		지방 15-30%
		*/
		$(function() {
			var totalCalory = <c:out value="${totalCalory}"></c:out>; 
			var totalCarbo = <c:out value="${totalCarbo}"></c:out>;
			var totalProtein = <c:out value="${totalProtein}"></c:out> ;
			var totalFat = <c:out value="${totalFat}"></c:out>;
			
			$("#ingestionInfo").append("<p> 총 칼로리 : "+totalCalory+" kcal</p><p> 총 탄수화물 : "+totalCarbo+"g </p><p> 총 단백질 : "+totalProtein+"g</p><p> 총 지방 : "+totalFat+"g</p>");
			
			var CPF = totalCarbo + totalProtein + totalFat;
			var carboRate = totalCarbo/CPF*100;
			var proteinRate = totalProtein/CPF*100;
			var fatRate = totalFat/CPF*100;
			
			Highcharts.chart('graph', {
			    chart: {
			        type: 'bar'
			    },
			    title: {
			        text: '영양 분석'
			    },
			    xAxis: {
			        categories: ['기준치', '현재량']
			    },
			    yAxis: {
			        min: 0,
			        title: {
			            text: '3대 영양소'
			        }
			    },
			    legend: {
			        reversed: true
			    },
			    plotOptions: {
			        series: {
			            stacking: 'normal'
			        }
			    },
			    series: [{
			    	name: '지방',
			        data: [25, fatRate]
			    }, {
			        name: '단백질',
			        data: [15, proteinRate]
			    }, {
				    name: '탄수화물',
			        data: [60, carboRate]
			    }]
			});
			
			$("#metabolism").click(function(){
				var sex = $('input[name="sex"]:checked').val();
				var weight = $('#weight').val();
				var result = 0;
				if(sex=="male"){
					result = weight*1.0*24;
				}else{
					result = weight*0.9*24;
				}
				var warm = "";
				var over = "";
				if(result > totalCalory){
					warm="<p>안전 합니다.</p>";
				}else{
					warm='<p style="color:red;">칼로리'+(-(result-totalCalory))+'kcal 초과!!</p>';
					over='<p>달리기 :'+1000*(-(result-totalCalory))/5/3.5/weight/10/60+'시간을 달려야 됩니다!</p>';
				}
				$("#metabolismInfo").html("<p>"+result+"kcal</p><p>"+warm+"</p>");
				$("#training").html(over);
			});
		});
		function forViewPage(code) {
			//alert(code);
			var path ="FoodServlet?command=view&code="+code;
			//alert(path);
			location.href=path;
		}
	</script>
</head>
<body>
<c:set var="totalCalory" value="0"/>
<c:set var="totalCarbo" value="0"/>
<c:set var="totalProtein" value="0"/>
<c:set var="totalFat" value="0"/>

<c:import url="../header.jsp"></c:import>
<section class="container">
	<c:forEach items="${list}" var="item" varStatus="i">
		<div class="col-sm-4" style="text-align: center">
				<div class="info" onclick="forViewPage(${item.code})">
					<img src="${pageContext.request.contextPath}/${item.img }" style="width:100%; height: 100%"><br>
					<article class="content" style="float: left; width: 70%">
						${item.name}
					</article>
				</div>	
		</div>

	</c:forEach>
	<br>
	<h1>섭취정보</h1>
<%-- 	<c:out value="${totalCalory}"></c:out>
	<c:out value="${totalCarbo}"></c:out>
	<c:out value="${totalProtein}"></c:out>
	<c:out value="${totalFat}"></c:out> --%>
	<div id="ingestionInfo">
	</div>
	<div class="row">
		<div id="graph">
		<!-- 막대 그래프 -->
		</div>
	</div>
	<div class="row">
		<div class="col-sm-6">
			<input type="radio" value="male" name="sex"/> 남성<!-- 남성 kg*1.0*24 -->
			<input type="radio" value="female" name="sex"/> 여성<!-- 여성 kg*0.9*24 --><br>
			체중 : <input type="text" id="weight" /> kg
			<input type="button" id="metabolism" value="확인"/>
		</div>
		<div class="col-sm-6" id="metabolismInfo">
		
		</div>
	</div>
	<div class="row" >
		<div class="col-sm-6" id="training">
		</div>
	</div>
</section>


<c:import url="../footer.jsp"></c:import>
</body>
</html>