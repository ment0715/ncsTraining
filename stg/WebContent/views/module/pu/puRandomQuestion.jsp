<%@page import="stg.vo.PuVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	PuVo vo = (PuVo)request.getAttribute("puRandomVo");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>프로그래밍언어활용 랜덤 Training</title>
<script type="text/javascript">
	function answer(){
		var answer = document.getElementById('answer');
		
		if (!answer.value) {
			alert('답을 입력하세요.');
			answer.focus();
			return
		}
		
		document.getElementById('puNForm').submit();
	}
</script>
</head>
<body>
	<header>
		<jsp:include page="/views/common/header.jsp"></jsp:include>
	</header>
	<section>
		<div class="divCenter">
			<div class="divCenter2">
				<form action="/puTrainigProc.do" method="post" id="puNForm">
					<table border="0">
						<tr>
							<th><%=vo.getPuno() %>번문제</th>
							<input type="hidden" value="<%=vo.getPuno()%>" id="puno" name="puno">
							<td><%=vo.getQuestion() %></td>
						</tr>
						<tr>
							<th>답</th>
							<td><input type="text" id="answer" name="answer"/></td>
						</tr>
					</table>
				</form>
					<button type="button" onclick="answer()">확인</button>
					<button type="button" onclick="location.href='/randomPuTraining.do'">다음문제</button>
					<button type="button" onclick="location.href='/'">홈으로</button>
			</div>
		</div>
	</section>

</body>
</html>