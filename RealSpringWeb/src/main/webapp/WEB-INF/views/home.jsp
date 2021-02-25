<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- npm을 이용한 jqeury 가져오기 -->
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script src="/resources/js/common.js"></script>
<html>
<head>
	<title>Home</title>
	<script>
		function getMessage(no) {
			
			util.requestSync("/study/getMessage"+no, "", "GET", result);
		}
		
		function result(data) {
			console.log(data);
			alert(data.name);
		}
		
		util.initSelectBox('type', 'period', '1w', 'Y');
	</script>
</head>
<body>
<h1>
	Hello world!  
</h1>
	<p> The time on the server is ${serverTime}</P>
	<h2> ${combo}</h2>
	1. 클래스를 이용한 JSON 반환 <input type="button" value="getMessage1" onclick="getMessage(1)"><br>
	2. Map을   이용한 JSON 반환 <input type="button" value="getMessage2" onclick="getMessage(2)"><br>
	<select id="type"></select><br>
	3. <a href="<c:url value="/study/exception404"/>">404 Error</a><br>
	4. <a href="<c:url value="/study/exceptionByZero"/>">By Zero Error</a>
</body>
</html>
