<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 결과 페이지</title>

<style>
	h1{
		background-color: yellow;
		color : red;
	}
</style>

</head>
<body>
	<h1>로그인 결과</h1>
	
	<!-- jsp에서 자바코드의 값을 출력(=)하는 방법 -->
	<%= request.getParameter("inputId") %>
	
	<br>
	
	<%= request.getParameter("inputPw") %>
	
	<br>
	
	
	<!-- 자바 코드 작성 영역(출력X) -->
	<%
		// 자바 주석 가능 == 자바 코드 작성 영역
		
		// request.getAttribute("key"); -> value
		
		String res = (String)request.getAttribute("r");
						// -> 다운캐스팅 필요
		
	%>
						<!-- 위에 res 변수에 저장된 값이 출력됨 -->
	<h3 style='color:green;'> <%= res %> </h3>
	
	<button type='button' onclick='history.back()'> 다시시도 </button>
	
</body>
</html>