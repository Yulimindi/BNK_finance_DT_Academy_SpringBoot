<%@page import="com.example.demo.dto.NewMember"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>회원가입</h1>
	<form id="frm">
		<input type="text" name="id" id="id">
		<button type="button" onclick="check()">아이디 중복 확인</button>
		<input type="text" name="pw" id="pw">
		<button type="button" onclick="sendForm()">전송</button>
	</form>
	<div id="p"></div>
	
	<h1>로그인</h1>
	<form id="frm2">
		<input type="text" name="id" id="id2">
		<input type="text" name="pw" id="pw2">
		<button type="button" onclick="login()">전송</button>
	</form>
	<div id="p2"></div>
	
	<script src="/js/m_script.js"></script>
</body>
</html>