<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/includeFile.jsp"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상세조회</title>
<!-- 핸들바 라이브러리 추가 -->
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/4.7.6/handlebars.js"></script>
<!-- 핸들바 탬플릿 작성 -->
<script id="replyTemplate" type="text/x-handlebars-template">
	{{#each .}}
		<li>
			<div>
				번호 : {{rnum}} <br>
				작성자 : {{writer}} <br>
				내용 : <span id='rnum{{rnum}}' > {{content}} </span> <br>
				등록일자 : {{regdate}} <br>
				<button class ='btnReplyModify' value='{{rnum}}'>수정</button>
				<button class ='btnReplySave' value='{{rnum}}' hidden>저장</button>
				<button class ='btnReplyCancel' value='{{rnum}}' hidden>취소</button>
				<button class ='btnReplyDelete' value='{{rnum}}'>삭제</button>
			</div>
		</li>
	{{/each}}
</script>

<script type="text/javascript">
 	$(function() {
 		
 		replyList();
 		
 		//수정버튼을 클릭했을때 수정폼으로 이동
 		$('#btnModify').on('click', function(e){
 			e.preventDefault(); //객체의 기본기능 소멸
 			var bnum = $('#bnum').text();
			$(location).attr('href', '${path}/board/modify?bnum='+ bnum);
 		} );

 		//목록버튼을 클릭했을때
 		$('#btnList').on('click', function(e) {
 			e.preventDefault(); //객체의 기본기능 소멸
			$(location).attr('href', '${path}/board/list');
		});
 		
 		//삭제버튼을 눌렀을때
 		$('#btnDelete').on('click', function(e) {
 			e.preventDefault(); //객체의 기본기능 소멸
 			var result = confirm('삭제하시겠습니까?');
 			if (result){
 	 			var bnum = $('#bnum').text();
 				$(location).attr('href', '${path}/board/delete?bnum=' + bnum);			
 			}
 			
		});
		
		//다운로드 버튼을 클릭했을때
		$('.fileDownload').on('click', function(e) {
 			e.preventDefault(); //객체의 기본기능 소멸
			var filename = $(this).val();
			$(location).attr('href', '${path}/board/filedownload?filename=' +filename);
			
		});
		
		//댓글추가저장버튼
		$('#btnReplyAdd').on('click',function(){
			var bnum = $('#bnum').text(); //게시물번호
			var replyWriter = $('#replyWriter').val(); //댓글 작성자
			var replyContent = $('#replyContent').val(); //댓글 내용
			//alert(replyContent);
			//공백 체크
			if (replyWriter == ''){
				alert('작성자를 입력해 주세요');
				$('#replyWriter').focus();
				return  //함수 실행 즉각 종료
			}else if (replyContent == ''){
				alert('내용을 입력해 주세요');
				$('#replyContent').focus();
				return
			}
			$.ajax({
				type:'post',
				contentType:'application/json',
				url : '${path}/reply/',
				data : JSON.stringify({bnum:bnum,writer:replyWriter,content:replyContent}), //json문자열 표기법으로 변환
				dataType : 'text',  //결과값의 타입
				success : function(result){
					alert(result);
					replyList();
					//추가데이터 클리어
					$('#replyWriter').val('');
					$('#replyContent').val('');
					
				},
				error:function(result){
					alert("error");
					console.log(result);
				}
			});
		});
		
		//댓글 조회
		$('#btnReplyList').on('click', function() {
			replyList();
		});
		
		function replyList(){
			var bnum = $('#bnum').text(); //게시물번호
			/* alert(bnum); */
			$.ajax({
				type:"get",
				url:'${path}/reply/' + bnum, //restfull하게 설계
				dataType : 'json', //결과값의 형태
				success:function(result){
		/* 			alert('성공'); */
					console.log(result);
					replyDisplay(result);
				},
				error:function(result){
					alert('error');
				}
			});
			
			
		}
		//댓글리스트 만들고 출력
		function replyDisplay(data) {
			//핸들바 탬플릿을 이용한 리스트 만들기 
			var source = $('#replyTemplate').html();
			var template = Handlebars.compile(source);
			$('#replies').html(template(data));
		}
		
		//댓글 수정
		$('#replies').on('click', '.btnReplyModify',function(){
			var rnum = $(this).val();
			var html = '<textarea id="rnum'+ rnum + '">'+ $('#rnum'+rnum).html() +'</textarea>'; //수정할수 있게 변경
			$('#rnum'+rnum).replaceWith(html); //기존의 html을 바꾼다
			//버튼 컨트롤
			$('.btnReplySave[value=' + rnum + ']').show(); //저장버튼 보이기
			$('.btnReplyCancel[value=' + rnum + ']').show(); //취소버튼 보이기
			$('.btnReplyModify[value=' + rnum + ']').hide(); //수정버튼 감추기
			
		});
		
		//댓글 취소
		$('#replies').on('click', '.btnReplyCancel',function(){
			var rnum = $(this).val();
			//원래상태대로 변경
			var html = '<span id="rnum'+ rnum + '">'+ $('#rnum'+rnum).html() +'</span>'; 
			$('#rnum'+rnum).replaceWith(html); //기존의 html을 바꾼다
			//버튼 컨트롤
			$('.btnReplySave[value=' + rnum + ']').hide(); //저장버튼 감추기
			$('.btnReplyCancel[value=' + rnum + ']').hide(); //취소버튼 감추기
			$('.btnReplyModify[value=' + rnum + ']').show(); //수정버튼 보이기
			
		});
		
		//댓글수정저장버튼
		$('#replies').on('click', '.btnReplySave',function(){
			var rnum = $(this).val(); //댓글번호
			var replyContent = $('#rnum'+rnum).val(); //댓글 내용
			//alert(replyContent);
			$.ajax({
				type:'put', //수정
				contentType:'application/json', //json형태로 데이터 서버에 보냄
				url : '${path}/reply/'+rnum, 
				data : JSON.stringify({content:replyContent}), //json문자열 표기법으로 변환
				dataType : 'text',  //결과값의 타입
				success : function(result){
					alert(result);
					afterSave(rnum);
				},
				error:function(result){
					alert("error");
					console.log(result);
				}
			});
		});

		//수정저장후 버튼 상태 변경
		function afterSave(rnum){
			var html = '<span id="rnum'+ rnum + '">'+ $('#rnum'+rnum).val() +'</span>';
			$('#rnum'+rnum).replaceWith(html); //기존의 html을 바꾼다
			//버튼 컨트롤
			$('.btnReplySave[value=' + rnum + ']').hide(); //저장버튼 감추기
			$('.btnReplyCancel[value=' + rnum + ']').hide(); //취소버튼 감추기
			$('.btnReplyModify[value=' + rnum + ']').show(); //수정버튼 보이기
		}
		
		//댓글 삭제
		$('#replies').on('click', '.btnReplyDelete',function(){
			var rnum = $(this).val(); //댓글 번호
			var bnum = $('#bnum').text(); //게시물 번호
			$.ajax({
				type:"delete",
				//url에서 파라미터 형식으로 bnum을 보내 주어도 된다
				url:'${path}/reply/' + rnum +'?bnum=' + bnum, //restfull하게 설계
				//server.xml에서 parseBodyMethods 기능을 추가시 data에 bnum을 넘겨주어도 된다
				//data : 'bnum=' + bnum, //바디로 보낸다
				dataType : 'text', //결과값의 형태
				success:function(result){
					alert(result);
					replyList();
				},
				error:function(result){
					alert('error');
				}
			});
			
		});		
		
	});
 </script>

</head>
<body>
	<div class="container">
		<h3 class="text-center text-white pt-5"></h3>
		<div class="container">
			<div id="login-row"
				class="row justify-content-center align-items-center">
				<div id="Mypage-column" class="col-md-6">
					<div id="Mypage-box" class="col-md-12">
						<h3 class="text-center text-info">상세 조회</h3>
						<div class="form-group">
							<label for="writer" class="text-info">순번:</label>&nbsp;&nbsp; <label
								id="bnum">${board.bnum}</label>&nbsp;&nbsp;&nbsp; <label
								class="text-info">조회수:</label>&nbsp;&nbsp; <label>${board.readcnt}</label>
						</div>
						<div class="form-group">
							<label for="writer" class="text-info">작성자:</label>&nbsp;&nbsp; <label>${board.writer}</label>
						</div>
						<div class="form-group">
							<label for="writer" class="text-info">이메일:</label>&nbsp;&nbsp; <label>${board.email}</label>
						</div>
						<div class="form-group">
							<label for="writer" class="text-info">내용:</label>&nbsp;&nbsp; <label>${board.content}</label>
						</div>
						<div class="form-group">
							<label for="writer" class="text-info">파일:</label>&nbsp;&nbsp; <label><c:forEach
									var="file" items="${flist}">
									${file.filename}
							<button class="fileDownload" value="${file.filename}">다운로드</button>
									<br>
								</c:forEach></label>
						</div>
						<div class="form-group">
							<label for="writer" class="text-info">등록일자:</label>&nbsp;&nbsp; <label><fmt:formatDate
									pattern="yyyy-MM-dd HH:mm:ss" value="${board.regdate}" /></label>
						</div>
						<div class="form-group">
							<label for="writer" class="text-info">수정일자:</label>&nbsp;&nbsp; <label><fmt:formatDate
									pattern="yyyy-MM-dd HH:mm:ss" value="${board.updatedate}" /></label>
						</div>
						<button class="btn btn-warning" id="btnModify">수정</button>
						<button class="btn btn-danger" id="btnDelete">삭제</button>
						<button class="btn btn-secondary" id="btnList">목록</button>
					</div>
				</div>
			</div>
		</div>
	</div>


	<div class="container">
		<h3 class="text-center text-white pt-5"></h3>
		<div id="login-row"
			class="row justify-content-center align-items-center">
			<div id="Mypage-column" class="col-md-6">
				<div id="Mypage-box" class="col-md-12">
					<div class="form-group">
						<label for="writer" class="text-info">댓글달기</label><br> <label
							for="writer" class="text-info">작성자:</label>&nbsp;&nbsp; <input
							type="text" id="replyWriter">
					</div>
					<div class="form-group">
						<label class="text-info">내용</label>
						<textarea class="form-control" id="replyContent" rows="2"
							cols="20"></textarea>
					</div>
					<button class="btn btn btn-secondary" id="btnReplyAdd">댓글추가</button>
				</div>
			</div>
			<!-- 댓글목록 -->
			<!-- <button id="btnReplyList">댓글조회</button> -->
		</div>
		<div id="replies" align="center"></div>
	</div>








</body>
</html>