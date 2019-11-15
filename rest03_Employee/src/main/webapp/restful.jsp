<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<c:url value="/findAllEmployees" var="findAllEmployees"/>
<h1><button id="btn">Show Employee List</button></h1>
<table border="2" width="50%">
	<thead>
		<tr>
			<th>직원아이디</th>
			<th>직원 이름</th>
			<th>부서번호</th>
		</tr>
	</thead>
	<tbody id="list">
	
	</tbody>
</table>
</body>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script>
$(function() {
	$('#btn').click(function() {
		$.ajax({
			url: "${findAllEmployees}",
			type: "get",
			success:function(resData){
				var str="";
				if(resData!=null){
					$.each(resData, function(idx, emp) {
						str += "<tr>";
						str += "<td>"+emp.id+"</td>";
						str += "<td>"+emp.name+"</td>";
						str += "<td>"+emp.title+"</td>";
					})//each
				}//if
				
				$("#list").append(str);
			}
			
		});//ajax
	});//click
});//function
</script>

</html>