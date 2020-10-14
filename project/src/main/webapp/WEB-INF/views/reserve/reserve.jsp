<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/includeFile.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>예약</title>
<link rel="stylesheet"
	href="http://code.jquery.com/ui/1.10.0/themes/base/jquery-ui.css" />
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="http://code.jquery.com/ui/1.10.0/jquery-ui.js"></script>
<link rel="stylesheet" href="/resources/demos/style.css" />
<script>
	$(function() {
		$("#startdate").datepicker(
				{
					dateFormat : 'yy-mm-dd',
					monthNamesShort : [ '1월', '2월', '3월', '4월', '5월', '6월',
							'7월', '8월', '9월', '10월', '11월', '12월' ],
					dayNamesMin : [ '일', '월', '화', '수', '목', '금', '토' ],
					changeMonth : true, // 월변경가능
					changeYear : true, // 년변경가능
					showMonthAfterYear : true
				// 년 뒤에 월표시
				});

		$("#enddate").datepicker(
				{
					dateFormat : 'yy-mm-dd',
					monthNamesShort : [ '1월', '2월', '3월', '4월', '5월', '6월',
							'7월', '8월', '9월', '10월', '11월', '12월' ],
					dayNamesMin : [ '일', '월', '화', '수', '목', '금', '토' ],
					changeMonth : true, // 월변경가능
					changeYear : true, // 년변경가능
					showMonthAfterYear : true
				// 년 뒤에 월표시
				});

		$('#btnCheck').on('click', function() {

			$('#reserve').attr('action', '${path}/reserve/check');
			$('#reserve').attr('method', 'post');
			$('#reserve').submit();

		});

		$('#btnMain').on('click', function() {
			$('#reserve').attr('action', '${path}/room/select');
			$('#reserve').submit();
		});
	});
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

						<form id="reserve" class="reserve">
							<h3 class="text-center text-info">예 약</h3>
							<div class="form-group">
								<div id="wrap">
									<div class="container">
										<div id="article">
											<label for="startdate" class="text-info">입실날짜</label> <input
												type="text" name="startdate" id="startdate" autocomplete="off"
												class="form-control">
										</div>
										<div class="form-group">
											<label for="enddate" class="text-info">퇴실날짜</label><br>
											<input type="text" name="enddate" id="enddate" autocomplete="off"
												class="form-control">
										</div>
										<input type="hidden" id="roomid" name="roomid"
											value=${roomid }> <input type="hidden" id="roomname"
											name="roomname" value=${roomname }> <input
											type="hidden" id="userid" name="userid"
											value=${sessionScope.userid }> <input type="button"
											id="btnCheck" class="btn btn-info" value="확인"> <input
											type="button" id="btnMain" class="btn btn-info" value="취소">
									</div>
								</div>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>