<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/includeFile.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 저장</title>
<script type="text/javascript">
	$(function() {
		//저장버튼을 클릭했을때
		$('#btnAdd').on('click', function(e) {
			e.preventDefault(); //객체의 기본기능 소멸
			$('#addForm').attr('action', '${path}/board/add');
			$('#addForm').attr('method', 'post');
			$('#addForm').attr('enctype', 'multipart/form-data');

			$('#addForm').submit();
		});

		//목록버튼을 클릭했을때
		$('#btnList').on('click', function(e) {
			e.preventDefault(); //객체의 기본기능 소멸
			$(location).attr('href', '${path}/board/list');
		});

		//파일 삭제 버튼을 클릭했을때
		$('.btnFileDelete').on('click', function(e) {
			e.preventDefault();
			$(this).parent().remove();
		});

		//파일이 change
		//동적 생성 엘리먼트에 이벤트 달기
		$('#fileGroup').on(
				'change',
				'div',
				function(e) {
					e.preventDefault();
					//파일 선택 추가 
					var appendHtml = '<div>'
							+ '<input type="file" name="bfiles">'
							+ '<button class="btnFileDelete">삭제</button>'
							+ '</div>';
					$('#fileGroup').append(appendHtml);

				});

	});
</script>
</head>
<body>
	<div id="Add">
		<h3 class="text-center text-white pt-5"></h3>
		<div class="container">
			<div id="login-row"
				class="row justify-content-center align-items-center">
				<div id="Mypage-column" class="col-md-6">
					<div id="Mypage-box" class="col-md-12">

						<form id="addForm" class="form" action="" method="post">
							<h3 class="text-center text-info">게시글 추가</h3>
							<div class="form-group">
								<label for="writer" class="text-info">작성자</label><br> <input
									type="text" name="writer" value="${sessionScope.userid}"
									class="form-control">
							</div>
							<div class="form-group">
								<label for="email" class="text-info">email</label><br> <input
									type="email" name="email" class="form-control">
							</div>
							<div class="form-group">
								<label for="subject" class="text-info">제목</label><br> <input
									type="text" name="subject" class="form-control">
							</div>
							<div class="form-group">
								<label for="content" class="text-info">내용</label><br>
								<textarea class="form-control" name="content" rows="5" cols="20"
									class="form-control"></textarea>
							</div>
							<div class="form-group">
								<label for="file" class="text-info">파일</label><br>
								<div id="fileGroup">
									<div>
										<input type="file" name="bfiles">
										<button class="btnFileDelete">삭제</button>
									</div>
								</div>
							</div>
							<div class="form-group">
								<input type="button" class="btn btn-info btn-md" value="추가" id='btnAdd'> 
								<input type="button" class="btn btn-info btn-md" value="취소" id='btnList'>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>