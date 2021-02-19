<%@page import="stg.vo.AktsVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
AktsVo vo = (AktsVo) request.getAttribute("aktsVo");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>애플리케이션테스트수행 Training</title>
<script type="text/javascript">
	function answer(){
		var answer = document.getElementById('answer');
		
		if (!answer.value) {
			alert('답을 입력하세요.');
			answer.focus();
			return
		}
		
		document.getElementById('aktsTForm').submit();
	}
</script>
</head>
<body>
	<header>
		<jsp:include page="/views/common/header.jsp"></jsp:include>
	</header>
	<section class="empty">
		<h3>애플리케이션테스트수행 Training</h3>
			<div class="divCenter">
				<div class="divCenter">
					<form action="/aktsTrainigProc.do" method="post" id="aktsTForm">
						<table border="0">
							<tr>
								<th><%=vo.getAktsno()%>번문제</th>
								<input type="hidden" value="<%=vo.getAktsno()%>" id="aktsno" name="aktsno">
								<td><%=vo.getQuestion() %></td>
							</tr>
							<tr>
								<th>답</th>
								<td><input type="text" id="answer" name="answer"/></td>
							</tr>
						</table>
					</form>
					<button type="button" onclick="answer()">확인</button>
					<button type="button" onclick="location.href='/aktsNext.do?aktsno=<%=vo.getAktsno()%>'">다음문제</button>
					<button type="button" onclick="location.href='/'">홈으로</button>
				</div>		
			</div>
	</section>
</body>
</html>