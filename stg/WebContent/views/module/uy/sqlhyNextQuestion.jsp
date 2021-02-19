<%@page import="stg.vo.UyVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%
	UyVo vo = (UyVo) request.getAttribute("uyNextVo");
	%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>응용SW기초기술활용 Training</title>
<script type="text/javascript">
	function answer(){
		var answer = document.getElementById('answer');
		
		if (!answer.value) {
			alert('답을 입력하세요.');
			answer.focus();
			return
		}
		
		document.getElementById('uyNForm').submit();
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
				<form action="/uyTrainigProc.do" method="post" id="uyNForm">
					<table border="0">
						<tr>
							<th><%=vo.getUyno() %>번문제</th>
							<input type="hidden" value="<%=vo.getUyno()%>" id="uyno" name="uyno">
							<td><%=vo.getQuestion() %></td>
						</tr>
						<tr>
							<th>답</th>
							<td><input type="text" id="answer" name="answer"/></td>
						</tr>
					</table>
				</form>
					<button type="button" onclick="answer()">확인</button>
					<button type="button" onclick="location.href='/uyNext.do?uyno=<%=vo.getUyno()%>'">다음문제</button>
					<button type="button" onclick="location.href='/'">홈으로</button>
			</div>
		</div>
	</section>

</body>
</html>