<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/includeFile.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<script type="text/javascript">
$(function () {
	
	//가입
	$('#btnJoin').on('click', function() {
		$('#joinForm').attr('action','${path}/member/');
		$('#joinForm').attr('method','post');
		$('#joinForm').submit();
	});
	

	//로그인 폼으로 이동
	$('#btnMain').on('click', function() {
		$(location).attr('href', '${path}/main/slider');
	});
	
	//naver아이디 및 계정 가지고 오기
	$('#btnNaver').on('click', function() {
		$(location).attr('href', '${apiURL}');
		
	});
	
})
</script>
</head>
<body>
	<form id="joinForm" name="join" action="" method="">
		<table border="1">
			<tr>
				<th>ID</th>
				<td><input type="text" name="userid" value="${email}"></td>
			</tr>
			<tr>
				<th>Password</th>
				<td><input type="password" name="passwd"></td>
			</tr>
			<tr>
				<th>Email</th>
				<td><input type="text" name="email" value="${email}"></td>
			</tr>
			<tr>
				<th>이름</th>
				<td><input type="text" name="name" value="${name}"></td>
			</tr>
			<tr>
				<th>전화번호</th>
				<td><input type="text" name="phone"></td>
			</tr>
		</table>
			<input type="button" id="btnJoin" value="가입">
			<input type="button" id="btnMain" value="취소">
			<input type="button" id="btnNaver" value="네이버로 회원가입">
	</form>
</body>
</html>