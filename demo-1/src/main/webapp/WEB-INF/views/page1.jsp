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
	<h1>${name }님 환영합니다.</h1>
	<h2>회원 목록</h2>
	<table>
		<thead>
			<tr>
				<th>아이디</th>
				<th>비밀번호</th>
				<th>이름</th>
			</tr>
		</thead>
		
		<tbody>
			<c:forEach var="list" items="${list }">
			<tr>
				<th>${list.id }</th>
				<th>${list.pw }</th>
				<th>${list.name }</th>
			</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>