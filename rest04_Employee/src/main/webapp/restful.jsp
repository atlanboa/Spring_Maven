<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:url value="/findAllEmployees" var="findAllEmployees"/>
<h1>전제직원명단보기 :: 버튼 클릭</h1>
<h1><button id="btn">Show Employee List</button></h1>
<table border="2" width="50%">
	<thead>
		<tr>
			<th>직원아이디</th>
			<th>직원이름</th>
			<th>타이틀</th>
		</tr>
	</thead>
	<tbody id="list">	
	</tbody>
</table>

<!-- INSERT, DELETE 추가로직  -->
<h1>직원 등록 폼</h1>
<form action="" id="empForm">
ID <input type="text" id="id" name="id"><br>
NAME <input type="text" id="name" name="name"><br>
MAILID <input type="text" id="mailid" name="mailid"><br>
START_DATE <input type="date" id="start_date" name="start_date"><br>
MANAGER_ID <input type="text" id="manager_id" name="manager_id"><br>
TITLE <input type="text" id="title" name="title"><br>
DEPT_ID <input type="text" id="dept_id" name="dept_id"><br>
SALARY <input type="text" id="salary" name="salary"><br>
COMMISSION <input type="text" id="commission_pct" name="commission_pct"><br><br>

<input type="button" value="추가하기" id="btnInsert">
<input type="button" value="삭제하기" id="btnDelete">
<input type="text" id="delId" placeholder="삭제할 아이디">

</form>
<div id="status"></div>
</body>
<!-- jquery cdn -->
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script>
$(function(){
	$('#btn').one('click',function() {
		$.ajax({
			url:"${findAllEmployees}",
			type:"get",
			
			success:function(resData){
				var str="";
				//$("#list").empty();
				if(resData!=null){
					$.each(resData, function(idx, emp) {
						str+="<tr>";
						str+="<td class='id'>"+emp.id+"</td>";
						str+="<td>"+emp.name+"</td>";
						str+="<td>"+emp.title+"</td>";
						str+="</tr>";
					});//each
					$("#list").append(str);
				}
			}//success			
		});//ajax
	});//click
	
	$('#btnInsert').click(function(){
		let employee={
				id:$("#id").val(),
				name:$("#name").val(),
				mailid:$("#mailid").val(),
				start_date:$("#start_date").val(),
				manager_id:$("#manager_id").val(),
				title:$("#title").val(),
				dept_id:$("#dept_id").val(),
				salary:$("#salary").val(),
				commission_pct:$("#commission_pct").val()
				};
		$.ajax({
			url:"addEmployee",
			type:"post",
			data:JSON.stringify(employee),
			contentType:"application/json", //응답할때 받는 타입
			success:function(resData){
				if(resData!=null){
					$("#status").html("직원등록 성공!!");
				}
			}
		});
	});//click
	$('#btnDelete').click(function(){
		let id=$('#delId').val();
		alert(id);
		$.ajax({
			url:"deleteEmployee/"+id,
			type:"delete",
			success:function(resData){
				if(resData!=null){
					$("#status").html("직원삭제 성공!!").css('color','red');
				}
			}
		});//ajax
	});//click
	
	$('#list').on('click','.id',function(){
		let id = $(this).text();
		$.ajax({
			url:"findEmployeeById/"+id,
			type:"get",
			success:function(resData){
				$("#status").html(resData.id+","+resData.name);
			}//success
		});//ajax
	});
});//function

</script>
</html>



























