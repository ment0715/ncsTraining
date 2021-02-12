<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
int hgno = (int) request.getAttribute("hgno");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>화면구현 트레이닝 만들기</title>
<link rel="stylesheet" href="/views/css/module/hg/hgMake.css" />
<script type="text/javascript">
	function hgProc() {
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
		
		document.getElementById('hgForm').submit();
	}
</script>
</head>
<body>
	<header>
		<jsp:include page="/views/common/header.jsp"></jsp:include>
	</header>
	<section class="empty">
		<h3>화면구현 트레이닝 만들기</h3>
		<div class="divCenter">
			<div class="divCenter2">
				<form action="/hgProc.do" id="hgForm">
					<table border="0">
						<tr>
							<th><%=hgno%>번문제</th>
							<input type="hidden" id="hgno" name="hgno" value="<%=hgno%>">
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
					<button type="button" onclick="hgProc()">만들기</button>
					<button type="button" onclick="location.href='/hgTraining.do'" >공부하러가기</button>
				</div>
			</div>
		</div>
	</section>
</body>
</html>