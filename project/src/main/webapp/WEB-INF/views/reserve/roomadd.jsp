<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/includeFile.jsp"%>
<!DOCTYPE html>
<html>
<head>
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<meta charset="EUC-KR">
<title>회원가입</title>
<style type="text/css">
#logo {
	display: block;
	margin-left: 600px;
}
</style>
<script type="text/javascript">
	$(function() {
		$('#btnRoomAdd').on('click', function() {
			$('#Add').attr('action', '${path}/room/add');
			$('#Add').attr('method', 'post');
			$('#Add').attr('enctype', 'multipart/form-data');
			$('#Add').submit();
		});

		$('#btnMain').on('click', function() {
			$('#Add').attr('action', '${path}/main/slider');
			$('#Add').submit();
		});

	})
</script>
</head>
<body>
	<div id="Join">
		<h3 class="text-center text-white pt-5"></h3>
		<div class="container">
			<div id="login-row"
				class="row justify-content-center align-items-center">
				<div id="Mypage-column" class="col-md-6">
					<div id="Mypage-box" class="col-md-12">

						<form id="Add" class="Add" >
							<h3 class="text-center text-info">방 등록</h3>
							<div class="form-group">
								<label for="filename" class="text-info">방 사진</label><br>
								<input type="file" name="files" id="files"
									class="form-control">
							</div>
							<div class="form-group">
								<label for="roomname" class="text-info">방 이름</label><br>
								<input type="text" name="roomname" id="roomname"
									class="form-control">
							</div>
							<div class="form-group">
								<label for="content1" class="text-info">방 구성</label><br> <input
									type="text" name="content1" id="content1" class="form-control">
							</div>
							<div class="form-group">
								<label for="content2" class="text-info">인원구성</label><br> <input
									type="text" name="content2" id="content2" class="form-control">
							</div>
							<div class="form-group">
								<label for="content3" class="text-info">인원추가 비용</label><br> <input
									type="text" name="content3" id="content3" class="form-control">
							</div>
							<div class="form-group">
								<input type="button" id="btnRoomAdd" class="btn btn-info btn-md" value="저장"> 
								<input type="button" id="btnMain" class="btn btn-info btn-md" value="취소">		
							</div>
						</form>

					</div>
				</div>
			</div>
		</div>
	</div>




</body>
</html>