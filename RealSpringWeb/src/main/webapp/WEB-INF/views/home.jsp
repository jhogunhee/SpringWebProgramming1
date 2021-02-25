<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- npm을 이용한 jqeury 가져오기 -->
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script src="/resources/js/common.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
<html>
<head>
	<title>Home</title>
	<script>
		window.onload = function () {
			util.initSelectBox('type', 'period', '1w', 'Y');
			
			$("#menu1").click(function () {
				showLoad("/study/exception404");
			});
			$("#menu2").click(function () {
				showLoad("/study/exceptionByZero");
			});
			$("#menu3").click(function () {
				showLoad("/study/registForm");
			});
			$("#menu4").click(function () {
				showLoad("/board/writeForm1");
			});
			$("#menu5").click(function () {
				showLoad("/board/writeForm2");
			});
			$("#menu6").click(function () {
				showLoad("/study/testTransaction");
			});
		}
	
		function getMessage(no) {
			util.requestSync("/study/getMessage"+no, "", "GET", result);
		}
		
		function result(data) {
			console.log(data);
			alert(data.name);
		}
		
		function showLoad(url) {
			$("#frame").load(url, function(response, status) {
				if(status == 'error') { // 에러도 화면이 나오게끔 처리
					$(this).html(response)
				}
			})
		}
	</script>
</head>
<body>

<h1>
	Hello world!  
</h1>
	<div id="container">
		<div class="row">
			<div class="col-md-2">
				<p>1. 클래스를 이용한 JSON 반환 <input type="button" value="getMessage1" onclick="getMessage(1)"></p><br>
				<p>2. Map을   이용한 JSON 반환 <input type="button" value="getMessage2" onclick="getMessage(2)"></p><br>
				<select id="type"></select><br>
				3. <a href="<c:url value="/study/exception404"/>">404 Error</a><br/>
				4. <a href="<c:url value="/study/exceptionByZero"/>">By Zero Error</a><br/>
				5. <a href="<c:url value="/study/registForm"/>">회원가입</a><br/>
				
				1. <span id="menu1" style="cursor:pointer;">404 Error</span><br/>
				2. <span id="menu2" style="cursor:pointer;">By Zero Error</span><br/>
				3. <span id="menu3" style="cursor:pointer;">회원가입</span><br/>
				4. <span id="menu4" style="cursor:pointer;">멀티 파일 업로드 </span><br/>
				5. <span id="menu5" style="cursor:pointer;">드래그앤 드롭 파일 다운로드</span><br/>
				6. <span id="menu6" style="cursor:pointer;">Transaction Test(콘솔로 데이터 확인)</span>
			</div>
			<div class="col-md-10">
				
				<div id="frame"></div>
			</div>
		</div>
	</div> 
</body>
</html>
