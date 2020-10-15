<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/includeFile.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상상펜션 홈페이지</title>


<script type="text/javascript">
	$(function() {

		if ('${sessionScope.userid}' == '') {
			$('.aLogin').show();
			$('.btnMember').show();
			$('.aLogout').hide();
			$('.roomAdd').hide();
			$('.userid').hide();
			$('.btnResultReserve').hide(); 
		

		} else if ('${sessionScope.userid}' == 'tkdtn1101') {
			$('.aLogin').hide();
			$('.aLogout').show();
			$('.roomAdd').show();
			$('.btnMember').hide();
			$('.userid').show();
			$('.btnResultReserve').hide();
			$('.btnreserve').show();
			
		} else {
			$('.aLogin').hide();
			$('.btnMember').hide();
			$('.aLogout').show();
			$('.roomAdd').hide();
			$('.userid').show();
			$('.btnResultReserve').show();
			
		}

		//로그인 이동
		$('#btnLogin').on('click', function(e) {
			e.preventDefault(); //객체의 기본기능을 소멸
			$('#loginForm').attr('action', '${path}/login/');
			$('#loginForm').attr('method', 'post');
			$('#loginForm').submit();
		});

		//로그아웃 폼으로 이동
		$('.aLogout').on('click', function(e) {
			e.preventDefault(); //객체의 기본기능을 소멸
			var result = confirm('로그아웃 하시겠습니까?');
			if (result){
				$(location).attr('href', '${path}/login/logout');
			}
		});
		
		$('.btnResultReserve').on('click',function(){
		
			$(this).attr('href', '${path}/reserve/result?userid=${sessionScope.userid}');
		});
	});
</script>
</head>
<body>

	<div class="colorlib-loader"></div>
	<div id="page">
		<nav class="colorlib-nav" role="navigation">
			<div class="top-menu">
				<div class="container">
					<div class="row">
						<div class="col-sm-7 col-md-9">
							<div id="colorlib-logo">
								<a href="${path}/main/">상상펜션에 오신걸 환영합니다</a>
							</div>
						</div>
					</div>	
					<div class="row">
						<div class="col-sm-12 text-left menu-1">
							<ul>
								<li id="userid" class="userid">${sessionScope.userid} 님 환영합니다</li>
								<li><a href="${path}/main/">홈</a></li>
								<li><a href="" data-toggle="modal" data-target="#loginModal" id="aLogin" class="aLogin">로그인</a></li>
								<li><a href="" class="aLogout">로그아웃</a></li>
								<li><a href="${path}/member/" target="myframe" id="btnMember" class="btnMember" >회원가입</a></li>
								<li><a href="${path}/room/select" id="btnReserve" target="myframe" class="btnreserve">예약</a></li>
								<li><a href="" id="btnResultReserve" target="myframe" class="btnResultReserve">예약확인/취소</a></li>
								<li><a href="${path}/board/" id="btnBoard" target="myframe" class="btnBoard">방명록</a></li>
								<li><a href="${path}/room/addform" id="roomAdd" target="myframe" class="roomAdd">방등록</a></li>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</nav>

		<!-- 로그인 Modal -->
		<div class="modal fade" id="loginModal" role="dialog">
			<div class="modal-dialog modal-sm">
				<div class="modal-content">
					<div class="modal-header">
						<h4 class="modal-title">로그인</h4>
					</div>
					<div class="modal-body">
						<form id="loginForm">
							<div class="input-group">
								<span class="input-group-addon"><i
									class="glyphicon glyphicon-user"></i></span> <input id="id"
									type="text" class="form-control" name="userid" placeholder="id" autocomplete="off">
							</div>
							<div class="input-group">
								<span class="input-group-addon"><i
									class="glyphicon glyphicon-lock"></i></span> <input id="password"
									type="password" class="form-control" name="passwd"
									placeholder="Password" autocomplete="off">
							</div>
						</form>
					</div>
					<div class="modal-footer">
						<a href="" class="btn btn-primary" id="btnLogin">로그인</a> <a
							href="" class="btn btn-success" id="btnLoginCancel">취소</a>
					</div>
				</div>
			</div>
		</div>
		<section>
			<iframe name="myframe" id="myframe" src="${path}/main/slider">
			</iframe>
		</section>
</body>
</html>