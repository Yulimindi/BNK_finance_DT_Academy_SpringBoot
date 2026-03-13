<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>createPage</h1>
	<br>
	<form action="/create" method="post">
		작성자 : <input type="text" name="writer" value="${dto.writer }">
		내용 : <input type="text" name="content" value="${dto.content }">
		<input type="submit" value="전송"><br>
	</form>
</body>
</html>