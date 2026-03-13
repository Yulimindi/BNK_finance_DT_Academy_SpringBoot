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
	<header>
		<img src="images/main.png"><h1>이진이 놀이터</h1>
	</header>
	
	<main>
		<table>
			<tr>
				<th class="title">제목</th>
				<th class="name">닉네임</th>
				<th class="date">작성일자</th>
			</tr>
		</table>
	
	<br>
	
	<a href="goPosting" id="border">　게시글 작성　</a>
	
	<br>
	<br>
		<table id="tbl">
			<c:forEach var="postList" items="${list }" varStatus="status">
					<tr>
						<td id="${postList.indexx}" class="title">${postList.post_title }</td>
						<td id="${postList.indexx}" class="name">${postList.name }</td>
						<td id="${postList.indexx}" class="date">${postList.post_date }</td>
					</tr>
			</c:forEach>
		</table>
		
		<c:forEach var="i" begin="1" end="${len }">
			<button class="btn">${i }</button>
		</c:forEach>
		
	</main>
	
	<script>
		const tbl = document.querySelector("#tbl");
		
		tbl.addEventListener("click", (e) => {
			location.replace("getDetail?indexx="+e.target.id);
		})
		
		<%
			String result = request.getParameter("result");			
		%>
		
		if("${update}" == "true") {
			alert("수정이 완료되었습니다.");
		}
		
		if("${delete}" == "true") {
			alert("게시글 삭제가 완료되었습니다.");
		}
		
		const btn = document.querySelectorAll(".btn");

		let a;
		for(a = 0; a < btn.length; a++) {
			btn[a].addEventListener("click", (e) => {

				location.replace("getPost?pagee=" + e.target.textContent);
			})
		}
		
		
		
	</script>
</body>
</html>