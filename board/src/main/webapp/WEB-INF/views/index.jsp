<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>

	header {
		text-align : center;
	}
	
	*{
		margin : 0px;
		padding : 0px;
	}

	img {
		
		height : 100px;
		width : 100px;
	}
	
	h1 {
		
	}
	
	a {
		text-decoration : none;
		color : black;
	}
	
	main {
		margin-left: 30%;
		margin-right: 30%;
		text-align : center;
	}
	
</style>
</head>
<body>
	<header>
		<img src="main.png"><h1>이진이 놀이터</h1>
	</header>
	<br>
	<hr>
	<br>
	<main>
		<h3>로그인</h3>
		<form action="doLogin" method="post">
			<input type="text" name="id" placeholder="아이디를 입력해주세요"><br>
			<input type="password" name="pw" placeholder="비밀번호를 입력해주세요"><br>
			<input type="submit" value="로그인">
		</form>
		<br>
		<hr>
		<br>
		<h4>회원이 아니신가요?</h4>
		<a href="goJoin">회원가입 하기</a>
	</main>
	
	<script>
		if("${result}" == "true") {
			alert("회원가입 되었습니다! 로그인 후 저희의 서비스를 이용해보세요.");
		}
		
		if("${login}" == "false") {
			alert("아이디 또는 비밀번호가 틀렸습니다.");
		}
	</script>
</body>
</html>