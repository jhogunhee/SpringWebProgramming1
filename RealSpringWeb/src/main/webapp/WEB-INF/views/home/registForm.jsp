<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
<script src="https://code.jquery.com/jquery-2.2.1.min.js"></script>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	function doReg() {
		$("#form").submit();
	}
</script>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-sm-12 text-center">
				<div class="col-sm-1"></div>
				
				<div class="col-sm-11">
					<h2>회원가입</h2>
					<form action="/study/doReg" id="form" method="post">
						<table class="table table-boardered">
							<tr>
								<th>아이디</th>
								<td><input type="text" class="form-control" id="name" name="name"></td>
							</tr>

							<tr>
								<th>이메일</th>
								<td><input type="text" class="form-control" name="email" id="email"></td>
							</tr>
							<tr>
								<th>패스워드</th>
								<td><input type="password" class="form-control" name="password" id="password"></td>
							</tr>
							<tr>
								<th>성별</th>
								<td><input type="radio" name="gender" id="man" value="M"><label for="man">남</label> &nbsp;&nbsp; 
								<input type="radio" name="gender" id="woman" value="W"><label for="woman">여</label> &nbsp;&nbsp;</td>
							</tr>
							<tr>
								<th>취미</th>
								<td><input type="checkbox" name="hobby1" id="hobby1" value="1">
								<label for="hobby1">독서</label> &nbsp;&nbsp; <input type="checkbox" name="hobby2" id="hobby2" value="1">
								<label for="hobby2">운동</label> &nbsp;&nbsp;</td>
							</tr>
							<tr>
								<td colspan="2">
									<button type="button" class="btn btn-info" id="reg_submit" onclick="doReg()">등록</button>
								</td>
							</tr>
						</table>
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>