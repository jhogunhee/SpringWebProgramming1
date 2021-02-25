<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
#doc {
	width: 1370px;
	clear: both;
	/* margin: 0 auto; */
	border: 0 none;
	background: #ffffff none repeat scroll 0 0;
	outline: 0 none;
	padding: 0;
}

#dropzone {
	border: 2px dotted #3292A2;
	width: 90%;
	height: 50px;
	color: #92AAB0;
	text-align: center;
	font-size: 24px;
	padding-top: 12px;
	margin-top: 10px;
}
</style>
<script>
	$(function () {
		var obj = $("#dropzone");
		
		obj.on('dragenter', function (e) {
			e.stopPropagation(); // 상위 노드로 가는 이벤트를 멈춘다.
			e.preventDefault(); // 현재 객체에 있는 실행요소를 멈춘다.
			
			$(this).css('border', '2px solid #5272A0');
		});
		
		obj.on('dragleave', function (e) {
			e.stopPropagation(); // 상위 노드로 가는 이벤트를 멈춘다.
			e.preventDefault(); // 현재 객체에 있는 실행요소를 멈춘다.
			
			$(this).css('border', '2px dotted #8296C2');
		});
		
		obj.on('dragover', function (e) {
			e.stopPropagation(); // 상위 노드로 가는 이벤트를 멈춘다.
			e.preventDefault(); // 현재 객체에 있는 실행요소를 멈춘다.
		});
		
		obj.on('drop', function (e) {
			e.preventDefault();
			e.stopPropagation(); // 상위 노드로 가는 이벤트를 멈춘다.
			$(this).css('border', '2px dotted #8296C2');
			
			var files = e.originalEvent.dataTransfer.files;
			
			if(files.length < 1) {
				return;
			}
			
			if(confirm(files.length + "개의 파일을 업로드 하시겠습니까?")) {
				var data = new FormData();
				for(var i = 0; i < files.length; i++) {
					data.append('files', files[i]);
				}
				
				var url = "/board/upload2";
				
				$.ajax({
					url         : url,
					method      : 'POST',
					data        : data,
					dataType    : 'json',
					
					// 일반적으로 서버에 전달되는 데이터는 query string 이라는 형태로 전달된다
					// 파일 전송의 경우 이를 하면 안된다.
					processData : false, 
					// contentType 은 default 값이 "application/x-www-form-urlencoded; charset=UTF-8" 인데, "multipart/form-data" 로 전송이 되게 false 로 넣어준다
					// false 말고 "multipart/form-data"를 넣으면 제대로 동작하지 않는다.
					contentType : false,
					success : function(res) {
						alert("업로드가 완료되었습니다.");
						F_FILEMultiUpload_Callback(res.files);
					},
					error : function(res) {
						alert("업로드 중에 에러가 발생했습니다. 파일은 10M를 넘을 수 없습니다.")
						console.log(res);
					}
				});
			}
		})
	})
	
	function F_FILEMultiUpload_Callback(files) {
		for(var i = 0; i < files.length; i++) {
			$("#downloadzone").append("<a href='/board/getFileDownload?filename="+encodeURI(files[i])+"'>"+files[i]+"</a>\n");
		}
	}
</script>
</head>
<body>
	<div id="dropzone">Drag & Drop Files Here</div>
	** 첨부된 파일 목록
	<div id="downloadzone"></div>
</body>
</html>