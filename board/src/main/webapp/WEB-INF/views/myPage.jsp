<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>    
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
		<a href="getMyPost">마이페이지</a>
		<a href="doLogout">로그아웃</a>
	</nav>
	
	<%
		HttpSession s = request.getSession();
	%>
	<div>
		<h2>아이디 : <%=s.getAttribute("id") %></h2>
		<h2>이름 : <%=s.getAttribute("name") %></h2>
		<a href="goUpdateInfo">내 정보 변경</a>
	</div>
	
	
	<table id="tbl">
		<h3>내가 쓴 글</h3>
		<tr>
			<th>제목</th>
			<th>날짜</th>
		</tr>
		
		<c:forEach var="list" items="${list  }">
		<tr>
			<td id="${list.indexx}">${list.post_title }</td>
			<td id="${list.indexx}">${list.post_date }</td>
		</tr>
		</c:forEach>
	</table>
	
	<script>
	const tbl = document.querySelector("#tbl");
	
	tbl.addEventListener("click", (e) => {
		location.replace("getDetail?indexx="+e.target.id);
	})
	</script>
	
</body>
</html>