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

	<hr>
	<br>
	<main>
		<form action="doPost" method="post">
			제목<input type="text" class="long" name="post_title"><br>
			내용<input type="text" id="long" class="long" name="post_content"><br>
			<input type="submit" value="작성 완료">
		</form>
	</main>
	
	
</body>
</html>