<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
int sqlhyno = (int) request.getAttribute("sqlhyno");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>프로그래밍언어활용 트레이닝 만들기</title>
<link rel="stylesheet" href="/views/css/module/sqlhy/sqlhyMake.css" />
<script type="text/javascript">
	function sqlhyProc() {
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
		
		document.getElementById('sqlhyForm').submit();
	}
</script>
</head>
<body>
	<header>
		<jsp:include page="/views/common/header.jsp"></jsp:include>
	</header>
	<section class="empty">
		<h3>SQL활용 트레이닝 만들기</h3>
		<div class="divCenter">
			<div class="divCenter2">
				<form action="/sqlhyProc.do" id="sqlhyForm">
					<table border="0">
						<tr>
							<th><%=sqlhyno%>번문제</th>
							<input type="hidden" id="sqlhyno" name="sqlhyno" value="<%=sqlhyno%>">
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
					<button type="button" onclick="sqlhyProc()">만들기</button>
					<button type="button" onclick="location.href='/sqlhyTraining.do'">공부하러가기</button>
					<button type="button" onclick="location.href='/'">홈으로</button>
				</div>
			</div>
		</div>
	</section>
</body>
</html>