<%@page import="stg.vo.SqlhyVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	SqlhyVo vo = (SqlhyVo)request.getAttribute("sqlhyRandomVo");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SQL활용 랜덤 Training</title>
<script type="text/javascript">
	function answer(){
		var answer = document.getElementById('answer');
		
		if (!answer.value) {
			alert('답을 입력하세요.');
			answer.focus();
			return
		}
		
		document.getElementById('sqlhyNForm').submit();
	}
</script>
</head>
<body>
	<header>
		<jsp:include page="/views/common/header.jsp"></jsp:include>
	</header>
	<section class="empty">
		<h3>SQL활용 랜덤 Training</h3>
		<div class="divCenter">
			<div class="divCenter2">
				<form action="/sqlhyTrainigProc.do" method="post" id="sqlhyNForm">
					<table border="0">
						<tr>
							<th><%=vo.getSqlhyno() %>번문제</th>
							<input type="hidden" value="<%=vo.getSqlhyno()%>" id="sqlhyno" name="sqlhyno">
							<td><%=vo.getQuestion() %></td>
						</tr>
						<tr>
							<th>답</th>
							<td><input type="text" id="answer" name="answer"/></td>
						</tr>
					</table>
				</form>
					<button type="button" onclick="answer()">확인</button>
					<button type="button" onclick="location.href='/randomSqlhyTraining.do'">다음문제</button>
					<button type="button" onclick="location.href='/'">홈으로</button>
			</div>
		</div>
	</section>

</body>
</html>