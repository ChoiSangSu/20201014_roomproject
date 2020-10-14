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

		$('.btnMain').on('click', function() {
			$('#resultForm').attr('action', '${path}/main/slider');
			$('#resultForm').submit();
		});

		$('.btnCan').on(
				'click',
				function(e) {
					e.preventDefault(); //객체의 기본기능을 소멸
					var rnum = $(this).val();
					$(location).attr('href',
							'${path}/reserve/cancle?rnum=' + rnum);
				});

	})
</script>
</head>
<body>
	<c:forEach var="list" items="${list}">
		<div id="Join">
			<h3 class="text-center text-white pt-5"></h3>
			<div class="container">
				<div id="login-row"
					class="row justify-content-center align-items-center">
					<div id="Mypage-column" class="col-md-6">
						<div id="Mypage-box" class="col-md-12">
							<form id="resultForm" class="resultForm">
								<h3 class="text-center text-info">예약 현황</h3>
								<div class="form-group">
									<label for="username" class="text-info">이름</label><br> 
									<input type="text" name="name" id="name" value="${list.name }" class="form-control" readonly>
								</div>
								<div class="form-group">
									<label for="" class="text-info">email</label><br> <input
										type="text" name="email" id="emil" value="${list.email}" class="form-control" readonly>
								</div>
								<div class="form-group">
									<label for="text" class="text-info">방이름</label><br> <input
										type="text" name="roomname" id="roomname" value="${list.roomname}" class="form-control" readonly>
								</div>
								<div class="form-group">
									<label for="text" class="text-info">입실날짜</label><br> <input
										type="text" name="startdate" id="startdate" value="${list.startdate}" class="form-control" readonly>
								</div>
								<div class="form-group">
									<label for="text" class="text-info">퇴실날짜</label><br> <input
										type="text" name="enddate" id="enddate" value="${list.enddate}" class="form-control" readonly>
								</div>
								<div class="form-group">
									<input type="button" id="btnRoomAdd" class="btn btn-info btn-md btnMain"  value="확인">
									<button  id="btnMain" class="btn btn-info btn-md btnCan" value="${list.rnum }">예약 취소</button>
								</div>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</c:forEach>


</body>
</html>