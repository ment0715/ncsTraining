<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
int akbfno = (int) request.getAttribute("akbfno");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>애플리케이션배포 트레이닝 만들기</title>
<link rel="stylesheet" href="/views/css/module/akbf/akbfMake.css" />
<script type="text/javascript">
	function akbfProc() {
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
		
		document.getElementById('akbfForm').submit();
	}
</script>
</head>
<body>
	<header>
		<jsp:include page="/views/common/header.jsp"></jsp:include>
	</header>
	<section class="empty">
		<h3>애플리케이션배포 트레이닝 만들기</h3>
		<div class="divCenter">
			<div class="divCenter2">
				<form action="/akbfProc.do" id="akbfForm">
					<table border="0">
						<tr>
							<th><%=akbfno%>번문제</th>
							<input type="hidden" id="akbfno" name="akbfno" value="<%=akbfno%>">
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
					<button type="button" onclick="akbfProc()">만들기</button>
					<button type="button" onclick="location.href='/akbfTraining.do'">공부하러가기</button>
					<button type="button" onclick="location.href='/'">홈으로</button>
				</div>
			</div>
		</div>
	</section>
</body>
</html>