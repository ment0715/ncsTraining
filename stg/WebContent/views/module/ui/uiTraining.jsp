<%@page import="stg.vo.UiVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
UiVo vo = (UiVo) request.getAttribute("uiVo");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>UI테스트 Training</title>
<script type="text/javascript">
	function answer(){
		var answer = document.getElementById('answer');
		
		if (!answer.value) {
			alert('답을 입력하세요.');
			answer.focus();
			return
		}
		
		document.getElementById('uiTForm').submit();
	}
</script>
</head>
<body>
	<header>
		<jsp:include page="/views/common/header.jsp"></jsp:include>
	</header>
	<section class="empty">
		<h3>UI테스트 Training</h3>
			<div class="divCenter">
				<div class="divCenter">
					<form action="/uiTrainigProc.do" method="post" id="uiTForm">
						<table border="0">
							<tr>
								<th><%=vo.getUino()%>번문제</th>
								<input type="hidden" value="<%=vo.getUino()%>" id="uino" name="uino">
								<td><%=vo.getQuestion() %></td>
							</tr>
							<tr>
								<th>답</th>
								<td><input type="text" id="answer" name="answer"/></td>
							</tr>
						</table>
					</form>
					<button type="button" onclick="answer()">확인</button>
					<button type="button" onclick="location.href='/uiNext.do?uino=<%=vo.getUino()%>'">다음문제</button>
					<button type="button" onclick="location.href='/randomUiTraining.do'">랜덤문제</button>
					<button type="button" onclick="location.href='/'">홈으로</button>
				</div>		
			</div>
	</section>
</body>
</html>