<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form id="form" method="post" enctype="multipart/form-data" action="/board/upload">
		<input type="file" name="files" accept="" multiple="multiple"/>
		<button class="btn btn-info" type="submit">등록</button>
	</form>
</body>
</html>