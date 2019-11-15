<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Rest API Controller Test</title>
</head>
<body>
	<c:url value="/getAllBooks" var="getAllBooks" />
	<c:url value="/getBook" var="getBook" />
	<c:url value="/insertBook" var="insertBook" />
	<c:url value="/updateBook" var="updateBook" />
	<c:url value="/deleteBook" var="deleteBook" />
	<h1 align="center">Welcome to SSAFY</h1>
	<hr />
	<h2>도서 관리</h2>
	<br />
	<br />

	<button id="btn">목록 조회</button>

	<ul id="ulList">
	</ul>
	<br />
	<form>
		<input type="reset" id="insertBookBtn" value="추가">
		<input type="reset" id="updateBookBtn" value="수정">
		<input type="reset" id="deleteBookBtn" value="삭제">
		<br /> 
		ISBN : <input id="isbn" type="text" name="isbn"> 
		제목 : <input id="title" type="text" name="title"> 
		저자 : <input	id="author" type="text" name="author"> 
		출판사 : <input id="publisher" type="text" name="publisher">
		<textarea id="description" name="description" rows="5" cols="100" ></textarea>
		
	</form>




</body>
<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script>
	$(function() {
		$('#btn').click(
				function() {
					$('#ulList').empty();
					$.ajax({
						url : "${getAllBooks}",
						type : "get",
						success : function(resData) {
							var str = "";
							if (resData != null) {
								$.each(resData, function(idx, book) {

									str += "<li class=list id="+book.isbn+">"
											+ book.isbn + "</li>";

								})//each
							}//if

							$("#ulList").append(str);
						}

					});//ajax
				});//click
		$(document).on('click', '.list', function() {
			var isbn = $(this).attr('id');
			//alert(id);
			$.ajax({
				url : "${getBook}" + "/" + isbn,
				type : "get",
				success : function(resData) {

					if (resData != null) {
						$('#isbn').val(resData.isbn);
						$('#title').val(resData.title);
						$('#author').val(resData.author);
						$('#publisher').val(resData.publisher);
						$('#description').val(resData.description);
					}

				}

			});//ajax
		});//on 

		$('#updateBookBtn').click(function() {
			
			
			
			var isbn = $('#isbn').val();
			var title = $('#title').val();
			var author = $('#author').val();
			var publisher = $('#publisher').val();
			var description = $('#description').val();

			alert(isbn + " " + title + " " + author + " " + publisher);

			$.ajax({
				url : "${updateBook}",
				type : "post",
				dataType : "json",
				data : JSON.stringify({
					"isbn" : isbn,
					"title" : title,
					"author" : author,
					"publisher" : publisher,
					"description" : description
				}),
				contentType : "application/json; charset=UTF-8",
				success : function(res) {

					alert("insertBook 성공");

				}

			});//ajax
			$('#btn').trigger("click");

		});//click

		$('#deleteBookBtn').click(function() {
			
			var isbn = $('#isbn').val();

			$.ajax({
				url : "${deleteBook}/" + isbn,
				type : "get",
				success : function() {

					alert("deleteBook 성공");

				}

			});//ajax
			$('#btn').trigger("click");

		});//click

		$('#insertBookBtn').click(function() {
			
			var isbn = $('#isbn').val();
			var title = $('#title').val();
			var author = $('#author').val();
			var publisher = $('#publisher').val();
			var description = $('#description').val();

			alert(isbn + " " + title + " " + author + " " + publisher);

			$.ajax({
				url : "${insertBook}",
				type : "post",
				dataType : "json",
				data : JSON.stringify({
					"isbn" : isbn,
					"title" : title,
					"author" : author,
					"publisher" : publisher,
					"description" : description,
					"catalogue" : "화보",
				}),
				contentType : "application/json; charset=UTF-8",
				success : function(res) {

					alert("insertBook 성공");

				}

			});//ajax
			$('#btn').trigger("click");

		});//click

	});//function
	

</script>
</html>