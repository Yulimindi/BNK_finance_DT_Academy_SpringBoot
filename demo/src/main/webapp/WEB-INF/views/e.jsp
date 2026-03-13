<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>e 페이지</h1>
	<hr>
	<h1>이름 : ${name }</h1>
	<h1>이름 : ${requestScope.name }</h1>
	<h1>이름 : ${sessionScope.name }</h1>
	<h1>이름 : ${modelScope.name }</h1>
</body>
</html>