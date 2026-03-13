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
	
	a {
		text-decoration : none;
		color : black;
	}
	
	nav {
		text-align : right;
		margin-right : 2%;
	}
	
	main {
		margin-left: 30%;
		margin-right: 30%;
		text-align : center;
	}
	
	#long {
		height : 300px;
	}
	
	.long {
		width : 100%;
	}
	
</style>
</head>
<body>
	<header>
		<img src="images/main.png"><h1>이진이 놀이터</h1>
	</header>
	
	<nav>
		<a href="getPost?pagee=1">홈</a>
		<a href="GetMyPost">마이페이지</a>
		<a href="doLogout">로그아웃</a>
	</nav>
	
	<%
		HttpSession s = request.getSession();
	%>
		
	<form action="updateInfo" method="post">
		<input type="text" name="id" value="<%=s.getAttribute("id")%>" readonly>
		<input type="text" name="pw" value="<%=s.getAttribute("pw")%>">
		<input type="text" name="name" value="<%=s.getAttribute("name")%>">
		<input type="submit">
	</form>
</body>
</html>