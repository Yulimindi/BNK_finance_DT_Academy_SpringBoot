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
	
	#title {
		display : inline;
	}
	#button2 {
		width : 10%;
	}
	#text {
		width : 87%;
		
	}
	p {
		display : inline;
	}
	.name {
		width : 8%;
	}
	.text {
		width : 72%;
	}
	.date {
		width : 20%;
	}
</style>
</head>
<body>
	<header>
		<img src="images/main.png"><h1>이진이 놀이터</h1>
	</header>
	
	<nav>
		<a href="GetTableServlet?page=1">홈</a>
		<a href="GetMyPost">마이페이지</a>
		<a href="LogoutServlet">로그아웃</a>
	</nav>
	
	<hr>
	<br>
	<main>
		<div id="mainContainer">
		<hr>
			번호 : <p id="indexx">${post.indexx }</p><br>
			제목 : <div id="title">${post.post_title}</div>　　　　　　　<button onclick="updatePost()">게시글 수정</button>　<button onclick="deletee()">게시글 삭제</button>
			
			<hr>
			내용<div id="content">
			<br>
			${post.post_content}</div>
		</div>
		
		<hr>
		<div>댓글</div>
		

		<input type="text" id="text">
		<button onclick="go()">댓글 달기</button>

		<table>
			<tr>
				<td class="name">닉네임</td>
				<td class="text">내용</td>
				<td class="date">날짜</td>
			</tr>
		</table>
		
		<table id="table">
		
			<c:forEach var="lists" items="${comment }">
			<tr>
				<td>${lists.name }</td>
				<td>${lists.commentt }</td>
				<td>${lists.com_date }</td>
				<td><a href="doDeComment?name=${lists.name }&commentt=${lists.commentt}&indexx=${lists.indexx}">삭제</a></td>
			</tr>
			</c:forEach>
		</table>
		
	</main>
	
	<script>

		<%
			HttpSession s = request.getSession();
		%>
	function deletee() {
		if("${post.id}" == "<%=s.getAttribute("id")%>") {
			location.replace("doDePost?indexx="+${post.indexx });
		} else {
			alert("타인의 게시글은 지울 수 없습니다.");
		}
		
	}
	
	function updatePost() {
		if("${post.id}" == "<%=s.getAttribute("id")%>") {
			location.replace("getDetail2?indexx="+${post.indexx });	
		} else {
			alert("타인의 게시글은 수정할 수 없습니다.");
		}
	}
	
	const text = document.querySelector("#text");
	const indexx = document.querySelector("#indexx");
	const table = document.querySelector("#table");
	
	function go() {

		const xhr = new XMLHttpRequest();
		
		xhr.onload = function() {
			table.innerHTML = "";
			text.value = "";
			const list = JSON.parse(xhr.responseText);
			let num;
			for(i = 0; i < list.length; i++) {
				if(list[i].indexx == indexx.textContent) {
					let tr = document.createElement("tr");
					
					let td1 = document.createElement("td");
					let td2 = document.createElement("td");
					let td3 = document.createElement("td");
					td1.textContent = list[i].name;
					td2.textContent = list[i].commentt;
					td3.textContent = list[i].com_date;
					td1.className += 'name';
					td2.className += 'text';
					td3.className += 'date';
		
					let a = document.createElement("a");
					
					a.setAttribute('href', 'doDeComment?name='+list[i].name+'&commentt='+list[i].commentt + '&indexx=' + list[i].indexx);
					a.textContent = "삭제";
					
					td3.appendChild(a);
					
					tr.appendChild(td1);
					tr.appendChild(td2);
					tr.appendChild(td3);
					table.appendChild(tr);
				} 
				
			}
			
		}
	
		xhr.open("GET", "doComment?indexx=" + indexx.textContent + "&commentt=" + text.value);
		xhr.send();
		
	}
	
	
	</script>
</body>
</html>