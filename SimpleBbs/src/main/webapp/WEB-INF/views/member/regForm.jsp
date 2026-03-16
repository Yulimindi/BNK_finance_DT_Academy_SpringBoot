<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Member Regist Form</h1>
	<hr>
	<form action="/member/regist" method="post">
		<input type="text" name="id" placeholder="Input id"><br>
		<input type="password" name="pw" placeholder="Input pw"><br>
		<input type="text" name="name" placeholder="Input name"><br>
		<input type="submit" value="등록">
	</form>
</body>
</html>