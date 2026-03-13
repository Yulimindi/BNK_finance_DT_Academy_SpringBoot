<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<body>
	<h1>a 페이지</h1>
	<form id="frm">
		<input type="text" name="no">
		<input type="text" name="name">
		<input type="text" name="phone">
		<button type="button" onclick="sendForm()">전송</button>
	</form>
	<div id="p"></div>
	<script src="/js/script2.js"></script>	
</body>
</html>