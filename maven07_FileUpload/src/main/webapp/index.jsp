<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 
1. 무조건 form 태그를 사용한다. -- a 태그는 불가
2. method 방식은 post ----- 단순한 스트링을 넘기는게 아니라 선택한 파일 자체(MultipartFile)를 넘기는 것이다.
3. input type ="file" 
4. enctype="multipart/form-data"
 -->
<h2>File Upload Form</h2>
<form action="fileUpload.do" method="post" enctype="multipart/form-data">
사용자명 <input type="text" name="userName"><p/>
<input type="file" name="uploadFile"><p/>
<input type="submit" value="전송하기"> 
</form>
</body>
</html>
<!--
보통은 여기까지 작성했으면..컴포넌트 작성하러 넘어가는데
파일업로드 기술은 vo를 하나 작성할게 있다.
model>UploadDataVO
 -->
