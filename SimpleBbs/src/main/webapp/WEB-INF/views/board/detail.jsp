<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Board Detail</h1>
	<hr>
	<h6>bno : ${board.bno }</h6>
	<h3>${board.title }</h3>
	<hr>
	<h4>${board.writer }</h4>
	<h4>${board.content }</h4>
	<h4>${board.regdate }</h4>
	
</body>
</html>