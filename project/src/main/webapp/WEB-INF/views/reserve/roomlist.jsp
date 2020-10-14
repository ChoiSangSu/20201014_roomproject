<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/includeFile.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>방</title>
<!-- Google Font -->
<link
	href="https://fonts.googleapis.com/css?family=Taviraj:300,400,500,600,700,800,900&display=swap"
	rel="stylesheet">
<link
	href="https://fonts.googleapis.com/css?family=Open+Sans:300,400,600,700,800&display=swap"
	rel="stylesheet">

<!-- Css Styles -->
<link rel="stylesheet"
	href="${path}/resources/room/css/bootstrap.min.css" type="text/css">
<link rel="stylesheet"
	href="${path}/resources/room/css/font-awesome.min.css" type="text/css">
<link rel="stylesheet" href="${path}/resources/room/css/flaticon.css"
	type="text/css">
<link rel="stylesheet" href="${path}/resources/room/css/linearicons.css"
	type="text/css">
<link rel="stylesheet"
	href="${path}/resources/room/css/owl.carousel.min.css" type="text/css">
<link rel="stylesheet"
	href="${path}/resources/room/css/jquery-ui.min.css" type="text/css">
<link rel="stylesheet" href="${path}/resources/room/css/nice-select.css"
	type="text/css">
<link rel="stylesheet"
	href="${path}/resources/room/css/magnific-popup.css" type="text/css">
<link rel="stylesheet"
	href="${path}/resources/room/css/slicknav.min.css" type="text/css">
<link rel="stylesheet" href="${path}/resources/room/css/style.css"
	type="text/css">
<script type="text/javascript">
	$(function() {

		$('.btnReserve').on('click', function() {
			var roomid = $('.roomid').val();
			$(location).attr('href', '${path}/reserve/?roomid=' + roomid);
		});

		$('.btnList').on('click', function() {
			$(location).attr('href', '${path}/main/slider');
		});

	})
</script>
</head>
<body>
	<!-- Rooms Section Begin -->
	<c:forEach var="rlist" items="${rlist}">
		<section class="room-section spad">
			<div class="container">
				<div class="rooms-page-item">
					<div class="row">
						<div class="col-lg-6">
							<div class="room-pic-slider owl-carousel">
								<div class="single-room-pic">
									<img src="${path}/localimg/${rlist.filename}" alt="">
								</div>
								<div class="single-room-pic">
									<img src="${path}/localimg/${rlist.filename}" alt="">
								</div>
							</div>
						</div>
						<div class="col-lg-6">
							<div class="room-text">
								<div class="room-title">
									<h2>${rlist.roomname }</h2>
								</div>
								<div class="room-desc">
									<p>${rlist.content1}</p>
									<p>${rlist.content2}</p>
									<p>${rlist.content3}</p>
								</div>
								<div class="room-features">
									<div class="room-info">
										<i class="flaticon-019-television"></i> <span>Smart TV</span>
									</div>
									<div class="room-info">
										<i class="flaticon-029-wifi"></i> <span>High Wi-fii</span>
									</div>
									<div class="room-info">
										<i class="flaticon-003-air-conditioner"></i> <span>AC</span>
									</div>
									<div class="room-info">
										<i class="flaticon-036-parking"></i> <span>Parking</span>
									</div>
									<div class="room-info last">
										<i class="flaticon-007-swimming-pool"></i> <span>Pool</span>
									</div>
									<div class="primary-btn">
									  <a href="#" class="btnReserve" >예약</a>
									  <input type="hidden" class="roomid" value="${rlist.roomid }">
									 </div>
									 <div class="primary-btn">
									  <a href="#" class="btnList" >취소</a>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</section>
	</c:forEach>
	<!-- Js Plugins -->
	<script src="${path}/resources/room/js/jquery-3.3.1.min.js"></script>
	<script src="${path}/resources/room/js/bootstrap.min.js"></script>
	<script src="${path}/resources/room/js/jquery.magnific-popup.min.js"></script>
	<script src="${path}/resources/room/js/jquery-ui.min.js"></script>
	<script src="${path}/resources/room/js/jquery.nice-select.min.js"></script>
	<script src="${path}/resources/room/js/jquery.slicknav.js"></script>
	<script src="${path}/resources/room/js/owl.carousel.min.js"></script>
	<script src="${path}/resources/room/js/main.js"></script>
</body>
</html>