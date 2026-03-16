<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Board Regist Form</h1>
	<hr>
	<form action="/board/regist" method="post">
		제목<input type="text" name="title">
		내용<textarea cols="20" rows="5" name="content"></textarea>
		작성자<input type="text" name="writer" value="${sessionScope.id }" readonly>
		<input type="submit" value="등록">
	</form>
</body>
</html>