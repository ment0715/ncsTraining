<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
int puno = (int) request.getAttribute("puno");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>프로그래밍언어활용 트레이닝 만들기</title>
<link rel="stylesheet" href="/views/css/module/pu/puMake.css" />
<script type="text/javascript">
	function puProc() {
		var question = document.getElementById('question');
		var answer = document.getElementById('answer');
		
		if (!question.value){
			alert('문제를 입력하세요.');
			question.focus();
			return
		}
		
		if (!answer.value){
			alert('답을 입력하세요.');
			answer.focus();
			return
		}
		
		document.getElementById('puForm').submit();
	}
</script>
</head>
<body>
	<header>
		<jsp:include page="/views/common/header.jsp"></jsp:include>
	</header>
	<section class="empty">
		<h3>응용프로그래밍언어활용 트레이닝 만들기</h3>
		<div class="divCenter">
			<div class="divCenter2">
				<form action="/puProc.do" id="puForm">
					<table border="0">
						<tr>
							<th><%=puno%>번문제</th>
							<input type="hidden" id="puno" name="puno" value="<%=puno%>">
							<td><input type="text" id="question" name="question"
								size="200"></td>
						</tr>
						<tr>
							<th>답</th>
							<td><input type="text" id="answer" name="answer" size="200"></td>
						</tr>
					</table>
				</form>
				<div class="btn">
					<button type="button" onclick="puProc()">만들기</button>
					<button type="button" onclick="location.href='/puTraining.do'">공부하러가기</button>
					<button type="button" onclick="location.href='/'">홈으로</button>
				</div>
			</div>
		</div>
	</section>
</body>
</html>