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
	<h1>Board List</h1>
	<hr>
	<table border="1">
		<thead>
			<tr>
				<th>bno</th>
				<th>title</th>
				<th>writer</th>
				<th>regdate</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach var="board" items="${boardList }">
			<tr>
				<th>${board.bno }</th>
				<th><a href="/board/detail?bno=${board.bno }">${board.title }</a></th>
				<th>${board.writer }</th>
				<th>${board.regdate }</th>
			</tr>
		</c:forEach>	
		</tbody>
		
	</table>
</body>
</html>