<%@page import="stg.vo.HgVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
HgVo vo = (HgVo) request.getAttribute("hgvo");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>화면구현 공부하기</title>
<script type="text/javascript">
	
</script>
</head>
<body>
	<header>
		<jsp:include page="/views/common/header.jsp"></jsp:include>
	</header>
	<section class="empty">
		<h3>화면구현 문제풀기</h3>
			<div class="divCenter">
				<div class="divCenter">
					<form action="">
						<table border="0">
							<tr>
								<th><%=vo.getHgno() %>번문제</th>
								<td><%=vo.getQuestion() %></td>
							</tr>
							<tr>
								<th>답</th>
								<td><input type="text" id="answer" name="answer"/></td>
							</tr>
						</table>
					</form>
				</div>		
			</div>
	</section>
</body>
</html>