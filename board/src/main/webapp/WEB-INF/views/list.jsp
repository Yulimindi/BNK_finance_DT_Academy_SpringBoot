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
	<h1>list 페이지</h1>

	<hr>
	
	<form action="/list3" method="get">
		<select name="type">
			<option value="">-- 선택 --</option>
			<option value="t">제목</option>
			<option value="c">내용</option>
			<option value="w">작성자</option>
			<option value="tc">제목 + 내용</option>
		</select>
		<input type="text" name="keyword">
		<input type="submit" value="검색">
	</form>
	
	<table border="1">
		<thead>
			<tr>
				<th>bno</th><th>title</th><th>content</th><th>writer</th><th>regdate</th>
			</tr>
		</thead>
		
		<tbody>
			<c:forEach var="board" items="${list }">
			<tr>
				<td>${board.bno }</td>
				<td>${board.title }</td>
				<td>${board.content }</td>
				<td>${board.writer }</td>
				<td>${board.regdate }</td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>