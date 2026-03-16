<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>인덱스 페이지</h1>
	
	<h1>쿼리스트링으로 파라미터 전송하고 컨트롤러에서 파라미터 처리하기</h1>
	<form>
		<input type="text" name="id" id="id">
		<input type="text" name="pw" id="pw">
		<button type="button" onclick="click1()">꾸욱</button>
	</form>
	<div id="div">${str }</div>
	
	<hr>
	
	<h1>커맨드 객체로 쿼리스트링 파라미터 처리하기</h1>
	<form id="frm2">
		<input type="text" name="id">
		<input type="text" name="pw">
		<button type="button" onclick="click2()">꾸욱</button>
	</form>
	<div id="div2"></div>
	
	<hr>
	
	<h1>커맨드 객체로 폼 파라미터 처리하기</h1>
	<form id="frm3">
		<input type="text" name="id">
		<input type="text" name="pw">
		<button type="button" onclick="click3()">꾸욱</button>
	</form>
	<div id="div3"></div>
	
	
	<script>
	
	const id = document.querySelector("#id");
	const pw = document.querySelector("#pw");
	
	const div = document.querySelector("#div");
	const div2 = document.querySelector("#div2");
	const div3 = document.querySelector("#div3");
	
	const frm2 = document.querySelector("#frm2");
	const frm3 = document.querySelector("#frm3");
	
	function click1() {
		location.href = "getData?id=" + id.value + "&pw=" + pw.value;
	}
	
	function click2() {
		const formData = new FormData(frm2);
		fetch("getParam", {
			method : "post",
			body : formData
		})
		.then(data => data.text())
		.then(data => {
			div2.innerHTML = data;
		})
	}
	
	function click3() {
		const formData = new FormData(frm3);
		const json = JSON.stringify(Object.fromEntries(formData.entries()));
		console.log(formData);
		fetch("getCommand", {
			method : "post",
			headers : {
				'Content-Type' : 'application/json'
			},
			body : json
		})
		.then(data => data.text())
		.then(data => {
			div3.innerHTML = data;
		})
	}
	
	</script>
</body>
</html>
