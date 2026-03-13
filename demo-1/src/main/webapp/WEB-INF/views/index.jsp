<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Index 페이지</h1>
	<form id="regist">
		<label>회원가입</label><br>
		아이디 <input type="text" name="id" id="id"><button type="button" onclick="check()">중복 확인</button><br>
		<p id="p"></p><br>
		비밀번호 <input type="password" name="pw"><br>
		이름 <input type="text" name="name"><br>
		<button type="button" onclick="signup()">회원가입</button>
	</form>
	
	<div id="result"></div>
	
	<form id="login">
		<label>로그인</label>
		아이디 <input type="text" name="id" id="id2">
		비밀번호 <input type="text" name="pw" id="pw2">
		<button type="button" onclick="login()">로그인</button>
	</form>
	
	<script>
	
	if("${result}" == "false") {
		alert("아이디 또는 비밀번호가 틀렸습니다.");
	}
	
	const form = document.querySelector("#regist");
	const form2 = document.querySelector("#login");
	
	
	const id = document.querySelector("#id");
	const p = document.querySelector("#p");
	const result = document.querySelector("#result");
	
	const id2 = document.querySelector("#id2");
	const pw2 = document.querySelector("#pw2");
	
	
	let duplication = "yes";
	
		function check() {
			duplication = "yes";
			fetch("check?id=" + id.value)
			.then(data => data.json())
			.then(data => {
				if(data == true) {
					duplication = "no";
					p.innerHTML = "사용 가능한 아이디입니다.";
				} else {
					duplication = "yes";
					p.innerHTML = "이미 사용중인 아이디입니다.";
				}
			})
		}
		
		function signup() {
			const formData = new FormData(form);

			if(duplication == "no") {
				fetch("signup", {
					method : "POST", 
					body : formData	
				})
				.then(data => data.text())
				.then(data => {
					result.innerHTML = data + "님 회원가입이 완료되었습니다.";
				})
			}
		}
		
		function login() {
			location.href="login?id="+id2.value+"&pw="+pw2.value;
		}
	
	</script>
</body>
</html>