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
	button {
		display : inline;
	}
	p {
		display : inline;
	}
</style>
</head>
<body>
	<header>
		<img src="images/main.png"><h1>이진이 놀이터</h1>
	</header>
	<br>
	<hr>
	<br>
	<h2>회원가입</h2>
	<form action="doJoin" method="post" id="form">
		<input type="text" name="id" id="id" placeholder="사용하실 아이디를 입력해주세요">
		<button type="button" onclick="check()">중복 확인</button><p id="p_check"></p><br>
		<input type="text" name="pw" placeholder="사용하실 비밀번호를 입력해주세요"><br>
		<input type="text" name="name" placeholder="사용하실 닉네임을 입력해주세요"><br>
		<input type="submit" value="회원가입" id="submit">
	</form>
	
	<script>
	
	const form = document.querySelector("#form");
	const p_check = document.querySelector("#p_check");
	const submit = document.querySelector("#submit");
	const id = document.querySelector("#id");
	let idCheck = "no";
	
	form.addEventListener("submit", (e) => {
		if(idCheck == "yes") {
			console.log("아이디 체크 성공");
			e.target.submit;
		} else {
			e.preventDefault();
			alert("아이디 중복확인을 해주세요.");
			e.id.focus();
			return;
		}
	})
	
	function check() {
		console.log(id.value);
		const xhr = new XMLHttpRequest();
		xhr.onload = () => {
			console.log(xhr.responseText);
			if(xhr.responseText == "true") {
				p_check.textContent = "사용 가능한 아이디입니다.";
				idCheck = "yes";
			} else {
				p_check.textContent = "해당 아이디는 사용하실 수 없습니다.";
				idCheck = "no";
			}	
		}
		xhr.open("POST", "checkId?id=" + id.value);
		xhr.send();
	}
	
	
	</script>
</body>
</html>