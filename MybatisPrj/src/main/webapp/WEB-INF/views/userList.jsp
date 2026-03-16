<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>userList 페이지</h1>
	<hr>
	<c:forEach var="user" items="${users }">
		${user.id } / ${user.pw }<br>
	</c:forEach>
</body>
</html>